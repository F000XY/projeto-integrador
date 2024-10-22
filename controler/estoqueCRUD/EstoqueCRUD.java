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
