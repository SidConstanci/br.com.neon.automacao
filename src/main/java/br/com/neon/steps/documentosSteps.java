package br.com.neon.steps;

import br.com.neon.core.Dsl;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;

public class documentosSteps {
    Dsl dsl;

    public documentosSteps() {
        this.dsl = new Dsl();
    }

    @Quando("^clicar na aba \"([^\"]*)\"$")
    public void clicar_na_aba(String arg1) throws Throwable {
        dsl.ClicarBotao(By.cssSelector("li.header__nav-list-item a[href='/pejota']\""));

    }

    @Quando("^clicar no elemento \"([^\"]*)\"$")
    public void clicar_no_elemento(String arg1) throws Throwable {
        dsl.ClicarBotao(By.cssSelector("#content-wrapper p:nth-child(6) span a"));

    }

    @Entao("^devo ser redirecinoado para a primeira etapa de cadastro$")
    public void devo_ser_redirecinoado_para_a_primeira_etapa_de_cadastro() throws Throwable {

    }

    @Entao("^clicar no elemento \"([^\"]*)\"$")
    public void clicar_no_elemento(String arg1) throws Throwable {

    }

    @Entao("^devo conseguir validar os documentos necessarios para abrir a conta$")
    public void devo_conseguir_validar_os_documentos_necessarios_para_abrir_a_conta() throws Throwable {

    }
}
