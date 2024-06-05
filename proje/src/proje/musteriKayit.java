package proje;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import proje.connection.musteriConnect;

import javax.swing.JLabel;
import javax.swing.JButton;

public class musteriKayit {

	private JFrame frmMteriKayt;
	private JTextField isim;
	private JTextField soyisim;
	private JLabel lblDoumTarihi;
	private JTextField dogtar;
	private JLabel lblTcNo;
	private JTextField tc;
	private JButton kayitbuton;

	/**
	 * Launch the application.
	 */
	public static void sayfa() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteriKayit window = new musteriKayit();
					window.frmMteriKayt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public musteriKayit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMteriKayt = new JFrame();
		frmMteriKayt.setTitle("Müşteri Kayıt");
		frmMteriKayt.setBounds(100, 100, 450, 300);
		frmMteriKayt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMteriKayt.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("İsim:");
		lblNewLabel.setBounds(29, 47, 45, 13);
		frmMteriKayt.getContentPane().add(lblNewLabel);
		
		isim = new JTextField();
		isim.setBounds(84, 44, 96, 19);
		frmMteriKayt.getContentPane().add(isim);
		isim.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Soyisim:");
		lblNewLabel_1.setBounds(29, 77, 56, 13);
		frmMteriKayt.getContentPane().add(lblNewLabel_1);
		
		soyisim = new JTextField();
		soyisim.setColumns(10);
		soyisim.setBounds(84, 74, 96, 19);
		frmMteriKayt.getContentPane().add(soyisim);
		
		lblDoumTarihi = new JLabel("Doğum Tarihi:");
		lblDoumTarihi.setBounds(190, 44, 87, 13);
		frmMteriKayt.getContentPane().add(lblDoumTarihi);
		
		dogtar = new JTextField();
		dogtar.setColumns(10);
		dogtar.setBounds(287, 44, 96, 19);
		frmMteriKayt.getContentPane().add(dogtar);
		
		lblTcNo = new JLabel("TC No:");
		lblTcNo.setBounds(206, 74, 45, 13);
		frmMteriKayt.getContentPane().add(lblTcNo);
		
		tc = new JTextField();
		tc.setColumns(10);
		tc.setBounds(287, 74, 96, 19);
		frmMteriKayt.getContentPane().add(tc);
		
		musteriConnect m = new musteriConnect();
		kayitbuton = new JButton("Kaydet");
		kayitbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = isim.getText();
				String soyad = soyisim.getText();
				String tcno = tc.getText();
				String dog = dogtar.getText();
				m.musterikayit(tcno, ad, soyad, dog);
				
			}
			});
		kayitbuton.setBounds(298, 113, 85, 21);
		frmMteriKayt.getContentPane().add(kayitbuton);
	}

}
