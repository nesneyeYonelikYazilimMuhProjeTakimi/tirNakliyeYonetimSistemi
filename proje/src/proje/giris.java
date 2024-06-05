package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proje.connection.personelConnect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class giris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		personelConnect p = new personelConnect();
		
		p.personelMi(5);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
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
	public giris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton personelButon = new JButton("Personel Giriş");
		personelButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personelGiris personelGiris = new personelGiris();
				personelGiris.sayfa();
			}
		});
		personelButon.setBounds(146, 87, 121, 21);
		contentPane.add(personelButon);
		
		JButton musteriButon = new JButton("Müşteri Giriş");
		musteriButon.setBounds(146, 137, 121, 21);
		contentPane.add(musteriButon);
		musteriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteriGiris musteri = new musteriGiris();
				musteri.sayfa();
			}
		});
		
		JButton kayitButon = new JButton("Müşteri Kayıt");
		kayitButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musteriKayit kayit = new musteriKayit();
				kayit.sayfa();
			}
		});
		kayitButon.setBounds(146, 168, 121, 21);
		contentPane.add(kayitButon);
	}
}
