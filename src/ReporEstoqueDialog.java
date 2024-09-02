package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReporEstoqueDialog extends JDialog {
    private JTextField codigoField;
    private JTextField quantidadeField;
    private JTextField valorEntradaField;
    private JButton reporButton;
    private JButton cancelarButton;

    private Estoque estoque;

    public ReporEstoqueDialog(Frame parent, Estoque estoque) {
        super(parent, "Repor Estoque", true);
        this.estoque = estoque;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Código do Produto:"));
        codigoField = new JTextField();
        add(codigoField);

        add(new JLabel("Quantidade a Repor:"));
        quantidadeField = new JTextField();
        add(quantidadeField);

        add(new JLabel("Valor Entrada Total:"));
        valorEntradaField = new JTextField();
        add(valorEntradaField);

        reporButton = new JButton("Repor");
        reporButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reporEstoque();
            }
        });
        add(reporButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelarButton);

        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    private void reporEstoque() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            int quantidade = Integer.parseInt(quantidadeField.getText());
            double valorEntrada = Double.parseDouble(valorEntradaField.getText());

            estoque.reporEstoque(codigo, quantidade, valorEntrada);

            JOptionPane.showMessageDialog(this, "Estoque reposto com sucesso!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}