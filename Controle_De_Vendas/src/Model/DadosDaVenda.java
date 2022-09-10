package Model;

/**
 * Classe DadosDaVenda cadastra as informacoes de uma venda.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

public class DadosDaVenda {
    private ProdutoVendido produtoVendido;
    private Cliente cliente;
    private Parcelado pagamentoParcelado;
    private Avista pagamento;

    /**
     * Construtor da classe DadosDaVenda. 
     * @param cliente Cliente que realizou a compra.
     * @param produtoVendido Produto vendido.
     * @param pagamentoP Pagamento parcelado realizado.
     */
    public DadosDaVenda(Cliente cliente, ProdutoVendido produtoVendido, Parcelado pagamentoP) {
        this.cliente = cliente;
        this.produtoVendido = produtoVendido;
        this.pagamentoParcelado = pagamentoP;
    }
    /**
     * Construtor da classe DadosDaVenda. 
     * @param cliente Cliente que realizou a compra.
     * @param produtoVendido Produto vendido.
     * @param pagamento Pagamento a vista.
     */
    public DadosDaVenda(Cliente cliente, ProdutoVendido produtoVendido, Avista pagamento) {
        this.cliente = cliente;
        this.produtoVendido = produtoVendido;
        this.pagamento = pagamento;
    }

    //Getters e setters

    public Parcelado getPagamentoP() {
        return pagamentoParcelado;
    }

    public void setPagamentoP(Parcelado pagamentoP) {
        this.pagamentoParcelado = pagamentoP;
    }

    public Avista getPagamento() {
        return pagamento;
    }

    public void setPagamento(Avista pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ProdutoVendido getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(ProdutoVendido produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

}
