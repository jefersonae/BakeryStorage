package src;

import src.lista.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioVendasDialog extends JDialog {
    private JTextArea textArea;
    private JButton fecharButton;

    private Estoque estoque;

    public RelatorioVendasDialog(Frame parent, Estoque estoque) {
        super(parent, "Relatório de Vendas", true);
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

        mostrarRelatorioVendas();

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void mostrarRelatorioVendas() {
        textArea.setText("Relatório de Vendas:\n\n");
        Node atual = estoque.listaProdutos.head;
        while (atual != null) {
            Produto produto = atual.produto;
            if (produto.quantidadeVendida > 0) {
                textArea.append("Produto: " + produto.descricao + "\n");
                textArea.append("Quantidade Vendida: " + produto.quantidadeVendida + "\n");
                textArea.append("Total Vendido: R$ " + produto.valorSaida + "\n");
                textArea.append("--------------------------\n");
            }
            atual = atual.next;
        }
    }
}