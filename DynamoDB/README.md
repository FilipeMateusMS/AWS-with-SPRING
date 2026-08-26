## Para rodar esse projeto localmente

1. Crie uma tabela no DynamoDB chamada "Product"
2. Vá em IAM > Users > Dê ao usuário as permissões do DynamoDB, como, por exemplo, DynamoDBFullAcess 
3. Obtenha em Access Key do usuário a acess-key e secret-key e coloque no arquivo de configuração da aplicação

## Para rodar essa aplicação em uma EC2

- Inicie uma instância
- IAM > Roles > Adicione uma permissão ao DynamoDB, por exemplo: AmazonDynamoDBFullAcess
- Atribua a instância a IAM criada
- Empacote a aplicação com o Maven ```/.mvnw clean package -Dspring.profiles.active=aws```
- Altere a permissão do arquivo de chave com ```chmod 400 "[nome do arquivo .pem]".pem```
- Conecte-se a aws e forneça o arquivo .pem junto com o jar
  - ```scp -i "[nome do arquivo da chave .pem].pem" [nome do jar].jar [nome da instância]:/home/ec2-user/```
- Acesse a máquina com ```ssh -i "[caminho do arquivo .pem].pem ec2-user@[nome da instância]```
- Instale o java com os seguintes comandos na instância
  - ```sudo yum update -y```
  - ```sudo amazon-linux-extras enable correto17```
  - ```sudo yum install java-17-amazon-correto -y```
  - ```java -version```
- Rode a aplicação:
  - ```nohup java -jar [nome do jar].jar --spring.profiles.active=aws > output.log 2>&1 &```