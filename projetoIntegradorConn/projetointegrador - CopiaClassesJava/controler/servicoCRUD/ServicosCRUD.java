package projetointegradorConn.controler.servicoCRUD;

import projetointegradorConn.model.DAO.ServicosDAO;
import projetointegradorConn.model.servicos.Servicos;

import java.util.Scanner;

public class ServicosCRUD {

    // Criação serviço
    public static void criarUmServico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastro de Serviços:");
        Servicos servicos = new Servicos();

        System.out.println("Insira o ID do cliente: ");
        servicos.setIdCliente(sc.nextInt());
        sc.nextLine();

        System.out.println("Insira o codigo do Produto: ");
        servicos.setIdEstoque(sc.nextInt());
        sc.nextLine();

        ServicosDAO servicosDAO = new ServicosDAO();
        servicosDAO.inserirServico(servicos);
    }
    public static void deletarServico(){
        Scanner sc = new Scanner(System.in);
        ServicosDAO servicosDAO = new ServicosDAO();

        System.out.println("Insira o ID do Serviço que deseja deletar: ");
        int idOs = sc.nextInt();

        // Chama a função para deletar o cliente
        servicosDAO.deletarServico(idOs);

        System.out.println("Serviço deletado com sucesso!");

    }
}
