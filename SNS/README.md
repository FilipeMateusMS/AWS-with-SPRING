## Serviço SNS

O Amazon SNS (Simple Notification Service) é um serviço de mensagens totalmente gerenciado da AWS que opera no modelo de publicação e assinatura (Pub/Sub). Ele é usado para comunicação assíncrona entre sistemas e arquiteturas distribuídas, enviando mensagens ativamente (via push) para os consumidores.

### Para criar um tópico

- No console AWS procure por SNS
- Dê um nome ao tópico
- Selecione o tipo de tópico
  - Standard: são entregues as mensagens, entretanto a ordem não é garantida
  - FIFO: Firs-in-First-Out
- Clique em Create Topic

### Para criar um Subscription dentro de um tópico

- Forneça o ARN do tópico
- Forneça o Protocol( Pode ser JSON, EMAIL, HTTP, HTTPS )
- Forneça os dados específicos para o protocol
- Confirme o subscription

### Para publicar uma mensagem de teste

- Procure por Amazon SNS > Topics > Selecione a Subscription > Coloque o corpo da requisição
