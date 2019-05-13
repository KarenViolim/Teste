package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Cidade;
import fabrica.Fabrica;

public class DAOCidade {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Cidade inserir(Cidade cidade) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(cidade);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return cidade;
	}
	public List<Cidade> consultar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Cidade").getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;
	}
	public Cidade alterar(Cidade cidade) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(cidade);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return cidade;
	}
	public Cidade excluir(Cidade cidade) {
		try {
			EntityManagerFactory fabrica = Fabrica.get(); 
			gerenciador = fabrica.createEntityManager(); 
			transacao = gerenciador.getTransaction(); 
			
			transacao.begin();
			cidade = gerenciador.find(Cidade.class, cidade.getIdcidade());
			gerenciador.remove(cidade);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return cidade;
	}
}
