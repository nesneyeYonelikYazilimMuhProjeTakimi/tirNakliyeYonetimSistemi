package proje;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proje.connection.musteriConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class musteriGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField musteriNo;

	/**
	 * Launch the application.
	 */
	public void sayfa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteriGiris frame = new musteriGiris();
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
	public musteriGiris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		musteriConnect m = new musteriConnect();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		musteriNo = new JTextField();
		musteriNo.setBounds(111, 25, 96, 19);
		contentPane.add(musteriNo);
		musteriNo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("musteri No:");
		lblNewLabel.setBounds(22, 25, 79, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Giriş");
		btnNewButton.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(musteriNo.getText());
				if(m.musteriMi(id)) {
					yukSayfa musteri = new yukSayfa();
					musteri.sayfa(id);
				}
				
			}
			});
		btnNewButton.setBounds(106, 64, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
