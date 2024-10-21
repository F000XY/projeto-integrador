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
}
