
package src;

import src.lista.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarProdutosDialog extends JDialog {
    private JTextArea textArea;
    private JButton fecharButton;

    private Estoque estoque;

    public MostrarProdutosDialog(Frame parent, Estoque estoque) {
        super(parent, "Mostrar Produtos", true);
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

        mostrarProdutos();

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void mostrarProdutos() {
        textArea.setText("");
        Node atual = estoque.listaProdutos.head;
        while (atual != null) {
            Produto produto = atual.produto;
            textArea.append("Código: " + produto.codigo + "\n");
            textArea.append("Descrição: " + produto.descricao + "\n");
            textArea.append("Marca: " + produto.marca + "\n");
            textArea.append("Valor de Compra: " + produto.valorEntrada + "\n");
            textArea.append("Valor Unitário: " + produto.valorUnitario + "\n");
            textArea.append("Quantidade em Estoque: " + produto.quantidadeEstoque + "\n");
            textArea.append("Quantidade Vendida: " + produto.quantidadeVendida + "\n");
            textArea.append("Valor em vendas: " + produto.valorSaida + "\n");
            textArea.append("--------------------------\n");
            atual = atual.next;
        }
    }
}