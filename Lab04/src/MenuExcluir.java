public enum MenuExcluir {
    CLIENTE(0),
    VEICULO(1),
    SINISTRO(2),
    VOLTAR(3);

    public final int operacao;

    MenuExcluir(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return operacao;
    }
}
