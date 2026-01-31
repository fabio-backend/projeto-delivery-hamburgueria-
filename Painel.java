package view;

import java.awt.EventQueue;    
import javax.swing.JFrame;
import model.UsuarioLogado;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import java.util.Date;
import java.awt.Label;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.InputEvent;
import java.awt.SystemColor;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import view.Login;


@SuppressWarnings("unused")
public class Painel extends javax.swing.JFrame {
	





	@SuppressWarnings("unused")
	private void formWindowActivated(java.awt.event.WindowEvent evt) {
		
		
	}

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	public JLabel lblusuario;
	private JLabel lblHora;

	DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Painel frame = new Painel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class HoraThread implements Runnable {
		
		public void run() {
			while (true) {
				lblHora.setText(formatoHora.format(new Date()));
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					System.out.println("Thread nao foi finalizado  + ex");
				}
		    }
		  }
		}
	/**
	 * Create the frame.
	 */
	public Painel() {
		initComponents();
		// instanciando a hora correte do sistema
		Thread relogioThread = new Thread(new Painel.HoraThread());
		relogioThread.start();
		setResizable(false);
		setTitle("STYLLUS HAMBURGUERIA - Gerencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1435, 916);
		// deixar a tela maximizada
		setExtendedState(MAXIMIZED_BOTH);
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		
		JMenu mnMenu1 = new JMenu("Informações");
		JMenu mnMenuCad = new JMenu("Cadastro");
		JMenu mnMenu4 = new JMenu("Cad. Fornecedor");
		JMenu mnMenu6 = new JMenu("Clientes");
		JMenu mnMenu7 = new JMenu("Ajuda");
		JMenu mnMenu8 = new JMenu("Opções");
		barra.add(mnMenu1);
		
		JMenuItem mnItemMdados = new JMenuItem("Meus dados");
		mnMenu1.add(mnItemMdados);
		
		JMenuItem mnItemMfolgas = new JMenuItem("Minhas Folgas");
		mnMenu1.add(mnItemMfolgas);
		barra.add(mnMenuCad);
		
		JMenuItem mnItem_CadFuncionario = new JMenuItem("Cadastro Funcionário");
		mnItem_CadFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		mnItem_CadFuncionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mnMenuCad.add(mnItem_CadFuncionario);
		
		JMenuItem mnItemCadFornecedor = new JMenuItem("Cadastro Fornecedor");
		mnItemCadFornecedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		mnMenuCad.add(mnItemCadFornecedor);
		
		JMenuItem mnItemCadProduto = new JMenuItem("Cadastro Produto");
		mnItemCadProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		mnMenuCad.add(mnItemCadProduto);
		
		JMenu mnMenuRelat = new JMenu("Relátorio");
		barra.add(mnMenuRelat);
		
		JMenuItem mnMenuItemVendas_Semanal = new JMenuItem("Vendas Semanal");
		mnMenuRelat.add(mnMenuItemVendas_Semanal);
		
		JMenuItem mntMenuItemVendas_Mensal = new JMenuItem("Vendas Mensal");
		mnMenuRelat.add(mntMenuItemVendas_Mensal);
		
		JMenuItem mntMenuItemDespesas_Variavel = new JMenuItem("Despesas Variaveis");
		mnMenuRelat.add(mntMenuItemDespesas_Variavel);
		
		JMenuItem mnMenuItemEscala_Folgas = new JMenuItem("Escala Folgas");
		mnMenuRelat.add(mnMenuItemEscala_Folgas);
		barra.add(mnMenu4);
		
		JMenuItem mnItemUPedidos = new JMenuItem("Ultimo Pedido");
		mnMenu4.add(mnItemUPedidos);
		
		JMenuItem mnItemTPedidos = new JMenuItem("Todos Pedidos");
		mnMenu4.add(mnItemTPedidos);
		
		JMenu mnMenu5 = new JMenu("MotoBoys");
		barra.add(mnMenu5);
		
		JMenuItem mnItemMconsulta = new JMenuItem("Consulta");
		mnMenu5.add(mnItemMconsulta);
		barra.add(mnMenu6);
		
		JMenuItem mnItemConsulta = new JMenuItem("Consulta");
		mnItemConsulta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.ALT_DOWN_MASK));
		mnMenu6.add(mnItemConsulta);
		barra.add(mnMenu7);
		barra.add(mnMenu8);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(53, 87, 125));
		desktopPane.setBounds(10, 11, 1144, 836);
		getContentPane().add(desktopPane);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon("D:\\Projetos imagens\\Projeto Styllus Hamburgueria\\Styllus Hamburgueria 4.jpg"));
		lbllogo.setBounds(1164, 11, 245, 209);
		getContentPane().add(lbllogo);
		// as linhas abaixo substituem a label lblData pela data atual do
		// sistema ao iniciar o form
	    //String usuario = new String();
	   // lblUsuario.setText(usuario);
	    
		
		
		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Arial", Font.BOLD, 18));
		lblData.setBounds(1164, 314, 255, 22);
		getContentPane().add(lblData);
		// as linhas abaixo substituem a label lblData pela data atual do
		// sistema ao iniciar o form
		 Date data = new Date();
	     DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
	     lblData.setText(formatador.format(data));
		
		lblusuario = new JLabel();
		lblusuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblusuario.setText("Olá " + "!");
		lblusuario.setBounds(1164, 274, 245, 14);
		getContentPane().add(lblusuario);
		
		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Arial", Font.BOLD, 18));
		lblHora.setBounds(1164, 352, 255, 22);
		lblHora.setText(formatoHora.format(new Date()));
		getContentPane().add(lblHora);
        }

	 @SuppressWarnings({ "unused", "null" })
		private void initComponents() {
		   

	        //desktop = new javax.swing.JDesktopPane();

		    lblusuario = new javax.swing.JLabel();
	      
	        lblData = new javax.swing.JLabel();
	       
	        lblusuario.setText("Usuário");
	        
	        lblData.setText("Data");
	        
	        lblHora = new javax.swing.JLabel();
	    }



	
}
