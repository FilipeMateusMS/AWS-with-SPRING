## Elastic Container Registry - ECR

O ECR é um serviço da AWS para armazenar imagens Docker/OCI

### Para criar um repositório

- Pesquise no console AWS por ECR
  - Clique em Create repository
  - Dê um nome para o repositório com padrão [nome1]/[nome2]
  - Selecione entre mutável e imutável caso deseje que as tags de latest não mude
  - Caso deseje pode excluir tags
  - Clique em criar
- Se autentique na AWS CLI
- Siga os passos definidos em Amazon ECR > Private registry > Repositories > Images > View push commands