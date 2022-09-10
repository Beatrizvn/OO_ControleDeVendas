package Control;
/**
 * Tem o objetivo de fazer a conexao entre o package Model e o package View
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Model.*;

public class ControleDados {
    private Dados d = new Dados();
    
    /**
     * Construtor do ControleDados
     */
    
    public ControleDados() {
        d.colocarAlgunsDados();
    }
    
    /**
     * Inserir ou editar Dados de Venda a lista.
     * @param c Cliente da Venda.
     * @param prod Produto vendido.
     * @param pag Forma de Pagamento a Vista.
     * @param pos posicao na lista.
     * @return boolean
     */
    public boolean inserirDadosDeVenda(Cliente c, ProdutoVendido prod, Avista pag, int pos) {
        DadosDaVenda dv = new DadosDaVenda(c,prod,pag);
        System.out.println(dv.getPagamento().getValorFinal());
        d.inserirDadosVenda(dv,pos);
        return true;
    }
    /**
     * Inserir ou editar Dados de Venda a lista. Sobrecarga do metodo inserirDadosDeVenda.
     * @param c Cliente da Venda.
     * @param prod Produto vendido.
     * @param pag Forma de Pagamento Parcelado.
     * @param pos posicao na lista.
     * @return boolean
     */
    public boolean inserirDadosDeVenda(Cliente c, ProdutoVendido prod, Parcelado pag, int pos) {
        DadosDaVenda dv = new DadosDaVenda(c,prod,pag);
        d.inserirDadosVenda(dv,pos);
        return true;
    }

    /**
     * Inserir ou editar Cliente a lista.
     * @param dadosCliente Novas informações a serem inseridas.
     * @return boolean
     */
    
    
    public boolean inserirEditarCliente(String[] dadosCliente) {
        Cliente c = new Cliente(dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
        d.inserirEditarCliente(c, Integer.parseInt(dadosCliente[0]));
        return true;
    }

    /**
     * Remover Cliente da lista.
     * @param i posicao na lista do Cliente a ser removido.
     * @return boolean
     */

    public boolean removerCliente(int i) {
        String clienteRemov = d.getCliente()[i].getNome();

        if (i == (d.getQtdCliente() - 1)) { //remover cliente que esta no final da lista
            d.setQtdCliente(d.getQtdCliente() - 1);
            d.getCliente()[d.getQtdCliente()] = null;
        } else { //remover cliente no meio da lista
            int cont = 0;
            while (d.getCliente()[cont].getNome().compareTo(clienteRemov) != 0) {
                cont++;
            }

            //rotina swap -> trocar valores de duas variaveis do mesmo tipo
            for (int j = cont; j < d.getQtdCliente() - 1; j++) {
                d.getCliente()[j] = null;
                d.getCliente()[j] = d.getCliente()[j + 1];
            }
            d.getCliente()[d.getQtdCliente()] = null;
            d.setQtdCliente(d.getQtdCliente() - 1);
        }
        return true;
    }

    /**
     * Inserir ou editar Produto a lista.
     * @param dadosProduto  Novas informações a serem inseridas.
     * @return boolean
     */
    public boolean inserirEditarProdutos(String[] dadosProduto) {
        Produto p = new Produto(dadosProduto[1], dadosProduto[2],
                Double.parseDouble(dadosProduto[3]), Double.parseDouble(dadosProduto[4]));
        d.inserirEditarProdutos(p, Integer.parseInt(dadosProduto[0]));
        return true;
    }
    /**
     * Remover Produto da lista.
     * @param i posicao na lista do Produto a ser removido.
     * @return boolean
     */

    public boolean removerProduto(int i) {
        String ProdutoRemov= d.getProdutos()[i].getNome();

        if (i == (d.getQtdProdutos() - 1)) { //remover produto que esta no final da lista
            d.setQtdProdutos(d.getQtdProdutos() - 1);
            d.getProdutos()[d.getQtdProdutos()] = null;
        } else { //remover produto no meio da lista
            int cont = 0;
            while (d.getProdutos()[cont].getNome().compareTo(ProdutoRemov) != 0) {
                cont++;
            }

            //rotina swap -> trocar valores de duas variaveis do mesmo tipo
            for (int j = cont; j < d.getQtdProdutos() - 1; j++) {
                d.getProdutos()[j] = null;
                d.getProdutos()[j] = d.getProdutos()[j + 1];
            }
            d.getProdutos()[d.getQtdProdutos()] = null;
            d.setQtdProdutos(d.getQtdProdutos() - 1);
        }
        return true;
    }
    /**
     * Confere se uma String contem apenas números.
     * @param s String a ser verificada.
     * @return boolean
     */

    public boolean checarSeENumero(String s){
        if(s.matches("[0-9]+")) {
            return true;
        } else return false;
    }

    //Getters e Setters
    public Cliente[] getCliente() {
        return this.d.getCliente();
    }

    public int getQtdCliente() {
        return this.d.getQtdCliente();
    }

    public Produto[] getProduto() {
        return this.d.getProdutos();
    }
    public int getQtdProduto(){
        return this.d.getQtdProdutos();
    }

    public Dados getDados() {
        return d;
    }

    public DadosDaVenda[] getDv() {
        return this.d.getDv();
    }

    public int getQtdDv() {
        return this.d.getQtdDv();
    }


}
