package View;
/**
 * Janela com a lista de clientes cadastrados e o botão de acesso ao View.EditarCadastrarCliente.
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Control.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class ViewCliente implements ActionListener, ListSelectionListener {
    private JFrame frameCliente = new JFrame();
    private JButton buttonCadastrar = new JButton("Cadastrar");
    private JButton buttonAtualizar = new JButton("Atualizar");
    private JList<String> listaClientesCadastrados;
    private ControleDados dados;
    private String[] listaNomes = new String[50];
    
    /**
     * Contrutor do ViewCliente
     */
    public ViewCliente() {

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
        frameCliente.add(buttonCadastrar);
        frameCliente.add(buttonAtualizar);

        //Configurações Basicas
        frameCliente.setTitle("Venda de Produtos - Cliente");
        frameCliente.setSize(400, 390);
        frameCliente.getContentPane().setBackground(new Color(178, 190, 191));
        frameCliente.setLayout(null);
        frameCliente.setVisible(true);

    }

    /**
     * Mostrar a lista de clientes cadastrados.
     * @param d ControleDados.
     */
    public void mostrarDados(ControleDados d) {
        dados = d;
        listaNomes = new ControleCliente(dados).getNomeCliente();
        listaClientesCadastrados = new JList<>(listaNomes);
        listaClientesCadastrados.setBounds(17, 50, 350, 170);
        listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaClientesCadastrados.setVisibleRowCount(10);
        listaClientesCadastrados.addListSelectionListener(this);
        frameCliente.add(listaClientesCadastrados);

    }
    
    /**
     * Configuraçoes para as açoes ao clicar nos botoes cadastrar e atualizar
     */
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCadastrar) {
            new EditarCadastrarCliente().inserirEditar(1, dados, this, 0);
        }
        if (e.getSource() == buttonAtualizar) {
            listaClientesCadastrados.setListData(new ControleCliente(dados).getNomeCliente());
            listaClientesCadastrados.updateUI();
            listaClientesCadastrados.setBackground(Color.WHITE); //para o fundo continuar branco
        }
    }
        
        /**
         * Configuraçoes para as açoes ao clicar em um dos clientes da lista
         */
        public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if (e.getValueIsAdjusting() && src == listaClientesCadastrados) {
            new EditarCadastrarCliente().inserirEditar(2, dados, this,
                    listaClientesCadastrados.getSelectedIndex());
        }
    }
}

