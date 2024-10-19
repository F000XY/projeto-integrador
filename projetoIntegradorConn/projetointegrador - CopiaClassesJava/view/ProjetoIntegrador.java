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
    public static void main(String[] args) {
        EstoqueDAO estoqueDAO = new EstoqueDAO();

        // Criar um novo item de estoque (chinelo)
        Estoque chinelo = new Estoque();
        chinelo.setIdItem(1); // Defina um ID único para o item
        chinelo.setNome("Chinelo");
        chinelo.setCusto(10); // Custo de 10
        chinelo.setRevenda(20); // Preço de revenda de 20
        chinelo.setLucro(10); // Lucro de 10 (revenda - custo)

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
        cliente.setIdCliente(3); // Defina o ID do cliente
        cliente.setNome("Nome do Cliente");
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        // Inserindo o cliente no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserirCliente(cliente);

        // Criando e inserindo um serviço
        Servicos servicos = new Servicos();
        servicos.setIdCliente(cliente.getIdCliente());
        servicos.setIdEstoque(1); // Defina o ID do item do estoque
        ServicosDAO servicosDAO = new ServicosDAO();
        servicosDAO.inserirServico(servicos);

        // Criando e inserindo uma venda
        Venda venda = new Venda();
        venda.setIdEstoque(1); // Defina o ID do item do estoque
        venda.setQuantidade(2); // Defina a quantidade vendida
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserirVenda(venda);
    }
}
