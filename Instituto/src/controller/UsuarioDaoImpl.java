package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Usuario;
import util.DBConnection;

public class UsuarioDaoImpl implements UsuarioDAO {

	@Override
	public List<Usuario> getallUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Usuario user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteUser(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarUser(Usuario user) {
		
		Connection conn = DBConnection.getConnection();
		
		try {
			PreparedStatement ps 
				= conn.prepareStatement(
						" INSERT INTO LOGIN(userLogin, senhaLogin, perfilLogin, lembrarLogin, cursoLogin)"
						+ "VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPerfil());
			ps.setBoolean(4, user.isLembrarLogin());
			ps.setString(5, user.getCurso());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
