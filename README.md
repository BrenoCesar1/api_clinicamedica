# api_clinicamedica
API criada para cadastramento de pacientes e medicos, e agendamento de consultas.
Para executar o projeto e necessário seguir os seguintes passos.
1. Criar no banco de dados uma data base com nome vollmed_api
1. Configurar o application properties do projeto com as configurações do seu banco de dados.
2. Executar o projeto para a criação das tabelas no banco de dados
3. Criar um login e uma senha e fazer a conversão da senha para Bcrypt no site https://bcrypt-generator.com/
4. Adicionar o login e a senha convertida na tabela usuários do banco de dados
5. Entrar no endereço /swagger-ui/index.html para executar as requisições JSON
6. Fazer login com usuario e senha escolhidos usando a senha antes de ser convertida
7. Utilizar o token gerado para executar as demais requisições adicionando ao botão authorize.
