# AWS 

# AWS Free Tier account
Inicie com a conta free tier, alguns serviços serão disponíveis apenas 12 meses

## Principais erro ao usar AWS

❌ Ignorar Alertas de Cobrança
👉 Risco de cobranças acidentais. Sempre configure um orçamento de custos com alertas por e-mail.

❌ Usar Instâncias EC2 ou RDS Grandes
👉 Utilize apenas tipos t2.micro ou outros elegíveis ao Free Tier.

❌ Implantar Usando o Usuário Root
👉 Crie um usuário IAM para as atividades do dia a dia com permissões limitadas.

❌ Esquecer de Parar/Encerrar Recursos
👉 EC2, RDS e até volumes EBS podem gerar cobranças se permanecerem em execução.

❌ Armazenar Arquivos Grandes no S3 sem Limpeza
👉 O Free Tier inclui 5 GB — monitore regularmente o uso do S3.

❌ Não Receber o E-mail de Ativação
👉 Sua conta não estará pronta até que você receba a confirmação da AWS.

❌ Escolher um Plano de Suporte Pago
👉 Selecione Suporte Básico ( Gratuito ) durante o cadastro.

❌ Não Monitorar o Uso
👉 Utilize o Painel de Cobrança ( Billing Dashboard ) para acompanhar o consumo mensal.

## BUDGETS

Sempre adicione orçamento de custos > Para isso pesquise "Billing" no painel da AWS > No painel Billing e costs home > Budgets, selecione:

    - Use a template ( simplified )
    - Coloque o nome do template
    - Coloque os emails das pessoas que irão receber
    - Clique em criar o budget

Ao passar do limite será enviado uma mensagem para o email do custo já atingido

# TIPOS DE USUÁRIOS

`Root User:` Pode criar usuários, apagar arquivos do sistema, instalar serviços e modificar qualquer configuração. Deve inserir um Email na criação.

`IAM User:` usuários criados para uso diário, com permissões específicas e mais seguras. Deve inserir email.

Por padrão, uma conta AWS permite até 5.000 usuários IAM. Esse limite pode ser consultado e, em alguns casos, solicitado para aumento através do Service Quotas.

Para criar um novo usuário: 

    - Acesse IAM resources
    - Na aba esquerda Acess Management > Users > Create user coloque:
        - Coloque um nome
        - Caso o usuário necessite de acesso ao console marque para ele ter permissão ao console da AWS, caso seja uma API não marque essa opção, pois irá ser usado Access Keys (Access Key ID e Secret Access Key) para API's
        - Caso deseja controlar mais específicamente o usuário marque o serviço Identity Center
        - Pode gerar uma senha ou customizar a senha
        - Caso deseje que o usuário mude a senha marque a opção de troca de senha

    - No Painel de Permissões( Set Permissions )
        Tem as seguintes opções Add Group, Copy permissions ou Attach policies directly 
    - Clique em create user
    - Irá ser criado o link da conta AWS criada o nome e a senha do usuário

Um usuário que não tem acesso a um serviço irá ser demonstrado como "API Error"
A lista de usuários estará em IAM > Users

## Policies ( Políticas de acesso )

Um usuário pode ou não ter acesso a um serviço para adicionar o acesso a um serviço para um usuário:

    - Vá IAM > Users > Clique no nome do usuário > Add Permission > Attach policies directly > Adicione as políticas necessárias.
    - Políticas terminadas em FullAccess permite o controle total do serviço pelo usuário, portanto AmazonEC2FullAcess permite o controle total do serviço EC2 

## User Groups

Configuração de política para alguns usuários que podem ser criados.
Para criar um grupo de usuário:

    - IAM > User groups > Create group > Dê um nome para o grupod de usuários > Dê acessos as políticas > Clique em Create Group 

## IAM Role

São permissões de acesso temporário para um um usuário ou qualquer outro aplicativo. Cada IAM Role terá um tipo de permissão.

Para criar um IAM ROLE:
    
    1. IAM > Roles > Create Role
    2. Selecione o tipo de entidade confiável, tipos de entidades, abaixo segue os tipos de entidades
    3. Adicione as permissões necessárias
    4. Dê um nome para a Role
    5. Adicione a Role para uma pessoa, para isso faça:
        5.1. IAM > Users > Selecione o usuário > Add Permissions > Create inline policy
        5.2 Edite com JSON
            "Action": Coloque em Action a ação que pode ser: pode ser "sts:AssumeRole",
             "Resource": Coloque o ARN da ROLE
        5.3 Salve e dê um nome para a policy
    6. Para acessar a Role ( assumir a Role ), vá em IAM > Roles > Abra o link em "Link to switch roles in console"
    

# Entidades confiáveis

### AWS service
É a opção mais utilizada.
Permite que um serviço da própria AWS utilize essa Role para executar ações em seu nome.
Por exemplo EC2 acessar um bucket S3.

