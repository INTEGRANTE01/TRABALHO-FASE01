package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FuncionarioDAO;
import model.Funcionario;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private Funcionario funcionario = new Funcionario();
	private int idfuncionario;
	private String destino = "";
	private String acao;
	private String message;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		acao = request.getParameter("acao");
		if (acao.equals("logout")) {
			logout(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		login(request, response);

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		funcionario = funcionarioDAO.buscarPorMatricula(request.getParameter("login"));
		String senha = request.getParameter("senha");

		if (funcionario.getSenha() != null && funcionario.getSenha().equals(senha)) {
			HttpSession sessao = request.getSession();
			// setando um atributo da sessao
			sessao.setAttribute("nome", funcionario.getNome());
			sessao.setAttribute("funcao", funcionario.getFuncao());
			destino = "pagina_inicial.jsp";
			response.sendRedirect(destino);			
		} else {
			message = "Falha no login, verifique os dados.";
			request.setAttribute("message", message);
			destino = "/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destino);
			rd.forward(request, response);
		}

	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// no logout invalido a sessao
		HttpSession sessao = request.getSession();
		sessao.removeAttribute("nome");
		sessao.invalidate();
		destino = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);

	}

}
