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