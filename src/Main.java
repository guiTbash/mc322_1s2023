package seguradora;

public class Main {
	public static void main(String[] args) {
		Cliente client = new Cliente("Guilherme","052.484.441.01","16/05/2000","Rua Roxo Moreira, 910", 22);
		if(client.validarCPF(client.getCpf())){
			System.out.printf("O cliente %s, TEM um CPF válido.\n",client.getNome());
		}
		else{
			System.out.printf("O cliente %s, NÃO TEM um CPF válido.\n",client.getNome());
		}
	}
}
