public class Validacao {
    private Validacao(){};

    //CPF VALIDATION FNCTION//
    public static boolean validaCPF(String cpf){
        String allNum;
        allNum = cpf.replaceAll("[^0-9]","");

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

    //Aux method to get the integer value of a character//
    public static int CtoI(char x){
        return Character.getNumericValue(x);
    }

    //CNPJ VALIDATION METHOD//
    public static boolean validaCNPJ(String cnpj){
        String allNum;
        allNum = cnpj.replaceAll("[^0-9]","");
        
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

    public static boolean validaNome(String nome){
        if(nome.matches("[a-zA-Z ]+"))
            return true;
        else    
            return false;
    }
}
