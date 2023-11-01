# sessao-voto
BackEnd desenvolvido em Java Spring para o desafio técnico da Sicredi

Para rodar é necessario ter o Java 17 instalado na maquina

No Editor de codigo, de preferencia InteliJ, abrir o projeto como projeto mavem, importando o pom.xml

Rodar o comando na pasta do projeto - mvn clean install

Startar a API apertando o Play

Aplicacao Usando Banco em Memoria H2


Teste dos Endpoints: 

Use ferramentas como Postman, cURL ou qualquer cliente HTTP para testar os endpoints expostos pelos controladores.
Exemplo de chamadas para os endpoints:

Cadastrar Associado:
Faça uma requisição POST para http://localhost:8080/api/associados
Você pode também fazer uma nova requisição GET para http://localhost:8080/api/associados 
para verificar se o novo associado está na lista.

Cadastrar uma nova pauta:
Método: POST
URL: http://localhost:8080/api/pautas
Corpo da requisição: {"titulo": "Pauta 1"}


Abrir uma sessão de votação:
Método: POST
URL: http://localhost:8080/api/sessoes-votacao/abrir?pautaId=1&duracaoMinutos=7


Receber votos:
Método: POST
URL: http://localhost:8080/api/votos?pautaId=1&associadoId=1&voto=true
Pode ir mudando o associadoId para os cadastrados na etapa 1


Obter resultado da votação:
Método: GET
URL: http://localhost:8080/api/sessoes-votacao/1/resultado
onde 1 é  a sessao da votacao
