# Consulta de Endereço na API Via CEP - Exemplo de Consumo de API

Este repositório contém um exemplo prático de como consumir uma API para buscar informações de endereço brasileiro a partir de um CEP. O objetivo é demonstrar como realizar uma requisição HTTP para uma API de terceiros e tratar o retorno em uma aplicação.


## 🚀 Tecnologias Utilizadas

- **Java** com Spring Boot
- **Maven** para gerenciamento de dependências
- API Pública de CEP (exemplo: [ViaCEP](https://viacep.com.br/))


## 📌 Funcionalidades

- **Consulta de Endereço**: Enviar um CEP e receber os seguintes dados:
  - Logradouro
  - Bairro
  - Localidade
  - UF
  - Complemento


## Resposta trata da Via Cep
```bash
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "",
  "bairro": "Santa Maria",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

## 📂 API Pública Utilizada

- **[ViaCEP](https://viacep.com.br/)**:
  - **Endpoint base**:  
    ```plaintext
    https://viacep.com.br/ws/{cep}/json/
    ```
