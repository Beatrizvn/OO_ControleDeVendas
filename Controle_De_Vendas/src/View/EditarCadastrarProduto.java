package View;
/**
 * Janelas para o cadastro e edicao de Produtos
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */
import Control.ControleDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCadastrarProduto implements ActionListener {
    private boolean res;
    private JFrame janela;
    private JButton buttonExcluir = new JButton("Excluir");
    private JButton buttonSalvar = new JButton("Salvar");
    private JLabel labelProduto = new JLabel("Produto: ");
    private JTextField valorProduto = new JTextField();
    private JLabel labelCategoria = new JLabel("Categoria: ");
    private JTextField valorCategoria = new JTextField();
    private JLabel labelPrecoVenda = new JLabel("Preco de venda: ");
    private JTextField valorPrecoVenda = new JTextField();
    private JLabel labelPrecoCusto = new JLabel("Preco de custo: ");
    private JTextField valorPrecoCusto = new JTextField();
    private ControleDados dados;
    private int posicao, opcao;
    private String s;
    private String[] novoDado = new String[9];
    
    /**
     * Define se a janela a ser aberta sera para cadastro de um produto novo
     * ou para ver detalhes de um produto ja cadastrado na lista.
     * @param op 1 para cadastro de produto e 2 para ver detalhes de um produto cadastrado. 
     * @param d ControleDados Dados provenientes do ControleDados
     * @param c ViewCliente
     * @param pos Posicao do produto.
     */
    public void inserirEditar(int op, ControleDados d, ViewProdutos p, int pos) {
        opcao = op;
        posicao = pos;
        dados = d;

        janela = new JFrame();

        if (op == 1) s = "Cadastro Cliente";
        if (op == 2) s = "Detalhe Cliente";

        if (op == 1) { //produto novo
            janela.setTitle(s);

            valorPrecoVenda = new JTextField();
            valorPrecoCusto = new JTextField();
            valorProduto = new JTextField();
            valorCategoria = new JTextField();

        } else { //editar produto existente
            janela.setTitle(s);

            //preencher com os dados ja existentes
            valorPrecoVenda = new JTextField(String.valueOf(dados.getProduto()[pos].getValor_de_venda()));
            valorPrecoCusto = new JTextField(String.valueOf(dados.getProduto()[pos].getValor_de_custo()));
            valorProduto = new JTextField(dados.getProduto()[pos].getNome());
            valorCategoria = new JTextField(dados.getProduto()[pos].getCategoria());

            //adicionando o botão excluir

            buttonExcluir.setBounds(195, 160, 100, 30);
            buttonExcluir.setBackground(new Color(189, 42, 46));
            buttonExcluir.setForeground(new Color(178, 190, 191));
            this.janela.add(buttonExcluir);
        }

        //Ajustando as caixas de texto e botoes

        labelProduto.setBounds(30, 30, 100, 25);
        valorProduto.setBounds(90, 30, 160, 25);

        labelCategoria.setBounds(30, 60, 100, 25);
        valorCategoria.setBounds(90, 60, 160, 25);

        labelPrecoCusto.setBounds(30, 90, 100, 25);
        valorPrecoCusto.setBounds(125, 90, 125, 25);

        labelPrecoVenda.setBounds(30, 120, 100, 25);
        valorPrecoVenda.setBounds(125, 120, 125, 25);

        buttonSalvar.setBounds(195, 195, 100, 30);
        buttonSalvar.setBackground(new Color(59, 57, 54));
        buttonSalvar.setForeground(new Color(178, 190, 191));

        //adicionando

        janela.add(buttonSalvar);
        janela.add(labelCategoria);
        janela.add(valorCategoria);
        janela.add(labelProduto);
        janela.add(valorProduto);
        janela.add(labelPrecoCusto);
        janela.add(valorPrecoCusto);
        janela.add(labelPrecoVenda);
        janela.add(valorPrecoVenda);

        //Configurações Basicas
        janela.setSize(325, 280);
        janela.getContentPane().setBackground(new Color(178, 190, 191));
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);

        buttonSalvar.addActionListener(this);
        buttonExcluir.addActionListener(this);

    }
    
    /**
     * Configuraçoes para as açoes ao clicar nos botoes salvar e excluir
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == buttonSalvar) {
            try {
                novoDado[1] = valorProduto.getText();
                novoDado[2] = valorCategoria.getText();
                novoDado[3] = valorPrecoCusto.getText();
                novoDado[4] = valorPrecoVenda.getText();

                if(opcao == 1) { //adicionar novo produto
                    novoDado[0] = Integer.toString(dados.getQtdProduto());

                } else { // edicao de produto existente
                    novoDado[0] = Integer.toString(posicao);
                }

                res = dados.inserirEditarProdutos(novoDado);

                if (res) {
                    mensagemSucessoCadastro();
                } else {
                    mensagemErroCadastro();
                }

            } catch (NullPointerException exc1) {
                mensagemErroCadastro();
            } catch (NumberFormatException exc2) {
                mensagemErroCadastro();
            }
        }

        //Excluir Produto
        if (src == buttonExcluir) {
            res = false;
            res = dados.removerProduto(posicao);
            if (res) mensagemSucessoExcluir();
            else mensagemErroExcluir();
        }
    }

        
    /**
     * Mensagem para sucesso em salvar os dados.
     */
    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso.", null, JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }
    /**
     * Mensagem para erro ao salvar os dados.
     */

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null, "Erro ao salvar os dados.", null, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Mensagem para sucesso em excluir.
     */

    public void mensagemSucessoExcluir() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso.", null, JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }
    /**
     * Mensagem para erro ao excluir.
     */

    public void mensagemErroExcluir() {
        JOptionPane.showMessageDialog(null, "Erro ao excluir os dados.", null, JOptionPane.INFORMATION_MESSAGE);
    }

}
