package Prozor;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Helperi.Helper;
import Helperi.Prikaz;
import Izuzeci.Greska;
import Resursi.CRUD_Operacije;

import javax.swing.ScrollPaneConstants;

public class SpisakHrane extends JFrame {

	private JPanel contentPane;
	private JTextField Naziv_tekst;
	private JTextField Cena_tekst;
	private JTextField Vrsta_tekst;
	
	static Helper Helper = new Helper();
    Prikaz HelperP = new Prikaz();
	private JTable table;
	private JTextField ID_tekst;
	private CRUD_Operacije CRUD_OP = new CRUD_Operacije();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpisakHrane frame = new SpisakHrane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SpisakHrane() {
		
		initComponents();
		CRUD_Operacije.prikaz(table);
	}
	
	
	private void initComponents() {
		setTitle("LISTA BRZE HRANE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 540, 650);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel NazivLabela = new JLabel("Naziv");
		NazivLabela.setFont(new Font("Tahoma", Font.BOLD, 17));
		NazivLabela.setBounds(20, 67, 55, 19);
		panel.add(NazivLabela);
		
		JLabel CenaLabela = new JLabel("Cena");
		CenaLabela.setFont(new Font("Tahoma", Font.BOLD, 17));
		CenaLabela.setBounds(20, 103, 55, 20);
		panel.add(CenaLabela);
		
		JLabel LabelaVrsta = new JLabel("Vrsta");
		LabelaVrsta.setFont(new Font("Tahoma", Font.BOLD, 17));
		LabelaVrsta.setBounds(20, 137, 55, 20);
		panel.add(LabelaVrsta);
		
		Naziv_tekst = new JTextField();
		Naziv_tekst.setBounds(75, 64, 201, 28);
		panel.add(Naziv_tekst);
		Naziv_tekst.setColumns(10);
		
		Cena_tekst = new JTextField();
		Cena_tekst.setBounds(75, 98, 201, 28);
		panel.add(Cena_tekst);
		Cena_tekst.setColumns(10);
		
		Vrsta_tekst = new JTextField();
		Vrsta_tekst.setBounds(75, 132, 201, 28);
		panel.add(Vrsta_tekst);
		Vrsta_tekst.setColumns(10);

		
		JButton IzlazDugme = new JButton("IZLAZ");
		IzlazDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		IzlazDugme.setFont(new Font("Tahoma", Font.BOLD, 15));
		IzlazDugme.setBounds(20, 213, 145, 33);
		panel.add(IzlazDugme);
		
		JButton DodajDugme = new JButton("DODAJ");
		DodajDugme.setFont(new Font("Tahoma", Font.BOLD, 15));
		DodajDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					CRUD_Operacije.Dodaj(Naziv_tekst.getText(), Cena_tekst.getText(), Vrsta_tekst.getText());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				CRUD_Operacije.prikaz(table);
				Naziv_tekst.setText("");
				Cena_tekst.setText("");
				Vrsta_tekst.setText("");
				

			}
		});
		DodajDugme.setBounds(286, 64, 145, 33);
		panel.add(DodajDugme);
		
		JButton IzmeniDugme = new JButton("IZMENI");
		IzmeniDugme.setFont(new Font("Tahoma", Font.BOLD, 15));
		IzmeniDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CRUD_Operacije.Izmeni(Naziv_tekst.getText(), Cena_tekst.getText(), Vrsta_tekst.getText(), ID_tekst.getText());
							
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				CRUD_Operacije.prikaz(table);
				Naziv_tekst.setText("");
				Cena_tekst.setText("");
				Vrsta_tekst.setText("");
			}
		});
		
		IzmeniDugme.setBounds(286, 109, 145, 33);
		panel.add(IzmeniDugme);
		
		JButton ObrisiDugme = new JButton("OBRIŠI");
		ObrisiDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				CRUD_Operacije.Obrisi(Naziv_tekst.getText(), Cena_tekst.getText(), Vrsta_tekst.getText(), ID_tekst.getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			
			CRUD_Operacije.prikaz(table);
				Naziv_tekst.setText("");
				Cena_tekst.setText("");
				Vrsta_tekst.setText("");
			
			}
		});
		ObrisiDugme.setFont(new Font("Tahoma", Font.BOLD, 15));
		ObrisiDugme.setBounds(286, 151, 145, 33);
		panel.add(ObrisiDugme);
		
		JLabel NaslovLabela = new JLabel("EVIDENCIJA BRZE HRANE");
		NaslovLabela.setFont(new Font("Tahoma", Font.BOLD, 20));
		NaslovLabela.setBounds(10, 0, 266, 60);
		panel.add(NaslovLabela);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 256, 503, 374);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ListSelectionModel rowSelectionModel = table.getSelectionModel();
		
		ID_tekst = new JTextField();
		ID_tekst.setBounds(213, 171, 63, 28);
		panel.add(ID_tekst);
		ID_tekst.setColumns(10);
		
		JButton OsveziDugme = new JButton("OSVEŽI");
		OsveziDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUD_Operacije.prikaz(table);
			}
		});
		OsveziDugme.setFont(new Font("Tahoma", Font.BOLD, 15));
		OsveziDugme.setBounds(287, 195, 144, 32);
		panel.add(OsveziDugme);
		ID_tekst.setVisible(false);

		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
		            int selectedRow = table.getSelectedRow();
		            String idForEdit = table.getModel().getValueAt(selectedRow, 0).toString();
		            String Naziv = table.getModel().getValueAt(selectedRow, 1).toString();
		            String Cena = table.getModel().getValueAt(selectedRow, 2).toString();
		            String Vrsta = table.getModel().getValueAt(selectedRow, 3).toString();
		            Naziv_tekst.setText(Naziv);
		            Cena_tekst.setText(Cena);
		            Vrsta_tekst.setText(Vrsta);
		            ID_tekst.setText(idForEdit);
		        }
		    }
		});

}}
