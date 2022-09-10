package View;
/**
 * Janelas para o cadastro de DadosDaVenda e a visualizacao deles
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */
import Model.*;
import Control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDadosDaVenda implements ActionListener {
    private ControleDados d;
    private ProdutoVendido pv;
    private Parcelado pg2;
    private Avista pg1;
    private boolean verificar, res;
    private int n, n2, opcao, pos;
    private JFrame tela1, tela2, janelaMostrar;
    private JButton proxima = new JButton("Proxima");
    private JButton proxima2 = new JButton("Proxima");
    private Cliente[] listaC;
    private Produto[] listaP;
    private String[] listaNomes = new String[50];
    private String[] listaProdutos = new String[50];
    private JComboBox<String> boxCliente, boxProduto, boxPagamento;
    private JLabel labelParcelas = new JLabel("Qtd Parcelas: ");
    private JTextField valorParcelas = new JTextField();
    private JLabel labelJuros = new JLabel("Juros: ");
    private JTextField valorJuros = new JTextField();
    private JLabel labelDesconto = new JLabel("Desconto: ");
    private JTextField valorDesconto = new JTextField();
    private JLabel labelQtd = new JLabel("Qtd: ");
    private JTextField valorQtd = new JTextField();
    private JLabel labelNome,labeltitulo, labelEndereco, labelTelefone, labelEmail, labelProduto, labelValor, labelQtdProd,
            labelPagamento, labelQtdParcelas, labelDesconto2, labelJuros2, labelValorParcelas, labelValorFinal;

    /**
     * Janela onde e possivel ver a lista de DadosDeVenda e onde há o botão para iniciar o cadastro de
     * um novo DadosDeVenda à ser inserido na lista.
     * @param dados Dados provenientes do ControleDados
     */
    public void primeiraJanela(ControleDados dados) {
        tela1 = new JFrame();

        d = dados;
        
        //Configurações de caixas

        //clientes
        listaC = new ControleCliente(d).getC();
        listaNomes = new ControleCliente(d).getNomeCliente();
        boxCliente = new JComboBox<String>(listaNomes);
        boxCliente.setBounds(20, 10, 100, 20);

        //produtos
        listaP = new ControleProdutos(d).getP();
        listaProdutos = new ControleProdutos(d).NomeProduto();
        boxProduto = new JComboBox<String>(listaProdutos);
        boxProduto.setBounds(20, 35, 100, 20);

        labelQtd.setBounds(130, 35, 50, 20);
        valorQtd.setBounds(155, 35, 20, 20);

        //pagamento
        String s[] = {"Parcelado", "A vista"};
        boxPagamento = new JComboBox<String>(s);
        boxPagamento.setBounds(20, 60, 100, 20);

        //Configurando botão
        proxima.setBounds(165, 85, 100, 30);
        proxima.setBackground(new Color(59, 57, 54));
        proxima.setForeground(new Color(178, 190, 191));
        proxima.addActionListener(this);

        //Adicionando
        tela1.add(proxima);
        tela1.add(boxCliente);
        tela1.add(boxProduto);
        tela1.add(boxPagamento);
        tela1.add(valorQtd);
        tela1.add(labelQtd);

        //Configurações Basicas
        tela1.setTitle("Produto e Cliente");
        tela1.setSize(300, 165);
        tela1.getContentPane().setBackground(new Color(178, 190, 191));
        tela1.setLayout(null);
        tela1.setVisible(true);
        tela1.setLocationRelativeTo(null);

    }
    /**
     * Janela onde sera selecionado o produto vendido, a 
     * quantidade desse produto e o cliente que realizou a compra.
     */

    private void segundaJanela() {

        tela1.dispose();

        tela2 = new JFrame();

        //Config layout
        proxima2.setBounds(175, 100, 100, 30);
        proxima2.setBackground(new Color(59, 57, 54));
        proxima2.setForeground(new Color(178, 190, 191));
        proxima2.addActionListener(this);
        tela2.add(proxima2);

        tela2.setTitle("Pagamento");
        tela2.setSize(300, 180);
        tela2.getContentPane().setBackground(new Color(178, 190, 191));
        tela2.setLayout(null);
        tela2.setVisible(true);
        tela2.setLocationRelativeTo(null);

        //Verificando se e a vista ou parcelado
        if (boxPagamento.getSelectedIndex() == 1) { // A vista

            labelDesconto.setBounds(30, 30, 100, 25);
            valorDesconto.setBounds(102, 30, 100, 25);

            tela2.add(labelDesconto);
            tela2.add(valorDesconto);

        } else { //Parcelado

            labelParcelas.setBounds(30, 30, 100, 25);
            valorParcelas.setBounds(105, 30, 100, 25);

            labelJuros.setBounds(30, 60, 100, 25);
            valorJuros.setBounds(105, 60, 100, 25);

            tela2.add(labelParcelas);
            tela2.add(valorParcelas);
            tela2.add(labelJuros);
            tela2.add(valorJuros);
        }
    }
    
    /**
     * Gera um novo DadosDaVenda e insere ele na lista.
     * @param dados Dados provenientes do ControleDados
     */
    public void criaVenda(ControleDados dados) {
        tela2.dispose();

        n = boxProduto.getSelectedIndex();
        n2 = boxCliente.getSelectedIndex();
        
        try {
            if (boxPagamento.getSelectedIndex() == 1) { // A vista
                opcao = 1;

                pv = new ProdutoVendido(listaP[n]);

                String qtd = valorQtd.getText();
                verificar = dados.checarSeENumero(qtd);
                if (verificar) {
                    pv.cadastrarMaisProduto(Integer.parseInt(valorQtd.getText()));
                }

                pg1 = new Avista(pv, true, Integer.parseInt(valorDesconto.getText()));

                pos = (dados.getQtdDv());
                res = dados.inserirDadosDeVenda(listaC[n2], pv, pg1, pos);

            } else { //Parcelado
                opcao = 2;

                pv = new ProdutoVendido(listaP[n]);

                String qtd = valorQtd.getText();
                verificar = dados.checarSeENumero(qtd);
                if (verificar) {
                    pv.cadastrarMaisProduto(Integer.parseInt(valorQtd.getText()));
                }

                pg2 = new Parcelado(pv, true, Integer.parseInt(valorParcelas.getText()),
                        Integer.parseInt(valorJuros.getText()));
               

                pos = (dados.getQtdDv());
                res = dados.inserirDadosDeVenda(listaC[n2], pv, pg2, pos);

            }
            if (res) {
                mensagemSucessoCadastro();
            }
        } catch (NullPointerException exc1) {
            mensagemErroCadastro();
        } catch (NumberFormatException exc2) {
            mensagemErroCadastro();
        }
    }
    /**
     * Janela onde será mostrado todos os dados da venda selecionada.
     * @param dados Dados provenientes do ControleDados
     * @param pos Posição da venda selecionada.
     */
    public void mostrarVenda(ControleDados dados, int pos) {

        janelaMostrar = new JFrame();
        d = dados;

        if (d.getDv()[pos].getPagamentoP() == null) {
            opcao = 1;
        } else {
            opcao = 2;
        }

        if (opcao == 1) {
            labelPagamento = new JLabel("A Vista");
            labelDesconto2 = new JLabel("Desconto: " + d.getDv()[pos].getPagamento().getDesconto());
            labelValorFinal = new JLabel("Valor Final: " + d.getDv()[pos].getPagamento().getValorFinal());

            janelaMostrar.add(labelPagamento);
            janelaMostrar.add(labelDesconto2);
            janelaMostrar.add(labelValorFinal);

            labelDesconto2.setBounds(30, 125, 150, 25);
            labelValorFinal.setBounds(30, 135, 150, 25);

        } else {
            labelPagamento = new JLabel("Parcelado");
            labelValorFinal = new JLabel("Valor final: " + d.getDv()[pos].getPagamentoP().getValor_apos_juros());
            labelJuros2 = new JLabel("Juros: " + d.getDv()[pos].getPagamentoP().getJuros());
            labelQtdParcelas = new JLabel("Qtd de Parcelas: " + d.getDv()[pos].getPagamentoP().getQtd_de_parcelas());
            labelValorParcelas = new JLabel("Valor das Parcelas: " + d.getDv()[pos].getPagamentoP().getValor_parcelas());

            janelaMostrar.add(labelPagamento);
            janelaMostrar.add(labelValorFinal);
            janelaMostrar.add(labelJuros2);
            janelaMostrar.add(labelQtdParcelas);
            janelaMostrar.add(labelValorParcelas);

            labelValorFinal.setBounds(30, 125, 150, 25);
            labelJuros2.setBounds(30, 135, 150, 25);
            labelQtdParcelas.setBounds(30, 145, 150, 25);
            labelValorParcelas.setBounds(30, 155, 250, 25);

        }

        //Configurações das Jlabel
        
        labeltitulo = new JLabel("Dados da Venda");
        labeltitulo.setBounds(30,10,200,40);
        labeltitulo.setFont(new Font("Serif", Font.BOLD, 16));

        labelNome = new JLabel(d.getDv()[pos].getCliente().getNome());
        labelTelefone = new JLabel(d.getDv()[pos].getCliente().getTelefone());
        labelEndereco = new JLabel(d.getDv()[pos].getCliente().getEndereco());
        labelEmail = new JLabel(d.getDv()[pos].getCliente().getEmail());
        labelProduto = new JLabel(d.getDv()[pos].getProdutoVendido().getProduto().getNome());
        labelValor = new JLabel("Valor: " + (d.getDv()[pos].getProdutoVendido().getProduto().getValor_de_venda()));
        labelQtdProd = new JLabel("Quantidade: " + d.getDv()[pos].getProdutoVendido().getQtd());

        labelNome.setBounds(30, 35, 150, 25);
        labelTelefone.setBounds(30, 45, 150, 25);
        labelEndereco.setBounds(30, 55, 150, 25);
        labelEmail.setBounds(30, 65, 150, 25);
        labelProduto.setBounds(30, 85, 150, 25);
        labelValor.setBounds(30, 95, 150, 25);
        labelPagamento.setBounds(30, 115, 150, 25);
        labelQtdProd.setBounds(105, 85, 200, 25);

        //Configurações Basicas
        
        janelaMostrar.add(labeltitulo);
        janelaMostrar.add(labelTelefone);
        janelaMostrar.add(labelEndereco);
        janelaMostrar.add(labelEmail);
        janelaMostrar.add(labelNome);
        janelaMostrar.add(labelProduto);
        janelaMostrar.add(labelValor);
        janelaMostrar.add(labelQtdProd);

        janelaMostrar.setSize(280, 280);
        janelaMostrar.setTitle("Dados da Venda");
        janelaMostrar.getContentPane().setBackground(new Color(178, 190, 191));
        janelaMostrar.setLayout(null);
        janelaMostrar.setVisible(true);
        janelaMostrar.setLocationRelativeTo(null);
    }
    /**
     * Configuraçoes para as açoes ao clicar nos botoes proxima e proxima2
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == proxima) {
            segundaJanela();
        }
        if (src == proxima2) {
            criaVenda(d);
        }
    }
    /**
     * Mensagem para quando o cadastro for um sucesso.
     */
    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso.", null, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Mensagem para quando der algum erro no cadastro.
     */

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null, "Erro ao salvar os dados.", null, JOptionPane.INFORMATION_MESSAGE);
    }
}

