# language: pt

Funcionalidade: Realizar as validações dos testes propostos

  @Test
  @Perguntas
  Cenario: Validação da respota da aba perguntas
    Dado que eu esteja na home da neon
    Quando clico na aba perguntas
    E preencho o campo busca
    Entao devo conseguir validar o resultado da pergunta

  @Test
  @Documentos
  Cenario: Verificar quais documentos são nescessarios para abrir uma conta
    Dado que eu esteja na home da neon
    Quando clicar na aba pejota
    E clicar no botao ABRA SUA NEON PEJOTA
    Quando for redirecinoado para a primeira etapa de cadastro
    E clicar no elemento CONFERIR LISTA
    Entao devo conseguir validar os documentos necessarios para abrir a conta