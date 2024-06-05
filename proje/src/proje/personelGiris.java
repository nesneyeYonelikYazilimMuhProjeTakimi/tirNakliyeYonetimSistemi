package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proje.connection.connectdb;
import proje.connection.personelConnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class personelGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField personelid;

	/**
	 * Launch the application.
	 */
	public static void sayfa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personelGiris frame = new personelGiris();
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
	public personelGiris() {
		setTitle("Personel Giriş");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personel ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 82, 84, 16);
		contentPane.add(lblNewLabel);
		
		personelid = new JTextField();
		personelid.setBounds(171, 83, 96, 19);
		contentPane.add(personelid);
		personelid.setColumns(10);
		
		JButton btnNewButton = new JButton("Giriş");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(personelid.getText());
				
				personelConnect p = new personelConnect();
				if(p.personelMi(id)) {
					if(p.yoneticiMi(id)) {
						yoneticiSayfa yonetici = new yoneticiSayfa();
						yonetici.sayfa(id);
					}
					else {
						soforSayfa sofor = new soforSayfa();
						sofor.sayfa(id);
					}
				}
				/*connectdb db = new connectdb();
				if(db.calisanKontrol(id)) {
					if(db.yoneticiKontrol(id)) {
						yoneticiSayfa yonetici = new yoneticiSayfa();
						yonetici.sayfa(id);
					}
					else {
						soforSayfa sofor = new soforSayfa();
						sofor.sayfa();
					}
				}*/
			}
		});
		btnNewButton.setBounds(181, 112, 85, 21);
		contentPane.add(btnNewButton);
	}
}
