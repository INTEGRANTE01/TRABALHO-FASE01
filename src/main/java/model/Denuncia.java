package model;

import java.util.Date;

public class Denuncia {
	
	private int iddenuncia;
	private Date data_denuncia;
	private String bairro;
	private String rua;
	private String quadra;
	private int lote;
	private String numero;
	private String cidade;
	private String tp_imovel;
	private String desc_den;
	private String denunciante;
	private String cep;
	
	
	public int getIddenuncia() {
		return iddenuncia;
	}
	public void setIddenuncia(int iddenuncia) {
		this.iddenuncia = iddenuncia;
	}
	public Date getData_denuncia() {
		return data_denuncia;
	}
	public void setData_denuncia(Date data_denuncia) {
		this.data_denuncia = data_denuncia;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTp_imovel() {
		return tp_imovel;
	}
	public void setTp_imovel(String tp_imovel) {
		this.tp_imovel = tp_imovel;
	}
	public String getDesc_den() {
		return desc_den;
	}
	public void setDesc_den(String desc_den) {
		this.desc_den = desc_den;
	}
	
	public String getDenunciante() {
		return denunciante;
	}
	public void setDenunciante(String denunciante) {
		this.denunciante = denunciante;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "Denuncia [iddencuncia=" + iddenuncia + ", data_denuncia=" + data_denuncia + ", bairro=" + bairro
				+ ", rua=" + rua + ", quadra=" + quadra + ", lote=" + lote + ", numero=" + numero + ", cidade=" + cidade
				+ ", tp_imovel=" + tp_imovel + ", desc_den=" + desc_den + "]";
	}
	

}
