package tarea.com.mvc.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdministratorView extends JFrame {

	public JPanel contentPane;
	public JLabel lblEntregados;
	public JLabel lblTotal;
	public JLabel lblNoEntregados;
	public JLabel llblTotaL3;
	public JPanel panelPedidos;

	public AdministratorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 590);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(15, 0, 15, 0));
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblListaDePedidos = new JLabel("Lista de Pedidos");
		lblListaDePedidos.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		panelTitulo.add(lblListaDePedidos);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.add(panelInformacion, BorderLayout.NORTH);
		panelInformacion.setLayout(new GridLayout(1, 2, 20, 0));
		
		JPanel panel_1 = new JPanel();
		panelInformacion.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));
		
		JLabel lbl = new JLabel("Entregados:\r\n");
		lbl.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbl);
		
		lblEntregados = new JLabel("0\r\n");
		lblEntregados.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_1.add(lblEntregados);
		
		JLabel lbl2 = new JLabel("TOTAL: ");
		lbl2.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbl2);
		
		lblTotal = new JLabel("0\r\n");
		lblTotal.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_1.add(lblTotal);
		
		JPanel panel_2 = new JPanel();
		panelInformacion.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lbl3 = new JLabel("No Entregados:");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_2.add(lbl3);
		
		lblNoEntregados = new JLabel("0\r\n");
		lblNoEntregados.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_2.add(lblNoEntregados);
		
		JLabel lbl4 = new JLabel("Total:");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_2.add(lbl4);
		
		llblTotaL3 = new JLabel("0\r\n");
		llblTotaL3.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		panel_2.add(llblTotaL3);
		
		panelPedidos = new JPanel();
		FlowLayout fl_panelPedidos = (FlowLayout) panelPedidos.getLayout();
		fl_panelPedidos.setHgap(40);
		panel.add(panelPedidos, BorderLayout.CENTER);
	}
	
	public void init() {
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("GESTION DE PEDIDOS");
	}
	
	public void setContentOrders(JComponent c) {
		panelPedidos.add(c);
		panelPedidos.repaint();
		panelPedidos.revalidate();
	}
}
