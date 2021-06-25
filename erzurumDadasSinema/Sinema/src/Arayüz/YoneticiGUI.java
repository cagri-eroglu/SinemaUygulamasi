package Arayüz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import extra.*;

public class YoneticiGUI extends JFrame {
	Filmler film = new Filmler();
	static Yonetici yonetici = new Yonetici();
	private JPanel contentPane;
	private JTable table_musteri;
	private JPasswordField sifre;
	private DefaultTableModel musteriModel = null;
	private Object[] musteriData = null;
	private JTextField adSoyad;
	private JTextField tcNo;
	private JTextField kullaniciid;
	private JTable table_film;
	private JTextField textFilm;
	private DefaultTableModel filmModel = null;
	private Object[] filmData = null;
	private JScrollPane scrollPane;
	private JPopupMenu filmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiGUI frame = new YoneticiGUI(yonetici);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void YoneticiTablosunuGuncelle() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_musteri.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < yonetici.getMusteriList().size(); i++) {
			musteriData[0] = yonetici.getMusteriList().get(i).getId();
			musteriData[1] = yonetici.getMusteriList().get(i).getAd();
			musteriData[2] = yonetici.getMusteriList().get(i).getTc();
			musteriData[3] = yonetici.getMusteriList().get(i).getSifre();
			musteriModel.addRow(musteriData);
		}

	}

	public void updateFilmModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_film.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < film.getList().size(); i++) {
			filmData[0] = film.getList().get(i).getId();
			filmData[1] = film.getList().get(i).getName();
			filmModel.addRow(filmData);
		}

	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public YoneticiGUI(Yonetici yonetici) throws SQLException {

		musteriModel = new DefaultTableModel();
		Object[] colMusteriName = new Object[4];
		colMusteriName[0] = "ID";
		colMusteriName[1] = "Ad - Soyad";
		colMusteriName[2] = "TC NO";
		colMusteriName[3] = "Þifre";
		musteriModel.setColumnIdentifiers(colMusteriName);
		musteriData = new Object[4];
		for (int i = 0; i < yonetici.getMusteriList().size(); i++) {
			musteriData[0] = yonetici.getMusteriList().get(i).getId();
			musteriData[1] = yonetici.getMusteriList().get(i).getAd();
			musteriData[2] = yonetici.getMusteriList().get(i).getTc();
			musteriData[3] = yonetici.getMusteriList().get(i).getSifre();
			musteriModel.addRow(musteriData);
		}

		filmModel = new DefaultTableModel();
		Object[] colFilm = new Object[2];
		colFilm[0] = "ID";
		colFilm[1] = "Film Adý";
		filmModel.setColumnIdentifiers(colFilm);

		filmModel.setColumnIdentifiers(colFilm);
		filmData = new Object[2];
		for (int i = 0; i < film.getList().size(); i++) {
			filmData[0] = film.getList().get(i).getId();
			filmData[1] = film.getList().get(i).getName();

			filmModel.addRow(filmData);
		}

		setTitle("Erzurum Dada\u015F Sinemas\u0131");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 567);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ho\u015Fgeldin :" + yonetici.getAd());
		lblNewLabel.setBounds(40, 16, 318, 33);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("\u00C7IKI\u015E");
		btnNewButton.setBounds(692, 16, 144, 39);
		btnNewButton.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 93, 765, 436);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Yönetici Kontrolü", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ad-Soyad :");
		lblNewLabel_1.setBounds(637, 10, 85, 42);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("TC NO");
		lblNewLabel_1_1.setBounds(637, 100, 85, 21);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("\u015Eifre");
		lblNewLabel_1_1_1.setBounds(637, 172, 85, 30);
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1);

		JButton btnEkle = new JButton("Ekle");
		btnEkle.setBounds(657, 249, 85, 21);
		btnEkle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adSoyad.getText().length() == 0 || tcNo.getText().length() == 0 || sifre.getText().length() == 0) {
					extra.ortakMetodlar.mesajGoster("fill");
				} else {
					try {
						boolean control = yonetici.addMusteri(tcNo.getText(), sifre.getText(), adSoyad.getText());
						if (control) {
							extra.ortakMetodlar.mesajGoster("success");
							tcNo.setText(null);
							sifre.setText(null);
							adSoyad.setText(null);// alanlarý sýfýrlýyoruz.
							YoneticiTablosunuGuncelle();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();

					}

				}
			}

		});
		panel.add(btnEkle);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Kullan\u0131c\u0131 ID");
		lblNewLabel_1_1_1_1.setBounds(637, 280, 85, 30);
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1_1_1);

		JButton btnSil = new JButton("Sil");
		btnSil.setBounds(657, 367, 85, 21);
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kullaniciid.getText().length() == 0) {
					extra.ortakMetodlar.mesajGoster("Lütfen geçerli bir müsteri seçiniz.");
				} else {
					if (extra.ortakMetodlar.confirm("sure")) {
						int selectID = Integer.parseInt(kullaniciid.getText());
						try {
							boolean control = yonetici.deleteMusteri(selectID);
							if (control) {
								extra.ortakMetodlar.mesajGoster("success");
								kullaniciid.setText(null);
								YoneticiTablosunuGuncelle();

							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}

			}
		});
		panel.add(btnSil);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 602, 389);
		panel.add(scrollPane);

		table_musteri = new JTable(musteriModel);
		scrollPane.setViewportView(table_musteri);
		table_musteri.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					kullaniciid.setText(table_musteri.getValueAt(table_musteri.getSelectedRow(), 0).toString());
				} catch (Exception e) {

				}
			}
		});

		table_musteri.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectId = Integer
							.parseInt(table_musteri.getValueAt(table_musteri.getSelectedRow(), 0).toString());
					String selectName = table_musteri.getValueAt(table_musteri.getSelectedRow(), 1).toString();
					String selectTcNo = table_musteri.getValueAt(table_musteri.getSelectedRow(), 2).toString();
					String selectSifre = table_musteri.getValueAt(table_musteri.getSelectedRow(), 3).toString();

					try {
						boolean control = yonetici.UPDATEMusteri(selectId, selectTcNo, selectSifre, selectName);
						if (control) {
							extra.ortakMetodlar.mesajGoster("success");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		JPanel filmPanel = new JPanel();
		tabbedPane.addTab("Filmler", null, filmPanel, null);
		filmPanel.setLayout(null);

		JScrollPane scrollFilm = new JScrollPane();
		scrollFilm.setBounds(22, 20, 281, 365);
		filmPanel.add(scrollFilm);

		filmMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("Güncelle");
		JMenuItem deleteMenu = new JMenuItem("Sil");
		filmMenu.add(updateMenu);
		filmMenu.add(deleteMenu);

		updateMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedID = Integer.parseInt(table_film.getValueAt(table_film.getSelectedRow(), 0).toString());
				Filmler selectFilm = film.getFetch(selectedID);
				updateFilm updateGuý = new updateFilm(selectFilm);
				updateGuý.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGuý.setVisible(true);
				updateGuý.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						try {
							updateFilmModel();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});

			}

		});

		deleteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (extra.ortakMetodlar.confirm("sure")) {
					int selectedID = Integer.parseInt(table_film.getValueAt(table_film.getSelectedRow(), 0).toString());
					try {
						if (film.deleteFilm(selectedID)) {
							extra.ortakMetodlar.mesajGoster("success");
							updateFilmModel();
						} else {
							extra.ortakMetodlar.mesajGoster("error");
						}
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}
			}

		});

		table_film = new JTable(filmModel);
		table_film.setComponentPopupMenu(filmMenu);
		table_film.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point point = e.getPoint();
				int selectedRow = table_film.rowAtPoint(point);
				table_film.setRowSelectionInterval(selectedRow, selectedRow);

			}
		});
		scrollFilm.setViewportView(table_film);

		JLabel lblNewLabel_1_2 = new JLabel("Film Ad\u0131:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(329, 20, 85, 42);
		filmPanel.add(lblNewLabel_1_2);

		textFilm = new JTextField();
		textFilm.setColumns(10);
		textFilm.setBounds(329, 62, 170, 30);
		filmPanel.add(textFilm);

		JButton btn_film_ekle = new JButton("Ekle");
		btn_film_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFilm.getText().length() == 0) {
					extra.ortakMetodlar.mesajGoster("fill");
				} else {
					try {
						if (film.addFilm(textFilm.getText())) {
							extra.ortakMetodlar.mesajGoster("success");
							textFilm.setText(null);
							updateFilmModel();

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btn_film_ekle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_film_ekle.setBounds(364, 108, 85, 21);
		filmPanel.add(btn_film_ekle);

		sifre = new JPasswordField();
		sifre.setBounds(647, 212, 103, 21);
		panel.add(sifre);

		adSoyad = new JTextField();
		adSoyad.setBounds(647, 52, 103, 30);
		panel.add(adSoyad);
		adSoyad.setColumns(10);

		tcNo = new JTextField();
		tcNo.setBounds(647, 132, 103, 30);
		panel.add(tcNo);
		tcNo.setColumns(10);

		kullaniciid = new JTextField();
		kullaniciid.setBounds(647, 321, 103, 21);
		panel.add(kullaniciid);
		kullaniciid.setColumns(10);

	}
}
