package projetointegradorConn.view;
import projetointegradorConn.model.cadastro.Cliente;
import projetointegradorConn.model.cadastro.Email;
import projetointegradorConn.model.cadastro.Endereco;
import projetointegradorConn.model.cadastro.Telefone;
import projetointegradorConn.model.ClienteDAO;

public class ProjetoIntegrador {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua Exemplo");
        endereco.setCep(12345678);
        endereco.setBairro("Bairro Exemplo");
        endereco.setCidade("Cidade Exemplo");

        Email email = new Email();
        email.setEmail("clientexample");



        Telefone telefone = new Telefone();
        telefone.setTelefone("123456789");

        // Criando uma instância de Cliente
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1); // Defina o ID do cliente
        cliente.setNome("Nome do Cliente");
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        // Inserindo o cliente no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserirCliente(cliente);
    }
}