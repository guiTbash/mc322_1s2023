public enum MenuCadastrar {
    CLIENTE(0),
    VEICULO(1),
    SEGURADORA(2),
    VOLTAR(3);

    public final int operacao;

    MenuCadastrar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return operacao;
    }
}
