package Model;

/**
 * Classe ProdutoVendido cadastra as informacoes de produto vendido.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

public class ProdutoVendido {
	private double valor;
	private Produto produto;
	private int qtd;
	    
	/**
	 * Construtor da classe ProdutoVendido.
	 * @param produto Produto que foi vendido
	 */
    public ProdutoVendido(Produto produto) {
        this.produto = produto;
        this.valor = produto.getValor_de_venda();
        this.qtd = 1;
    }

    /**
     * Adicionar mais quantidade de um produto à venda.
     * @param quantidade Quantidade do produto que sera adicionado a venda.
     */
    public void cadastrarMaisProduto(int quantidade) {
        for (int i = 1; i < quantidade; i++) {
            this.valor += produto.getValor_de_venda();
        }
        qtd = quantidade;
    }
    
    //Getters e Setters

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}