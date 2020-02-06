# language: pt

Funcionalidade: Realizar as validações dos testes propostos

  @Test
  @Mensagen
  Cenario: Mensagem idade minima
    Dado que eu esteja na home da neon
    Quando clico na aba "Perguntas"
    E preencho o campo busca com "Qual é a idade mínima para abrir uma conta Neon?"
    Entao devo conseguir validar o resultado da pergunta

  Cenario: Verificar de o serviço (Ativar cartão) está funcionando
    Dado que eu esteja na home da neon