package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import proje.connection.personelConnect;

public class soforSayfa {
	static int id;
	private JFrame frmGarajYneticisi;

	/**
	 * Launch the application.
	 */
	public static void sayfa(int sid) {
		id = sid;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					soforSayfa window = new soforSayfa();
					window.frmGarajYneticisi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public soforSayfa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGarajYneticisi = new JFrame();
		frmGarajYneticisi.setTitle("Şoför bilgileri");
		frmGarajYneticisi.setBounds(100, 100, 450, 300);
		frmGarajYneticisi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGarajYneticisi.getContentPane().setLayout(null);
		
		personelConnect h = new personelConnect();
		JLabel bilgi = new JLabel(h.bilgi(id));
		bilgi.setBounds(10, 34, 416, 202);
		frmGarajYneticisi.getContentPane().add(bilgi);
	}
}
