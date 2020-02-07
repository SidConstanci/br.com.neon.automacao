# language: pt

Funcionalidade: Realizar as validações dos testes propostos

  @Test
  @Mensagen
  Cenario: Validação da respota da aba perguntas
    Dado que eu esteja na home da neon
    Quando clico na aba "Perguntas"
    E preencho o campo busca com "Quero cancelar minha conta. Como faço?"
    Entao devo conseguir validar o resultado da pergunta

  Cenario: Verificar de o serviço (Ativar cartão) está funcionando
    Dado que eu esteja na home da neon