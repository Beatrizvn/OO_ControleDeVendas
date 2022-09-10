package Model;
/**
 * Classe Avista cadastra as informacoes de um pagamento a vista. Herda da classe abstrata Pagamento.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

public class Avista extends Pagamento {
    private int desconto;
    private double valorFinal;

    /**
     * Construtor da classe Avista.  Aqui ja e feito o calculo do valor final apos o desconto.
     * @param produtoVendido Produto que foi vendido
     * @param status status do pagamento
     * @param desconto desconto da venda
     *
     */
    public Avista(ProdutoVendido produtoVendido, boolean status, int desconto) {
    	super(produtoVendido, status);
        this.desconto = desconto;
        this.valorFinal = getProdutoVendido().getValor() - (getProdutoVendido().getValor() * (getDesconto() / 100d));
    }

    //Getters e Setters

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
    	this.valorFinal = valorFinal;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {

        this.desconto = desconto;
    }

}
