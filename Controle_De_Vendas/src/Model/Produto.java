package Model;
/**
 * Classe Produto cadastra as informacoes de um produto.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

public class Produto {
    private String nome, categoria;
    private double valor_de_custo, valor_de_venda;
    
    /**
     * Construtor da classe Produto.
     * @param nome nome do produto
     * @param categoria categoria do produto
     * @param valor_de_custo Valor de custo do produto
     * @param valor_de_venda Valor de venda do produto
     */

    public Produto(String nome, String categoria,  double valor_de_custo, double valor_de_venda) {
        this.nome = nome;
        this.categoria = categoria;
        this.valor_de_custo = valor_de_custo;
        this.valor_de_venda = valor_de_venda;
    }

    //Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor_de_custo() {
        return valor_de_custo;
    }

    public void setValor_de_custo(double valor_de_custo) {
        this.valor_de_custo = valor_de_custo;
    }

    public double getValor_de_venda() {
        return valor_de_venda;
    }

    public void setValor_de_venda(double valor_de_venda) {
        this.valor_de_venda = valor_de_venda;
    }
}
