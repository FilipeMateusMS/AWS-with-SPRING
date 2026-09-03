## Serviço API Gateway

### Para criar a conexão de API

- No Console AWS pesquise API Gateway > Clique em Create an API

Opções:
- New API: Cria uma API REST do zero.
- Clone existing API: Faz uma cópia de uma API que já existe.
- Import API: Importa uma API pronta usando OpenAPI/Swagger.
- Example API: Cria uma API de exemplo da AWS para aprender.

- Dê um nome a API e uma descrição caso seja necessário

Escolha o tipo de endpoint da API
- Regional: Internet (uma região da AWS), opção padrão e mais usada
- Edge Optimized: Internet (com CloudFront), utilizar quando os usuários estão espalhados pelo mundo
- Private: Apenas dentro da VPC, APIs internas

### Recursos da API Gateway
- Os recursos englobam os métodos
- Eles modificam a URL podendo colocar um nome posterior a "/", por exemplo /relatorios

### Para criar um método que se conectar dentro API Gateway

- Dentro do API Gateway:
    - Selecione o recurso
    - Clique em Create method
        - Selecione o tipo de requisição HTTP
        - Selecione o tipo de integração
        - Insira a URL
        - Selecione o tipo de conversão de conteúdo( Content handling )
        - Selecione o tempo de timeout máximo
        - Altera as configurações de headers, parâmetros, corpo de requisição
    - Clique em Deploy API
        - Crie ou selecione um estágio( por exemplo "Dev", "Homologação", "Produção" )
        - Clique em Deploy