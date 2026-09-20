## Serviço Secrets Manager

- Pesquise no console AWS Secrets Manager
- Na seção tipo de segredo:
  - Selecione o tipo de segredo
  - Coloque suas credenciais
  - Selecione o Banco de Dados( Caso a chave seja seja para Banco de dados )
  - As chaves podem ser key/value, para isso selecione Outro tipo de segredo
- Na seção Configurar segredo
  - Dê um nome para o segredo
  - Dê uma descrição caso seja necessário
  - Coloque Tags caso seja necessário
  - Coloque permissões, caso seja necessário
  - Caso deseje replicar segredo, habilite essa opção
  - Opção Rotation schedule: faz trocar automaticamente o valor do segredo (senha, API Key, credencial de banco etc.) em um intervalo definido. O objetivo é aumentar a segurança: se uma credencial vazar, ela deixa de ser válida após a próxima rotação
- Quando o código for criado será mostrado como implementar aquela chave específica
- Clique em Store

