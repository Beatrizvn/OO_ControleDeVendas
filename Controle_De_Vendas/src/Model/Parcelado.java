package Model;
/**
 * Classe Parcelado cadastra as informacoes de um pagamento parcelado. Herda da classe abstrata Pagamento.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

public class Parcelado extends Pagamento {
    private int qtd_de_parcelas, juros;
    private double valor_parcelas, valor_apos_juros;


    /**
     * Construtor da classe Parcelado. Aqui ja e feito o calculo do valor apos os juros e o valor de cada parcela.
     * @param produtoVendido Produto vendido.
     * @param status Status do pagamento.
     * @param qtd_de_parcelas Quantidade de Parcelas.
     * @param juros Juros da venda.
     */
    public Parcelado(ProdutoVendido produtoVendido, boolean status, int qtd_de_parcelas, int juros) {
        super(produtoVendido, status);
        this.qtd_de_parcelas = qtd_de_parcelas;
        this.juros = juros;
        this.valor_apos_juros = getProdutoVendido().getValor() + (getProdutoVendido().getValor() * (getJuros() / 100d));
        this.valor_parcelas = getValor_apos_juros() / getQtd_de_parcelas();
    }


    //Getters e Setters

    public double getValor_apos_juros() {
        return valor_apos_juros;
    }

    public void setValor_apos_juros(double valor_apos_juros) {
        this.valor_apos_juros = valor_apos_juros;
    }

    public int getQtd_de_parcelas() {
        return qtd_de_parcelas;
    }

    public void setQtd_de_parcelas(int qtd_de_parcelas) {
        this.qtd_de_parcelas = qtd_de_parcelas;
    }

    public double getValor_parcelas() {
        return valor_parcelas;
    }

    public void setValor_parcelas(double valor_parcelas) {
        this.valor_parcelas = valor_parcelas;
    }

    public int getJuros() {
        return juros;
    }

    public void setJuros(int juros) {
        this.juros = juros;
    }

}
