package proje;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proje.connection.musteriConnect;
import proje.connection.personelConnect;

import javax.swing.JLabel;
import javax.swing.JButton;

public class yukSayfa extends JFrame {
	static int musterino;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void sayfa(int mno) {
		 musterino=mno;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yukSayfa frame = new yukSayfa();
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
	public yukSayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		musteriConnect m = new musteriConnect();
		
		JLabel yukbilgisi = new JLabel(m.yukbilgi(musterino));
		yukbilgisi.setBounds(35, 20, 391, 172);
		contentPane.add(yukbilgisi);
		
		JButton yukEkle = new JButton("Yeni yük ekle");
		yukEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yeniYuk yuk = new yeniYuk();
				yuk.sayfa(musterino);
			}});
		yukEkle.setBounds(10, 202, 118, 21);
		contentPane.add(yukEkle);
	}

}
