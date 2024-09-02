package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VenderProdutoDialog extends JDialog {
    private JTextField codigoField;
    private JTextField quantidadeField;
    private JButton venderButton;
    private JButton cancelarButton;

    private Estoque estoque;

    public VenderProdutoDialog(Frame parent, Estoque estoque) {
        super(parent, "Vender Produto", true);
        this.estoque = estoque;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Código do Produto:"));
        codigoField = new JTextField();
        add(codigoField);

        add(new JLabel("Quantidade a Vender:"));
        quantidadeField = new JTextField();
        add(quantidadeField);

        venderButton = new JButton("Vender");
        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderProduto();
            }
        });
        add(venderButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelarButton);

        setSize(400, 150);
        setLocationRelativeTo(null);
    }

    private void venderProduto() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            int quantidade = Integer.parseInt(quantidadeField.getText());

            estoque.venderProduto(codigo, quantidade);

            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}