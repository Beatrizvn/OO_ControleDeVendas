package View;
/**
 * Janela com a lista de produtos cadastrados e o botão de acesso ao View.EditarCadastrarProduto.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Control.ControleDados;
import Control.ControleProdutos;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ViewProdutos implements ActionListener, ListSelectionListener {
    private JFrame frameProdutos = new JFrame();
    private JButton buttonCadastrar = new JButton("Cadastrar");
    private JButton buttonAtualizar = new JButton("Atualizar");
    private JButton buttonPesquisar = new JButton("Pesquisar");
    private JButton buttonPesquisar2 = new JButton("Pesquisar");
    private JList<String> listaDeProdutosCadastrados;
    private ControleDados dados;
    private String[] listaProdutos = new String[50];
    private JTextField valorPesquisa = new JTextField();
    private JFrame janelaPesquisa = new JFrame();

    /**
     * Contrutor do ViewProdutos
     */
    public ViewProdutos() {

        //Configurando os botoes

        buttonAtualizar.setBounds(170, 345, 100, 30);
        buttonAtualizar.setBackground(new Color(59, 57, 54));
        buttonAtualizar.setForeground(new Color(178, 190, 191));
        buttonAtualizar.addActionListener(this);

        buttonCadastrar.setBounds(280, 345, 100, 30);
        buttonCadastrar.setBackground(new Color(59, 57, 54));
        buttonCadastrar.setForeground(new Color(178, 190, 191));
        buttonCadastrar.addActionListener(this);

        buttonPesquisar.setBounds(60, 345, 100, 30);
        buttonPesquisar.setBackground(new Color(59, 57, 54));
        buttonPesquisar.setForeground(new Color(178, 190, 191));
        buttonPesquisar.addActionListener(this);

        //Adicionando
        frameProdutos.add(buttonAtualizar);
        frameProdutos.add(buttonCadastrar);
        frameProdutos.add(buttonPesquisar);

        //Configurações Basicas
        frameProdutos.setTitle("Produtos");
        frameProdutos.setSize(430, 430);
        frameProdutos.getContentPane().setBackground(new Color(178, 190, 191));
        frameProdutos.setResizable(false);
        frameProdutos.setLayout(null);
        frameProdutos.setVisible(true);

    }
    /**
     * Mostrar a lista de produtos cadastrados.
     * @param d Dados provenientes do ControleDados
     */
    public void mostrarDados(ControleDados d) {
        dados = d;
        listaProdutos = new ControleProdutos(dados).NomeProduto();
        listaDeProdutosCadastrados = new JList<>(listaProdutos);
        listaDeProdutosCadastrados.setBounds(17, 50, 350, 170);
        listaDeProdutosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaDeProdutosCadastrados.setVisibleRowCount(10);
        listaDeProdutosCadastrados.addListSelectionListener(this);
        frameProdutos.add(listaDeProdutosCadastrados);

    }
    /**
     * Configurações de layout da janela de pesquisar produtos.
     */
    public void pesquisarProdutoJanela() {

        valorPesquisa.setBounds(50, 40, 140, 25);

        buttonPesquisar2.setBounds(73, 90, 100, 30);
        buttonPesquisar2.setBackground(new Color(59, 57, 54));
        buttonPesquisar2.setForeground(new Color(178, 190, 191));
        buttonPesquisar2.addActionListener(this);

        janelaPesquisa.add(valorPesquisa);
        janelaPesquisa.add(buttonPesquisar2);
        janelaPesquisa.setLocationRelativeTo(null);

        janelaPesquisa.setTitle("Pesquisar");
        janelaPesquisa.setSize(250, 190);
        janelaPesquisa.getContentPane().setBackground(new Color(178, 190, 191));
        janelaPesquisa.setResizable(false);
        janelaPesquisa.setLayout(null);
        janelaPesquisa.setVisible(true);
}
    /**
     * Pesquisar um produto dentro da lista.
     * @param d Dados provenientes do ControleDados
     */
	public void pesquisarProduto(ControleDados d){
	    dados = d;
	    listaProdutos = new ControleProdutos(dados).NomeProduto();
	    int n;
	    String pes = valorPesquisa.getText();
	    try {
	        for(int i = 0; i < listaProdutos.length; i ++){
	            if(listaProdutos[i].equals(pes)){
	                n = i;
	                new EditarCadastrarProduto().inserirEditar(2, dados, this,
	                        n);
	                janelaPesquisa.dispose();
	            }
	        }
	    } catch (NullPointerException exc1) {
	        mensagemErro();}
	}

	/**
	 * Configuraçoes para as açoes ao clicar nos botoes cadastrar,atualizar,pesquisar	
	 */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonCadastrar) {
            new EditarCadastrarProduto().inserirEditar(1, dados, this, 0);
        }
        if (e.getSource() == buttonAtualizar) {
            listaDeProdutosCadastrados.setListData(new ControleProdutos(dados).NomeProduto());
            listaDeProdutosCadastrados.updateUI();
            listaDeProdutosCadastrados.setBackground(Color.WHITE); //para o fundo continuar branco
        }
        if (e.getSource() == buttonPesquisar){
            pesquisarProdutoJanela();
        }
        if(e.getSource() == buttonPesquisar2){
            pesquisarProduto(dados);
        }
    }

    /**
     * Configuraçoes para as açoes ao clicar em um dos clientes da lista
     */
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if (e.getValueIsAdjusting() && src == listaDeProdutosCadastrados) {
            new EditarCadastrarProduto().inserirEditar(2, dados, this,
                    listaDeProdutosCadastrados.getSelectedIndex());
        }
    }

    public void mensagemErro(){
        JOptionPane.showMessageDialog(null, "Erro ao encontrar os dados.", null, JOptionPane.INFORMATION_MESSAGE);
    }
}
