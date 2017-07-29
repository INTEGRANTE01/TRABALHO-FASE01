package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DenunciaDAO;
import model.Denuncia;

@WebServlet(name = "ServletBuscaDenuncia", urlPatterns = "/buscadenuncia")
public class ServletBuscaDenuncia extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DenunciaDAO denunciaDAO = new DenunciaDAO();
	private Denuncia denuncia = new Denuncia();
	private int iddenuncia;
	private String destino = "";
	private String acao;
	private String message;
	private String textopesquisa1;
	private String textopesquisa2;
	private String textopesquisa3;
	private String textopesquisa4;
	private Date data_formatada;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		acao = request.getParameter("acao");
		if (acao != null) {
			if (acao.equalsIgnoreCase("Consultar")) {
				consultareditardenuncia(request, response);
				RequestDispatcher rd = request.getRequestDispatcher(destino);
				rd.forward(request, response);
			} else if (acao.equalsIgnoreCase("Excluir")) {
				excluirdenuncia(request, response);
				RequestDispatcher rd = request.getRequestDispatcher(destino);
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF8");
		buscardenuncia(request, response);
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);

	}

	protected void buscardenuncia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Denuncia> listadenuncia = new ArrayList<Denuncia>();

		textopesquisa1 = request.getParameter("txtpesquisa1");
		textopesquisa2 = request.getParameter("txtpesquisa2");
		textopesquisa3 = request.getParameter("txtpesquisa3");
		textopesquisa4 = request.getParameter("txtpesquisa4");

	//	if ((textopesquisa1 != "" && textopesquisa1 != null) || (textopesquisa2 != "" && textopesquisa2 != null)
	//			|| (textopesquisa3 != "" && textopesquisa3 != null)
	//			|| (textopesquisa4 != "" && textopesquisa4 != null)) {

			listadenuncia = denunciaDAO.listar(textopesquisa1, textopesquisa2, textopesquisa3, textopesquisa4);
	//	} else {
	//		listadenuncia = denunciaDAO.listar();

	//	}
		request.setAttribute("listadenuncia", listadenuncia);
		destino = "/c_denuncia.jsp";
	}

	protected void consultareditardenuncia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String auxiliar = "";
		iddenuncia = Integer.parseInt(request.getParameter("iddenuncia"));
		denuncia.setIddenuncia(iddenuncia);
		denuncia = denunciaDAO.consultar_editar(denuncia);
		request.setAttribute("denuncia", denuncia);
		destino = "/denuncia.jsp";
	}

	protected void excluirdenuncia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		iddenuncia = Integer.parseInt(request.getParameter("iddenuncia"));
		denuncia.setIddenuncia(iddenuncia);
		request.setAttribute("denuncia", denuncia);
		denunciaDAO.excluir(denuncia);
		List<Denuncia> listadenuncia = new ArrayList<Denuncia>();
		listadenuncia = denunciaDAO.listar(textopesquisa1, textopesquisa2, textopesquisa3, textopesquisa4);
		request.setAttribute("listadenuncia", listadenuncia);
		destino = "/c_denuncia.jsp";
	}
}