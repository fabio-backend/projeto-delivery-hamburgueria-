package view;

import java.awt.EventQueue;    
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import model.UsuarioLogado;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.text.Collator;
import java.text.MessageFormat;
import java.text.StringCharacterIterator;


@SuppressWarnings("unused")
public class Login extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
   
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		 initComponents();
		
		setTitle("Hamburgueria Styllus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 250, 317, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(41, 46, 63, 20);
		panel.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(41, 64, 234, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(41, 99, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnEntrar = new JButton(" Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			
			/**
			 * chamar a clase UsuarioDTO
			 */
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			//private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
			Logar();
				
			}

		});
		btnEntrar.setBounds(114, 157, 89, 23);
		panel.add(btnEntrar);
		
		JLabel lblNewLabel_2 = new JLabel("     Bem vindo!");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(77, 15, 162, 14);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 114, 234, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/view/imagens/Styllus Hamburgueria 4.jpg")));
		lblNewLabel_3.setBounds(54, 28, 254, 205);
		contentPane.add(lblNewLabel_3);
	}
     

		private void Logar() {
        	try {
				String nome_usuario, senha_usuario;
				
				nome_usuario = textFieldUsuario.getText();
				senha_usuario = passwordField.getText();
			
			 // instanciando a classe DTO e criando o objeto objusuariodto
				UsuarioDTO objusuariodto = new UsuarioDTO();
				objusuariodto.setNome_usuario(nome_usuario);
				objusuariodto.setSenha_usuario(senha_usuario);
			
			// instanciando a classe DAO e criando o objeto objusuariodao
				UsuarioDAO objusuariodao = new UsuarioDAO();
				ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);
				
			// estrutura If e Else (se rsusuariodao obter algum resultado do banco positivo entao ok acesso liberado caso nao sera negado o acesso)
				if (rsusuariodao.next()) {
			 // a estrutura abaixo faz o tratamento do usuario
					String perfil=rsusuariodao.getString(5);
					String usuario=rsusuariodao.getString(3);
				if (perfil.equals("ADMIN")) {
			// chamar tela que eu quero abrir
				Painel objpainel = new Painel();
				objpainel.setVisible(true);
				Painel objusuario = new Painel();
			    objusuario.lblusuario.setVisible(true);
			    //UsuarioLogado usuariologado = new UsuarioLogado();
			   //Painel.lblusuario.setText(rsusuariodao.getString(3));
				
			       dispose();
	       		
			}else {
			// chamar tela que eu quero abrir
			Menu objmenu = new Menu();
			objmenu.setVisible(true);
		
			// fechar a tela login
					dispose();
			}
					
		 }	
	        	
				else {
				
				// enviar mensagem dizendo incorreto.
			    JOptionPane.showMessageDialog(null, "Verifique as informações");
				}
				
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Login" + erro);
				
			}
        	
        }
		 @SuppressWarnings({ "unused", "null" })
			private void initComponents() {
			   

		        //desktop = new javax.swing.JDesktopPane();


		    }
	
}
