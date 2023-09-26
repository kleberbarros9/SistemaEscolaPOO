package tela;

import tipoaluno.Aluno;
import tipoaluno.AlunoEspecial;
import tipoaluno.AlunoRegular;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAluno {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNota1;
	private JTextField textFieldNota2;
	private JTextField textFieldNota3;
	private JTextField textFieldNota4;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno window = new TelaAluno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 849, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 74, 644, 152);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Situa\u00E7\u00E3o", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "M\u00E9dia" }));

		DefaultTableModel tabela;

		scrollPane.setViewportView(table);

		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(148, 293, 70, 15);
		frame.getContentPane().add(lblNota1);

		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(312, 293, 70, 15);
		frame.getContentPane().add(lblNota2);

		JLabel lblNota3 = new JLabel("Nota 3");
		lblNota3.setBounds(449, 293, 70, 15);
		frame.getContentPane().add(lblNota3);

		JLabel lblNota4 = new JLabel("Nota 4");
		lblNota4.setBounds(638, 293, 70, 15);
		frame.getContentPane().add(lblNota4);

		JLabel lblMain = new JLabel("Tela Notas");
		lblMain.setBounds(364, 12, 102, 15);
		frame.getContentPane().add(lblMain);

		textFieldNota1 = new JTextField();
		textFieldNota1.setBounds(117, 325, 114, 19);
		frame.getContentPane().add(textFieldNota1);
		textFieldNota1.setColumns(10);

		textFieldNota2 = new JTextField();
		textFieldNota2.setColumns(10);
		textFieldNota2.setBounds(268, 325, 114, 19);
		frame.getContentPane().add(textFieldNota2);

		textFieldNota3 = new JTextField();
		textFieldNota3.setColumns(10);
		textFieldNota3.setBounds(430, 325, 114, 19);
		frame.getContentPane().add(textFieldNota3);

		textFieldNota4 = new JTextField();
		textFieldNota4.setColumns(10);
		textFieldNota4.setBounds(603, 325, 114, 19);
		frame.getContentPane().add(textFieldNota4);

		JLabel lblTipoAluno = new JLabel("Escolha tipo do aluno:");
		lblTipoAluno.setBounds(114, 249, 180, 15);
		frame.getContentPane().add(lblTipoAluno);

		JRadioButton rdbtnEspecial = new JRadioButton("especial");
		rdbtnEspecial.setBounds(312, 245, 149, 23);
		frame.getContentPane().add(rdbtnEspecial);

		JRadioButton rdbtnRegular = new JRadioButton("regular");
		rdbtnRegular.setBounds(466, 245, 149, 23);
		frame.getContentPane().add(rdbtnRegular);

		// Cria grupo de botoes
		ButtonGroup bg = new ButtonGroup();

		// Adiciona botoes ao grupo
		bg.add(rdbtnEspecial);
		bg.add(rdbtnRegular);

		// Seta botao especial como selecionado
		rdbtnEspecial.setSelected(true);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Passa nome e notas internamente
				String nome = textFieldNome.getText();
				float nota1 = Float.parseFloat(textFieldNota1.getText());
				float nota2 = Float.parseFloat(textFieldNota2.getText());
				float nota3 = Float.parseFloat(textFieldNota3.getText());
				float nota4 = Float.parseFloat(textFieldNota4.getText());

				// Seleciona radiobutton
				boolean tipoAluno = rdbtnEspecial.isSelected();

				double calculoMedia = (double) ((nota1 + nota2 + nota3 + nota4) / 4.0);
				// String tipo_aluno;

				Aluno aluno = new Aluno();
				AlunoEspecial alunoEspecial = new AlunoEspecial();
				AlunoRegular alunoRegular = new AlunoRegular();

				// Se aluno especial
				if (tipoAluno) {
					aluno = alunoEspecial;
					aluno.modificarNota(nota1, nota2, nota3, nota4);
					calculoMedia = aluno.getMedia();
					aluno.setNome(nome);
					aluno.setTipoAluno("Especial");
				}
				// Se aluno regular
				else {
					aluno = alunoRegular;
					aluno.modificarNota(nota1, nota2, nota3, nota4);
					calculoMedia = aluno.getMedia();
					aluno.setNome(nome);
					aluno.setTipoAluno("Regular");
				}

				// Modelagem da tabela
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				tabela.addRow(new String[] { aluno.getNome(), aluno.getTipoAluno(), String.valueOf(nota1),
						String.valueOf(nota2), String.valueOf(nota3), String.valueOf(nota4),
						String.valueOf(calculoMedia) });
			}
		});
		btnCadastrar.setBounds(114, 425, 117, 25);
		frame.getContentPane().add(btnCadastrar);

		// Comportamento do botao excluir
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				deleteTabela(tabela);
			}
		});
		btnExcluir.setBounds(638, 425, 117, 25);
		frame.getContentPane().add(btnExcluir);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(117, 383, 114, 19);
		frame.getContentPane().add(textFieldNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(148, 356, 70, 15);
		frame.getContentPane().add(lblNome);

		JButton btnExcluirAluno = new JButton("Excluir Aluno");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				deleteSelectedRow(tabela, table);

			}
		});
		btnExcluirAluno.setBounds(353, 425, 149, 25);
		frame.getContentPane().add(btnExcluirAluno);
	}

	// Deleta todas as linhas da tabela
	private void deleteTabela(DefaultTableModel model) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	// Deleta uma linhas da tabela
	public static void deleteSelectedRow(DefaultTableModel model, JTable table) {
		int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) { // Ensure a row is selected.
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
        }
    }


}