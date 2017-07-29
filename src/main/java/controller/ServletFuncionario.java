package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FuncionarioDAO;
import model.Funcionario;

@WebServlet(name = "ServletFuncionario", urlPatterns = "/funcionario")
public class ServletFuncionario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private Funcionario funcionario = new Funcionario();
	private String destino = "";
	private int idfuncionario;
	private String nome;
	private String funcao;
	private String matricula;
	private String email;
	private String senha;
	private String message;
	private boolean acao = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		acao = false;

		try {

			idfuncionario = Integer.parseInt(request.getParameter("idfuncionario"));
			System.out.println("NA VARIAVEL: " + idfuncionario);

		} catch (NumberFormatException number) {
			acao = true;
			adicionafuncionario(request, response);
			destino = "/c_funcionario.jsp";
		}

		if (acao == false) {
			funcionario.setIdfuncionario(idfuncionario);
			funcionarioDAO.existe(funcionario);
			if (funcionarioDAO.existe(funcionario) == true) {
				editarfuncionario(request, response);
				destino = "/c_funcionario.jsp";
			}
		}

		/*
		 * System.out.println("NA VARIAVEL ACAO: " + acao);
		 * System.out.println("NO metodo existe " +
		 * funcionarioDAO.existe(funcionario));
		 */

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	protected void adicionafuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nome = request.getParameter("nome");
		System.out.println("Nome: " + nome);
		funcao = request.getParameter("funcao");
		matricula = request.getParameter("matricula");
		email = request.getParameter("email");
		senha = request.getParameter("senha");

		try {

			funcionario.setMatricula(matricula);
			funcionario.setNome(nome);
			funcionario.setFuncao(funcao);
			funcionario.setEmail(email);
			funcionario.setSenha(senha);

		} catch (Exception e) {
			System.out.println("Parametro incorreto.");
		}
		if (funcionarioDAO.inserir(funcionario) == true)
			message = "Erro ao Gravar Registro";
		else
			message = "Registro Gravado com Sucesso";

	}

	protected void editarfuncionario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		nome = request.getParameter("nome");
		funcao = request.getParameter("funcao");
		matricula = request.getParameter("matricula");
		email = request.getParameter("email");
		senha = request.getParameter("senha");

		/*
		 * System.out.println("no EDITAR: " + idfuncionario);
		 * System.out.println("no EDITAR: " + nome);
		 * System.out.println("no EDITAR: " + matricula);
		 * System.out.println("no EDITAR: " + email);
		 * System.out.println("no EDITAR: " + funcao);
		 * System.out.println("no EDITAR: " + senha);
		 */

		try {

			funcionario.setIdfuncionario(idfuncionario);
			funcionario.setMatricula(matricula);
			funcionario.setNome(nome);
			funcionario.setFuncao(funcao);
			funcionario.setEmail(email);
			funcionario.setSenha(senha);

		} catch (Exception e) {
			System.out.println("Parametro incorreto.");
		}

		if (funcionarioDAO.alterar(funcionario) == true)
			message = "Erro ao Alterar Registro";
		else
			message = "Registro Alterado com Sucesso";
	}
}