# Serviço sessao-api

Esta API é responsável por:

- Criar uma sessão de votação  
- Gerenciar o tempo de uma sessão de votação  
- Finalizar a sessão e informar a assembleia-api  

## Executando a aplicação

Para iniciar a aplicação siga os seguintes passos:  

~~~~bash
./mvnw compile
./mvnw spring-boot:run
~~~~

## Sobre o banco de dados

Para facilitar o desenvolvimento foi utilizado o banco de dados H2.  
Se mantida a configuração default, o banco será armazenado em `~/data/sessaodb`.  
O banco pode ser acessado pelo link `http://localhost:8081/h2-console` com usuário e senha `sa`.  

## Documentação da API Rest

A documentação da API foi gerada usando swagger, após iniciar a aplicação a mesma está disponível em `http://localhost:8081/swagger-ui.html`.

## Executar testes unitários

Os testes podem ser executados por meio do comando:

~~~~bash
./mvnw test
~~~~
