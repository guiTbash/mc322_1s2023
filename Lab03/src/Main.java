import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	//Function to display number menu//
	private static void exibirMenu(){
		System.out.println("\n---Escolha a Opção desejada---\n\n1- Cadastrar Cliente Pessoa Física\n2- Cadastrar Cliente Pessoa Jurídica\n4- Cadastrar Veículo\n3- Remover Cliente\n4- Listar Clientes (PF)\n5- Listar Clientes (PJ)\n6- Visualizar Sinistro\n\n------------------------------");
	}
	
	//Function to choose between number options//
	private static void entrada(Seguradora seguradora){
		Scanner scannerInt = new Scanner(System.in);
		int entrada = scannerInt.nextInt();	
		if(entrada == 1){
			System.out.println("\n---Cadastro de Cliente Pessoa Física---\n");
			Scanner scannerStr = new Scanner(System.in);
				System.out.println("Digite um nome: ");
				String nome = scannerStr.nextLine();
				System.out.println("\nDigite um endereço: ");
				String endereco = scannerStr.nextLine();
				System.out.println("\nDigite um dataLicenca: ");
				String dataLicenca = scannerStr.nextLine();
				System.out.println("\nDigite o nível de educação: ");
				String educacao = scannerStr.nextLine();
				System.out.println("\nDigite o gênero: ");
				String genero = scannerStr.nextLine();
				System.out.println("\nDigite a classe econômica: ");
				String classeEconomica = scannerStr.nextLine();
				System.out.println("\nDigite um cpf válido: ");
				String cpf = scannerStr.nextLine();
				System.out.println("\nDigite a data de nascimento: ");
				String dataNascimento = scannerStr.nextLine();
				ArrayList<Veiculo> listaV = new ArrayList<Veiculo>();
				Cliente cliente = new ClientePF(nome,endereco,dataLicenca,educacao,genero,classeEconomica,listaV,cpf,dataNascimento);
				seguradora.cadastrarCliente(cliente);
				scannerStr.close();
			}if(entrada == 2){
				System.out.println("\n---Cadastro de Cliente Pessoa Física---\n");
				Scanner scannerStr = new Scanner(System.in);
				System.out.println("Digite um nome: ");
				String nome = scannerStr.nextLine();
				System.out.println("\nDigite um endereço: ");
				String endereco = scannerStr.nextLine();
				System.out.println("\nDigite um cnpj válido: ");
				String cnpj = scannerStr.nextLine();
				ArrayList<Veiculo> listaV = new ArrayList<Veiculo>();
				ClientePJ cliente = new ClientePJ(nome,endereco,listaV,cnpj);
				seguradora.cadastrarCliente(cliente);
				scannerStr.close();
			}if(entrada == 3){
				System.out.println("\n---Remoção de Cliente---\n");
				System.out.println("\nDigite o nome do cliente a ser removido:");
				Scanner scannerStr = new Scanner(System.in);
				String nome = scannerStr.nextLine();
				seguradora.removerCliente(nome);
				scannerStr.close();
			}if(entrada == 4){
				System.out.println("\n---Lista de Clientes Pessoa Física---\n");
				System.out.println(seguradora.listarClientes("PF"));
			}if(entrada == 5){
				System.out.println("\n---Lista de Clientes Pessoa Jurídica---\n");
				System.out.println(seguradora.listarClientes("PJ"));
			}if(entrada == 6){
				System.out.println("\n---Lista de Sinistros---\n\nDigite o nome do cliente para visualizar seus sinistros:");
				Scanner scannerStr = new Scanner(System.in);
				String nome = scannerStr.nextLine();
				seguradora.visualizarSinistro(nome);
				scannerStr.close();
			}
			scannerInt.close();
		}
		
	public static void main(String[] args) {
		//Initialize Vehicles//
		ArrayList<Veiculo> listaV1= new ArrayList<Veiculo>();
		Veiculo v1 = new Veiculo("BMW-0001","BMW","X6",2020);
		Veiculo v2 = new Veiculo("GOL-0002","Volkswagen","Gol Bola",1990);
		
		listaV1.add(v1);
		listaV1.add(v2);
		
		//Initialize client with the Vehicle list above//
		ClientePJ c1 = new ClientePJ("Jóia da Índia","Rua Alcântara Machado,333",
		listaV1,"21.597.493/0001-69");
		
		ArrayList<Veiculo> listaV2= new ArrayList<Veiculo>();
		Veiculo v3 = new Veiculo("FOX-0003","Volkswagen","Fox",2007);
		Veiculo v4 = new Veiculo("FIT-0004","Honda","Fit",2015);
		
		listaV2.add(v3);
		listaV2.add(v4);
		
		//Initialize client with the Vehicle list above//
		ClientePF c2 = new ClientePF("Romildo Serra","Rua Condessa do Pinhal,666",
		"18/04/2023","Ensino médio completo",
		"Masculino","Média",listaV2,"733.500.070-07",
		"04/07/1983");
		
		//Initialize client and accident lists//
		ArrayList<Cliente> listaC = new ArrayList<Cliente>();
		ArrayList<Sinistro> listaS = new ArrayList<Sinistro>();
		
		//Initialize insurance object//
		Seguradora vps = new Seguradora("VPS","6730284433","vpscorretora@gmail.com",
		"Rua Pacaembú,111",listaS,listaC);
		
		//Calls Seguradora's methods//
		vps.cadastrarCliente(c1);
		vps.cadastrarCliente(c2);
		vps.gerarSinistro();
		
		exibirMenu();
		
		entrada(vps);
	}
}
