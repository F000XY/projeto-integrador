package projetointegradorConn.view;

import projetointegradorConn.model.cadastro.Cliente;
import projetointegradorConn.model.cadastro.Email;
import projetointegradorConn.model.cadastro.Endereco;
import projetointegradorConn.model.cadastro.Telefone;
import projetointegradorConn.model.ClienteDAO;
import projetointegradorConn.model.Servicos;
import projetointegradorConn.model.ServicosDAO;
import projetointegradorConn.model.Venda;
import projetointegradorConn.model.VendaDAO;
import projetointegradorConn.model.Estoque;
import projetointegradorConn.model.EstoqueDAO;

import java.sql.SQLOutput;
import java.util.Scanner;
public class ProjetoIntegrador {

    // Criar um novo item de estoque
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

    // Criação serviço
    public static void criarUmServiço(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastro de Serviços:");
        Servicos servicos = new Servicos();

        System.out.println("Insira o ID do cliente: ");
        servicos.setIdCliente(cliente.getIdCliente());
        sc.nextLine();

        System.out.println("Insira o codigo do Produto: ");
        servicos.setIdEstoque(sc.nextInt());
        sc.nextLine();

        ServicosDAO servicosDAO = new ServicosDAO();
        servicosDAO.inserirServico(servicos);
    }

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

    public static void main(String[] args) {
        // Insere um item no estoque
    //   inserirItemEstoque();

        // Cria um cliente
     Cliente cliente = criarCliente();

        // Cria um serviço associado ao cliente
    //    criarUmServiço(cliente);

        // Cria uma venda
     //   criarVenda();

        // Mensagem de sucesso
      //  System.out.println("Processo concluído com sucesso!");
    }
}
