package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Visita {
	
	private int idvisita;
	private String agente;
	private Date data_visita;
	private String bairro;
	private String rua;
	private String quadra;
	private int lote;	
	private String numero;
	private int cep;
	private String cidade;
	private String latitude;
	private String longitude;
	private String tp_imovel;
	private String estagio;
	private String tp_larvicida;
	private String ac_corretiva;
	private String local_foco;

	
	public int getIdvisita() {
		return idvisita;
	}
	public void setIdvisita(int idvisita) {
		this.idvisita = idvisita;
	}
	public String getAgente() {
		return agente;
	}
	public void setAgente(String agente) {
		this.agente = agente;
	}
	public Date getData_visita() {
		return data_visita;
	}
	public void setData_visita(Date data_visita) {
		this.data_visita = data_visita;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getQuadra() {
		return quadra;
	}
	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}
	public int getLote() {
		return lote;
	}
	public void setLote(int lote) {
		this.lote = lote;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getTp_imovel() {
		return tp_imovel;
	}
	public void setTp_imovel(String tp_imovel) {
		this.tp_imovel = tp_imovel;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public String getTp_larvicida() {
		return tp_larvicida;
	}
	public void setTp_larvicida(String tp_larvicida) {
		this.tp_larvicida = tp_larvicida;
	}
	public String getAc_corretiva() {
		return ac_corretiva;
	}
	public void setAc_corretiva(String ac_corretiva) {
		this.ac_corretiva = ac_corretiva;
	}
	public String getLocal_foco() {
		return local_foco;
	}
	public void setLocal_foco(String local_foco) {
		this.local_foco = local_foco;
	}	

	
	@Override
	public String toString() {
		return "Visita [idvisita=" + idvisita + ", agente=" + agente + ", data_visita=" + data_visita + ", bairro="
				+ bairro + ", rua=" + rua + ", quadra=" + quadra + ", lote=" + lote + ", numero=" + numero + ", cep="
				+ cep + ", cidade=" + cidade + ", latitude=" + latitude + ", longitude=" + longitude + ", tp_imovel="
				+ tp_imovel + ", estagio=" + estagio + ", tp_larvicida=" + tp_larvicida + ", ac_corretiva="
				+ ac_corretiva + ", local_foco=" + local_foco + "]";
	}
}
