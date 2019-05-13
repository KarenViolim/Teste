package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idestado;
	private String nome;
	private String sigla;
	public long getIdestado() {
		return idestado;
	}
	public void setIdestado(long idestado) {
		this.idestado = idestado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
