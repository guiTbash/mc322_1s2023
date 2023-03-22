package seguradora;

public class Cliente {
		private String nome;
		private String cpf;
		private String dataNascimento;
		private String endereco;
		private int idade;
	
	public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.idade = idade;
	}
	

	//GETTERS AND SETTERS//
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;

	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	//CPF VALIDATION FNCTION//
	public boolean validarCPF(){
		String allNum;
		allNum = this.cpf.replaceAll("[^0-9]","");

		//Replace all non numeric characters by a void char//
		int length = allNum.length();
		
		//Verify the number of digits//
		if(length != 11)
			return false;
			
		char aux = allNum.charAt(0); char check = 0;
		for(int i = 1;i < length;i++){
			if(allNum.charAt(i) != aux)
				check = 1;				
		}
		
		//Verify if all digits are the same//
		if(check == 0)
			return false;

		//Calculate the verifying digits//
		int checker, charToint, soma = 0;
		
		//Calculating the first verifying digit//
		for(int i = 0,j = 10;i < length-2; i++,j--){
			charToint = Character.getNumericValue(allNum.charAt(i));
			soma += charToint * j; 
		}

		if(soma % 11 == 0 || soma % 11 == 1){
			checker = 0;
		}else{
			checker = 11 - (soma % 11);
		}

		if(checker != Character.getNumericValue(allNum.charAt(9)))
			return false;
		
		soma = 0; checker = -1;
		//Calculating the second verifying digit//
		for(int i = 1,j = 10;i < length-1; i++,j--){
			charToint = Character.getNumericValue(allNum.charAt(i));
			soma += charToint * j; 
		}
		
		if(soma % 11 == 0 || soma % 11 == 1){
			checker = 0;
		}else{
			checker = 11 - (soma % 11);
		}
		
		if(checker != Character.getNumericValue(allNum.charAt(10)))
			return false;
		
		//All verifications match//
		return true;
	}
}
