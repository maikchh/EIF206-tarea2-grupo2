package tarea.com.mvc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrdersMenu extends JFrame {

	public JPanel contentPane;
	public JTextField txtHost;
	public JTextField txtXCliente;
	public JLabel lblCantidad;
	public JButton btnEnviarPedido;
	public JComboBox comboBox;
	public JButton btnConectar;
	public JButton btnAgregar;
	public JButton btnQuitar;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;

	public OrdersMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblSolicitarPedido = new JLabel("Solicitar Pedido");
		lblSolicitarPedido.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		panel.add(lblSolicitarPedido);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(15);
		panel_2.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		panel_2.add(lblHost);
		
		txtHost = new JTextField();
		txtHost.setText("127.0.0.1");
		txtHost.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		panel_2.add(txtHost);
		txtHost.setColumns(40);
		
		btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_2.add(btnConectar);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(10, 80, 10, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setHgap(18);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblPedido = new JLabel("Pedido");
		lblPedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblPedido.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_4.add(lblPedido);
		
		comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(500, 30));
		comboBox.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		panel_4.add(comboBox);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_4.add(btnAgregar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(10, 10, 10, 0));
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setHgap(20);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_5, BorderLayout.SOUTH);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_5.add(lblCliente);
		
		txtXCliente = new JTextField();
		txtXCliente.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_5.add(txtXCliente);
		txtXCliente.setColumns(30);
		
		btnEnviarPedido = new JButton("Enviar Pedido");
		btnEnviarPedido.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_5.add(btnEnviarPedido);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(20);
		panel_6.add(panel_7, BorderLayout.SOUTH);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_7.add(lblTotal);
		
		lblCantidad = new JLabel("0");
		lblCantidad.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_7.add(lblCantidad);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_7.add(btnQuitar);
		
		scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}
	
	public void init() {
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Menu de pedidos");
	}
	
	public void allowChat(boolean allow) {
		
		btnAgregar.setEnabled(allow);
		btnEnviarPedido.setEnabled(allow);
		comboBox.setEnabled(allow);
		txtXCliente.setEnabled(allow);
		btnQuitar.setEnabled(allow);
		
	}

}
