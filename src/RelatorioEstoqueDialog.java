
package src;

import src.lista.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioEstoqueDialog extends JDialog {
    private JTextArea textArea;
    private JButton fecharButton;

    private Estoque estoque;

    public RelatorioEstoqueDialog(Frame parent, Estoque estoque) {
        super(parent, "Relatório de Estoque", true);
        this.estoque = estoque;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(fecharButton, BorderLayout.SOUTH);

        mostrarRelatorioEstoque();

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void mostrarRelatorioEstoque() {
        textArea.setText("Relatório de Estoque:\n\n");
        Node atual = estoque.listaProdutos.head;
        while (atual != null) {
            Produto produto = atual.produto;
            textArea.append("Produto: " + produto.descricao + "\n");
            textArea.append("Quantidade em Estoque: " + produto.quantidadeEstoque + "\n");
            textArea.append("--------------------------\n");
            atual = atual.next;
        }
    }
}