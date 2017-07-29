package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * Classe responsavel pela Conexao com o Banco de dados. É utilizada por outras
 * classes de persistencia de dados.
 * 
 */
public class ConectaBanco {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "root";
		//String senha = "123456";
		String senha = "spot0011";
		String nomeBancoDados = "dbendemic";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeBancoDados, usuario, senha);
		} catch (Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "Erro na Conexão com o banco dbendemic","Aviso",JOptionPane.ERROR_MESSAGE);
		}
		return conexao;
	}
}