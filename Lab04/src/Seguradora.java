import java.util.ArrayList;

public class Seguradora {
		private String nome;
		private String telefone;
		private String email;
		private String endereco;
		private ArrayList<Sinistro> listaSinistros;
		private ArrayList<Cliente> listaClientes;
		
	public Seguradora(String nome, String telefone, String email, String endereco,ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
	}
	
	//GETTERS AND SETTERS//
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes){
		this.listaClientes = listaClientes;
	}

	//METODOS DA CLASSE SEGURADORA//
	public Boolean cadastrarCliente(Cliente cliente){
		this.listaClientes.add(cliente);
		return true;
	}

	public Boolean removerCliente(String cliente){
		if(listaClientes.isEmpty()){
			System.out.println("Lista de clientes vazia");
			return false;
		}else{
			for(int i=0;i<listaClientes.size();i++){
				if(listaClientes.get(i).getNome().equals(cliente)){	
					this.listaClientes.remove(listaClientes.get(i));
					System.out.println("Cliente removido com sucesso!");
					return true;
				}
			}
			System.out.println("Cliente não encontrado!");
			return false;
		}
	}

	public String listarClientes(String tipoCliente){
		String out = "";
		for(int i=0;i<listaClientes.size();i++){
			if(tipoCliente == "PF"){
				if(this.getListaClientes().get(i).getClass() == ClientePF.class)
					out += this.getListaClientes().get(i).toString();
			}if(tipoCliente == "PJ"){
				if(this.getListaClientes().get(i).getClass() == ClientePJ.class){
					out += this.getListaClientes().get(i).toString();				}
			}
		}
		out+= "\n";
		return out;
	}

	public Boolean gerarSinistro(Cliente cliente,Veiculo veiculo,String data,String endereco){
		Sinistro sinistro = new Sinistro(data,endereco,this,veiculo,cliente);
		this.listaSinistros.add(sinistro);
		return true;
	};

	public Boolean visualizarSinistro(String cliente){
		for(int i=0;i<listaSinistros.size();i++){
			if(this.listaSinistros.get(i).getCliente().getNome().equals(cliente)){
				System.out.println(listaSinistros.get(i).toString());
				return true;
			}
		}
		System.out.println("\nSinistro não encontrado!");
		return false;
	}

	public String listarSinistros(){
		String out = "";
		for(int i = 0;i < this.listaSinistros.size();i++){
			out += listaSinistros.get(i).toString();
		}
		return out;
	}

	//TOSTRING//
	public String toString(){
		String out = "";
		out+= getNome()+"\nTelefone: "+getTelefone()+"\nEmail: "+getTelefone()+"\nEndereço: "+getEndereco();
		return out;
	}
}
