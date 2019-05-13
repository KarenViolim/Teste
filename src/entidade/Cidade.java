package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idcidade;
	private String nome;
	@ManyToOne
	private Estado estado;
	
	public long getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(long idcidade) {
		this.idcidade = idcidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
