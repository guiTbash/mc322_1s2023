import java.util.Scanner;
import java.util.ArrayList;

public class AppMain {
	public static void main(String[] args) {
		//Initialize Vehicles//
		ArrayList<Veiculo> listaV1= new ArrayList<Veiculo>();
		Veiculo v1 = new Veiculo("BMW-0001","BMW","X6",2020);
		Veiculo v2 = new Veiculo("GOL-0002","Volkswagen","Gol Bola",1990);
		
		listaV1.add(v1);
		listaV1.add(v2);
	
		//Initialize client with the Vehicle list above//
		ClientePJ c1 = new ClientePJ("Jóia da Índia","Rua Alcântara Machado,333",
		listaV1,"21.597.493/0001-69","16/09/1984",15);
		
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
		ArrayList<Seguradora> listaSeg = new ArrayList<Seguradora>();
		
		//Initialize "Seguradora"//
		Seguradora vps = new Seguradora("VPS","6730284433","vpscorretora@gmail.com",
		"Rua Pacaembú,111",listaS,listaC);
		listaSeg.add(vps);
		
		//Calls Seguradora's methods//
		vps.cadastrarCliente(c1);
		vps.cadastrarCliente(c2);
		vps.gerarSinistro(c1,v1,"10/04/2022","Av. Afonso Pena, 443");
		
		Scanner scanner = new Scanner(System.in);
		
		MenuPrincipal operacao = null;
		while(operacao != MenuPrincipal.SAIR){
			System.out.println("\nSelecione uma opção:\n");
			for(MenuPrincipal op: MenuPrincipal.values()){
				System.out.printf("%d - %s\n",op.getOperacao(),op);
			}

			int select = scanner.nextInt();
			operacao = MenuPrincipal.values()[select];
			switch (operacao){
				case SAIR:
				System.out.println("\nPrograma encerrado!!!!");
				break;
				case CADASTRAR:
					MenuCadastrar opC = null;
					System.out.println("\nSelecione o que deseja cadastrar:");
					for(MenuCadastrar op: MenuCadastrar.values()){
						System.out.printf("%d - %s\n",op.getOperacao(),op);
					}
					Scanner scannerI1 = new Scanner(System.in);
					int cadastro = scannerI1.nextInt();
					opC = MenuCadastrar.values()[cadastro];
					
					switch (opC){
						case CLIENTE:
							Scanner scanType = new Scanner(System.in);
							System.out.println("Qual tipo de cliente deseja cadastrar? (PF/PJ)");
							String type = scanType.nextLine();
							Scanner scannerC = new Scanner(System.in);
							
							if(type.equalsIgnoreCase("PF")){
								System.out.println("\n---Cadastro de Cliente Pessoa Física---\n");
								System.out.println("\nDigite o nome da seguradora para cadastrar o cliente:");
								String seguradora = scannerC.nextLine();
								System.out.println("\nDigite um nome: ");
								String nome = scannerC.nextLine();
								if(!Validacao.validaNome(nome)){
									System.out.println("\nNome inválido, utilize apenas letras e espaços vazios.\n");
									break;
								}
								System.out.println("\nDigite um endereço: ");
								String endereco = scannerC.nextLine();
								System.out.println("\nDigite um dataLicenca: ");
								String dataLicenca = scannerC.nextLine();
								System.out.println("\nDigite o nível de educação: ");
								String educacao = scannerC.nextLine();
								System.out.println("\nDigite o gênero: ");
								String genero = scannerC.nextLine();
								System.out.println("\nDigite a classe econômica: ");
								String classeEconomica = scannerC.nextLine();
								System.out.println("\nDigite um cpf válido: ");
								String cpf = scannerC.nextLine();
								if(!Validacao.validaCPF(cpf)){
									System.out.println("\nCPF inválido, tente novamente!\n");
									break;
								}
								System.out.println("\nDigite a data de nascimento: ");
								String dataNascimento = scannerC.nextLine();
								ArrayList<Veiculo> listaV = new ArrayList<Veiculo>();
								Cliente cliente = new ClientePF(nome,endereco,dataLicenca,educacao,genero,classeEconomica,listaV,cpf,dataNascimento);
								for(int i = 0; i < listaSeg.size();i++){
									if(listaSeg.get(i).getNome().equals(seguradora)){
										listaSeg.get(i).cadastrarCliente(cliente);
										System.out.println("\nCliente PF cadastrado com sucesso!\n");
										break;
									}
									if(i == listaSeg.size()-1 && !listaSeg.get(i).getNome().equalsIgnoreCase(seguradora))
										System.out.println("\nNão foi possível cadastrar o cliente, seguradora não encontrada!");
								}	
							}if(type.equalsIgnoreCase("PJ")){
								System.out.println("\n---Cadastro de Cliente Pessoa Jurídica---\n");
								System.out.println("\nDigite o nome da seguradora para cadastrar o cliente:");
								String seguradora = scannerC.nextLine();
								System.out.println("Digite um nome: ");
								String nome = scannerC.nextLine();
								if(!Validacao.validaNome(nome)){
									System.out.println("\nNome inválido, utilize apenas letras e espaços vazios.\n");
									break;
								}
								System.out.println("\nDigite um endereço: ");
								String endereco = scannerC.nextLine();
								System.out.println("\nDigite um cnpj válido: ");
								String cnpj = scannerC.nextLine();
								if(!Validacao.validaCNPJ(cnpj)){
									System.out.println("\nCNPJ inválido, tente novamente!\n");
									break;
								}
								System.out.println("\nDigite a data de fundação da empresa:");
								String dataFundacao = scannerC.nextLine();
								System.out.println("\nDigite o número de funcionários:");
								int qtdFuncionarios = scannerC.nextInt();
								ArrayList<Veiculo> listaV = new ArrayList<Veiculo>();
								ClientePJ cliente = new ClientePJ(nome,endereco,listaV,cnpj,dataFundacao,qtdFuncionarios);
								for(int i = 0; i < listaSeg.size();i++){
									if(listaSeg.get(i).getNome().equalsIgnoreCase(seguradora)){
										listaSeg.get(i).cadastrarCliente(cliente);
										System.out.println("\nCliente PJ cadastrado com sucesso!\n");
										break;
									}
									if(i == listaSeg.size()-1 && !listaSeg.get(i).getNome().equals(seguradora))
										System.out.println("Não foi possível cadastrar o cliente, seguradora não encontrada!");
								}
							}
							break;
							case VEICULO:
								Scanner scannerV = new Scanner(System.in);
								System.out.println("\n---Cadastro de Veículo---\n");
								System.out.println("Digite o nome da seguradora a cadastrar o veículo:");
								String nomeSeg = scannerV.nextLine();
								System.out.println("\nDigite o nome do cliente a cadastrar o veículo:");
								String nomeCliente = scannerV.nextLine();
								System.out.println("\nDigite a placa do veículo:");
								String placa = scannerV.nextLine();
								System.out.println("\nDigite a marca do veículo:");
								String marca = scannerV.nextLine();
								System.out.println("\nDigite o modelo do veículo:");
								String modelo = scannerV.nextLine();
								System.out.println("\nDigite o ano de fabricação do veículo:");
								int anoFabricacao = scannerV.nextInt();
								Veiculo veiculo = new Veiculo(placa,marca,modelo,anoFabricacao);
								int x=-1;
								for(int i = 0; i < listaSeg.size();i++){
									if(listaSeg.get(i).getNome().equalsIgnoreCase(nomeSeg)){
										x = i;
										break;
									}
								}
								if(x==-1){
									System.out.println("Seguradora não encontrada!");
									break;
								}
								for(int j = 0; j < listaSeg.get(x).getListaClientes().size();j++){
									if(listaSeg.get(x).getListaClientes().get(j).getNome().equals(nomeCliente)){
										listaSeg.get(x).getListaClientes().get(j).getListaVeiculos().add(veiculo);
										listaSeg.get(x).getListaClientes().get(j).setValorSeguro();
										System.out.printf("\nVeículo cadastrado com sucesso em nome de %s!\n",listaSeg.get(x).getListaClientes().get(j).getNome());
										break;
									}
									if(j == listaSeg.get(x).getListaClientes().size()-1 && !vps.getListaClientes().get(j).getNome().equals(nomeCliente))
										System.out.println("Não foi possível cadastrar o veículo, cliente não encontrado!");
								}
								break;
							case SEGURADORA:
								Scanner scannerS = new Scanner(System.in);
								System.out.println("\n---Cadastro de Seguradora---");
								System.out.println("\nDigite o nome da seguradora:");
								String nome = scannerS.nextLine();
								System.out.println("\nDigite o telefone da seguradora:");
								String telefone = scannerS.nextLine();
								System.out.println("\nDigite o email da seguradora:");
								String email = scannerS.nextLine();
								System.out.println("\nDigite o endereço da seguradora:");
								String endereco = scannerS.nextLine();
								ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
								ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
								Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, listaSinistros, listaClientes);	
								listaSeg.add(seguradora);
								System.out.println("\nSeguradora cadastrada com sucesso!");
								break;
						case VOLTAR:
							break;
					}
					break;
				case LISTAR:
					MenuListar opL = null;
					System.out.println("\nSelecione o que deseja listar:");
					for(MenuListar op: MenuListar.values()){
						System.out.printf("%d - %s\n",op.getOperacao(),op);
					}

					Scanner scannerI2 = new Scanner(System.in);
					int lista = scannerI2.nextInt();
					opL = MenuListar.values()[lista];
					
					switch(opL){
						case CLIENTES_POR_SEGURADORA:
							for(int i = 0; i < listaSeg.size();i++){
								System.out.printf("\nSeguradora %s:\n",listaSeg.get(i).getNome());
								System.out.println("\n---Clientes Pessoa Física---\n");
								System.out.println(listaSeg.get(i).listarClientes("PF"));
								System.out.println("\n---Clientes Pessoa Jurídica---\n");
								System.out.println(listaSeg.get(i).listarClientes("PJ"));
							}
							break;

						case SINISTROS_POR_SEGURADORA:
							for(int i = 0;i < listaSeg.size();i++){
								System.out.printf("\nSeguradora %s:\n",listaSeg.get(i).getNome());
								System.out.println(listaSeg.get(i).listarSinistros());
							}
							break;

						case SINISTROS_POR_CLIENTE:
							for(int i = 0;i < listaSeg.size();i++){
								for(int j = 0; j < listaSeg.get(i).getListaClientes().size();j++){
									System.out.printf("\nSinistros do cliente %s da Seguradora %s:\n",listaSeg.get(i).getListaClientes().get(j).getNome(),listaSeg.get(i).getNome());
									listaSeg.get(i).visualizarSinistro(listaSeg.get(i).getListaClientes().get(j).getNome());
								}
							}
							break;

						case VEICULOS_POR_CLIENTE:
							for(int i = 0;i < listaSeg.size();i++){
								for(int j = 0; j < listaSeg.get(i).getListaClientes().size();j++){
									System.out.printf("\nVeículos do cliente %s da Seguradora %s:\n",listaSeg.get(i).getListaClientes().get(j).getNome(),listaSeg.get(i).getNome());
									for(int k = 0; k < listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size();k++){
										System.out.println(listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k).toString());
									}
								}
							}
							break;

						case VEICULOS_POR_SEGURADORA:
							for(int i = 0;i < listaSeg.size();i++){
								System.out.printf("\nVeículos cadastrados na Seguradora %s:\n",listaSeg.get(i).getNome());
								for(int j = 0; j < listaSeg.get(i).getListaClientes().size();j++){
									for(int k = 0; k < listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size();k++){
										System.out.println(listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k).toString());
										System.out.printf("\n----------------\n");
									}
								}
							}	
							break;

						case SAIR:
							break;
					}

