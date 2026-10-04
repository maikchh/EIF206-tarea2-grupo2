package tarea.com.mvc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tarea.com.mvc.models.Administrador;

public class OrdersPanel extends JPanel {
	public JLabel lblTotalCantidadDel;
	public JLabel lblEstado;
	public JLabel lblNumero;
	public JLabel lblNombre;
	public JButton btnButton;
	public DefaultListModel<String> model;
	public JScrollPane scrollPane;
	public JList listPlatillos;
	
	/**
	 * Create the panel.
	 */
	public OrdersPanel(Administrador administrador) {
		this.setPreferredSize(new Dimension(400, 300));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		JPanel panelButton = new JPanel();
		panelButton.setBorder(new EmptyBorder(15, 15, 15, 0));
		FlowLayout flowLayout = (FlowLayout) panelButton.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panelButton, BorderLayout.SOUTH);
		
		btnButton = new JButton("Entregar\r\n");
		btnButton.addActionListener(e->{
			btnButton.setVisible(false);
			this.lblEstado.setText("Entregado");
			int id = Integer.parseInt(this.lblNumero.getText()) - 1 ;
			
			administrador.changeStatus(id+1);
			administrador.setEntregados(id);
		});
		
		btnButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnButton.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panelButton.add(btnButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(15, 10, 15, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setHgap(25);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblPedido = new JLabel("Pedido: \r\n");
		lblPedido.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel.add(lblPedido);
		
		lblNumero = new JLabel("0");
		lblNumero.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel.add(lblNumero);
		
		lblNombre = new JLabel("Nombre del Cliente");
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel.add(lblNombre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 25, 0, 0));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 1, 0, 5));
		
		JLabel lblPlatillos = new JLabel("Platillos:");
		lblPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlatillos.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_1.add(lblPlatillos);
		
		
		model = new DefaultListModel<>();
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		listPlatillos = new JList(model);
		//listPlatillos.setModel(model);
		scrollPane.setViewportView(listPlatillos);
		
		lblTotalCantidadDel = new JLabel("TOTAL: cantidad del precio final");
		lblTotalCantidadDel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_1.add(lblTotalCantidadDel);

		
		lblEstado = new JLabel("Estado:\r\n");
		lblEstado.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_1.add(lblEstado);

	}
	
	

}
