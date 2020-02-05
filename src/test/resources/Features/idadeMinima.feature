# language: pt

Funcionalidade: Validação da mensagem de idade minima na seção de perguntas
  Eu como usuario
  Quero acessar a aba "Perguntas"
  Para saber a idade minima para ralizar a abertura de uma conta

  @Test
  Cenario: Mensagem idade minima
    Dado que eu esteja na home da neon
    Quando clico na aba "Perguntas"
    E preencho o campo busca com "Qual é a idade mínima para abrir uma conta Neon?"
    Entao devo conseguir validar o resultado da pergunta