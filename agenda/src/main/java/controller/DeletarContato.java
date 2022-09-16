package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.DAO;

@WebServlet("/DeletarContato")
public class DeletarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deletandoContato(request, response);
	}

	protected void deletandoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idcon = Integer.parseInt(request.getParameter("idcon"));
		
		Contato contato = new Contato();
		
		contato.setIdcon(idcon);
		
		dao.deletarContato(contato);
		
		contatos(request, response);
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Contato> listar = dao.listarContatos();
		
		request.setAttribute("contatos", listar);
		
		RequestDispatcher rd = request.getRequestDispatcher("agendaContatos.jsp");
		rd.forward(request, response);
	}

}
