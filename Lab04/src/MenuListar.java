public enum MenuListar {
    CLIENTES_POR_SEGURADORA(0),
    SINISTROS_POR_SEGURADORA(1),
    SINISTROS_POR_CLIENTE(2),
    VEICULOS_POR_CLIENTE(3),
    VEICULOS_POR_SEGURADORA(4),
    SAIR(5);

    public final int operacao;

    MenuListar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return operacao;
    }
}
