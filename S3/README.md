# AWS S3 - Spring Boot

Projeto simples demonstrando como configurar uma aplicação Spring Boot para se conectar ao Amazon S3.

## Configuração

Crie um bucket no AWS S3 e um usuário IAM com permissão de acesso ao bucket.

Configure as credenciais no `application.yml` ou, preferencialmente, por variáveis de ambiente.

```yaml
cloud:
  aws:
    credentials:
      access-key: ${AWS_ACCESS_KEY}
      secret-key: ${AWS_SECRET_KEY}
    region:
      static: ${AWS_REGION:ap-south-1}
    bucket:
      name: ${AWS_BUCKET}
```

## Variáveis de ambiente

```
AWS_ACCESS_KEY=<sua_access_key>
AWS_SECRET_KEY=<sua_secret_key>
AWS_REGION=ap-<nome_regiao>
AWS_BUCKET=<nome_do_bucket>
```

## Observações

- Nunca compartilhe suas credenciais da AWS.
- O usuário IAM deve possuir permissão para acessar o bucket informado.

## Como hospedar um site estático no S3

- Crie um bucket no S3
  - Com General purpose
  - Dê um nome ao bucket
  - Desabilite Block all public acess
  - Crie o bucket
- Suba os arquivos para bucket, contendo o arquivo index.html
- Mude as propriedades do bucket( S3 > Buckets > Selecione o bucket > Selecione a aba Properties)
    - Clique em edit
    - Habilite hospedagem de site estático
    - Forneça a página inicial do site como por exemplo index.html( Deve estar na raíz do bucket )
    - Caso deseje, coloque uma página de erro
- Mude as permissões do bucket ( S3 > Buckets > Selecione o bucket > Selecione a aba Permissions )
  - Edite as políticas do bucket, coloque por exemplo:
```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadGetObject",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::meu-bucket-exemplo/*"
    }
  ]
}
```