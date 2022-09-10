package Model;

/**
 * Classe abstrata Pagamento, onde estão contidos metodos e atributos para o mesmo.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * 
 */

abstract class Pagamento {
    private ProdutoVendido produtoVendido;
    private boolean status;

    /**
     * Construtor da classe abstrata Pagamento.
     * @param produtoVendido Produto que foi vendido.
     * @param status Status do Pagamento.
     */

    public Pagamento(ProdutoVendido produtoVendido, boolean status) {
        this.produtoVendido = produtoVendido;
        this.status = status;    
    }

    
    //Getters e Setters
    

    public ProdutoVendido getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(ProdutoVendido produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
