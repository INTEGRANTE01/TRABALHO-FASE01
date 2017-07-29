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
import model.VisitaDAO;
import model.Visita;

@WebServlet(name = "ServletVisita", urlPatterns = "/visita")
public class ServletVisita extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private VisitaDAO VisitaDAO = new VisitaDAO();
	private Visita visita = new Visita();
	private String destino = "";
	private int idvisita;
	private String agente;			
	private String data_string;
	private Date data_visita;
	private String bairro;
	private String rua;
	private String quadra;
	private int lote = 0;
	private String numero;
	private int cep = 0;
	private String cidade;
	private String latitude;
	private String longitude;
	private String tp_imovel;
	private String estagio;
	private String tp_larvicida;
	private String ac_corretiva;
	private String local_foco;			
	private String message;
	private boolean acao = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF8");
		acao = false;
		 System.out.println(agente = request.getParameter("agente"));

		try {

			idvisita = Integer.parseInt(request.getParameter("idvisita"));
			System.out.println("NA VARIAVEL: " + idvisita);

			if (idvisita<=0){
				acao = true;
				adicionaVisita(request, response);
				destino = "/c_visita.jsp";
			}
			
		} catch (NumberFormatException number) {			
		}

		if (acao == false) {
			visita.setIdvisita(idvisita);
			VisitaDAO.existe(visita);
			if (VisitaDAO.existe(visita) == true) {
				editarVisita(request, response);
				destino = "/c_visita.jsp";
			}
		}

		/*
		 * System.out.println("NA VARIAVEL ACAO: " + acao);
		 * System.out.println("NO metodo existe " +
		 * VisitaDAO.existe(Visita));
		 */

		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	protected void adicionaVisita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  System.out.println(agente = request.getParameter("agente"));
		  data_string = request.getParameter("data_visita");
		  System.out.println("NO DATA_STRING: "  + data_string);
		  bairro =  request.getParameter("bairro");
		  rua =  request.getParameter("rua");
		  quadra = request.getParameter("quadra");
		  lote = Integer.parseInt(request.getParameter("lote"));
		  numero =  request.getParameter("numero");
		  cep = Integer.parseInt(request.getParameter("cep"));
		  cidade =  request.getParameter("cidade");
		  latitude =  request.getParameter("latitude");
		  longitude =  request.getParameter("longitude");
		  tp_imovel =  request.getParameter("tp_imovel");;
		  estagio =  request.getParameter("estagio");;
		  tp_larvicida =  request.getParameter("tp_larvicida");
		  ac_corretiva =  request.getParameter("ac_corretiva");
		  local_foco =  request.getParameter("local_foco");
			
		try {
			
			visita.setAgente(agente);
          	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            data_visita = (Date) formato.parse(data_string);                   
            visita.setData_visita(data_visita); 
            visita.setBairro(bairro);						
			visita.setRua(rua);
			visita.setQuadra(quadra);
			visita.setLote(lote);
			visita.setNumero(numero);
			visita.setCep(cep);
			visita.setCidade(cidade);  
			visita.setLatitude(latitude);
			visita.setLongitude(longitude);
			visita.setTp_imovel(tp_imovel);
			visita.setEstagio(estagio);
			visita.setTp_larvicida(tp_larvicida);
			visita.setAc_corretiva(ac_corretiva);
			visita.setLocal_foco(local_foco);

		} catch (Exception e) {
			System.out.println("Parametro incorreto.");
		}
		if (VisitaDAO.inserir(visita) == true)
			message = "Erro ao Gravar Registro";
		else
			message = "Registro Gravado com Sucesso";
		


	}

	protected void editarVisita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   agente = request.getParameter("agente");
		   data_string = request.getParameter("data_visita");
		   bairro =  request.getParameter("bairro");
		   rua =  request.getParameter("rua");
		   quadra = request.getParameter("quadra");
		   lote = Integer.parseInt(request.getParameter("lote"));
		   numero =  request.getParameter("numero");
		   cep = Integer.parseInt(request.getParameter("cep"));
		   cidade =  request.getParameter("cidade");
		   latitude =  request.getParameter("latitude");
		   longitude =  request.getParameter("longitude");
		   tp_imovel =  request.getParameter("tp_imovel");;
		   estagio =  request.getParameter("estagio");;
		   tp_larvicida =  request.getParameter("tp_larvicida");
		   ac_corretiva =  request.getParameter("ac_corretiva");
		   local_foco =  request.getParameter("local_foco");
		  
		try {
			
			visita.setAgente(agente);
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	        data_visita = (Date) formato.parse(data_string);                   
	        visita.setData_visita(data_visita);     		
			visita.setIdvisita(idvisita);
			visita.setBairro(bairro);					
			visita.setRua(rua);
			visita.setQuadra(quadra);
			visita.setLote(lote);
			visita.setNumero(numero);
			visita.setCep(cep);
			visita.setCidade(cidade);
			visita.setLatitude(latitude);
			visita.setLongitude(longitude);
			visita.setTp_imovel(tp_imovel);
			visita.setEstagio(estagio);
			visita.setTp_larvicida(tp_larvicida);
			visita.setAc_corretiva(ac_corretiva);
			visita.setLocal_foco(local_foco);

		} catch (Exception e) {
			System.out.println("Parametro incorreto.");
		}

		if (VisitaDAO.alterar(visita) == true)
			message = "Erro ao Alterar Registro";
		else
			message = "Registro Alterado com Sucesso";
	}
}