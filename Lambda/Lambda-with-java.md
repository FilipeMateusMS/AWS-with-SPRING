# Para executar um projeto java na AWS lambda

- Crie um projeto java, por exemplo com o Maven e Java 21
- Empacote para o jar com Maven install
- No console AWS crie uma nova função lambda:
  - Com Author from scratch
  - Dê um nome a função
  - Coloque o runtime como Java 21
  - Coloque o jar na função lambda criada clicando no botão Upload from > .zip or .jar file
  - Deixe a arquitetura em x86_64
  - Em Runtime settings altere o handler que deve ser o caminho do método java, por exemplo:
    - Um nome válido de handler seria "org.example.LambdaExample::handler" o padrão [ nome da classe ]::[ nome do método ] 