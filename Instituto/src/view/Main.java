
package view;

import javax.swing.JFrame;

public class Main
{

	public static void main(String[] args)
	{
		Janela login = new Janela("Login/Cadastro");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(300,600);
		login.setVisible(true);
		login.setResizable(false);
		

	}

}