package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DenunciaDAO;
import model.Denuncia;

@WebServlet(name = "ServletDenuncia", urlPatterns = "/denuncia")
public class ServletDenuncia extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DenunciaDAO denunciaDAO = new DenunciaDAO();
	private Denuncia denuncia = new Denuncia();
	private String destino = "";
	private int iddenuncia;
	private String denunciante;
	private String cep;
	private String data_string;
	private Date data_denuncia;
	private String bairro;
	private String rua;
	private String quadra;
	private int lote = 0;
	private String numero;
	private String cidade;
	private String tp_imovel;
	private String desc_den;
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
			iddenuncia = Integer.parseInt(request.getParameter("iddenuncia"));

		} catch (NumberFormatException number) {
			acao = true;
			adicionaDenuncia(request, response);
			destino = "/c_denuncia.jsp";
		}

		if (acao == false) {
			denuncia.setIddenuncia(iddenuncia);
			denunciaDAO.existe(denuncia);
			if (denunciaDAO.existe(denuncia) == true) {
				editarDenuncia(request, response);
				destino = "/c_denuncia.jsp";
			}
		}		

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	protected void adicionaDenuncia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		denunciante = request.getParameter("denunciante");
		cep = request.getParameter("cep");
		data_string = request.getParameter("data_denuncia");
		bairro = request.getParameter("bairro");
		rua = request.getParameter("rua");
		quadra = request.getParameter("quadra");
		lote = Integer.parseInt(request.getParameter("lote"));
		numero = request.getParameter("numero");
		cidade = request.getParameter("cidade");
		tp_imovel = request.getParameter("tp_imovel");
		desc_den = request.getParameter("desc_den");

		try {

			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				data_denuncia = (Date) formato.parse(data_string);
				denuncia.setData_denuncia(data_denuncia);
			} catch (Exception e) {
				System.out.println("Erro ao formatar data.");
			}
			denuncia.setDenunciante(denunciante);
			denuncia.setCep(cep);
			denuncia.setBairro(bairro);
			denuncia.setBairro(bairro);
			denuncia.setRua(rua);
			denuncia.setQuadra(quadra);
			denuncia.setLote(lote);
			denuncia.setNumero(numero);
			denuncia.setCidade(cidade);
			denuncia.setTp_imovel(tp_imovel);
			denuncia.setDesc_den(desc_den);

		} catch (Exception e) {
			System.out.println("Parametro incorreto.");
		}
		if (denunciaDAO.inserir(denuncia) == true)
			message = "Erro ao Gravar Registro";
		else
			message = "Registro Gravado com Sucesso";

	}

	protected void editarDenuncia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		iddenuncia = Integer.parseInt(request.getParameter("iddenuncia"));
		denunciante = request.getParameter("denunciante");
		cep = request.getParameter("cep");
		data_string = request.getParameter("data_denuncia");
		bairro = request.getParameter("bairro");
		rua = request.getParameter("rua");
		quadra = request.getParameter("quadra");
		lote = Integer.parseInt(request.getParameter("lote"));
		numero = request.getParameter("numero");
		cidade = request.getParameter("cidade");
		tp_imovel = request.getParameter("tp_imovel");
		desc_den = request.getParameter("desc_den");

		try {

			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				data_denuncia = (Date) formato.parse(data_string);
				denuncia.setData_denuncia(data_denuncia);
			} catch (Exception e) {
				System.out.println("Erro ao formatar data.");
			}
			denuncia.setIddenuncia(iddenuncia);
			denuncia.setDenunciante(denunciante);
			denuncia.setCep(cep);
			denuncia.setBairro(bairro);
			denuncia.setRua(rua);
			denuncia.setQuadra(quadra);
			denuncia.setLote(lote);
			denuncia.setNumero(numero);
			denuncia.setCidade(cidade);
			denuncia.setTp_imovel(tp_imovel);
			denuncia.setDesc_den(desc_den);
			

		} catch (Exception e) {
			System.out.println("Parametro incorreto.");
		}

		if (denunciaDAO.alterar(denuncia) == true)
			message = "Erro ao Alterar Registro";
		else
			message = "Registro Alterado com Sucesso";
	}
}