# Av2-Arquitetura-Web

# Sistema Acadêmico - Backend (API)

[cite_start]Breve descrição do projeto, explicando que esta é a API RESTful para o Sistema Acadêmico, responsável pelo gerenciamento de alunos e cursos[cite: 122].

## [cite_start]🛠️ Tecnologias Utilizadas [cite: 123]

* [cite_start]Spring Boot 3 [cite: 11]
* [cite_start]Spring Data JPA [cite: 16]
* [cite_start]Spring Security [cite: 15]
* [cite_start]Banco de Dados H2 (em memória) [cite: 19]
* [cite_start]Spring Boot Actuator (Monitoramento) [cite: 17]
* [cite_start]Springdoc (Swagger) (Documentação da API) [cite: 18]
* Docker (para o `Dockerfile` de deploy)
* [cite_start]Render (Plataforma de Deploy) [cite: 68]

## [cite_start]🚀 Como Rodar Localmente [cite: 124]

1.  Clone este repositório.
2.  Certifique-se de ter o Java (JDK 21+) e o Maven instalados.
3.  Execute na raiz do projeto: `mvn spring-boot:run`
4.  A aplicação estará disponível em `http://localhost:8080`.

## [cite_start]🔑 Acesso e Autenticação [cite: 125]

* **Autenticação:** A API usa HTTP Basic Auth (Spring Security).
* **Usuário de Teste:** `admin`
* **Senha de Teste:** `adminpass`

* [cite_start]**Documentação (Swagger):** Acesse `http://localhost:8080/swagger-ui/index.html` para ver todos os endpoints[cite: 125].

## [cite_start]📊 Monitoramento (Prometheus e Grafana) [cite: 126]

[cite_start]O monitoramento é configurado via Docker Compose[cite: 88].

1.  [cite_start]Inicie a aplicação Spring Boot localmente (ela expõe métricas em `/actuator/prometheus` [cite: 111]).
2.  Na raiz do projeto, execute: `docker-compose up -d`
3.  **Prometheus:** Acesse `http://localhost:9090` (para ver os *targets*).
4.  **Grafana:** Acesse `http://localhost:3000` (login `admin`/`admin`).

[cite_start]*(Nota: Tivemos problemas para fazer o Prometheus (Docker) se conectar ao `localhost` (Host). A configuração do `prometheus.yml` [cite: 106] pode precisar de ajuste dependendo da rede, como usar o IP local em vez de `host.docker.internal`[cite: 113].)*

## [cite_start]🏋️ Testes de Carga e Stress (JMeter) [cite: 127]

[cite_start]Usei o Apache JMeter para simular múltiplos acessos[cite: 51, 53].

1.  Abra o Apache JMeter.
2.  Carregue o plano de teste (ex: `TesteDeCarga.jmx`) salvo neste repositório.
3.  O plano está configurado para fazer requisições `GET` e `POST` em `/api/alunos`, incluindo autenticação.
4.  Execute o teste e analise os resultados no "Relatório Agregado".

## [cite_start]☁️ Deploy no Render [cite: 128]

[cite_start]O deploy desta API foi feito no Render usando Docker[cite: 68].

1.  Um `Dockerfile` foi criado na raiz deste projeto.
2.  No Render, um novo "Web Service" foi criado, apontando para este repositório.
3.  O Render foi configurado para usar o `Dockerfile` para construir e rodar a imagem.
4.  A URL da API no ar é: `https://av2-arquitetura-web-nd87.onrender.com`

---


