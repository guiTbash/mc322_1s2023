package seguradora;

public class Main {
	public static void main(String[] args) {
		
		//INSTANCIACAO DO CLIENTE//
		Cliente client = new Cliente("Gui","052.484.441-01","31/02/1998","Rua Roxo Moreira,1332", 24);
		
		//Testando Setters//
		client.setNome("Guilherme");
		client.setCpf("231.312.060-04");
		client.setDataNascimento("28/02/1997");
		client.setEndereco("Rua Condessa do Pinhal, 555");
		client.setIdade(25);

		//Imprimindo atraves dos Getters//
		System.out.printf("\n---CLIENTE---\nNome: %s\nCPF: %s",client.getNome(),client.getCpf());
		
		if(client.validarCPF())
			System.out.printf(" (VALIDO)\n");
		else
			System.out.printf(" (INVALIDO)\n");
		
		System.out.printf("Data de Nascimento: %s\nEndereco: %s\nIdade: %d\n",client.getDataNascimento(),client.getEndereco(),client.getIdade());

		//INSTANCIACAO DA SEGURADORA//
		Seguradora seguradora = new Seguradora("Segura o Tchan","40028922","amarra_tchan@gmail.com", "Rua Compadre Washington, 2000");

		//Testando Setters//
		seguradora.setNome("VPS Seguros");
		seguradora.setTelefone("(67)3028-4433");
		seguradora.setEmail("vpsseguros@gmail.com");
		seguradora.setEndereco("Rua Regente Feijó, 54C");

		//Imprimindo atraves dos Getters//
		System.out.printf("\n---Seguradora---\nNome: %s\nTelefone: %s\nEmail: %s\nEndereco: %s\n",seguradora.getNome(),seguradora.getTelefone(),seguradora.getEmail(),seguradora.getEndereco());
		
		//INSTANCIACAO VEICULO//
		Veiculo carro = new Veiculo("BOI-0000","Fiat","Uno");

		//Testando Setters//
		carro.setPlaca("BOY-7777");
		carro.setMarca("BMW");
		carro.setModelo("X6");

		//Imprimindo atraves dos Getters//
		System.out.printf("\n---VEICULO---\nPlaca: %s\nMarca: %s\nModelo: %s\n",carro.getPlaca(),carro.getMarca(),carro.getModelo());

		//INSTANCIACAO SINISTRO//
		Sinistro acidente = new Sinistro("31/02/2023","Rua dos Bobos, 0");

		//Testando Setters//
		acidente.setData("28/02/2023");
		acidente.setEndereco("Av. Albert Einstein, 400");

		//Imprimindo atraves dos Getters//
		System.out.printf("\n---Sinistro---\nID: %d\nData: %s\nEndereco: %s\n",acidente.getId(),acidente.getData(),acidente.getEndereco());
	}
}
