package projetointegradorConn.controler.cadastroCRUD;
import projetointegradorConn.model.cadastro.Cliente;
import projetointegradorConn.model.cadastro.Email;
import projetointegradorConn.model.cadastro.Endereco;
import projetointegradorConn.model.cadastro.Telefone;
import projetointegradorConn.model.DAO.ClienteDAO;

import java.util.Scanner;

public class CadastroCRUD {
    // Criação Cadastro
    public static Cliente criarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastro de Cliente: ");

        // Criando endereço
        Endereco endereco = new Endereco();
        System.out.println("Insira a rua: ");
        endereco.setRua(sc.nextLine());
        System.out.println("Insira o CEP: ");
        endereco.setCep(sc.nextInt());
        sc.nextLine();  // Consome o "Enter"
        System.out.println("Insira o bairro: ");
        endereco.setBairro(sc.nextLine());
        System.out.println("Insira a cidade: ");
        endereco.setCidade(sc.nextLine());

        Email email = new Email();
        System.out.println("Insira o email do cliente: ");
        email.setEmail(sc.nextLine());  // Lê o email


        Telefone telefone = new Telefone();
        System.out.println("Insira o telefone do cliente: ");
        telefone.setTelefone(sc.nextLine());  // Lê o telefone


        Cliente cliente = new Cliente();
        System.out.println("Insira o nome do cliente: ");
        cliente.setNome(sc.nextLine());  // Lê o nome


        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserirCliente(cliente);

        return cliente;
    }

    public static void atualizarCliente() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();

        // Obter ID do cliente
        System.out.println("Insira o ID do cliente que deseja atualizar: ");
        int idCliente = sc.nextInt();
        cliente.setIdCliente(idCliente);
        sc.nextLine();  // Consome o "Enter"

        // Menu de opções para atualização
        while (true) {
            System.out.println("O que você gostaria de atualizar?");
            System.out.println("1. Email");
            System.out.println("2. Endereço");
            System.out.println("3. Telefone");
            System.out.println("4. Nome");
            System.out.println("5. Salvar e sair");

            int escolha = sc.nextInt();
            sc.nextLine(); // Consome o "Enter"

            switch (escolha) {
                case 1: // Atualizar Email
                    Email email = new Email();
                    System.out.println("Insira o ID do email correspondente: ");
                    email.setIdEmail(sc.nextInt());
                    sc.nextLine(); // Consome o "Enter"
                    System.out.println("Insira o novo email do cliente: ");
                    email.setEmail(sc.nextLine());
                    cliente.setEmail(email);
                    break;

                case 2: // Atualizar Endereço
                    Endereco endereco = new Endereco();
                    System.out.println("Insira o ID do endereço correspondente: ");
                    endereco.setIdEndereco(sc.nextInt());
                    sc.nextLine(); // Consome o "Enter"
                    System.out.println("Insira a nova rua: ");
                    endereco.setRua(sc.nextLine());
                    System.out.println("Insira o novo CEP: ");
                    endereco.setCep(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Insira o novo bairro: ");
                    endereco.setBairro(sc.nextLine());
                    System.out.println("Insira a nova cidade: ");
                    endereco.setCidade(sc.nextLine());
                    cliente.setEndereco(endereco);
                    break;

                case 3: // Atualizar Telefone
                    Telefone telefone = new Telefone();
                    System.out.println("Insira o ID do telefone correspondente: ");
                    telefone.setIdTelefone(sc.nextInt());
                    sc.nextLine(); // Consome o "Enter"
                    System.out.println("Insira o novo telefone do cliente: ");
                    telefone.setTelefone(sc.nextLine());
                    cliente.setTelefone(telefone);
                    break;

                case 4: // Atualizar Nome
                    System.out.println("Insira o novo nome do cliente: ");
                    cliente.setNome(sc.nextLine());
                    break;

                case 5: // Salvar e sair
                    ClienteDAO clienteDAO = new ClienteDAO();
                    clienteDAO.updateCliente(cliente);
                    System.out.println("Cliente atualizado com sucesso!");
                    return; // Sai do método

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
    public static void deletarCliente(){
        Scanner sc = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("Insira o ID do cliente que deseja deletar: ");
        int idCliente = sc.nextInt();

        // Chama a função para deletar o cliente
        clienteDAO.deleteCliente(idCliente);

        System.out.println("Cliente deletado com sucesso!");

    }
}
