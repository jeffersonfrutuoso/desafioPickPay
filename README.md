# 💸 PicPay Simplificado - Desafio Backend

Este projeto é uma solução para o desafio técnico proposto pelo PicPay. Ele simula uma plataforma de pagamentos entre usuários e lojistas, com regras de negócio, validações e integrações externas.

> Repositório: [github.com/jeffersonfrutuoso/desafioPickPay](https://github.com/jeffersonfrutuoso/desafioPickPay)

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Flyway (migrations)
- Docker
- RestTemplate
- DBeaver (acesso ao banco)

---

## 📋 Funcionalidades Implementadas

- Cadastro de usuários com CPF/CNPJ e e-mail únicos
- Tipos de usuário:
  - **COMMON**: pode enviar e receber transferências
  - **MERCHANT**: só pode receber transferências
- Validação de saldo antes de transferir
- Transferência atômica (transacional)
- Consulta a serviço externo de autorização:
  - `GET https://util.devi.tools/api/v2/authorize`
- Envio de notificação via serviço externo:
  - `POST https://util.devi.tools/api/v1/notify`
- Exceções personalizadas para falhas de negócio e serviços externos
- Estrutura em camadas (Controller, Service, Repository)

---

## 📦 Como Executar Localmente

> Pré-requisitos: Docker instalado

```bash
# Clonar o repositório
git clone https://github.com/jeffersonfrutuoso/desafioPickPay.git
cd desafioPickPay

# Subir os containers da aplicação e banco
docker-compose up --build
API: http://localhost:8080

PostgreSQL: localhost:5432
Usuário: postgres
Senha: postgres

🧱 Estrutura do Projeto

src/
├── controller         # Endpoints REST
├── domain             # Entidades JPA
├── dtos               # Data Transfer Objects
├── enums              # Enum de tipo de usuário
├── excetion           # Tratamento de erros customizados
├── repository         # Interfaces JPA
├── service            # Regras de negócio
├── util               # Utilitários
└── PicPayApplication  # Classe principal
🔁 Endpoint Principal: Transferência
POST /transfer
json

{
  "value": 100.0,
  "payer": 1,
  "payee": 2
}
Regras:
Apenas usuários COMMON podem transferir

MERCHANT não pode enviar dinheiro

Validação de saldo antes da operação

Transação revertida em caso de falha externa

Autorização via API externa mock

Notificação enviada ao recebedor

📂 Migrations com Flyway
As migrations rodam automaticamente ao subir a aplicação.

Scripts estão localizados em:


src/main/resources/db/migration/
Você pode visualizar e editar dados pelo DBeaver, conectando ao banco PostgreSQL.

