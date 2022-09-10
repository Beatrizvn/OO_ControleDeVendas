package View;
/**
 * Janela com a lista de DadosDaVenda cadastrados e o botão de acesso ao View.CadastrarDadosDaVenda.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Control.ControleDados;
import Control.ControleVenda;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDadosDaVenda implements ActionListener, ListSelectionListener {

    private JFrame frameVenda = new JFrame();
    private JButton buttonCadastrar = new JButton("Cadastrar");
    private JButton buttonAtualizar = new JButton("Atualizar");
    private String[] listaVenda;
    private ControleDados dados;
    private JList<String> listaVendaCadastradas;

/**
 * Construtor do ViewDadosDaVenda
 * @param d Dados provenientes do ControleDados
 */
    public ViewDadosDaVenda(ControleDados d) {
        dados =d;
        //Configurando os botoes

        buttonAtualizar.setBounds(165, 300, 100, 30);
        buttonAtualizar.setBackground(new Color(59, 57, 54));
        buttonAtualizar.setForeground(new Color(178, 190, 191));
        buttonAtualizar.addActionListener(this);

        buttonCadastrar.setBounds(275, 300, 100, 30);
        buttonCadastrar.setBackground(new Color(59, 57, 54));
        buttonCadastrar.setForeground(new Color(178, 190, 191));
        buttonCadastrar.addActionListener(this);

        //Adicionando o botão
        frameVenda.add(buttonCadastrar);
        frameVenda.add(buttonAtualizar);

        //Configurações Basicas
        frameVenda.setTitle("Venda de Produtos - Dados da Venda");
        frameVenda.setSize(400, 390);
        frameVenda.getContentPane().setBackground(new Color(178, 190, 191));
        frameVenda.setResizable(false);
        frameVenda.setLayout(null);
        frameVenda.setVisible(true);

    }
    /**
     * Mostrar a lista de vendas cadastradas.
     * @param d Dados provenientes do ControleDados
     */
    
    public void mostrarDados(ControleDados d) {
        dados = d;
        listaVenda = new ControleVenda(d).getNomeClienteEProduto();
        listaVendaCadastradas = new JList<>(listaVenda);
        listaVendaCadastradas.setBounds(17, 50, 350, 170);
        listaVendaCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaVendaCadastradas.setVisibleRowCount(10);
        listaVendaCadastradas.addListSelectionListener(this);
        frameVenda.add(listaVendaCadastradas);
    }
    /**
     * Configuraçoes para as açoes ao clicar nos botoes cadastrar e atualizar
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCadastrar) {
            new CadastrarDadosDaVenda().primeiraJanela(dados);
        }
        if(e.getSource() == buttonAtualizar) {
            listaVendaCadastradas.setListData(new ControleVenda(dados).getNomeClienteEProduto());
            listaVendaCadastradas.updateUI();
            listaVendaCadastradas.setBackground(Color.WHITE); //para o fundo continuar branco
        }
    }

    /**
     * Configuraçoes para as açoes ao clicar em um item da lista
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if (e.getValueIsAdjusting() && src == listaVendaCadastradas) {
            new CadastrarDadosDaVenda().mostrarVenda(dados, listaVendaCadastradas.getSelectedIndex());
        }
    }
}

