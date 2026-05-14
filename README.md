# ⚽ FuteApi

FuteApi é uma aplicação desenvolvida com **Spring Boot** para gerenciar e consumir dados futebolísticos integrados com a **Api-Sports (API-Football)** e alavancar inteligência utilizando a IA do Google (**Gemini AI**).

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-green.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A22?logo=apachemaven&logoColor=white)

---

## 🏗 Arquitetura e Convenções

O projeto segue um padrão arquitetural em camadas para separar responsabilidades de forma clara, facilitar a manutenção e a escalabilidade.

- **`controller/`**: Camada responsável por receber as requisições HTTP e entregar as respostas. Não contém regras de negócio focando em apenas tratar entrada/saída.
- **`service/`**: Contém interfaces para os serviços da aplicação.
  - **`service/impl/`**: Implementações das lógicas de negócio e regras de domínio específicas (ex: `AuthKeyServiceImpl`, `ApiSportsImporterImpl`).
- **`repository/`**: Interfaces responsáveis pela integração e persistência com o banco de dados via Spring Data JPA.
- **`model/`**: Entidades mapeadas para o banco de dados (ex: `League`, `AuthKey`).
- **`dto/`**: Objetos de transferência de dados, focados em transitar informações entre API, Banco e Client, isolando o modelo de domínio da estrutura da API externa (`authdto`, `apisportsdto`).
- **`client/`**: Camada que centraliza a comunicação HTTP com serviços externos (ex: ApiSports).
- **`authorization/`**: Configurações de segurança e autenticação internas da API.

---

## 🛠 Tecnologias e Ferramentas

- **Java 21**
- **Spring Boot** (Web, Data JPA)
- **PostgreSQL** para persistência relacional.
- **Lombok** para reduzir boilerplate code (Getters, Setters, Construtores).
- Integração com **API-Football** e **Google Gemini AI**.

---

## ⚙️ Configuração Local (Setup)

Para executar o projeto localmente, é necessário configurar as variáveis de ambiente. O projeto está preparado para buscar um arquivo `.env` na raiz do projeto (`.env.properties` opcional).

### Variáveis de Ambiente Necessárias

Crie um arquivo `.env` na raiz do projeto seguindo este modelo:

```env
# Banco de Dados
DATABASE_URL=jdbc:postgresql://localhost:5432/seu_banco
DATABASE_USER=seu_usuario
DATABASE_PASSWORD=sua_senha

# API-Sports (FootBall API)
API_FOOTBALL_KEY=sua_chave_apisports

# Google Gemini AI
GOOGLE_AI_KEY=sua_chave_gemini
```

### Inicializando a aplicação

1. Realize o clone do repositório:
```bash
git clone https://repositorio/futeApi.git
cd futeApi
```

2. Efetue o build com Maven e faça o download das dependências:
```bash
./mvnw clean install
```

3. Suba a aplicação (garanta que o banco PostgreSQL já está no ar conforme as credenciais cadastradas):
```bash
./mvnw spring-boot:run
```

A aplicação subirá por padrão na porta `8080`.

---

## 🧪 Testes Automatizados

O projeto já contempla dependências para testes através do Spring Boot Starter Test (`spring-boot-starter-data-jpa-test` e `webmvc-test`).

Para rodá-los:
```bash
./mvnw test
```

---

## 📝 Pontos de Destaque

- **Uso de Records (Java):** Aplicação massiva de `Records` para DTOs, como o `FootballAuthData` deixando o sistema imutável para transporte dos dados, tornando a aplicação mais leve.
- **Data JPA Projections:** Utilizado no retorno de dados, garantindo respostas coesas sem expor toda a Entidade/Modelo aos endpoints.

