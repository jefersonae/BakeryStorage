package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarPrecosDialog extends JDialog {
    private JTextField percentualField;
    private JButton aplicarButton;
    private JButton cancelarButton;

    private Estoque estoque;

    public AlterarPrecosDialog(Frame parent, Estoque estoque) {
        super(parent, "Alterar Preços", true);
        this.estoque = estoque;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Percentual de Alteração (%):"));
        percentualField = new JTextField();
        add(percentualField);

        aplicarButton = new JButton("Aplicar");
        aplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarAlteracao();
            }
        });
        add(aplicarButton);

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

    private void aplicarAlteracao() {
        try {
            double percentual = Double.parseDouble(percentualField.getText());
            estoque.aplicarAlteracaoPrecos(percentual);

            JOptionPane.showMessageDialog(this, "Alteração de preços aplicada com sucesso!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor percentual válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}