package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.dao.AlunoDao;
import com.dao.DataSource;
import com.model.Usuario;

public class TelaJframe {

	private JFrame frmProgramaAluno;
	private TextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldIdade;
	private JTable tableResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJframe window = new TelaJframe();
					window.frmProgramaAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaJframe() {
		initialize();
		readJtable();
	}

	public void readJtable() {
		DefaultTableModel modelo = (DefaultTableModel) tableResultado.getModel();
		DataSource ds = new DataSource();
		AlunoDao A = new AlunoDao(ds);

		for (Usuario user : A.listarAluno()) {
			modelo.addRow(new Object[] { user.getId(), user.getNome(), user.getEmail(), user.getFrequencia(), });
		}
	}

	public void clearJtable() {
		DefaultTableModel modelo = (DefaultTableModel) tableResultado.getModel();
		modelo.setNumRows(0);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaAluno = new JFrame();
		frmProgramaAluno.setTitle("Programa Aluno");
		frmProgramaAluno.setBounds(100, 100, 650, 400);
		frmProgramaAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaAluno.getContentPane().setLayout(null);
		try {

			tableResultado.setShowGrid(true);
			;
		} catch (Exception e) {
			// TODO: handle exception
		}

		JButton btnMostrarResultado = new JButton("Mostrar Resultado");
		btnMostrarResultado.setBackground(Color.LIGHT_GRAY);
		btnMostrarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableResultado.clearSelection();
				;
				DataSource ds = new DataSource();
				AlunoDao ad = new AlunoDao(ds);
				ArrayList<Usuario> lista = ad.listarAluno();
				if (lista != null) {
					for (Usuario a : lista) {
						System.out.println(lista);
					}
				}
				if (lista == null) {
					System.out.println("Entrou sim");
				}
			}
		});
		btnMostrarResultado.setBounds(58, 327, 142, 24);
		frmProgramaAluno.getContentPane().add(btnMostrarResultado);

		textFieldNome = new TextField();
		textFieldNome.setBounds(509, 180, 115, 23);
		frmProgramaAluno.getContentPane().add(textFieldNome);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(509, 234, 115, 20);
		frmProgramaAluno.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(509, 285, 115, 20);
		frmProgramaAluno.getContentPane().add(textFieldIdade);
		textFieldIdade.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(513, 160, 46, 14);
		frmProgramaAluno.getContentPane().add(lblNome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(513, 209, 46, 14);
		frmProgramaAluno.getContentPane().add(lblEmail);

		JLabel lblFrequencia = new JLabel("Frequ\u00EAncia");
		lblFrequencia.setBounds(509, 265, 84, 14);
		frmProgramaAluno.getContentPane().add(lblFrequencia);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.LIGHT_GRAY);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataSource ds = new DataSource();
				Usuario user = new Usuario();
				AlunoDao a = new AlunoDao(ds);
				Object coluna = tableResultado.getValueAt(tableResultado.getSelectedRow(), 0);
				JOptionPane pane = new JOptionPane();
				if (pane.showConfirmDialog(tableResultado,
						"Esta Ação não poderá ser desfeita! \n Deseja remover o Aluno da Lista?", "Atenção!",
						pane.YES_NO_OPTION) == 0) {

					int id = Integer.parseInt(coluna.toString());
					System.out.println("Aqui o id" + id + pane.YES_OPTION);
					user.setId(Integer.parseInt(coluna.toString()));
					a.delete(user);
					clearJtable();
					readJtable();
				}

			}
		});
		btnRemover.setBounds(289, 327, 89, 24);
		frmProgramaAluno.getContentPane().add(btnRemover);

		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario A = new Usuario();
				DataSource ds = new DataSource();
				AlunoDao dao = new AlunoDao(ds);
				clearJtable();
				try {
					A.setNome(textFieldNome.getText());
					A.setEmail(textFieldEmail.getText());
					A.setFrequencia(Integer.parseInt(textFieldIdade.getText()));
					dao.create(A);
					JOptionPane.showMessageDialog(frmProgramaAluno, "Adicionado!", "Menssagem", 1);
					textFieldIdade.setText("");
					textFieldEmail.setText("");
					textFieldNome.setText("");

				} catch (Exception a) {
					JOptionPane.showMessageDialog(frmProgramaAluno, "Preencha todos os campos", "Erro!", 2);
				}
				readJtable();

			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(518, 327, 89, 24);
		frmProgramaAluno.getContentPane().add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 39, 459, 266);
		frmProgramaAluno.getContentPane().add(scrollPane);
		tableResultado = new JTable();

		scrollPane.setViewportView(tableResultado);
		scrollPane.setViewportView(tableResultado);
		tableResultado.setToolTipText("id,\r\n\r\n");
		tableResultado.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableResultado.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Aluno", "Email", "Frequência" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, true, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}
}
