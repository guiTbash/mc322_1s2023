package seguradora;
import java.util.Random;

public class Sinistro {
		private int id;
		private String data;
		private String endereco;
		
	public Sinistro(String data, String endereco) {
		this.id = getRandomNumber();
		this.data = data;
		this.endereco = endereco;
	}
	
	//Getters and setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData(){	
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//Random number generator function
	
	public int getRandomNumber() {
		Random rand= new Random();
		return rand.nextInt(999999999);
	}
	
}
