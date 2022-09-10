package Model;

/**
 * Classe Dados gera dados aleatorios das classes: Cliente, Produto, Avista,ProdutoVendido e
 * DadosDaVenda e insere eles em uma lista.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * 
 */

public class Dados {
    private Cliente[] cliente = new Cliente[50];
    private int qtdCliente = 0;
    private Produto[] produto = new Produto[50];
    private int qtdProdutos = 0;
    private Avista[] pag = new Avista[50];
    private int qtdPag = 0;
    private DadosDaVenda[] dv = new DadosDaVenda[50];
    private  int qtdDv =0;
    private ProdutoVendido[] pv = new ProdutoVendido[50];

    
	/**
	 * Gera dados aleatorios para as classes: Cliente, Produto, Avista, ProdutoVendido e DadosDaVenda.
	 * Criando uma list dos mesmos.
	 */
    
    public void colocarAlgunsDados() { //criando dados aleatorios

        for (int i = 0; i < 5; i++) {
            cliente[i] = new Cliente("Cliente" + i, "Endereco" + i, "619999-999" + i, "email" + i);
            produto[i] = new Produto("Produto"+i,"Categoria" + i, 50*i+50,100*i+50);
        }
        qtdCliente = 5;
        qtdProdutos = 5;

        for(int i = 0; i < 2; i++) {
            pv[i] = new ProdutoVendido(produto[i]);
        }

        for(int i = 0; i < 2; i++) {
            pag[i] = new Avista(pv[i],true,10);
            dv[i] = new DadosDaVenda(cliente[i],pv[i],pag[i]);
        }
        qtdPag = 2;
        qtdDv = 2;
    }
    /**
     * Inserir DadosDaVenda na lista.
     * @param ddv DadosDaVenda.
     * @param pos posicao dos DadosDaVenda
     */
    
    public void inserirDadosVenda(DadosDaVenda ddv, int pos) {
        this.dv[pos] = ddv;
        if (pos == qtdDv) qtdDv++;
    }
    /**
     * Inserir ou Editar Produto na posicao da lista.
     * @param p Produto a ser inserido ou editado.
     * @param pos Posicao do produto.
     */
    public void inserirEditarProdutos (Produto p, int pos) {
        this.produto[pos] = p;
        if (pos == qtdProdutos) qtdProdutos++;
    }
    /**
     * Inserir ou Editar Cliente na posicao da lista.
     * @param c Cliente a ser inserido ou editado.
     * @param pos Posicao do cliente.
     */
    public void inserirEditarCliente(Cliente c, int pos) {
        this.cliente[pos] = c;
        if (pos == qtdCliente) qtdCliente++;
    }

    //Getters e Setters
    public int getQtdDv() {
        return qtdDv;
    }

    public DadosDaVenda[] getDv() {
        return dv;
    }

    public void setDv(DadosDaVenda[] dv) {
        this.dv = dv;
    }
    public Cliente[] getCliente() {
        return cliente;
    }

    public void setCliente(Cliente[] cliente) {
        this.cliente = cliente;
    }

    public int getQtdCliente() {
        return qtdCliente;
    }

    public void setQtdCliente(int qtdCliente) {
        this.qtdCliente = qtdCliente;
    }

    public Produto[] getProdutos() {
        return produto;
    }

    public void setProduto(Produto[] produtos) {
        this.produto = produtos;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public Avista[] getPag() {
        return pag;
    }

    public void setPag(Avista[] pag) {
        this.pag = pag;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }

    public DadosDaVenda[] getdv() {
        return dv;
    }

    public void setdv(DadosDaVenda[] dv) {
        this.dv = dv;
    }
}
