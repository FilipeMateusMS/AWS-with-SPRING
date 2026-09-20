## Serviço Amazon SQS

O Amazon SQS (Simple Queue Service) é um serviço da AWS de fila de mensagens. Ele permite que dois sistemas se comuniquem de forma assíncrona: um sistema envia uma mensagem para uma fila, e outro a processa quando estiver disponível.

### Para criar uma fila

- Pesquise por SQS no console AWS > Clique em Create Queue
- Selecione o tipo de fila:
  - Standard: são entregues as mensagens, entretanto a ordem não é garantida
  - FIFO: Firs-in-First-Out
- Forneça um nome para fila
- Forneça o tempo de visibilidade de timeout, tempo que o consumidor tem para processar a mensagem
- Forneça o tempo de retenção, tempo máximo até ser excluída
- Forneça o tempo delay de entrega, tempo que o consumidor irá esperar para ler a mensagem
- Forneça o tamanho máximo da mensagem
- Forneça o tempo de aguarda do SQS para uma resposta para um consumidor( Receive message wait time )
- Selecione as configurações de criptografia
- Configure Acess policy, ou seja, quem pode acessar
- Habilite ou desabilite a Redrive Allow Policy é uma configuração que define quais filas podem usar uma fila como Dead Letter Queue (DLQ).  Em outras palavras, ela é uma camada de permissão: mesmo que uma fila seja configurada como DLQ, a Redrive Allow Policy decide quem tem autorização para enviar mensagens para essa DLQ.
- Habilite ou desabilite Dead-letter queue: A DLQ (Dead Letter Queue) é uma fila de mensagens que recebe mensagens que falharam repetidamente no processamento. Em vez de deixar uma mensagem presa sendo processada infinitamente, o SQS a move para a DLQ para que ela possa ser analisada depois.
- Caso esteja habilitado DLQ forneça o número máximo de tentativas até ir para a DLQ