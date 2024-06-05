package proje;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

import proje.connection.yoneticiConnect;

public class yoneticiSayfa {
	static int yoneticiID;
	private JFrame frmGarajBigileri;

	/**
	 * Launch the application.
	 */
	public static void sayfa(int id) {
		yoneticiID = id;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yoneticiSayfa window = new yoneticiSayfa();
					window.frmGarajBigileri.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public yoneticiSayfa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGarajBigileri = new JFrame();
		frmGarajBigileri.setTitle("Garaj Bigileri");
		frmGarajBigileri.setBounds(100, 100, 450, 300);
		frmGarajBigileri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGarajBigileri.getContentPane().setLayout(null);
		
		yoneticiConnect y = new yoneticiConnect();
		
		JLabel yoneticiNo = new JLabel("Garaj Yönetici no: "+ String.valueOf(yoneticiID));
		yoneticiNo.setBounds(10, 10, 152, 13);
		frmGarajBigileri.getContentPane().add(yoneticiNo);
		
		int garajNumarasi = y.garajNo(yoneticiID);
		JLabel garajNo = new JLabel("Garaj no:" + String.valueOf(garajNumarasi));
		garajNo.setBounds(244, 10, 138, 13);
		frmGarajBigileri.getContentPane().add(garajNo);
		
		int tirMasrafi = y.tirMasrafi(yoneticiID);
		JLabel tirMasraflari = new JLabel("Tır masrafları: "+ String.valueOf(tirMasrafi));
		tirMasraflari.setBounds(10, 73, 152, 13);
		frmGarajBigileri.getContentPane().add(tirMasraflari);
		
		JLabel lblNewLabel = new JLabel("Masraflar:");
		lblNewLabel.setBounds(10, 50, 69, 13);
		frmGarajBigileri.getContentPane().add(lblNewLabel);
		
		int garajGeliri = y.gelir(garajNumarasi);
		JLabel lblNewLabel_1 = new JLabel("Gelir:"+String.valueOf(garajGeliri));
		lblNewLabel_1.setBounds(244, 50, 81, 13);
		frmGarajBigileri.getContentPane().add(lblNewLabel_1);
		
		int personelMasrafi = y.personelMasrafi(garajNumarasi);
		JLabel personelMasraf = new JLabel("Personel Masrafları:"+ String.valueOf(personelMasrafi));
		personelMasraf.setBounds(10, 96, 152, 13);
		frmGarajBigileri.getContentPane().add(personelMasraf);
		
		int toplam = garajGeliri - (tirMasrafi + personelMasrafi);
		JLabel toplamKazanç = new JLabel("Toplam kazanç:"+ String.valueOf(toplam));
		toplamKazanç.setBounds(244, 96, 168, 13);
		frmGarajBigileri.getContentPane().add(toplamKazanç);
		
		int tir = y.tirSayisi(garajNumarasi);
		JLabel tirSayisi = new JLabel("Garajda bulunan tir sayisi:"+ String.valueOf(tir));
		tirSayisi.setBounds(10, 145, 168, 13);
		frmGarajBigileri.getContentPane().add(tirSayisi);
		
		int dorse = y.dorseSayisi(garajNumarasi);
		JLabel dorseSayisi = new JLabel("Garajda bulunan dorse sayisi:"+ String.valueOf(dorse));
		dorseSayisi.setBounds(244, 145, 182, 13);
		frmGarajBigileri.getContentPane().add(dorseSayisi);
	}
}
