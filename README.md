# ClienteAPI-REST-LC
LETSCODE API REST- Programação web JAVA


Crie uma API em Spring com a base de dados H2Database em memória que suporte.

GET /client/list
    Listar todos os clientes em JSON.
PUT /client/{id}
    Alterar os dados do cliente associado ao ID.
POST /client
    Criar um novo cliente.
DELETE /client/{id}
    Remover do sistema o cliente assosiado ao ID.

O cliente tem os seguintes dados:

    Name, mínimo 5 legras e no máximo 100 caractéres
    Age, mínimo 18 anos
    VAT Number, exemplo XX999999999
    Email

Os dados do cliente são obrigatórios e precisam ser validados, não deve permitir inserir ou alterar dados inválidos.
