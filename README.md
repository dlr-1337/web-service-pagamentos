# Web Service de Pagamentos

Projeto exemplo de arquitetura de Web Services (REST) com Spring Boot, evoluindo de um POJO de domínio para um controller que expõe endpoints JSON de pagamentos.

## Tecnologias
- Java 21
- Spring Boot 3.3 (Spring Web)
- Jackson (JSR-310 para `LocalDate`)
- Maven

## Como rodar
```bash
mvn spring-boot:run
# aplicaçao sobe em http://localhost:8080
```

## Endpoints
- `GET /pagamentos` — lista todos os pagamentos.
- `GET /pagamentos/hoje` — lista pagamentos com vencimento na data atual.
- `GET /pagamentos/{id}` — detalhe por codigo (retorna 404 se nao existir).

## Testes manuais
```bash
curl http://localhost:8080/pagamentos
curl http://localhost:8080/pagamentos/hoje
curl http://localhost:8080/pagamentos/1
```

## Testes automatizados (Postman/Newman)
- Importar `web-service-pagamentos.postman_collection.json` no Postman (variavel `baseUrl` padrao `http://localhost:8080`) e executar a collection.
- Via CLI: `newman run web-service-pagamentos.postman_collection.json --env-var baseUrl=http://localhost:8080`

## Estrutura
- `pom.xml` — dependencias Spring Web e Jackson JSR-310.
- `src/main/java/com/otavio/webservices/dominio/Pagamento.java` — POJO com construtor padrao, completo e `@JsonFormat` para `LocalDate`.
- `src/main/java/com/otavio/webservices/dados/BancoDeDados.java` — lista estatica mockada com pagamentos e filtros (todos, vencendo hoje, por codigo).
- `src/main/java/com/otavio/webservices/controller/PagamentoController.java` — REST controller expondo os endpoints.
- `web-service-pagamentos.postman_collection.json` — collection para exercitar e validar a API.

## Notas sobre Web Services
- SOAP: contratos WSDL em XML, forte tipagem e maior rigidez.
- REST: uso direto de HTTP com JSON, contratos mais flexiveis e simples de evoluir.
