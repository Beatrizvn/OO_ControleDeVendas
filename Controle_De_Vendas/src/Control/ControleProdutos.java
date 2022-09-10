package Control;
/**
 * Tem o objetivo de fazer a conexao entre o Model.Produto e o package View
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Model.*;

public class ControleProdutos {
    private Produto[] p;
    private int qtdProdutos;
    
    /**
     * Construtor do ControleProdutos
     * @param d Dados provenientes do ControleDados
     */
    public ControleProdutos(ControleDados d) {
        p = d.getProduto();
        qtdProdutos = d.getQtdProduto();
    }
    
    /**
     * Os atributos nome do Produto, da lista, é atribuido a uma nova String[].
     * @return String[]
     */
    public String[] NomeProduto() {
        String[] s = new String[qtdProdutos];
        for (int i = 0; i < qtdProdutos; i++) {
            s[i] = p[i].getNome();
        }
        return s;
    }

    public Produto[] getP() {
        return p;
    }

    public void setP(Produto[] p) {
        this.p = p;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }
}
