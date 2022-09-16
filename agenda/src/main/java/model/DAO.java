package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda";
	private String user = "root";
	private String password = "root";
	
	protected Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void adicionarContatos(Contato contato) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			 conn = conectar();
			 
			 ps = conn.prepareStatement("INSERT INTO contatos (nome,fone,email) VALUES (?,?,?)");
			 
			 ps.setString(1, contato.getNome());
			 ps.setString(2, contato.getFone());
			 ps.setString(3, contato.getEmail());
			 
			 ps.executeUpdate();
			 
			 ps.close();
			 conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Contato> listarContatos(){
		ArrayList<Contato> lista = new ArrayList<>();
		
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = conectar();
			
			ps = conn.prepareStatement("SELECT * FROM contatos");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int idcon = rs.getInt(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				lista.add(new Contato(idcon,nome,fone,email));
				
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void selecionarContato(Contato contato) {
		try {
			Connection conn = conectar();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM contatos WHERE idcon = ?");
			
			ps.setInt(1, contato.getIdcon());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				contato.setIdcon(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarContato(Contato contato) {
		
		try {
			Connection conn = conectar();
			
			PreparedStatement ps = conn.prepareStatement("UPDATE contatos SET nome=?, fone=?, email=? WHERE idcon=?");
			
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getFone());
			ps.setString(3, contato.getEmail());
			ps.setInt(4, contato.getIdcon());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarContato(Contato contato) {
		try {
			Connection conn = conectar();
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM contatos WHERE idcon=?");
			
			ps.setInt(1, contato.getIdcon());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
