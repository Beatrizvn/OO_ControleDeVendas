package View;
/**
 * Janelas para o cadastro e edicao de Clientes
 * @author Beatriz Vieira e Isabelle Costa
 * @since 2022
 * @version 1.0 
 */

import Control.ControleDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EditarCadastrarCliente implements ActionListener {
    private boolean res;
    private JFrame janela = new JFrame();
    private JButton buttonSalvar = new JButton("Salvar");
    private JButton buttonExcluir = new JButton("Excluir");
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField valorNome = new JTextField();
    private JLabel labelTelefone = new JLabel("Telefone: ");
    private JTextField valorTelefone = new JTextField();
    private JLabel labelEndereco = new JLabel("Endereco: ");
    private JTextField valorEndereco = new JTextField();
    private JLabel labelEmail = new JLabel("Email: ");
    private JTextField valorEmail = new JTextField();
    private int posicao, opcao;
    private String s;
    private static ControleDados dados;
    private String[] novoDado = new String[9];
    
    /**
     * Define se a janela a ser aberta sera para cadastro de um cliente novo
     * ou para ver detalhes de um cliente ja cadastrado na lista.
     * @param op 1 para cadastro de cliente e 2 para ver detalhes de um cliente cadastrado. 
     * @param d Dados provenientes do ControleDados
     * @param c ViewCliente.
     * @param pos Posicao do cliente.
     */

    public void inserirEditar(int op, ControleDados d, ViewCliente c, int pos) {
        opcao = op;
        posicao = pos;
        dados = d;

        janela = new JFrame();

        if (op == 1) s = "Cadastro Cliente";
        if (op == 2) s = "Detalhe Cliente";

        if (op == 1) { //cliente novo
            janela.setTitle(s);

            valorEndereco = new JTextField();
            valorTelefone = new JTextField();
            valorEmail = new JTextField();
            valorNome = new JTextField();

        } else { //cliente existente
            janela.setTitle(s);

            //preencher com os dados ja existentes
            valorEndereco = new JTextField(dados.getCliente()[pos].getEndereco());
            valorTelefone = new JTextField(dados.getCliente()[pos].getTelefone());
            valorEmail = new JTextField(dados.getCliente()[pos].getEmail());
            valorNome = new JTextField(dados.getCliente()[pos].getNome());

            //adicionando o botão excluir

            buttonExcluir.setBounds(195, 160, 100, 30);
            buttonExcluir.setBackground(new Color(189, 42, 46));
            buttonExcluir.setForeground(new Color(178, 190, 191));
            this.janela.add(buttonExcluir);
        }

        //Ajustando as caixas de texto e botoes
        labelNome.setBounds(30, 30, 100, 25);
        valorNome.setBounds(90, 30, 205, 25);

        labelTelefone.setBounds(30, 60, 100, 25);
        valorTelefone.setBounds(90, 60, 205, 25);

        labelEmail.setBounds(30, 90, 100, 25);
        valorEmail.setBounds(90, 90, 205, 25);

        labelEndereco.setBounds(30, 120, 100, 25);
        valorEndereco.setBounds(90, 120, 205, 25);

        buttonSalvar.setBounds(195, 195, 100, 30);
        buttonSalvar.setBackground(new Color(59, 57, 54));
        buttonSalvar.setForeground(new Color(178, 190, 191));

        //Adicionando
        janela.add(buttonSalvar);
        janela.add(labelNome);
        janela.add(valorNome);
        janela.add(valorEmail);
        janela.add(labelEmail);
        janela.add(valorEndereco);
        janela.add(labelEndereco);
        janela.add(labelTelefone);
        janela.add(valorTelefone);

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
                novoDado[1] = valorNome.getText();
                novoDado[2] = valorEndereco.getText();
                novoDado[4] = valorEmail.getText();
                novoDado[3] = valorTelefone.getText();

                if(opcao == 1) { //adicionar novo cliente
                    novoDado[0] = Integer.toString(dados.getQtdCliente());

                } else { // edicao de cliente existente
                    novoDado[0] = Integer.toString(posicao);
                }

                res = dados.inserirEditarCliente(novoDado);

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

        //Excluir cliente
        if (src == buttonExcluir) {
            res = false;
            res = dados.removerCliente(posicao);
            if (res) mensagemSucessoExcluir();
            else mensagemErroExcluir();
        }
    }

    /**
     * Mensagem para sucesso de cadastro.
     */
    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso.", null, JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }
    /**
     * Mensagem para erro de cadastro.
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
     * Mensagem para erro em excluir.
     */

    public void mensagemErroExcluir() {
        JOptionPane.showMessageDialog(null, "Erro ao excluir os dados.", null, JOptionPane.INFORMATION_MESSAGE);
    }

}
