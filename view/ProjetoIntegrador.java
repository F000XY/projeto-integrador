package projetointegradorConn.view;
import projetointegradorConn.controler.estoqueCRUD.EstoqueCRUD;
import projetointegradorConn.controler.servicoCRUD.ServicosCRUD;
import projetointegradorConn.controler.vendaCRUD.VendaCRUD;
import projetointegradorConn.controler.cadastroCRUD.CadastroCRUD;

import java.util.Scanner;

public class ProjetoIntegrador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Escolha uma operação: ");
            System.out.println("=-=-=-= 1. Menu do cadastro de Clientes =-=-=-=");
            System.out.println("=-=-=-= 2. Menu do cadastro de Produtos =-=-=-=");
            System.out.println("=-=-=-= 3. Menu do cadastro de Serviços =-=-=-=");
            System.out.println("=-=-=-= 4. Menu do cadastro de Vendas =-=-=-=-=");
            System.out.println("5. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    while (true){
                        System.out.println("1. Criar Cadastro // 2. Atualizar Cadastro // 3. Deletar Cadastro // 4. Sair");
                        int subOpcao = sc.nextInt();
                        if (subOpcao == 1) CadastroCRUD.criarCliente();
                        else if (subOpcao ==2)CadastroCRUD.atualizarCliente();
                        else if (subOpcao ==3)CadastroCRUD.deletarCliente();
                        else if (subOpcao ==4) break;
                        else{System.out.println("Opção invalida");}
                    }
                    break;
                case 2:
                    while (true){
                        System.out.println("1. Criar Produto // 2. Atualizar Produto // 3. Deletar Produto // 4. Sair");
                        int subOpcao2 = sc.nextInt();
                        if (subOpcao2 == 1)EstoqueCRUD.inserirItemEstoque();
                        else if (subOpcao2 ==2)EstoqueCRUD.atualizarEstoque();
                        else if (subOpcao2 ==3)EstoqueCRUD.deletarItem();
                        else if (subOpcao2 ==4) break;
                        else{System.out.println("Opção invalida");}
                    }
                    break;
                case 3:
                    while (true){
                        System.out.println("1. Criar Seviço // 2. Deletar Serviço // 3. Sair");
                        int subOpcao3 = sc.nextInt();
                        if (subOpcao3 == 1)ServicosCRUD.criarUmServico();
                        else if (subOpcao3 ==2)ServicosCRUD.deletarServico();
                        else if (subOpcao3 ==3) break;
                        else{System.out.println("Opção invalida");}
                    }
                    break;
                case 4:
                    while (true){
                        System.out.println("1. Criar Venda // 2. Deletar Venda // 3. Sair");
                        int subOpcao4 = sc.nextInt();
                        if (subOpcao4 == 1)VendaCRUD.criarVenda();
                        else if (subOpcao4 ==2)VendaCRUD.deletarVenda();
                        else if (subOpcao4 ==3) break;
                        else{System.out.println("Opção invalida");}
                    }
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