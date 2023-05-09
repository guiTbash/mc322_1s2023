import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private Date dataFundacao = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
                        String cnpj){
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
    }

    //GETTERS AND SETTERS//

    //cnpj only have getter, since it is a final variable//
    public String getCNPJ(){
        return cnpj;
    }

    public Date getDataFundacao(){
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    //Aux method to get the integer value of a character//
    public int CtoI(char x){
        return Character.getNumericValue(x);
    }
    //CNPJ VALIDATION METHOD//
    public Boolean validaCNPJ(){
        String allNum;
        allNum = this.cnpj.replaceAll("[^0-9]","");
        
        //Replace all non numeric characters by a void char//
        int length = allNum.length();
        
        //Verify the number of digits//
        if(length != 14)
            return false;
            
        char aux = allNum.charAt(0); char check = 0;
        for(int i = 1;i < length;i++){
            if(allNum.charAt(i) != aux)
                check = 1;				
        }
        
        //Verify if all digits are the same//
        if(check == 0)
            return false;
        
        //Chek first verifying digit//
        int ver = (CtoI(allNum.charAt(0))*5 + CtoI(allNum.charAt(1))*4 + CtoI(allNum.charAt(2))*3 + CtoI(allNum.charAt(3))*2 + CtoI(allNum.charAt(4))*9 +CtoI(allNum.charAt(5))*8 + CtoI(allNum.charAt(6))*7 + CtoI(allNum.charAt(7))*6 + CtoI(allNum.charAt(8))*5 + CtoI(allNum.charAt(9))*4 + CtoI(allNum.charAt(10))*3 + CtoI(allNum.charAt(11))*2);
        ver = ver % 11;
        
        if(ver >= 2){
            ver = 11 - ver;
        }
        else{
            ver = 0;}
            
        if(ver != CtoI(allNum.charAt(12)))
            return false;

        //Check the second verifying digit//
        ver = (CtoI(allNum.charAt(0))*6 + CtoI(allNum.charAt(1))*5 + CtoI(allNum.charAt(2))*4 + CtoI(allNum.charAt(3))*3 + CtoI(allNum.charAt(4))*2 + CtoI(allNum.charAt(5))*9 +CtoI(allNum.charAt(6))*8 + CtoI(allNum.charAt(7))*7 + CtoI(allNum.charAt(8))*6 + CtoI(allNum.charAt(9))*5 + CtoI(allNum.charAt(10))*4 + CtoI(allNum.charAt(11))*3 + CtoI(allNum.charAt(12))*2);
        ver = ver % 11;
        if(ver >= 2)
            ver = 11 - ver;
        else
            ver = 0;
        
        if(ver != CtoI(allNum.charAt(13)))
            return false;
        
        return true;
    }

    //toString//
    public String toString(){
        String out = "";
        out += "\nNome: "+getNome()
        +"\nEndereço: "+getEndereco()
        +"\nVeículo: "
        +"\nCNPJ: "+getCNPJ();
        return out;
    } 
}