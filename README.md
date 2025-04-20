# 🛒 ListNest

Aplicação backend em Java com Spring Boot que permite ao usuário criar e gerenciar listas de compras de mercado.

---

## 📖 Sobre o Projeto

O **ListNest** é um sistema simples de listas de compras, onde o usuário pode criar listas, adicionar produtos e organizar os itens que deseja comprar. A aplicação foi desenvolvida com foco em boas práticas de arquitetura como a separação em camadas (`controller`, `service`, `repo`, `model`) e facilidade de manutenção.

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (ou outro de sua preferência)
- Maven
- JUnit 5 (testes)
- Lombok
- Swagger (se configurado)

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java 17 ou superior
- Maven

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/ListNest.git

# Acesse a pasta do projeto
cd ListNest

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
```

> A aplicação irá iniciar na porta padrão: `http://localhost:8080`

---

## 📂 Estrutura do Projeto

```
src/main/java/br.com.appList.listnest/controller -> Camada de controle (endpoints REST)
src/main/java/br.com.appList.listnest/service -> Lógica de negócio 
src/main/java/br.com.appList.listnest/model -> Entidades JPA
src/main/java/br.com.appList.listnest/repo -> Repositório
src/main/java/br.com.appList.listnest/config -> Configurações do projeto

src/main/resources/application.properties -> Configure seu banco de dados
src/main/resources/static/templates ->

---

## 📬 Endpoints (exemplo)

| Método | Endpoint                 | Descrição                   |
|--------|--------------------------|-----------------------------|
| GET    | /listas                  | Retorna todas as listas     |
| POST   | /listas                  | Cria uma nova lista         |
| GET    | /produtos                | Lista todos os produtos     |
| POST   | /produtos                | Cadastra novo produto       |
| POST   | /itens/adicionar         | Adiciona item à lista       |
| DELETE | /listas/{id}             | Remove uma lista específica |

> ⚠️ Verifique o arquivo `application.properties` para escolher o banco de dados (H2, PostgreSQL, etc).

---

## 🧪 Testes

Para rodar os testes:

```bash
mvn test
```

---

## 🛠️ Futuras melhorias

- Autenticação e autorização com JWT
- Integração com frontend Angular ou React
- Deploy em nuvem (Heroku, Render, etc)

---

## 👨‍💻 Autor

Desenvolvido por [Thiago Alves] 💻

---
