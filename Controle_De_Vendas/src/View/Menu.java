package View;
/**
 * Janela com as opções de frames disponiveis ao usuário
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Control.ControleDados;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Menu implements ActionListener {
    private static JFrame menu = new JFrame();
    private static JButton cliente = new JButton("Cliente");
    private static JButton produtos = new JButton("Produtos");
    private static JButton dadosDaVenda = new JButton("DadosDaVenda");
    private static ControleDados dados = new ControleDados();
    
    /**
     * Construtor do Menu
     */
    
    public Menu() {

        //Configurando aparencia dos botoes

        cliente.setBounds(75, 75, 140, 30);
        cliente.setBackground(new Color(59, 57, 54));
        cliente.setForeground(new Color(178, 190, 191));
        cliente.addActionListener(this);

        produtos.setBounds(75, 115, 140, 30);
        produtos.setBackground(new Color(59, 57, 54));
        produtos.setForeground(new Color(178, 190, 191));
        produtos.addActionListener(this);

        dadosDaVenda.setBounds(75, 155, 140, 30);
        dadosDaVenda.setBackground(new Color(59, 57, 54));
        dadosDaVenda.setForeground(new Color(178, 190, 191));
        dadosDaVenda.addActionListener(this);

        //Adicionando os botoes no menu

        menu.add(cliente);
        menu.add(produtos);
        menu.add(dadosDaVenda);

        //Configuracoes basicas

        menu.setTitle("Venda de Produtos - Menu");
        menu.setSize(300, 300);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.getContentPane().setBackground(new Color(178, 190, 191));
        menu.setResizable(false);
        menu.setLayout(null);
        menu.setVisible(true);

    }
    /**
     * Configuraçoes para as açoes ao clicar nos botoes cliente, produtos e dadosDaVenda
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cliente) {
            new ViewCliente().mostrarDados(dados);
        }
        if (e.getSource() == dadosDaVenda) {
            new ViewDadosDaVenda(dados).mostrarDados(dados);
        }
        if (e.getSource() == produtos) {
            new ViewProdutos().mostrarDados(dados);
        }
    }

    //Main
    public static void main(String[] args) {
    	
        new Menu();

    }

}