### AWS account
Essa opção permite que outra conta AWS utilize essa Role.

### Web identity
Permite que usuários autenticados por um provedor de identidade web assumam uma Role.

### SAML 2.0 federation
Usado por empresas que possuem um sistema corporativo de autenticação.

### Custom trust policy
Permite escrever manualmente a política de confiança.

![img_1.png](img_1.png)

---
# Serviços
---

# Como gerar o Acess Key para uma aplicação acessar um serviço

    1. Vá em IAM > Users
    3. Selecione ou crie o usuário( o usuário deve ser um IAM user )
    4. Dê acesso ao serviço desejado( Por exemplo ele pode ter a permissão AWSS3FullAcess )
    5. No menu de informações do usuário clique em Create Acess Key
        5.1. Selecione o caso de uso
        5.2. Caso seja necessário adicione uma tag a acess key
        5.3. Será gerado um valor para "Acess key" e "Secret acess key"

## Serviço Simple Storage Service - S3

Utilizado para salvar objetos, para isso crie um novo bucket( balde ) ele irá armazenar objetos
    Buckets: como se fosse uma pasta, como um container
    Object: qualquer arquivo, que pode ser armazenado também em pastas e em sub-pastas
    Key: Nome único do arquivo, que pode estar em pastas
    Region: região da AWS específica
    Public Acess: controla quem pode acessar o bucket ou o arquivo

Para criar um bucket:

    - Acesse Amazon S3 dentro do console da AWS
    - Escolha a região 
    - Escolha entre "General purpose" ( É o bucket tradicional do S3, utilizado na maioria dos projetos. ) ou "Directory" ( São voltados para aplicações que precisam de milhares ou milhões de operações por segundo. ) -
    - Dê um nome ao bucket, ele tem que ser único em toda a AWS
    - Em Object Ownership, escolha entre habilitar ou desabilitar ACLs, caso esteja desabilitado somente o proprietario da conta poderá definir o acesso ao bucket
    - Defina se deseja que o bucket seja público ou não 
    - Em Bucket Versioning escolha entre se deseja versionar os objetos ou não. Caso esteja desabilitado em caso de exclusão acidental não tem backup
    - Adicione tags para buckets, caso deseje, as tags podem ser utilizadas para segregar buckets
    - Selecione o tipo de criptografia para o bucket ( por padrão colocar SSE-S3 )
    - Caso o projeto necessite de controle de concorrência para os objetos, habilite "Object Lock", isso automaticamente irá habilitar o versionamento

Para acessar a lista de buckets:

    - Acesse Amazon S3 > General purpose buckets

Custos:
Custos:

    - S3 Standard: Ideal para arquivos acessados com frequência.
    - S3 Intelligent-Tiering: Indicado para padrões de acesso variados ou imprevisíveis, alternando automaticamente entre camadas de armazenamento para reduzir custos.
    - S3 Standard-IA: Recomendado para arquivos acessados ocasionalmente, mas que precisam de recuperação rápida.
    - S3 Glacier Instant Retrieval: Ideal para arquivamento de dados raramente acessados, com recuperação imediata.
    - S3 Glacier Flexible Retrieval: Indicado para arquivamento de longo prazo, quando a recuperação pode levar alguns minutos ou horas.
    - S3 Deep Archive: Melhor opção para arquivamento de longo prazo de dados quase nunca acessados, com o menor custo de armazenamento.

## Serviço Elastic Compute Cloud - EC2

Máquinas escaláveis

Para criar uma instância EC2:
    
    - Vá até EC2 no console da AWS
    - Clique em Lauch instance
    - Dê um nome para a instância
    - Escolha o sistema operacional para a instância ( o Amazon Linux é gratuito )
    - Escolha a arquitetura ( x86 ou Arm, por padrão x86 )
    - Escolha o tipo de instância, existem tipos específicos para processamento, armazenamento e outros fins ( t2.micro é gratuito )
    - Crie uma key pair para fazer o login da seguinte forma:
        - 1. Clique em create new key pair
        - 2. Dê um nome a sua key pair
        - 3. Selecione o algoritmo de codificação
        - 4. Selecione o formato do arquivo de key( chave ), caso a máquina que irá acessar a instância seja Windows -> .ppk, caso MacOS -> .pem
        - 5. Irá ser instalado o arquivo
    - Para permitir acesso por meio de grupos de segurança:
        - 1. Crie um grupo de segurança ou selecione um já existente
        - 2. Caso deseje habilite conexão SSH ( 0.0.0.0/0 é conexão de todos os destinatórios, ou seja qualquer IP )
        - 3. Caso deseje que a instância receba requisições HTTP habilite tal opção
    - Configure o armazenamento não volátil( por padrão 1GB de SSD( gp3 ) )
    - Em advanced details:
        1. É possível criar um script em shell para rodar quando a instância for iniciada
    - Verifique o que foi adicionada em Summary 
    - Clique em Launch instance

