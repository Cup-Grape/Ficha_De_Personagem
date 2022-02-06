package banco_de_dados;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class InDel_tabela {

	public void Inserir(String nome, String raca, String classe) throws ParseException, SQLDataException {
		Connection conexao = null;
		java.sql.PreparedStatement st = null;
		try {
			conexao = Banco_D_Dados.getConnection();
			 st = conexao.prepareStatement("INSERT INTO Personagem "
			 		+ "(nome,"
			 		+ "raca, "
			 		+ "classe, "
			 		+ "nivel, "
			 		+ "xp) "
			 		+ "VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					 
			 st.setString(1, nome);
			 st.setString(2, raca);
			 st.setString(3, classe);
			 st.setInt(4, 1);
			 st.setInt(5, 5);
			
			 st.executeUpdate();
			
			 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				Banco_D_Dados.closeStatement(st);

			} catch (SQLDataException e1) {
				e1.printStackTrace();
			}
			}
			try {
				Banco_D_Dados.getConnection();
			} catch (SQLDataException e1) {
				e1.printStackTrace();
			}
		}
	}


