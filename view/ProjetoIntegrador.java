package projetointegradorConn.view;
import projetointegradorConn.controler.estoqueCRUD.EstoqueCRUD;
import projetointegradorConn.controler.servicoCRUD.ServicosCRUD;
import projetointegradorConn.controler.vendaCRUD.VendaCRUD;
import projetointegradorConn.controler.cadastroCRUD.CadastroCRUD;

import java.util.Scanner;

public class ProjetoIntegrador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // CadastroCRUD.deletarCliente(); --> OK
      //  CadastroCRUD.atualizarCliente(); --> OK

        //EstoqueCRUD.deletarItem(); --> OK
        // ServicosCRUD.deletarServico(); --> OK
         VendaCRUD.deletarVenda();
        // erro em relação ao get do email na hora de att -->
        // Atualização de Registros
        // Deleção ed registros
        // Criação de registros
        while (true) {


            System.out.println("Escolha uma operação: ");
            System.out.println("1. Inserir Item de Estoque");
            System.out.println("2. Criar Cliente");
            System.out.println("3. Criar Serviço");
            System.out.println("4. Criar Venda");

            System.out.println("5. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    EstoqueCRUD.inserirItemEstoque();
                    break;
                case 2:
                    CadastroCRUD.criarCliente();
                    break;
                case 3:
                    ServicosCRUD.criarUmServico();
                    break;
                case 4:
                    VendaCRUD.criarVenda();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}