### Para obter a lista de instâncias rodando

- Procure por EC2 no console > Intances 
- Para acessar a máquina clique no endereço de DNS

### Para acessar a instância pelo computador por meio da conexão SSH
- Siga os passos de EC2 > Instances > Selecione a instância > Clique em Connect > Clique em SSH Client
- Caso tenha uma máquina Windows deve ter o Putty instalado

### Atenção: para cada região é mostrado a quantidade de instância da região específica, por isso veja as instâncias em EC2 Global View para visualizar todas as instâncias ativas

### Para pausar ou parar uma instância 
- EC2 > Instances > Selecione a instância > Instance state 
    - Stop Instance( parar )
    - Reboot Instance( reiniciar )
    - Terminate( deletar )


## Como conectar uma aplicação que está rodando no EC2 no serviço S3

- Crie a instância EC2
- Crie o bucket do S3
- Crie o seguinte acesso:
  - IAM > Roles > Create Role > Selecione AWS Service 
  - Em use case: selecione EC2 e Allows EC2 instance to call AWS service on your behalf ( Selecione o serviço chamador)
  - Adicione as permissões para o S3( pode ser AmazonS3FullAcess )
  - Dê um nome a role
- Atribua a role para a instância
  - EC2 > Instances > Selecione a instância > Actions > Security > Modify IAM Role > Escolha a role e salve
- Coloque o jar no EC2 e o coloque para rodar

## Serviço Amazon Relational Database Service - RDS

Serviço da AWS para criar, configurar e administrar bancos de dados relacionais sem você precisar cuidar diretamente do servidor.
Em vez de instalar PostgreSQL, MySQL etc. em uma EC2, você pode deixar a AWS administrar grande parte da infraestrutura.

- Para criar um banco de dados no RDS:
    - No console da AWS pesquise por RDS > Na opção Aurora and RDS clique em Dashboard > Clique em Create a database
    - Caso deseje facilidade selecione Easy Create, caso deseje personalizar selecione Standard Create
    - Selecione o Banco de Dados e a versão
    - Selecione entre Production( Para ambiente de produção ), Dev ou Free tier( Opção gratuita )
    - Selecione a disponibilidade e durabilidade
    - Dê um nome ao banco ( Default: database-1 )
    - Dê o nome para o Master Username ( Default: admin ) e também uma senha
    - Em Instance configuration selecione a instância
    - Em storage informe a quantidade de armazenamento como, por exemplo, 20 Gigabytes
    - Selecione as configurações de conectividade:
        - Selecione se o banco de dados necessita se conectar ao EC2
        - Selecione o tipo de rede( Default: IPV4 )
        - Selecione se deseja que tenha um endereço de IP para acesso( Habilite para edição do banco de dados caso deseje )
        - Crie uma VPC ou selecione uma já existente
        - Selecione a zona de disponibilidade 
    - Caso deseje crie tags, por exemplo Desenvolvimento, teste ou produção
    - Selecione o tipo de autenticação
    - Selecione o tipo de monitoramento do banco de dados
    - Clique em criar Banco de Dados

Para obter a lista de Banco de dados
    - Aurora and RDS > Databases 

Para acessar um banco de dados específico
    - Por exemplo, se for MySQL deve estar instalado na máquina que irá acessar
    - Obtenha o endpoint do banco de dados com Aurora and RDS > Databases > selecione o banco de dados > Connectivity e Security > Valor de Endpoint
    - Dê o seguinte comando ```mysql -h [ endpoint da Banco de dados ] -P 3306 -u [ nome do usuário, o padrão é admin ] -p```
    - Forneça a senha do usuário 

Para deletar um Banco de dados e também os backups
    - Aurora and RDS > Databases > Seleciona a base > Actions > Delete será mostrado uma lista de opções:
        - Desabilite Create Final Snapshot
        - Desabilite Retain automated backups
        - Habilite "I acknowledge..."
        - Digite "delete me"
        - Clique em Delete

## Serviço DynamoDB

Banco de dados para armazenar dados em formato NoSQL

Para criar uma tabela no DynamoDB:
- No console AWS pesquise e selecione "DynamoDB"
- Dê um nome a tabela
- Em Partion key coloque o nome para a chave primária a ser usada
- É a chave usada para ordenar e identificar itens dentro de uma mesma Partition Key (PK).
- Caso deseje forneça uma segunda chave que ser para pesquisa dentro da Partion Key essa chave se chama Sort Key
- Escolha entre as configurações das tabelas, se será o padrão pré-configurado ( Default settings ) ou configurações customizadas
- Adicione uma tag caso seja necessário
- Clique em Create Table

Para editar itens da tabela
- Acesse DynamoDB > Explore items > Clique na tabela > Edite/crie itens

Para remover uma tabela
- Acesse DynamoDB > Tables > Delete > Digite "confirm"