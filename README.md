# Como Rodar
1. Configurar o banco local mysql com usuario, senha.
2. Substituir no arquivo 
String endereco = "jdbc:mysql://localhost:3306/SeuBanco";
String usuario = "root";
String senha = "****";

3. [Instalar o MySql Connector](https://dev.mysql.com/downloads/connector/j/) --> Divers para estabelecer a conn
4. Colocar os drivers no seu projeto 
   - Descompactar a pasta
   -  Achar o arquivo mysql-connector-j-9.1.0.jar
      
5. Vá no seu editor de cod. em estrutura do projeto
- -->  libraries
- --> +
- --> C:\Users\***\Downloads\mysql-connector-j-9.1.0\mysql-connector-j-9.1.0 (local do arqv.)
-  (Raiz + botão direito + F4)
