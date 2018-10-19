package br.insper.tecweb.p2.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAONota {
	private Connection connection = null;
	public DAONota() {
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			connection = DriverManager.getConnection(
			"jdbc:mysql://localhost/projeto1", "root", "senha123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Notas> getListaNota(String idlog) {
		List<Notas> notas = new ArrayList<Notas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Notas where usuario_abriu=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer idl= Integer.parseInt(idlog);
		try {
			//System.out.println(nota.getAberta());
			stmt.setInt(1,idl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Notas nota = new Notas();
				nota.setId(rs.getInt("id"));
				nota.setTitulo(rs.getString("titulo"));
				nota.setTexto(rs.getString("texto"));
				nota.setCor(rs.getString("cor"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("prazo_final_nota"));
				nota.setPrazo_final(cal);
				
				cal.setTime(rs.getDate("data_criacao"));
				nota.setData_criacao(cal);
				
				notas.add(nota);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notas;
		}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void adiciona(Notas nota) {
		String sql = "INSERT INTO Notas" +


		"(aberta,usuario_abriu,titulo,texto,cor,prazo_final_nota,data_criacao) values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//System.out.println(nota.getAberta());
			stmt.setInt(1,nota.getAberta());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//System.out.println(nota.getUsuario_abriu());
			stmt.setInt(2,nota.getUsuario_abriu());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			//System.out.println(nota.getTitulo());
			stmt.setString(3,nota.getTitulo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			//System.out.println(nota.getTexto());
			stmt.setString(4,nota.getTexto());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//System.out.println(nota.getCor());
			stmt.setString(5,nota.getCor());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		
		try {
			//System.out.println(nota.getPrazo_final());
			stmt.setDate(6,new Date(nota.getPrazo_final().getTimeInMillis()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//System.out.println(nota.getData_criacao());
			stmt.setDate(7,new Date(nota.getData_criacao().getTimeInMillis()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void altera(Notas nota) {
		String sql = "UPDATE Notas SET " +
				"aberta=?,titulo=?, texto=?, cor=?,prazo_final_nota=? WHERE id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setInt(1, nota.getAberta());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(2, nota.getTitulo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(3, nota.getTexto());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		try {
			stmt.setString(4,nota.getCor());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//System.out.println(nota.getPrazo_final());
			stmt.setDate(5,new Date(nota.getPrazo_final().getTimeInMillis()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setInt(6, nota.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void remove(Integer id) {
		PreparedStatement stmt = null;
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM Notas WHERE id=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setLong(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
}
