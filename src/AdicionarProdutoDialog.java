package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarProdutoDialog extends JDialog {
    private JTextField codigoField;
    private JTextField descricaoField;
    private JTextField marcaField;
    private JTextField valorEntradaField;
    private JTextField valorUnitarioField;
    private JTextField quantidadeEstoqueField;
    private JButton adicionarButton;
    private JButton cancelarButton;

    private Estoque estoque;

    public AdicionarProdutoDialog(Frame parent, Estoque estoque) {
        super(parent, "Adicionar Produto", true);
        this.estoque = estoque;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Código:"));
        codigoField = new JTextField();
        add(codigoField);

        add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        add(descricaoField);

        add(new JLabel("Marca:"));
        marcaField = new JTextField();
        add(marcaField);

        add(new JLabel("Valor de Entrada:"));
        valorEntradaField = new JTextField();
        add(valorEntradaField);

        add(new JLabel("Valor Unitário:"));
        valorUnitarioField = new JTextField();
        add(valorUnitarioField);

        add(new JLabel("Quantidade em Estoque:"));
        quantidadeEstoqueField = new JTextField();
        add(quantidadeEstoqueField);

        adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });
        add(adicionarButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelarButton);

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void adicionarProduto() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String descricao = descricaoField.getText();
            String marca = marcaField.getText();
            double valorEntrada = Double.parseDouble(valorEntradaField.getText());
            double valorUnitario = Double.parseDouble(valorUnitarioField.getText());
            int quantidadeEstoque = Integer.parseInt(quantidadeEstoqueField.getText());

            Produto produto = new Produto(codigo, descricao, marca, valorEntrada, valorUnitario, quantidadeEstoque);
            estoque.adicionarProduto(produto);

            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}