package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.UsuarioDaoImpl;
import model.Usuario;

import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class Janela extends JFrame
{

	private final JLabel userLabel;
	private final JLabel senhaLabel;
	private final JLabel iconLabel;
	private final JTextField userField;
	private final JPasswordField passwordField;
	private final JButton acessarButton;
	private final JButton cadastrarButton;
	private final JCheckBox checkBox;
	private final JRadioButton docenteRadio;
	private final JRadioButton discenteRadio;
	private final ButtonGroup bg;
	private final JComboBox comboBox;
	private final String[] cursos= {"Engenharia de Software", "Sistemas de Informação", "Ciência da Computação", "Análise e Desenvolvimento de Software", "Medicina", "Medicina Veterinária", "Enfermagem"};

	public Janela(String titulo)
	{	
		super(titulo);
		setLayout(new FlowLayout());

		ImageIcon icon = new ImageIcon("/img/group.png");
		Image img = icon.getImage().getScaledInstance(256,256,Image.SCALE_SMOOTH);
		iconLabel = new JLabel(new ImageIcon(img));

		Font fonte = new Font("Dialog",Font.PLAIN,22);

		userLabel = new JLabel("Usuário:");
		userLabel.setFont(fonte);
		senhaLabel = new JLabel("Senha:");
		senhaLabel.setFont(fonte);

		userField = new JTextField("usuário",10);
		passwordField = new JPasswordField("senha", 10);

		acessarButton = new JButton("Acessar");
		acessarButton.setFont(fonte);
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(fonte);

		docenteRadio = new JRadioButton("Docente");
		docenteRadio.setFont(fonte);
		discenteRadio = new JRadioButton("Discente");
		discenteRadio.setFont(fonte);

		bg = new ButtonGroup();
		bg.add(docenteRadio);
		bg.add(discenteRadio);
	
		checkBox = new JCheckBox("Lembrar-me");

		comboBox = new JComboBox<String>(cursos);
		comboBox.setMaximumRowCount(3);

		add(iconLabel);
		add(userLabel);
		add(userField);
		add(senhaLabel);
		add(passwordField);
		add(acessarButton);
		add(cadastrarButton);
		add(docenteRadio);
		add(discenteRadio);
		add(checkBox);
		add(comboBox);

		ComponentsHandler handler = new ComponentsHandler();
		acessarButton.addActionListener(handler);
		cadastrarButton.addActionListener(handler);
		checkBox.addItemListener(handler);
		docenteRadio.addItemListener(handler);
		discenteRadio.addItemListener(handler);

	}

	private class ComponentsHandler implements ActionListener, ItemListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			UsuarioDaoImpl userDAO = new UsuarioDaoImpl();
			
			if(event.getSource()==cadastrarButton)
			{
				Usuario user = new Usuario(
						userField.getText(),
						passwordField.getText(),
						(docenteRadio.isSelected() ? "Docente": "Discente"),
						(checkBox.isSelected() ? true:false),
						(String)comboBox.getSelectedItem());
			
			userDAO.adicionarUser(user);
			
			JOptionPane.showMessageDialog(Janela.this, "Usuário cadastrado com sucesso!");
			
			}
		}

		@Override
		public void itemStateChanged(ItemEvent event)
		{

			if(docenteRadio.isSelected())
				System.out.println("Docente selecionado.");
		}
	}

}