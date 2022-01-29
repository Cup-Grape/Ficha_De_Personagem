package banco_de_dados;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//Conexão com banco de dados
public class Banco_D_Dados {

	private static Connection conexao = null;
	
	public static Connection getConnection() throws SQLDataException{
		if(conexao == null) {
			try {
				Properties propriedade = loadProperties();
				String url = propriedade.getProperty("dburl");
				conexao = DriverManager.getConnection(url,propriedade);
				
				
			} catch (SQLException erro) {
				throw new SQLDataException(erro.getMessage());

			}
		}
		return conexao;
		
	}

	private static Properties loadProperties() throws SQLDataException {
		try (FileInputStream fs = new FileInputStream("bd.properties")) {
			Properties propriedade = new Properties();
			propriedade.load(fs);
			return propriedade;
			
		} catch (Exception erro_properties) {
			throw new SQLDataException(erro_properties.getMessage());
		}
	}

	public static void closeConnection() throws SQLDataException {
		if(conexao != null) {
			try {
				conexao.close();
			} catch (Exception erro) {
				throw new SQLDataException(erro.getMessage());
			}
		}
	}
	

	public static void closeStatement(Statement st) throws SQLDataException {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException erro) {
				throw new SQLDataException(erro.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rt) throws SQLDataException {
		if(rt != null) {
			try {
				rt.close();
			} catch (SQLException erro) {
				throw new SQLDataException(erro.getMessage());
			}
		}
		
	}
	
}



