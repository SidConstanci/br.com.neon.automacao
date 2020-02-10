package br.com.neon.steps;

import br.com.neon.pages.cadastroPage;
import br.com.neon.pages.homePage;
import br.com.neon.pages.pejotaHomePage;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class documentosSteps {
    private homePage homePage = new homePage();
    private pejotaHomePage pejotaHomePage = new pejotaHomePage();
    private cadastroPage cadastroPage = new cadastroPage();

    @Quando("^clicar na aba pejota$")
    public void clicar_na_aba_pejota() throws Throwable {
        homePage.clicarPejota();
    }

    @Quando("^clicar no botao ABRA SUA NEON PEJOTA$")
    public void clicar_no_botao_ABRA_SUA_NEON_PEJOTA() throws Throwable {
        pejotaHomePage.clicarAbraSuaConta();
    }

    @Quando("^for redirecinoado para a primeira etapa de cadastro$")
    public void for_redirecinoado_para_a_primeira_etapa_de_cadastro() throws Throwable {
        cadastroPage.validarTelaCadastro();
    }

    @Entao("^clicar no elemento CONFERIR LISTA$")
    public void clicar_no_elemento_CONFERIR_LISTA() throws Throwable {
        cadastroPage.botaoConferirALista();
    }

    @Entao("^devo conseguir validar os documentos necessarios para abrir a conta$")
    public void devo_conseguir_validar_os_documentos_necessarios_para_abrir_a_conta() throws Throwable {
        cadastroPage.validarLista();
    }
}
