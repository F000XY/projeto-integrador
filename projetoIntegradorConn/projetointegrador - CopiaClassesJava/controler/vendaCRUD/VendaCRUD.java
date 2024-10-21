package projetointegradorConn.controler.vendaCRUD;

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
}
