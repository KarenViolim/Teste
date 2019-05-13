package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.DAOCidade;
import dao.DAOCliente;
import entidade.Cidade;
import entidade.Cliente;
import fabrica.Fabrica;

public class TelaCliente {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Fabrica.get(); 
		
		DAOCliente dao = new DAOCliente();
		Cidade cidade = new Cidade();
		Cliente cliente = new Cliente();
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
				System.out.println("INSERIR CLIENTE");
				System.out.println("NOME: ");
				String nome = scann.nextLine();
				cliente.setNome(nome);
				
				System.out.println("RG: ");
				String rg = scann.nextLine();
				cliente.setRg(rg);
				
				System.out.println("CPF: ");
				String cpf = scann.nextLine();
				cliente.setCpf(cpf);
				
				System.out.println("TELEFONE: ");
				String telefone = scann.nextLine();
				cliente.setTelefone(telefone);
				
				System.out.println("E-MAIL: ");
				String email = scann.nextLine();
				cliente.setEmail(email);
				
				System.out.println("ENDEREÇO: ");
				String endereco = scann.nextLine();
				cliente.setEndereco(endereco);
				
				listarCidades();
				System.out.println("INSIRA O ID DA CIDADE: ");
				Long idcidade = scann.nextLong();
				cidade.setIdcidade(idcidade);
				cliente.setCidade(cidade);
				
				dao.inserir(cliente);
			}
			else if (opcao == 2) {
				listarClientes();
			}
			else if (opcao == 3) {
				listarClientes();
				System.out.println("ALTERAR CLIENTE");
				System.out.println("INSIRA O ID: ");
				cliente.setIdcliente(scann.nextLong());
				System.out.println("NOVO NOME: ");
				cliente.setNome(scann.next());
				System.out.println("NOVO RG: ");
				cliente.setRg(scann.next());
				System.out.println("NOVO CPF: ");
				cliente.setCpf(scann.next());
				System.out.println("NOVO TELEFONE: ");
				cliente.setTelefone(scann.next());
				System.out.println("NOVO E-MAIL: ");
				cliente.setEmail(scann.next());
				System.out.println("NOVO ENDEREÇO: ");
				cliente.setEndereco(scann.next());
				scann.nextLine();
				System.out.println("NOVA CIDADE, ID: ");
				long idcidade = scann.nextLong();
				cidade.setIdcidade(idcidade);
				cliente.setCidade(cidade);
				
				dao.alterar(cliente);
			}
			else if (opcao == 4) {
				listarClientes();
				System.out.println("EXCLUIR CLIENTE");
				System.out.println("INSIRA O ID: ");
				cliente.setIdcliente(scann.nextLong());
				dao.excluir(cliente);
			}
		}while(opcao != 5);
		}
		public static void listarClientes() {
			DAOCliente dao = new DAOCliente();
			System.out.println("LISTAR CLIENTES");
			List<Cliente> cli = dao.consultar();
			
			for(Cliente cliente : cli) {
				System.out.println("ID: "+cliente.getIdcliente()+" Nome: "+cliente.getNome()+" RG: "+cliente.getRg()+" CPF: "+cliente.getCpf()+
						" Telefone: "+cliente.getTelefone()+" E-mail: "+cliente.getEmail()+" Endereço: "+cliente.getEndereco()+" Cidade: "+cliente.getCidade().getNome());
			}
		}
		public static void listarCidades() {
			DAOCidade dao = new DAOCidade();
			System.out.println("LISTAR CIDADES");
			List<Cidade> cid = dao.consultar();
				
			for(Cidade cidade : cid) {
				System.out.println("Id: "+cidade.getIdcidade()+" Cidade: "+cidade.getNome()+" Estado: "+cidade.getEstado().getSigla());
			}
		}
}
