import java.util.ArrayList;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private String dataLicenca;
    private String educacao;
    private String dataNascimento;
    private String classeEconomica;
    private int qtdSinistros;
    private double valorSeguro;        

    public ClientePF(String nome, String endereco, String dataLicenca,
                        String educacao, String genero, String classeEconomica,
                        ArrayList<Veiculo> listaVeiculos, String cpf, String dataNascimento){
        super(nome,endereco,listaVeiculos);
        this.dataNascimento = dataNascimento;
        this.dataLicenca = dataLicenca;
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.classeEconomica = classeEconomica;
        this.qtdSinistros = 0;
        this.valorSeguro = calculaScore();
    }

    //GETTERS AND SETTERS//
    public String getCPF(){
        return cpf;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getDataLicenca(){
        return dataLicenca;
    }

    public void setDataLicenca(String dataLicenca){
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao(){
        return educacao;
    }

    public void setEducacao(String educacao){
        this.educacao = educacao;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica(){
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
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

    public double calculaScore(){
        String ano = this.dataNascimento.substring(dataNascimento.length()-4);
        int anoNasc = Integer.parseInt(ano);
        CalcSeguros fator = null;
        CalcSeguros base = CalcSeguros.values()[0];
        if(2023-anoNasc >= 18 && 2023-anoNasc<=30){
            fator = CalcSeguros.values()[1];
        }if(2023-anoNasc > 30 && 2023-anoNasc <= 60){
            fator = CalcSeguros.values()[2];
        }if(2023-anoNasc > 60 && 2023-anoNasc <= 90){
            fator = CalcSeguros.values()[3];
        }
        return(fator.getFator() * base.getFator() * this.getListaVeiculos().size());
    }

    //toString Method//
    public String toString(){
        String out = "";
        out += "\nNome: "+getNome()+
        "\nEndereço: "+getEndereco()
        +"\nData Licença: "+getDataLicenca()
        +"\nEducação: "+getEducacao()
        +"\nGênero: "+getGenero()
        +"\nClasse Econômica: "+getClasseEconomica()
        +"\nCPF: "+getCPF()
        +"\nData de Nascimento: "+getDataNascimento()
        +"\nValor do Seguro: "+getValorSeguro();
        return out;
    }
}