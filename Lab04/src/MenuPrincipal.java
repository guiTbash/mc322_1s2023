public enum MenuPrincipal {
    SAIR(0),
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA_SEGURADORA(6);
    
    public final int operacao;
        
    MenuPrincipal(int operacao){
        this.operacao = operacao;
    }
    
    public int getOperacao(){
        return operacao;
    }
}
