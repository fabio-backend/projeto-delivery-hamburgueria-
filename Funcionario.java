package view;

import java.awt.Color;
import model.UsuarioLogado;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Funcionario extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	private JLabel lblusuario;
	private JLabel lblHora;

	DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario frame = new Funcionario();
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
	public Funcionario() {
		initComponents();
		Thread relogioThread = new Thread(new Funcionario.HoraThread());
		relogioThread.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(41, 59, 540, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("Data");
		lblData.setBackground(new Color(53, 87, 125));
		lblData.setBounds(110, 116, 277, 14);
		panel.add(lblData);
		 Date data = new Date();
	     DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
	     lblData.setText(formatador.format(data));
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(110, 147, 158, 14);
		panel.add(lblHora);
		lblHora.setText(formatoHora.format(new Date()));
		
		
		lblusuario = new JLabel();
		lblusuario.setBounds(110, 80, 46, 14);
		panel.add(lblusuario);

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
	


	
