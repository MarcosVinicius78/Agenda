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

@WebServlet("/EditarContato")
public class EditarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Contato contato = new Contato();
	
	DAO dao = new DAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editarContato(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editandoContato(request, response);
	}
	
	protected void editandoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idcon = Integer.parseInt(request.getParameter("idcon"));
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		
		Contato contato = new Contato(idcon, nome, fone, email);
		
		dao.editarContato(contato);;
		
		contatos(request, response);
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		
		contato.setIdcon(Integer.parseInt(idcon));
		
		dao.selecionarContato(contato);
		
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		
		RequestDispatcher rd = request.getRequestDispatcher("editarContato.jsp");
		rd.forward(request, response);
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Contato> listar = dao.listarContatos();
		
		request.setAttribute("contatos", listar);
		
		RequestDispatcher rd = request.getRequestDispatcher("agendaContatos.jsp");
		rd.forward(request, response);
	}

}
