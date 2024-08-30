package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque controleEstoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nSistema de Controle de Estoque");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Mostrar produtos");
            System.out.println("3. Ordenar lista de produtos por nome");
            System.out.println("4. Repor estoque de produto");
            System.out.println("5. Vender produto");
            System.out.println("6. Aplicar alteração de preços em todos os produtos");
            System.out.println("7. Mostrar relatório de venda");
            System.out.println("8. Mostrar relatório de estoque");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha

                    System.out.print("Descrição do produto: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Marca do produto: ");
                    String marca = scanner.nextLine();

                    System.out.print("Valor de entrada: ");
                    double valorEntrada = scanner.nextDouble();

                    System.out.print("Valor Unitário: ");
                    double valorSaida = scanner.nextDouble();

                    System.out.print("Quantidade em estoque: ");
                    int quantidadeEstoque = scanner.nextInt();

                    Produto novoProduto = new Produto(codigo, descricao, marca, valorEntrada, valorSaida, quantidadeEstoque);
                    controleEstoque.adicionarProduto(novoProduto);
                    break;

                case 2:
                    controleEstoque.mostrarProdutos();
                    break;

                case 3:
                    controleEstoque.ordenarProdutosPorNome();
                    break;

                case 4:
                    System.out.print("Código do produto para repor: ");
                    int codigoRepor = scanner.nextInt();
                    System.out.print("Quantidade a repor: ");
                    int quantidadeRepor = scanner.nextInt();
                    System.out.print("Valor dos itens repostos: ");
                    double valorRepor = scanner.nextDouble();
                    controleEstoque.reporEstoque(codigoRepor, quantidadeRepor, valorRepor);
                    break;

                case 5:
                    System.out.print("Código do produto para vender: ");
                    int codigoVender = scanner.nextInt();
                    System.out.print("Quantidade a vender: ");
                    int quantidadeVender = scanner.nextInt();
                    controleEstoque.venderProduto(codigoVender, quantidadeVender);
                    break;

                case 6:
                    System.out.print("Percentual de alteração de preços: ");
                    double percentual = scanner.nextDouble();
                    controleEstoque.aplicarAlteracaoPrecos(percentual);
                    break;

                case 7:
                    controleEstoque.mostrarRelatorioVendas();
                    break;

                case 8:
                    controleEstoque.mostrarRelatorioEstoque();
                    break;

                case 9:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);

        scanner.close();
    }
}
