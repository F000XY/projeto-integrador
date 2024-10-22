package projetointegradorConn.controler.vendaCRUD;

import projetointegradorConn.model.DAO.EstoqueDAO;
import projetointegradorConn.model.DAO.VendaDAO;
import projetointegradorConn.model.venda.Venda;

import java.util.Scanner;

public class VendaCRUD {
    // Criação Venda
    public static void criarVenda() {
        // Criando e inserindo uma venda
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastro de Venda:");
        Venda venda = new Venda();
        System.out.println("Insira o codigo do Produto:");
        venda.setIdEstoque(sc.nextInt());
        sc.nextLine();

        System.out.println("Insira a quantidade do Produto:");
        venda.setQuantidade(sc.nextInt());
        sc.nextLine();

        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserirVenda(venda);
    }
    public static void deletarVenda(){
        Scanner sc = new Scanner(System.in);
        VendaDAO vendaDAO = new VendaDAO();

        System.out.println("Insira o ID da venda que deseja deletar: ");
        int idVenda = sc.nextInt();

        // Chama a função para deletar o cliente
        vendaDAO.deletarVenda(idVenda);

        System.out.println("Venda deletada com sucesso!");

    }
}