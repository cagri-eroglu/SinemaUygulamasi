package Arayüz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Filmler;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updateFilm extends JFrame {

	private JPanel contentPane;
	private static Filmler film;
	private JTextField filmField;
	private static Filmler film22 = new Filmler();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateFilm frame = new updateFilm(film22);
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
	public updateFilm(Filmler film22) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 226, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblifre_1 = new JLabel("Film Ad\u0131 :");
		lblifre_1.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblifre_1.setBounds(53, 55, 104, 29);
		contentPane.add(lblifre_1);
		
		JButton btnDuzenle = new JButton("D\u00FCzenle");
		btnDuzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(extra.ortakMetodlar.confirm("sure")){
					try {
						film22.Updatefilm(film22.getId(), filmField.getText());
						extra.ortakMetodlar.mesajGoster("success");
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDuzenle.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnDuzenle.setBounds(32, 214, 156, 53);
		contentPane.add(btnDuzenle);
		
		filmField = new JTextField();
		filmField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		filmField.setColumns(10);
		filmField.setBounds(15, 120, 187, 34);
		filmField.setText(film22.getName());
		contentPane.add(filmField);
	}
}
