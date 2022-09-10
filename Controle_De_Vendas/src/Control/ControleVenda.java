package Control;
/**
 * Tem o objetivo de fazer a conexao entre o Model.DadosDaVenda e o package View
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Model.DadosDaVenda;

public class ControleVenda {
    private DadosDaVenda[] dv;
    private int qtdDv;

    /**
     * Construtor do ControleVenda
     * @param d Dados provenientes do ControleDados
     */
    public ControleVenda(ControleDados d) {
        dv = d.getDv();
        qtdDv = d.getQtdDv();
    }
    
    /**
     * Os atributos nome do Cliente e o nome do ProdutoVendido em 
     * DadosDaVenda, da lista, é atribuido a uma nova String[].
     * @return String[]
     */
    public String[] getNomeClienteEProduto() {
        String[] s = new String[qtdDv];
        for (int i = 0; i < qtdDv; i++) {
            s[i] = dv[i].getCliente().getNome() + " + " + dv[i].getProdutoVendido().getProduto().getNome();
        }
        return s;
    }
}

