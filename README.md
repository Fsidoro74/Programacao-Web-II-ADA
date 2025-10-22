# Como funcionam as aplicações web?

Nesta aula, exploraremos detalhadamente como funcionam as aplicações web, incluindo o modelo cliente-servidor, o protocolo HTTP e as APIs REST. Vamos entender como esses elementos trabalham juntos para garantir uma comunicação eficiente na web, destacando também características das aplicações distribuídas e sua importância no desenvolvimento moderno.

As aplicações web estão na base de muitos serviços digitais que utilizamos diariamente, desde redes sociais até sistemas bancários e plataformas de e-commerce. Compreender como essas aplicações funcionam é essencial para quem deseja construir soluções robustas e escaláveis.

## Programação Distribuída

Programação distribuída envolve a execução de diferentes partes de uma aplicação em máquinas distintas conectadas em rede. Essa abordagem permite a comunicação entre clientes e servidores, viabilizando uma diversidade abrangente de serviços e recursos.

* **Cliente:** Software ou dispositivo que realiza solicitações e consome serviços fornecidos por servidores.
* **Servidor:** Sistema ou serviço que processa solicitações, executa tarefas e retorna respostas apropriadas.

### Características

* **Distribuição de carga:** melhor desempenho e escalabilidade.
* **Tolerância a falhas:** operações continuam mesmo se um servidor falhar.
* **Localização remota:** acesso a serviços de qualquer lugar do mundo.

### Exemplo

Ao acessar um site no navegador, este atua como cliente ao enviar uma solicitação ao servidor, que responde com a página web correspondente. Essa interação exemplifica como a programação distribuída é aplicada nas aplicações web modernas.

## Protocolo HTTP

HTTP (Hypertext Transfer Protocol) é o principal protocolo de comunicação na web. Ele especifica como solicitações e respostas devem ser estruturadas para garantir um intercâmbio de informações eficiente entre clientes e servidores.

### Estrutura de uma requisição HTTP

```http
GET /index.html HTTP/1.1
Host: [www.exemplo.com](https://www.exemplo.com)
