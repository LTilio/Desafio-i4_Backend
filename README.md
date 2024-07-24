<h1 align="center">Desafio i4 - Gerenciamento de Consultas Veterinárias</h1>

## 📝 Índice
<ul>
  <li><a href="#sobre-o-projeto">Sobre o projeto</a></li>
  <li><a href="#tecnologias-utilizadas">Tecnologias Utilizadas</a></li>
  <li><a href="#endpoints">Endpoints</a></li>
  <li><a href="#autor-do-projeto">Autor do projeto</a></li>
</ul>

## :desktop_computer: Sobre o projeto
O objetivo deste desafio é construir uma aplicação full-stack para o gerenciamento de consultas veterinárias. A aplicação deve conter duas telas principais: uma para exibir uma lista de pets e outra para o cadastro de novos pets.

### Requisitos do Front-End
- **Tecnologia:** O front-end deve ser desenvolvido em React (para web) ou React Native (para mobile), a critério do desenvolvedor.
- **Tela de Listagem:**
  - Renderizar uma lista de pets obtidos através de uma chamada ao endpoint GET do back-end.
  - Cada item da lista deve exibir pelo menos um nome e uma descrição.
- **Tela de Cadastro:**
  - Formulário para adicionar novos pets, contendo pelo menos campos para nome e tipo.
  - Botão para enviar os dados do formulário para o endpoint POST do back-end.
  - Após o envio bem-sucedido, o usuário deve ser redirecionado para a tela de listagem.

### Requisitos do Back-End
- **Tecnologia:** O back-end deve ser desenvolvido em Java, utilizando o framework Spring Boot.
- **Endpoints:**
   - **GET /pets**: Retorna a lista de pets cadastrados.
   - **POST /pets**: Recebe os dados do formulário e adiciona um novo pet à lista. O pet pode ter uma imagem associada.
   - **GET /consultas/pet/{petId}**: Retorna a lista de consultas associadas a um pet específico.
   - **POST /consultas**: Adiciona uma nova consulta para um pet específico.

### Critérios de Avaliação
1. **Funcionalidade:** A aplicação deve cumprir todos os requisitos funcionais descritos acima.
2. **Usabilidade:** A interface deve ser intuitiva e fácil de usar.
3. **Código:** O código deve ser bem estruturado e organizado.
4. **Boas Práticas:** Adoção de boas práticas de desenvolvimento tanto no front-end quanto no back-end.

## :hammer_and_wrench: Tecnologias Utilizadas
<ul>
  <li>Java 17</li>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>H2 Database</li>
  <li>React / React Native</li>
  <li>Maven</li>
  <li>Postman (para testes)</li>
</ul>

## :dart: Endpoints

### Pets
- **GET /pets**: Retorna a lista de pets cadastrados.
- **POST /pets**: Recebe os dados do formulário e adiciona um novo pet à lista. O pet pode ter uma imagem associada.

### Consultas
- **GET /consultas/pet/{petId}**: Retorna a lista de consultas associadas a um pet específico.
- **POST /consultas**: Adiciona uma nova consulta para um pet específico.

## 👀 Autor do projeto

Leandro Tilio - [LTilio](https://github.com/LTilio)

  
