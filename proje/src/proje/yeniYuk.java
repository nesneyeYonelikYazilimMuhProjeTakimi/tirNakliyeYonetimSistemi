package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proje.connection.agirYuk;
import proje.connection.hafifYuk;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class yeniYuk extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static int musteriid;
	private JTextField ilkil;
	private JTextField agirlik;
	private JTextField sonil;

	/**
	 * Launch the application.
	 */
	public static void sayfa(int id) {
		musteriid = id;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yeniYuk frame = new yeniYuk();
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
	public yeniYuk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Başlangıç ili");
		lblNewLabel.setBounds(58, 22, 113, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Yük ağırlığı");
		lblNewLabel_1.setBounds(58, 105, 99, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Götürülecek il");
		lblNewLabel_2.setBounds(58, 61, 99, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(agirlik.getText());
				String ail = ilkil.getText();
				String sil = sonil.getText();
				if(a<=15) {
					hafifYuk hy = new hafifYuk(a,sil,ail);
				}
				else {
					agirYuk ay = new agirYuk(a,sil,ail);
				}
			}
		});
		btnNewButton.setBounds(167, 148, 96, 21);
		contentPane.add(btnNewButton);
		
		ilkil = new JTextField();
		ilkil.setBounds(167, 19, 96, 19);
		contentPane.add(ilkil);
		ilkil.setColumns(10);
		
		agirlik = new JTextField();
		agirlik.setBounds(167, 102, 96, 19);
		contentPane.add(agirlik);
		agirlik.setColumns(10);
		
		sonil = new JTextField();
		sonil.setBounds(167, 58, 96, 19);
		contentPane.add(sonil);
		sonil.setColumns(10);
	}

}
