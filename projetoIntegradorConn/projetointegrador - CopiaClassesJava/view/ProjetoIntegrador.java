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

public class ProjetoIntegrador {
    // Criar um novo item de estoque
    public static void inserirItemEstoque() {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        Estoque chinelo = new Estoque();
        chinelo.setIdItem(19);
        chinelo.setNome("TesteOficial");
        chinelo.setCusto(10);
        chinelo.setRevenda(20);
        chinelo.setLucro(10);

        // Inserindo o item no estoque
        estoqueDAO.inserirEstoque(chinelo);
    }

    // Criação Cadastro
    public static Cliente criarCliente() {
        // Criando endereço
        Endereco endereco = new Endereco();
        endereco.setRua("Rua Exemplo");
        endereco.setCep(12345678);
        endereco.setBairro("Bairro Exemplo");
        endereco.setCidade("Cidade Exemplo");

        // Criando email
        Email email = new Email();
        email.setEmail("clientexample@example.com");

        // Criando telefone
        Telefone telefone = new Telefone();
        telefone.setTelefone("123456789");

        // Criando cliente
        Cliente cliente = new Cliente();
        cliente.setIdCliente(19);
        cliente.setNome("Nome do Cliente");
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        // Inserindo o cliente no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserirCliente(cliente);

        return cliente;
    }

    // Criação serviço
    public static void criarUmServiço(Cliente cliente) {
        // Criando e inserindo um serviço
        Servicos servicos = new Servicos();
        servicos.setIdCliente(cliente.getIdCliente());
        servicos.setIdEstoque(19);
        ServicosDAO servicosDAO = new ServicosDAO();
        servicosDAO.inserirServico(servicos);
    }

    // Criação Venda
    public static void criarVenda() {
        // Criando e inserindo uma venda
        Venda venda = new Venda();
        venda.setIdEstoque(19);
        venda.setQuantidade(2);
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserirVenda(venda);
    }

    public static void main(String[] args) {
        // Insere um item no estoque
       inserirItemEstoque();

        // Cria um cliente
        Cliente cliente = criarCliente();

        // Cria um serviço associado ao cliente
        criarUmServiço(cliente);

        // Cria uma venda
        criarVenda();

        // Mensagem de sucesso
        System.out.println("Processo concluído com sucesso!");
    }
}
