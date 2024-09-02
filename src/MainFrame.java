package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Estoque controleEstoque;

    public MainFrame() {
        controleEstoque = new Estoque();
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Controle de Estoque");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1, 10, 10));  // 8 linhas, 1 coluna, espaçamento de 10px entre os componentes

        JButton btnAdicionarProduto = new JButton("Adicionar Produto");
        btnAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarProdutoDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnAdicionarProduto);

        JButton btnMostrarProdutos = new JButton("Mostrar Produtos");
        btnMostrarProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostrarProdutosDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnMostrarProdutos);

        JButton btnReporEstoque = new JButton("Repor Estoque");
        btnReporEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReporEstoqueDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnReporEstoque);

        JButton btnVenderProduto = new JButton("Vender Produto");
        btnVenderProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VenderProdutoDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnVenderProduto);

        JButton btnAlterarPrecos = new JButton("Alterar Preços");
        btnAlterarPrecos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlterarPrecosDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnAlterarPrecos);

        JButton btnRelatorioVendas = new JButton("Relatório de Vendas");
        btnRelatorioVendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RelatorioVendasDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnRelatorioVendas);

        JButton btnRelatorioEstoque = new JButton("Relatório de Estoque");
        btnRelatorioEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RelatorioEstoqueDialog(MainFrame.this, controleEstoque).setVisible(true);
            }
        });
        add(btnRelatorioEstoque);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(btnSair);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}