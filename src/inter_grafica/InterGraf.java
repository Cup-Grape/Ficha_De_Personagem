package inter_grafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import banco_de_dados.Banco_D_Dados;
import banco_de_dados.InDel_tabela;

public class InterGraf {

	private JFrame frame;
	private JTextField p_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterGraf window = new InterGraf();
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
	public InterGraf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 605, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
						.addGap(0)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(32)));

		JPanel criar_personagem = new JPanel();
		criar_personagem.setToolTipText("");
		tabbedPane.addTab("New tab", null, criar_personagem, null);

		JComboBox<String> p_raca = new JComboBox<String>();
		p_raca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p_raca.setModel(new DefaultComboBoxModel<String>(new String[] { "An\u00E3o", "Draconato", "Elfo", "Gnomo",
				"Goblin", "Halfling", "Humano", "Minotauro", "Orc", "Tiefling" }));

		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("CLASSE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_2 = new JLabel("RA\u00C7A");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		p_nome = new JTextField();
		p_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p_nome.setColumns(10);

		JComboBox<String> p_classe = new JComboBox<String>();
		p_classe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p_classe.setMaximumRowCount(10);
		p_classe.setModel(new DefaultComboBoxModel<String>(new String[] { "Arqueiro", "Assassino", "B\u00E1rbaro ",
				"Bardo ", "Berserker", "Bruxo ", "Ca\u00E7ador ", "Cl\u00E9rigo", "Curandeiro", "Druida ",
				"Elementalista", "Feiticeiro", "Guerreiro", "Invocador ", "Ladino", "Ladr\u00E3o ", "Mago", "Monge ",
				"Necromante", "Ninja", "Paladino ", "Ranger", "Sacerdote ", "Templ\u00E1rio", "Xam\u00E3" }));

		JButton criar = new JButton("CRIAR");
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, classe, raca;
				nome = p_nome.getText();
				classe = (String) p_classe.getSelectedItem();
				raca = (String) p_raca.getSelectedItem();

				InDel_tabela indel = new InDel_tabela();
				try {
					indel.Inserir(nome, raca, classe);
					JOptionPane.showMessageDialog(frame, "Criado com sucesso!!");
				} catch (SQLDataException | ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		criar.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_criar_personagem = new GroupLayout(criar_personagem);
		gl_criar_personagem.setHorizontalGroup(gl_criar_personagem.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_criar_personagem.createSequentialGroup().addGroup(gl_criar_personagem
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_criar_personagem.createSequentialGroup().addGap(62).addGroup(gl_criar_personagem
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_criar_personagem.createSequentialGroup().addGap(124)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
								.addGroup(gl_criar_personagem.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_criar_personagem.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel).addComponent(lblNewLabel_1,
														GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_criar_personagem.createParallelGroup(Alignment.LEADING, false)
										.addComponent(p_nome)
										.addComponent(p_classe, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(p_raca, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_criar_personagem.createSequentialGroup().addGap(186).addComponent(criar,
								GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
						.addGap(203)));

		gl_criar_personagem.setVerticalGroup(gl_criar_personagem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_criar_personagem.createSequentialGroup().addContainerGap(53, Short.MAX_VALUE)
						.addGroup(gl_criar_personagem.createParallelGroup(Alignment.BASELINE)
								.addComponent(p_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(gl_criar_personagem.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1).addComponent(p_classe, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_criar_personagem.createParallelGroup(Alignment.BASELINE)
								.addComponent(p_raca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addGap(38).addComponent(criar).addGap(171)));
		criar_personagem.setLayout(gl_criar_personagem);

		JPanel ver_personagem = new JPanel();
		tabbedPane.addTab("New tab", null, ver_personagem, null);

		JTextPane txt_plano = new JTextPane();
		txt_plano.setEditable(false);
		txt_plano.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_plano.setText("XP:\r\nNivel:\r\nNome:\r\nRa\u00E7a:\r\nClasse:\r\n");

		JComboBox<String> combo_nome = new JComboBox<String>();
		combo_nome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		combo_nome.setModel(new DefaultComboBoxModel(new String[] {""}));

		JButton ver_tabela_1 = new JButton("Ver tabela completa");
		ver_tabela_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conexao = null;
				Statement st = null;
				ResultSet rt = null;

				try {
					conexao = Banco_D_Dados.getConnection();
					st = conexao.createStatement();
					String pnome = (String) combo_nome.getSelectedItem();
					System.out.print(combo_nome.getSelectedIndex());
					rt = st.executeQuery("SELECT * FROM personagem Where nome =" + " '"+pnome+"' ");

					while (rt.next()) {

						txt_plano.setText("XP: " + rt.getString("xp") + "\r\nNivel: " + rt.getInt("nivel") + "\r\nNome: "
								+ rt.getString("nome") + "\r\nRa\u00E7a: " + rt.getString("raca") + "\r\nClasse: "
								+ rt.getString("classe") + "\r\n");
					}

				} catch (SQLException erro) {
					erro.printStackTrace();
				}

				finally {
					try {
						Banco_D_Dados.closeStatement(st);

					} catch (SQLDataException e1) {
						e1.printStackTrace();
					}
					try {
						Banco_D_Dados.closeResultSet(rt);
					} catch (SQLDataException e1) {
						e1.printStackTrace();
					}
					try {
						Banco_D_Dados.getConnection();
					} catch (SQLDataException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		ver_tabela_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton = new JButton("Carregar Nomes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				Statement st = null;
				ResultSet rt = null;

				try {
					conexao = Banco_D_Dados.getConnection();
					st = conexao.createStatement();
					rt = st.executeQuery("SELECT * FROM personagem");

					while (rt.next()) {

						combo_nome.insertItemAt(rt.getString("nome"), 0);
						
					}

				} catch (SQLException erro) {
					erro.printStackTrace();
				}

				finally {
					try {
						Banco_D_Dados.closeStatement(st);

					} catch (SQLDataException e1) {
						e1.printStackTrace();
					}
					try {
						Banco_D_Dados.closeResultSet(rt);
					} catch (SQLDataException e1) {
						e1.printStackTrace();
					}
					try {
						Banco_D_Dados.getConnection();
					} catch (SQLDataException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_ver_personagem = new GroupLayout(ver_personagem);
		gl_ver_personagem.setHorizontalGroup(gl_ver_personagem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ver_personagem.createSequentialGroup().addContainerGap().addGroup(gl_ver_personagem
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_ver_personagem.createSequentialGroup().addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(combo_nome, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addComponent(txt_plano).addComponent(ver_tabela_1, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(257, Short.MAX_VALUE)));
		gl_ver_personagem.setVerticalGroup(gl_ver_personagem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ver_personagem.createSequentialGroup().addGap(22)
						.addGroup(gl_ver_personagem.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(combo_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txt_plano, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(ver_tabela_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGap(59)));
		ver_personagem.setLayout(gl_ver_personagem);
		frame.getContentPane().setLayout(groupLayout);
	}
}
