package Control;
/**
 * Tem o objetivo de fazer a conexao entre o Model.Cliente e o package View
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Model.*;

public class ControleCliente {
    private Cliente[] c;
    private int qtdCliente;
    
    /**
     * Construtor do ControleCliente
     * @param d Dados provenientes do ControleDados
     */
    public ControleCliente(ControleDados d) {
        c = d.getCliente();
        qtdCliente = d.getQtdCliente();
    }
    /**
     * Os atributos nome do Cliente, na lista, é atribuido a uma nova String[].
     * @return String[]
     */

    public String[] getNomeCliente() {
        String[] s = new String[qtdCliente];
        for (int i = 0; i < qtdCliente; i++) {
            s[i] = c[i].getNome();
        }
        return s;
    }

    public Cliente[] getC() {
        return c;
    }

    public int getQtd() {
        return qtdCliente;
    }

    public void setQtd(int qtd) {
        this.qtdCliente = qtd;
    }

    public int getQtdCliente() {
        return qtdCliente;
    }

    public void setQtdCliente(int qtdCliente) {
        this.qtdCliente = qtdCliente;
    }

    public String getNome(int i) {
        return c[i].getNome();
    }

    public String getEndereco(int i) {
        return c[i].getEndereco();
    }

    public String getTelefone(int i) {
        return c[i].getTelefone();
    }

    public String getEmail(int i) {
        return c[i].getEmail();
    }

}
