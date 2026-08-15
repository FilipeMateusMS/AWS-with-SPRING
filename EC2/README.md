### Para colocar uma aplicação Spring Boot no EC2

- Crie um .jar ( rode package do Maven, o arquivo estará em target/[nome do arquivo].jar ou dê o comando ./mvnw clean package )
- Se conecte a instância por meio de uma conexão SSH

- Coloque o jar na instância com o seguinte comando:

```
    scp -i (sua chave de acesso, ex: "minha-chave.pem") (o arquivo que você quer enviar, ex: "meu-app.jar") (usuário do servidor, ex: ec2-user)@(endereço ou IP do seu servidor AWS, ex: ec2-12-34-56-78.compute.amazonaws.com):(pasta onde vai salvar no servidor, ex: /home/ec2-user)
```

- Instale o Java com os seguintes comandos

1:
```
    sudo yum update -y
```
2 ( instale o java correto 17, ou outro que necessitar ):
```
    sudo yum install java-17-amazon-corretto -y
```

3 ( verifique se foi instalado corretamente ):
```
    java -version
```

- Rode o arquivo .jar com o seguinte comando, o comando irá fazer com que rode em segundo plano e continue a rodar mesmo após fechar a conexão SSH

```
    nohup java -Dspring.profiles.active=[ Nome do perfil ativo caso exista ] -jar [ Nome do arquivo JAR ].jar > [ Nome qualquer para o arquivo de log, por exemplo output.log ].log 2>&1 &
```
Para obter o conteúdo do arquivo de log ```` cat output.log````

- Altere as configurações de segurança para adicionar a porta da aplicação, por exemplo, a porta 8080 para uma aplicação Spring, para fazer isso: acesse EC2 > Instances > Selecione a instância > Security > Clique Edit inbound roles > Adicione a conexão HTTP para a porta 8080 para qualquer IP ( 0.0.0.0/0 r)
