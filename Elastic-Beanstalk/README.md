## Serviço Elastic-Beanstalk

O AWS Elastic Beanstalk é uma plataforma como serviço (PaaS) da Amazon Web Services que simplifica o processo de implantação e escalabilidade de aplicações e serviços web desenvolvidos em linguagens como Java, .NET, PHP, Node.js, Python, Ruby, Go e containers Docker, sem a necessidade de gerenciar diretamente a infraestrutura subjacente.
Quando você faz o deploy de uma aplicação (seja em Java, Node.js, Python, etc.) enviando um arquivo ZIP ou WAR, o Elastic Beanstalk cria automaticamente um bucket no S3 para guardar essa versão e as futuras atualizações do seu código.

## Para colocar uma aplicação no Elastic Beanstalk

- Empacote o projeto gerando o .jar
- No console da AWS pesquise AWS Elastic Beanstalk clique em Create Application
    - Dê um nome ao projeto
    - Informe as tags, caso seja necessário
    - Informe a plataforma, para Spring
      - Platform: Tomcat
      - Tomcat 8.5 com a versão do Java compatível
    - Selecione a opção de Upload your code
    - Escolha de Local File
    - Selecione o .jar
    - Clique em Create Application