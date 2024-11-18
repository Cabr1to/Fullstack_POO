package model;

public class Usuario {
	
	private String user;
	private String password;
	private String perfil;
	private boolean lembrarLogin;
	private String curso;
	
	
	public Usuario(String user, String password, String perfil, boolean lembrarLogin, String curso) {
		this.user = user;
		this.password = password;
		this.perfil = perfil;
		this.lembrarLogin = lembrarLogin;
		this.curso = curso;
	}
	
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public boolean isLembrarLogin() {
		return lembrarLogin;
	}


	public void setLembrarLogin(boolean lembrarLogin) {
		this.lembrarLogin = lembrarLogin;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public Usuario()
	{
		this(null, null, null,false, null);
	}

}
