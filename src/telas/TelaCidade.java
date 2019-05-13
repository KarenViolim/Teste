package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.DAOCidade;
import dao.DAOEstado;
import entidade.Cidade;
import entidade.Estado;
import fabrica.Fabrica;

public class TelaCidade {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Fabrica.get(); 
		
		DAOCidade dao = new DAOCidade();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Scanner scann = new Scanner(System.in);
		
		int opcao = 0;
		do{
			System.out.println("01 - Inserir");
			System.out.println("02 - Consultar");
			System.out.println("03 - Alterar ");
			System.out.println("04 - Excluir");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("INSERIR CIDADE");
				System.out.println("NOME: ");
				String nome = scann.nextLine();
				cidade.setNome(nome);

				listarEstados();
				System.out.println("INSIRA O ID: ");
				long idestado = scann.nextLong();
				estado.setIdestado(idestado);
				cidade.setEstado(estado);
				dao.inserir(cidade);
			}
			else if (opcao == 2) {
				listarCidades();
			}
			else if (opcao == 3) {
				listarCidades();
				System.out.println("ALTERAR CIDADE");
				System.out.println("INSIRA O ID: ");	
				cidade.setIdcidade(scann.nextLong());
				System.out.println("NOVO NOME: ");
				cidade.setNome(scann.next());
				System.out.println("NOVO ESTADO, ID: ");
				long idestado = scann.nextLong();

				dao.alterar(cidade);
			}
			else if (opcao == 4) {
				listarCidades();
				System.out.println("EXCLUIR CIDADE");
				System.out.println("INSIRA O ID: ");
				cidade.setIdcidade(scann.nextLong());
				dao.excluir(cidade);
			}
		}while(opcao != 5);
		}
		public static void listarEstados() {
			DAOEstado dao = new DAOEstado();
			System.out.println("LISTAR ESTADOS");
			List<Estado> est = dao.consultar();
	
			for (Estado estado : est) {
				System.out.println("ID: "+estado.getIdestado()+" Estado: "+estado.getNome()+" - "+estado.getSigla());
			}		
		}
		public static void listarCidades() {
			DAOCidade dao = new DAOCidade();
			System.out.println("LISTAR CIDADES");
			List<Cidade> cid = dao.consultar();
				
			for(Cidade cidade : cid) {
				System.out.println("ID: "+cidade.getIdcidade()+" Cidade: "+cidade.getNome()+" Estado: "+cidade.getEstado().getSigla());
			}
		}
}
