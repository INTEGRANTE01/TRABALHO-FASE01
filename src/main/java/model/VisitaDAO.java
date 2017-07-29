package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Visita;

/**
 * 
 * Classe de PersistÃªncia de dados dos objetos de Visita
 * é "filha" da Classe ConectaBanco. 
 *
 */

public class VisitaDAO extends ConectaBanco {
	
	public boolean alterar(Visita visita) {
		boolean erro = false;

		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao
					.prepareStatement("Update visita SET agente = ?, data_visita = ?, bairro = ?, rua = ?, quadra = ?, "
									+ "lote = ?, numero = ?, cep = ?, cidade = ?, latitude = ?, longitude = ?, "
									+ "tp_imovel = ?, estagio = ?, tp_larvicida = ?, ac_corretiva = ?, local_foco = ? WHERE idvisita = ? ");
			pstmt.setString(1, visita.getAgente());			
			pstmt.setTimestamp(2,  new java.sql.Timestamp(visita.getData_visita().getTime()));  
			pstmt.setString(3, visita.getBairro());
			pstmt.setString(4, visita.getRua());
			pstmt.setString(5, visita.getQuadra());
			pstmt.setInt(6, visita.getLote());
			pstmt.setString(7, visita.getNumero());
			pstmt.setInt(8, visita.getCep());
			pstmt.setString(9, visita.getCidade());
			pstmt.setString(10, visita.getLatitude());
			pstmt.setString(11, visita.getLongitude());
			pstmt.setString(12, visita.getTp_imovel());
			pstmt.setString(13, visita.getEstagio());
			pstmt.setString(14, visita.getTp_larvicida());
			pstmt.setString(15, visita.getAc_corretiva());
			pstmt.setString(16, visita.getLocal_foco());			
			pstmt.setInt(17, visita.getIdvisita());
			pstmt.execute();
			pstmt.close();
			conexao.close();
			}catch (Exception e) {
				e.printStackTrace();
				erro = true;					
			}
		return erro;
	}

	public boolean excluir(Visita visita) {
		boolean erro = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from visita where idvisita = ?");
			pstm.setInt(1, visita.getIdvisita());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			erro = true;
		}
		return erro;
	}

	public boolean existe(Visita visita) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select idvisita from visita where idvisita = ?");
			//if(pstm==null)				
			pstm.setInt(1, visita.getIdvisita());
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO AO EDITAR");			
		}
		return achou;
	}

	public boolean inserir(Visita visita) {
		boolean erro = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	visita (agente, data_visita, bairro, rua, quadra,lote, numero, cep, cidade, latitude, "
							+ "longitude,tp_imovel, estagio, tp_larvicida, ac_corretiva, local_foco) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");			
			pstm.setString(1, visita.getAgente());			
			pstm.setTimestamp(2,  new java.sql.Timestamp(visita.getData_visita().getTime())); 
			pstm.setString(3, visita.getBairro());
			pstm.setString(4, visita.getRua());
			pstm.setString(5, visita.getQuadra());
			pstm.setInt(6, visita.getLote());
			pstm.setString(7, visita.getNumero());
			pstm.setInt(8, visita.getCep());
			pstm.setString(9, visita.getCidade());
			pstm.setString(10, visita.getLatitude());
			pstm.setString(11, visita.getLongitude());
			pstm.setString(12, visita.getTp_imovel());
			pstm.setString(13, visita.getEstagio());
			pstm.setString(14, visita.getTp_larvicida());
			pstm.setString(15, visita.getAc_corretiva());
			pstm.setString(16, visita.getLocal_foco());	
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			erro = true;	
			e.printStackTrace();
			System.out.println("ERRO AO INSERIR");	
		}
		return erro;
	}

	public List<Visita> listar(String agente, String par_bairro, String par_cidade, String par_tipo, String par_estagio,  String par_rua) {
		
		List<Visita> lista = new ArrayList<Visita>();
		
		try {
			/*Statement stm = conexao.createStatement();*/
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from visita where agente like ? and bairro like ? and cidade like ? and tp_imovel like ? and estagio like ? and rua like ? order by bairro asc");
			pstm.setString(1, "%" + agente +"%");
			pstm.setString(2, par_bairro +"%");
			pstm.setString(3, par_cidade +"%");
			pstm.setString(4, "%" + par_tipo +"%");
			pstm.setString(5, "%" + par_estagio +"%");
			pstm.setString(6, "%" + par_rua +"%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Visita visita = new Visita();
				visita.setIdvisita(rs.getInt("idvisita"));
				visita.setAgente(rs.getString("agente"));
				visita.setBairro(rs.getString("bairro"));
				visita.setCidade(rs.getString("cidade"));
				visita.setTp_imovel(rs.getString("tp_imovel"));
				visita.setEstagio(rs.getString("estagio"));				
				lista.add(visita);
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Visita> listarmapa(String par_bairro, String par_cidade, String par_tipo, String par_estagio) {
	
	List<Visita> lista = new ArrayList<Visita>();
	
	try {
		/*Statement stm = conexao.createStatement();*/
		Connection conexao = getConexao();
		PreparedStatement pstm = conexao
				.prepareStatement("Select latitude, longitude from visita where bairro like ? and cidade like ? and tp_imovel like ? and estagio like ? order by bairro asc");
		pstm.setString(1, par_bairro +"%");
		pstm.setString(2, par_cidade +"%");
		pstm.setString(3, "%" + par_tipo +"%");
		pstm.setString(4, "%" + par_estagio +"%");
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Visita visita = new Visita();
			visita.setLongitude(rs.getString("longitude"));
			visita.setLatitude(rs.getString("latitude"));				
			lista.add(visita);
		}
		pstm.close();
		conexao.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lista;
}

public List<Visita> listarmapa() {
	
	List<Visita> lista = new ArrayList<Visita>();
	
	try {
		/*Statement stm = conexao.createStatement();*/
		Connection conexao = getConexao();
		PreparedStatement pstm = conexao
				.prepareStatement("Select * from visita order by bairro asc");
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Visita visita = new Visita();
			visita.setBairro(rs.getString("bairro"));
			visita.setCidade(rs.getString("cidade"));
			visita.setEstagio(rs.getString("estagio"));
			visita.setLongitude(rs.getString("longitude"));
			visita.setLatitude(rs.getString("latitude"));					
			lista.add(visita);
		}
		pstm.close();
		conexao.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lista;
}
	
	
	
public List<Visita> listar() {
		
		List<Visita> lista = new ArrayList<Visita>();
		
		try {
			/*Statement stm = conexao.createStatement();*/
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from visita order by bairro asc");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Visita visita = new Visita();
				visita.setIdvisita(rs.getInt("idvisita"));
				visita.setAgente(rs.getString("agente"));
				visita.setBairro(rs.getString("bairro"));
				visita.setCidade(rs.getString("cidade"));
				visita.setTp_imovel(rs.getString("tp_imovel"));
				visita.setEstagio(rs.getString("estagio"));				
				lista.add(visita);
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Visita consultar_editar(Visita visita) {
		
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from visita where idvisita = ?");
			pstm.setInt(1, visita.getIdvisita());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				visita.setIdvisita(rs.getInt("idvisita"));
				visita.setAgente(rs.getString("agente"));    
				visita.setData_visita(rs.getTimestamp("data_visita"));
				visita.setBairro(rs.getString("bairro"));
				visita.setRua(rs.getString("rua"));
				visita.setQuadra(rs.getString("quadra"));
				visita.setLote(rs.getInt("lote"));
				visita.setNumero(rs.getString("numero"));
				visita.setCep(rs.getInt("cep"));
				visita.setCidade(rs.getString("cidade"));
				visita.setLatitude(rs.getString("latitude"));
				visita.setLongitude(rs.getString("longitude"));
				visita.setTp_imovel(rs.getString("tp_imovel"));
				visita.setEstagio(rs.getString("estagio"));
				visita.setTp_larvicida(rs.getString("tp_larvicida"));
				visita.setAc_corretiva(rs.getString("ac_corretiva"));
				visita.setLocal_foco(rs.getString("local_foco"));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visita;
	}
	
}