				case EXCLUIR:
					MenuExcluir opE = null;
					System.out.println("\nSelecione o que deseja excluir:");
					for(MenuExcluir op: MenuExcluir.values()){
						System.out.printf("%d - %s\n",op.getOperacao(),op);
					}
					Scanner scannerI3 = new Scanner(System.in);
					int remocao = scannerI3.nextInt();
					opE = MenuExcluir.values()[remocao];
					
					switch(opE){
						case CLIENTE:
							Scanner scannerC = new Scanner(System.in);
							System.out.println("\nDigite o nome do cliente a ser removido:");
							String nomeCliente = scannerC.nextLine();
							for(int i = 0;i < listaSeg.size();i++){
								for(int j = 0; j < listaSeg.get(i).getListaClientes().size();j++){
									if(listaSeg.get(i).getListaClientes().get(j).getNome().equals(nomeCliente)){
										listaSeg.get(i).getListaClientes().remove(listaSeg.get(i).getListaClientes().get(j));
										System.out.println("\nCliente removido com sucesso!");
									}
									if(i == listaSeg.size()-1 && j == listaSeg.get(i).getListaClientes().size()-1 && !listaSeg.get(i).getListaClientes().get(j).getNome().equals(nomeCliente)){
										System.out.println("\nA remoção não foi possível, cliente não encontrado!");
									}
								}
							}
							break;
						case VEICULO:
							Scanner scannerV = new Scanner(System.in);
							System.out.println("\nDigite a placa do veículo a ser removido:");
							String placaVeiculo = scannerV.nextLine();
							for(int i = 0; i < listaSeg.size();i++){
								for(int j = 0;j < listaSeg.get(i).getListaClientes().size();j++){
									for(int k = 0; k < listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size();k++){
										if(listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k).getPlaca().equals(placaVeiculo)){
											listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().remove(listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k));
											System.out.println("\nVeículo removido com sucesso!");
										}
										if(i == listaSeg.size() && j == listaSeg.get(i).getListaClientes().size()-1 && k == listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size() && !listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k).getPlaca().equals(placaVeiculo)){
											System.out.println("\nA remoção não foi possível, veículo não encontrado!");
										}
									}
								}
							}
							break;
						case SINISTRO:
							Scanner scannerS = new Scanner(System.in);
							System.out.println("\nDigite o ID do sinistro a ser removido:");
							int idSinistro = scannerS.nextInt();
							for(int i = 0;i < listaSeg.size();i++){
								for(int j = 0;j < listaSeg.get(i).getListaSinistros().size();j++){
									if(listaSeg.get(i).getListaSinistros().get(j).getId() == idSinistro){
										listaSeg.get(i).getListaSinistros().remove(listaSeg.get(i).getListaSinistros().get(j));
										System.out.println("\nSinistro removido com sucesso!");
									}
									if(i == listaSeg.size()-1 && j == listaSeg.get(i).getListaSinistros().size()-1 && listaSeg.get(i).getListaSinistros().get(j).getId() != idSinistro){
										System.out.println("A remoção não foi possível!");
									}
								}
							}
							break;
						case VOLTAR:
							break;
					}
					break;
				case GERAR_SINISTRO:
					Scanner scannerG = new Scanner(System.in);
					System.out.println("Digite o nome da seguradora para gerar o sinistro:");
					String nomeSeg = scannerG.nextLine();
					System.out.println("Qual a data da ocorrência do sinistro?");
					String data = scannerG.nextLine();
					System.out.println("Qual foi o endereço da ocorrência?");
					String endereco = scannerG.nextLine();
					System.out.println("Qual o nome do cliente envolvido no acidente?");
					String nomeCliente = scannerG.nextLine();
					System.out.println("Qual a placa do veículo danificado?");
					String placaVeiculo = scannerG.nextLine();
					for(int i = 0;i < listaSeg.size();i++){
						if(listaSeg.get(i).getNome().equals(nomeSeg)){
							for(int j = 0;j < listaSeg.get(i).getListaClientes().size();j++){
								if(listaSeg.get(i).getListaClientes().get(j).getNome().equals(nomeCliente)){
									for(int k =0; k < listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size();k++){
										if(listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k).getPlaca().equals(placaVeiculo)){
											listaSeg.get(i).getListaClientes().get(j).setQtdSinistros(listaSeg.get(i).getListaClientes().get(j).getQtdSinistros()+1);
											listaSeg.get(i).getListaClientes().get(j).setValorSeguro();
											listaSeg.get(i).gerarSinistro(listaSeg.get(i).getListaClientes().get(j),listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k), data, endereco);
											System.out.println("\nSinistro gerado com sucesso!");
										}
										if(i == listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size()-1 && !listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(k).getPlaca().equals(placaVeiculo)){
											System.out.println("\nVeículo não encontrado!");
										}
									}
								}
								if(j == listaSeg.get(i).getListaClientes().size()-1 && !listaSeg.get(i).getListaClientes().get(j).getNome().equals(nomeCliente)){
									System.out.println("\nCliente não encontrado!");
								}
							}
						}
						if(i == listaSeg.size()-1 && !listaSeg.get(i).getNome().equals(nomeSeg)){
							System.out.println("\nSeguradora não encontrada!");
						}
					}
					break;
				case TRANSFERIR_SEGURO:
					Scanner scannerT = new Scanner(System.in);
					System.out.println("\nDigite o nome do cliente que fará a transferência do seguro:");
					String cliente1 = scannerT.nextLine();
					System.out.println("\nDigite o nome do cliente a quem o seguro será transferido:");
					String cliente2 = scannerT.nextLine();
					for(int i = 0;i < listaSeg.size();i++){
						for(int j = 0;j < listaSeg.get(i).getListaClientes().size();j++){
							if(listaSeg.get(i).getListaClientes().get(j).getNome().equals(cliente1)){
								for(int k = 0; k < listaSeg.get(i).getListaClientes().size();k++){
									if(listaSeg.get(i).getListaClientes().get(k).getNome().equals(cliente2)){
										for(int x = 0; x < listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size();x++){
											listaSeg.get(i).getListaClientes().get(k).getListaVeiculos().add(listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().get(x));
										}
										listaSeg.get(i).getListaClientes().get(k).setValorSeguro();
										System.out.printf("\nSeguro transferido com sucesso do cliente %s para o cliente %s!\n",listaSeg.get(i).getListaClientes().get(j).getNome(),listaSeg.get(i).getListaClientes().get(k).getNome());
										for(int x = 0; x < listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().size();x++){
											listaSeg.get(i).getListaClientes().get(j).getListaVeiculos().clear();
										}
										listaSeg.get(i).getListaClientes().get(j).setValorSeguro();
									}
								}
							}
						}
					}
					break;
				case CALCULAR_RECEITA_SEGURADORA:
					Scanner scannerR = new Scanner(System.in);
					System.out.println("\nDigite o nome da seguradora que deseja calcular a receita:");
					String nome = scannerR.nextLine();
					double receita = 0;
					for(int i = 0; i < listaSeg.size();i++){
						if(listaSeg.get(i).getNome().equalsIgnoreCase(nome)){
							for(int j = 0; j < listaSeg.get(i).getListaClientes().size();j++){
								receita += listaSeg.get(i).getListaClientes().get(j).getValorSeguro();
							}
							System.out.printf("\nA receita total da seguradora %s é R$%.2f.\n",listaSeg.get(i).getNome(),receita);
						}
						if(i == listaSeg.size()-1 && !listaSeg.get(i).getNome().equalsIgnoreCase(nome)){
							System.out.println("\nNão foi possível calcular a receita, seguradora não encontrada!\n");
						}
					}
					break;	
			}
		}	
		scanner.close();	
	}
}
