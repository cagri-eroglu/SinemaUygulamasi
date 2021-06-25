package Aray�z;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Yonetici;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import extra.*; //ba�ka pakette oldu�u i�in s�n�flar�yla birlikte import ettim.

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField MusteriKullaniciAdi;
	private JTextField YoneticiKullaniciAdi;
	private JPasswordField YoneticiSifre;
	private JPasswordField MusteriSifre;
	private DataBaseConnect connection = new DataBaseConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setTitle("ERZURUM DADA\u015E S\u0130NEMASI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo_lbl = new JLabel(new ImageIcon(getClass().getResource("sinema.jpg")));
		logo_lbl.setBounds(110, 10, 472, 166);
		contentPane.add(logo_lbl);
		
		JLabel lblNewLabel = new JLabel("Erzurum Dada\u015F Sinemas\u0131na ho\u015Fgeldiniz !");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblNewLabel.setBounds(135, 186, 447, 29);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 233, 644, 211);
		contentPane.add(tabbedPane);
		
		JPanel Y�neticiGiris = new JPanel();
		Y�neticiGiris.setBackground(Color.WHITE);
		tabbedPane.addTab("Y�netici Giri�i", null, Y�neticiGiris, null);
		Y�neticiGiris.setLayout(null);
		
		JLabel lblgeldiniz_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131: ");
		lblgeldiniz_1.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblgeldiniz_1.setBounds(59, 26, 156, 29);
		Y�neticiGiris.add(lblgeldiniz_1);
		
		YoneticiKullaniciAdi = new JTextField();
		YoneticiKullaniciAdi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		YoneticiKullaniciAdi.setColumns(10);
		YoneticiKullaniciAdi.setBounds(226, 27, 351, 34);
		Y�neticiGiris.add(YoneticiKullaniciAdi);
		
		JLabel lblifre_1 = new JLabel("\u015Eifre");
		lblifre_1.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblifre_1.setBounds(69, 65, 156, 29);
		Y�neticiGiris.add(lblifre_1);
		
		JButton btnYoneticiGiris = new JButton("Giri\u015F Yap");
		btnYoneticiGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (YoneticiKullaniciAdi.getText().length() == 0||YoneticiSifre.getText().length()==0) {
					ortakMetodlar.mesajGoster("fill");
				}else {
					try {
						Connection con =connection.dataBaseConnection();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT*FROM kullanici");
						while(rs.next())
						{
							if (YoneticiKullaniciAdi.getText().equals(rs.getString("tc"))&& YoneticiSifre.getText().equals(rs.getString("sifre"))) {
								Yonetici yonetici = new Yonetici();
								yonetici.setId(rs.getInt("id"));
								yonetici.setSifre("sifre");
								yonetici.setTc("tc");
								yonetici.setAd(rs.getString("ad"));
								yonetici.setTip(rs.getString("tip"));
								YoneticiGUI Ygui = new YoneticiGUI(yonetici); 
								Ygui.setVisible(true);
								dispose();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnYoneticiGiris.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnYoneticiGiris.setBounds(262, 121, 156, 53);
		Y�neticiGiris.add(btnYoneticiGiris);
		
		YoneticiSifre = new JPasswordField();
		YoneticiSifre.setBounds(226, 71, 351, 34);
		Y�neticiGiris.add(YoneticiSifre);
		
		JPanel M�steriGiris = new JPanel();
		M�steriGiris.setBackground(Color.WHITE);
		tabbedPane.addTab("M��teri Giri�i", null, M�steriGiris, null);
		M�steriGiris.setLayout(null);
		
		JLabel lblgeldiniz = new JLabel("Kullan\u0131c\u0131  Ad\u0131 :");
		lblgeldiniz.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblgeldiniz.setBounds(52, 10, 156, 29);
		M�steriGiris.add(lblgeldiniz);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblifre.setBounds(62, 49, 156, 29);
		M�steriGiris.add(lblifre);
		
		MusteriKullaniciAdi = new JTextField();
		MusteriKullaniciAdi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		MusteriKullaniciAdi.setColumns(10);
		MusteriKullaniciAdi.setBounds(229, 11, 351, 34);
		M�steriGiris.add(MusteriKullaniciAdi);
		
		JButton btnM�steriGirisYap = new JButton("Giri\u015F Yap");
		btnM�steriGirisYap.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnM�steriGirisYap.setBounds(366, 121, 156, 53);
		M�steriGiris.add(btnM�steriGirisYap);
		
		JButton btnKay�tOl = new JButton("Kay\u0131t Ol");
		btnKay�tOl.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnKay�tOl.setBounds(102, 121, 156, 53);
		M�steriGiris.add(btnKay�tOl);
		
		MusteriSifre = new JPasswordField();
		MusteriSifre.setBounds(228, 49, 352, 34);
		M�steriGiris.add(MusteriSifre);
	}
}
