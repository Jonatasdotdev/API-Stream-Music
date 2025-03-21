
# **API REST para Plataforma de Streaming de Música**

Este projeto é uma API REST desenvolvida para gerenciar uma biblioteca de músicas em uma plataforma de streaming. A API permite a inclusão, exclusão, alteração e consulta de músicas, seguindo uma arquitetura robusta e escalável.

---

## **Tecnologias Utilizadas**
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento.
- **Spring Data JPA**: Abstração para acesso a dados.
- **Maven**: Gerenciador de dependências e build.
- **Insomnia**: Ferramenta para teste e documentação de APIs.

---

## **Requisitos Funcionais**
A API atende aos seguintes requisitos:
1. **Inclusão de Músicas:** Adicionar novas músicas com título, artista, gênero e duração.
2. **Exclusão de Músicas:** Excluir músicas com base em um ID único.
3. **Alteração de Músicas:** Atualizar os detalhes de uma música existente.
4. **Consulta de Músicas:** Buscar músicas por título, artista, gênero ou ID.

---


## **Configuração do Projeto**

### **Pré-requisitos**
- Java 17 ou superior.
- Maven instalado.
- Insomnia ou Postman para testar os endpoints.

### **Passos para Executar o Projeto**

1. **Clone o Repositório:**
  
2. **Compile o Projeto:**
   ```bash
   mvn clean install
   ```

3. **Execute a Aplicação:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API:**
   - A API estará disponível em `http://localhost:8080`.

5. **Acesse o Console do H2:**
   - Abra o navegador e acesse `http://localhost:8080/h2-console`.
   - Use as seguintes credenciais:
     - **JDBC URL:** `jdbc:h2:mem:musicdb`
     - **User Name:** `sa`
     - **Password:** `password`

---

## **Endpoints da API**

| Método | Endpoint                  | Descrição                              |
|--------|---------------------------|----------------------------------------|
| POST   | `/music`                  | Cria uma nova música.                  |
| GET    | `/music`                  | Retorna todas as músicas.              |
| GET    | `/music/{id}`             | Retorna os detalhes de uma música.     |
| PATCH  | `/music/{id}`             | Atualiza os detalhes de uma música.    |
| DELETE | `/music/{id}`             | Exclui uma música.                     |








