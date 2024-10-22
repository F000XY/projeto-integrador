package projetointegradorConn.controler.estoqueCRUD;

import projetointegradorConn.model.DAO.ClienteDAO;
import projetointegradorConn.model.DAO.EstoqueDAO;
import projetointegradorConn.model.estoque.Estoque;

import java.util.Scanner;

public class EstoqueCRUD { // Criar um novo item de estoque
    public static void inserirItemEstoque() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastro de Estoque:");

        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Estoque item = new Estoque();


        System.out.println("Insira o nome do Produto: ");
        String nome = sc.nextLine();

        System.out.println("Insira o preço do Produto: ");
        double custo = sc.nextDouble();
        sc.nextLine();

        System.out.println("Insira o preço da Revenda: ");
        double revenda = sc.nextDouble();
        sc.nextLine();

        item.setNome(nome);
        item.setCusto(custo);
        item.setRevenda(revenda);

        double lucro = revenda - custo;
        item.setLucro(lucro);
        System.out.println("O lucro calculado foi: " + lucro);

        estoqueDAO.inserirEstoque(item);
    }
    public static void atualizarEstoque() {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

        // Obter ID do item do estoque
        System.out.println("Insira o ID do item que deseja atualizar: ");
        int idItem = sc.nextInt();
        estoque.setIdItem(idItem);
        sc.nextLine();  // Consome o "Enter"

        // Menu de opções para atualização
        while (true) {
            System.out.println("O que você gostaria de atualizar?");
            System.out.println("1. Nome");
            System.out.println("2. Custo");
            System.out.println("3. Revenda");
            System.out.println("4. Lucro");
            System.out.println("5. Salvar e sair");

            int escolha = sc.nextInt();
            sc.nextLine(); // Consome o "Enter"

            switch (escolha) {
                case 1: // Atualizar Nome
                    System.out.println("Insira o novo nome do item: ");
                    estoque.setNome(sc.nextLine());
                    break;

                case 2: // Atualizar Custo
                    System.out.println("Insira o novo custo do item: ");
                    estoque.setCusto(sc.nextDouble());
                    sc.nextLine(); // Consome o "Enter"
                    break;

                case 3: // Atualizar Revenda
                    System.out.println("Insira o novo preço de revenda do item: ");
                    estoque.setRevenda(sc.nextDouble());
                    sc.nextLine(); // Consome o "Enter"
                    break;

                case 4: // Atualizar Lucro
                    System.out.println("Insira o novo lucro do item: ");
                    estoque.setLucro(sc.nextDouble());
                    sc.nextLine(); // Consome o "Enter"
                    break;

                case 5: // Salvar e sair
                    EstoqueDAO estoqueDAO = new EstoqueDAO();
                    estoqueDAO.atualizarEstoque(estoque);
                    System.out.println("Item atualizado com sucesso!");
                    return; // Sai do método

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    public static void deletarItem(){
        Scanner sc = new Scanner(System.in);
        EstoqueDAO estoqueDAO = new EstoqueDAO();

        System.out.println("Insira o ID do item que deseja deletar: ");
        int idItem = sc.nextInt();

        // Chama a função para deletar o cliente
        estoqueDAO.deletarItem(idItem);

        System.out.println("Item deletado com sucesso!");

    }
}
