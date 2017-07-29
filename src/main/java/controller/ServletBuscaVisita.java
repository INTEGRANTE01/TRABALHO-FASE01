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
import model.VisitaDAO;
import model.Visita;

@WebServlet(name="ServletBuscaVisita", urlPatterns = "/buscavisita")
public class ServletBuscaVisita extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private VisitaDAO visitaDAO = new VisitaDAO();
	private Visita visita = new Visita();
	private int idvisita;
	private String destino = "";
	private String acao;
	private String message;
	private String textopesquisa1; 
	private String textopesquisa2; 
	private String textopesquisa3;
	private String textopesquisa4;
	private String textopesquisa5; 
	private String textopesquisa6;
	private Date data_formatada;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			acao = request.getParameter("acao");	
			if(acao!=null){
				if(acao.equalsIgnoreCase("Consultar")){
					consultareditarvisita(request, response);
					RequestDispatcher rd = request.getRequestDispatcher(destino);
				    rd.forward(request, response); 
				}else if(acao.equalsIgnoreCase("Excluir")){
					excluirvisita(request,response);
					RequestDispatcher rd = request.getRequestDispatcher(destino);
				    rd.forward(request, response); 
				}
			}					
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
			
			request.setCharacterEncoding("UTF8");
			buscarvisita(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(destino);
	     	rd.forward(request, response);
		
	}
	protected void buscarvisita(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException, IOException {

			textopesquisa1 = request.getParameter("txtpesquisa1");
			textopesquisa2 = request.getParameter("txtpesquisa2");		
			textopesquisa3 = request.getParameter("txtpesquisa3");
			textopesquisa4 = request.getParameter("txtpesquisa4");	
			textopesquisa5 = request.getParameter("txtpesquisa5");
			textopesquisa6 = request.getParameter("txtpesquisa6");

			List<Visita> listavisita = new ArrayList<Visita>();
			
			
	      //  if((textopesquisa1!="" && textopesquisa1!=null)
	      //  		|| (textopesquisa2!="" && textopesquisa2!=null)
	      //  		|| (textopesquisa3!="" && textopesquisa3!=null)
	      //  		|| (textopesquisa4!="" && textopesquisa4!=null)
	      //  		|| (textopesquisa5!="" && textopesquisa5!=null)){

				    		
				listavisita = visitaDAO.listar(textopesquisa1, textopesquisa2, textopesquisa3, textopesquisa4, textopesquisa5, textopesquisa6);				
		   //  }else{
		   // 	listavisita = visitaDAO.listar();	
		   // }	 
	        request.setAttribute("listavisita", listavisita);
			destino = "/c_visita.jsp";
	}  
	 protected void consultareditarvisita(HttpServletRequest request,
	 		    HttpServletResponse response) throws ServletException, IOException {
			 	
		 		String auxiliar = ""; 	 	
		 		idvisita = Integer.parseInt(request.getParameter("idvisita")); 			
				visita.setIdvisita(idvisita);			
				visita = visitaDAO.consultar_editar(visita);					
		        request.setAttribute("visita", visita);
				destino = "/visita.jsp";	
		}
	 
	 protected void excluirvisita(HttpServletRequest request,
	 		    HttpServletResponse response) throws ServletException, IOException {

		 		idvisita = Integer.parseInt(request.getParameter("idvisita"));
				visita.setIdvisita(idvisita);			
				request.setAttribute("visita", visita);
				visitaDAO.excluir(visita);
				List<Visita> listavisita = new ArrayList<Visita>();    		
	        	listavisita = visitaDAO.listar(textopesquisa1, textopesquisa2, textopesquisa3, textopesquisa4, textopesquisa5, textopesquisa6);
				request.setAttribute("listavisita", listavisita);				
				destino = "/c_visita.jsp";	
		}
}