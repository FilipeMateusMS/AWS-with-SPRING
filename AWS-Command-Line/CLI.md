# AWS Command Line - CLI

## Para instalar e utilizar com um usuário a AWS CLI
- Acesse e baixe o arquivo necessário conforme o seu SO em: https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html
- No console AWS( site online ), crie um usuário e dê as permissões que o CLI poderá ter 
- Crie um acess key, para isso no usuário criado clique em "Create acess key" > Clique em Command Line Interface ( CLI ) para gerar a Acess key ID e Secret Acess Key
- Para configurar a AWS CLI, na máquina do usuário dê o seguinte comando: ```Aws configure```, forneça os seguintes dados
  - Acess ID
  - Secret Acess Key 
  - Coloque uma região específica
  - Default output format: deixe o padrão ( sem digitar nada clique em enter nessa opção )

### Comandos gerais
- Para saber onde a AWS CLI está instalada: ```which aws``` 
- Para saber a versão do CLI da AWS: ```aws --version```
- Para saber quais comandos utilizar ```aws help``` para um serviço especifíco ```aws s3 help```

### Caso deseje rodar um script para a AWS ( por exemplo um .bat )

- Exemplo de arquivo
    - Crie um arquivo, por exemplo, criar-bucket.bat
    - Na pasta do arquivo forneça o nome completo do arquivo
```
@echo off
set BUCKET=meu-bucket-teste-123456789

echo Criando bucket %BUCKET%...

aws s3 mb s3://%BUCKET% --region us-east-1

echo.
echo Processo concluido.
pause
```

