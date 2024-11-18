package controller;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> getallUsers();
	public Usuario getUser(String user);
	public void updateUser(Usuario user);
	public void deleteUser(Usuario user);
	public void adicionarUser(Usuario user);
}
