package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.DAOEstado;
import entidade.Estado;
import fabrica.Fabrica;

public class TelaEstado {
	public static void main (String [] args) {
		EntityManagerFactory fabrica = Fabrica.get();
		DAOEstado dao = new DAOEstado();
		Estado estado = new Estado();
		Scanner scann = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out.println("1 - Inserir");
			System.out.println("2 - Consultar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("INSERIR ESTADO");
				System.out.println("NOME: ");
				String nome = scann.nextLine();
				estado.setNome(nome);
				
				System.out.println("SIGLA: ");
				String sigla = scann.nextLine();
				estado.setSigla(sigla);
				
				dao.inserir(estado);
			}
			else if (opcao == 2) {
				listarEstado();
			}
			else if (opcao == 3) {
				listarEstado();
				System.out.println("ALTERAR ESTADO");
				System.out.println("Insira o ID:");	
				estado.setIdestado(scann.nextLong());
				System.out.println("Novo nome: ");
				estado.setNome(scann.next());
				System.out.println("Nova sigla: ");
				estado.setSigla(scann.next());
				dao.alterar(estado);
			}
			else if (opcao == 4) {
				listarEstado();
				System.out.println("EXCLUIR ESTADO");
				System.out.println("Insira o ID: ");
				estado.setIdestado(scann.nextLong());
				dao.excluir(estado);
			}
		}while(opcao != 5);
	}
		public static void listarEstado() {
			DAOEstado dao = new DAOEstado();
			System.out.println("LISTAR ESTADOS");
			List<Estado> est = dao.consultar();

			for (Estado estado : est) {
				System.out.println("ID: "+estado.getIdestado()+" Estado: "+estado.getNome()+" - "+estado.getSigla());
			}		
	}
}
