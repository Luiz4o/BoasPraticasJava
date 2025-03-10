# Aplicação Java aplicando Boas práticas

## Descrição
Este projeto é uma aplicação de linha de comando desenvolvida em Java, focada em boas práticas de desenvolvimento utilizando os princípios do **SOLID** e o design pattern **COMMAND**. A aplicação realiza operações com uma API, permitindo o cadastro e listagem de abrigos e pets, além da importação de pets via arquivo CSV.

## Funcionalidades
A aplicação oferece os seguintes comandos:
1. **Cadastrar Abrigos**: Permite adicionar novos abrigos.
2. **Listar Abrigos**: Exibe todos os abrigos cadastrados.
3. **Importar Pets via CSV**: Realiza a importação de dados de pets a partir de um arquivo CSV.
4. **Listar Pets**: Lista os pets cadastrados.

## Tecnologias Utilizadas
- **Java 21**
- **Princípios SOLID**: Organização e estruturação do código para maior manutenibilidade.
- **Design Pattern COMMAND**: Implementação de comandos flexíveis e expansíveis.
- **HTTP Client**: Para realizar requisições `POST` e `GET` à API.
- **Leitura de Arquivo CSV**: Processamento e importação de dados.

## Requisitos
- **Java**: Versão 12 ou superior.
- **Maven**: Para gerenciar as dependências do projeto.
- **API**: A aplicação depende de uma API para salvar e resgatar os dados. Certifique-se de configurá-la corretamente.

## Como Usar
1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. Inicie o api.jar:
   ```
   java -jar api.jar
   ```
3. Dê run na sua aplicação.
