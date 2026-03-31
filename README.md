# CadastroDeNinjas

API e interface web para cadastro de ninjas e suas missões, desenvolvida com Spring Boot.

## Status do projeto

🚧 Em andamento: este projeto está sendo desenvolvido e ainda receberá novas funcionalidades e melhorias.

## Objetivo do projeto

Este projeto demonstra uma aplicação Java com:
- CRUD REST para ninjas
- Interface web com Thymeleaf para criar/listar/detalhar ninjas
- Persistência com Spring Data JPA
- Banco H2
- Migrações com Flyway

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring Data JPA
- Spring Boot Actuator
- Thymeleaf
- Flyway
- H2 Database
- Lombok
- Maven
- JUnit 5 (via `spring-boot-starter-test`)

## Estrutura do projeto

```text
src/main/java/dev/java10x/CadastroDeNinjas
|- CadastroDeNinjasApplication.java
|- HomeController.java
|- Ninjas/
|  |- NinjaController.java      (API REST)
|  |- NinjaControllerUi.java    (UI com Thymeleaf)
|  |- NinjaService.java
|  |- NinjaRepository.java
|  |- NinjaModel.java
|  |- NinjaDTO.java
|  |- NinjaMapper.java
|- Missoes/
|  |- MissoesController.java
|  |- MissoesService.java
|  |- MissoesRepository.java
|  |- MissoesModel.java

src/main/resources
|- application.properties
|- db/migrations/V2__Add_Ranking_TB_CADASTRO_DE_NINJAS.sql
|- templates/
   |- criarNinja.html
   |- mostrarTodos.html
   |- detalhesNinja.html
```

## Modelagem (resumo)

- `NinjaModel` -> tabela `tb_cadastro_de_ninjas`
  - campos principais: `id`, `nome`, `email` (único), `img_url`, `idade`, `ranking`, `missoes_id`
- `MissoesModel` -> tabela `tb_missoes`
  - campos principais: `id`, `nome`, `dificuldade`
- Relacionamento:
  - uma missão pode ter vários ninjas (`@OneToMany`)
  - um ninja pertence a uma missão (`@ManyToOne`)

## Pre-requisitos

- Java 17 instalado
- Maven (opcional, pois o projeto usa Maven Wrapper)

## Configuração de ambiente

O projeto usa variáveis de ambiente no `application.properties`:

- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`

Exemplo para Windows PowerShell:

```powershell
$env:DATABASE_URL="jdbc:h2:file:./data/CadastroDeNinjasDb"
$env:DATABASE_USERNAME="sa"
$env:DATABASE_PASSWORD=""
```

## Como executar

### Windows (PowerShell)

```powershell
cd "C:\Users\petru\Downloads\CadastroDeNinjas\CadastroDeNinjas"
$env:DATABASE_URL="jdbc:h2:file:./data/CadastroDeNinjasDb"
$env:DATABASE_USERNAME="sa"
$env:DATABASE_PASSWORD=""
.\mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
cd /caminho/para/CadastroDeNinjas
export DATABASE_URL="jdbc:h2:file:./data/CadastroDeNinjasDb"
export DATABASE_USERNAME="sa"
export DATABASE_PASSWORD=""
./mvnw spring-boot:run
```

## Endpoints principais

### Home

- `GET /` -> retorna `API de Ninjas funcionando!`

### Ninjas (REST)

Base: `/ninjas`

- `POST /criar` -> cria ninja
- `GET /todos` -> lista todos
- `GET /ninja/{id}` -> busca por id (retorna mensagem)
- `PUT /alterar/{id}` -> atualiza ninja
- `DELETE /deletar/{id}` -> remove ninja

Exemplo de payload para criar/alterar ninja:

```json
{
  "nome": "Naruto Uzumaki",
  "email": "naruto@folha.com",
  "imgUrl": "https://url-da-imagem",
  "idade": 16,
  "ranking": "Genin"
}
```

### Ninjas (UI)

Base: `/ninjas/ui`

- `GET /criar` -> formulário de criação
- `POST /salvar` -> salva ninja e redireciona
- `GET /todos` -> lista na tela
- `GET /ninja/{id}` -> página de detalhes
- `GET /deletar/{id}` -> remove e redireciona para lista

### Missões

Base: `/missoes`

- `POST /criar`
- `GET /todas`
- `PUT /alterar`
- `DELETE /deletar/{id}`

Observação: no estado atual, os endpoints de missões retornam mensagens simples e ainda não estão integrados com serviço/regra de negócio.

## Banco e migrations

- Banco padrão: H2 em arquivo (`./data/CadastroDeNinjasDb`)
- Console H2 habilitado em: `http://localhost:8080/h2-console`
- Flyway habilitado (`spring.flyway.enabled=true`)
- Migration presente:
  - `V2__Add_Ranking_TB_CADASTRO_DE_NINJAS.sql`

## Testes

Para rodar os testes:

```powershell
cd "C:\Users\petru\Downloads\CadastroDeNinjas\CadastroDeNinjas"
.\mvnw.cmd test
```

No momento, existe um teste de carga de contexto em `CadastroDeNinjasApplicationTests`.

## Melhorias sugeridas

- Implementar `MissoesService` com regras reais de negócio
- Completar fluxo de update na UI (`NinjaControllerUi`)
- Retornar DTO/objeto no endpoint `GET /ninjas/ninja/{id}` ao invés de texto
- Adicionar validações (`@Valid`) e tratamento global de exceções
- Expandir cobertura de testes (service, repository e controller)
- Ativar segurança (dependências de Spring Security já aparecem comentadas no `pom.xml`)

