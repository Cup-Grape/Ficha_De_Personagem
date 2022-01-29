package aplicacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import banco_de_dados.Banco_D_Dados;

public class Aplicacao {

	public static void main(String[] args) throws SQLDataException{
		
		Connection conexao = null;
		Statement st = null;
		ResultSet rt = null;
		
		try {
			conexao = Banco_D_Dados.getConnection();
			st = conexao.createStatement();
			rt = st.executeQuery("SELECT * FROM personagem");
			
			while(rt.next()) {
				System.out.print("XP:");
				int num =0;
				while(num < rt.getInt("xp")) {
					System.out.print("I");
					num = num +1;
				}
				System.out.println("\nNome: "+rt.getString("nome"));
				System.out.println("Raça: "+rt.getString("raca"));
				System.out.println("Classe: "+rt.getString("classe"));
				System.out.println("Nivel: "+rt.getInt("nivel"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			Banco_D_Dados.closeStatement(st);
			Banco_D_Dados.closeResultSet(rt);
			Banco_D_Dados.getConnection();
		}
	}

}
