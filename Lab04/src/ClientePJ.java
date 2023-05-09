import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private String dataFundacao;
    private int qtdFuncionarios;
    private int qtdSinistros;
    private double valorSeguro;        
    
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
                        String cnpj,String dataFundacao, int qtdFuncionarios){
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
        this.qtdSinistros = 0;
        this.valorSeguro = calculaScore();
    }

    //GETTERS AND SETTERS//

    //cnpj only have getter, since it is a final variable//
    public String getCNPJ(){
        return cnpj;
    }

    public String getDataFundacao(){
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public int getQtdFuncionarios(){
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios){
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public int getQtdSinistros(){
        return qtdSinistros;
    }

    public void setQtdSinistros(int qtdSinistros){
        this.qtdSinistros = qtdSinistros;
    }

    public double getValorSeguro(){
        return valorSeguro;
    }
    
    public void setValorSeguro(){
        this.valorSeguro = calculaScore() * (1+qtdSinistros);
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

    public double calculaScore(){
        CalcSeguros base = CalcSeguros.values()[0];
        return(base.getFator() * (1 + (this.getQtdFuncionarios()/100)) * this.getListaVeiculos().size());
    }

    //toString//
    public String toString(){
        String out = "";
        out += "\nNome: "+getNome()
        +"\nEndereço: "+getEndereco()
        +"\nVeículo: "
        +"\nCNPJ: "+getCNPJ()
        +"\nValor do Seguro: "+getValorSeguro();
        return out;
    } 
}