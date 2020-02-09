package br.com.neon.steps;

import br.com.neon.core.Dsl;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static br.com.neon.core.driverFactory.getDriver;

public class documentosSteps {
    Dsl dsl;

    public documentosSteps() {
        this.dsl = new Dsl();
    }

    @Quando("^clicar na aba pejota$")
    public void clicar_na_aba_pejota() throws Throwable {
        dsl.ClicarBotao(By.cssSelector("li.header__nav-list-item a[href='/pejota']"));
    }

    @Quando("^clicar no botao ABRA SUA NEON PEJOTA$")
    public void clicar_no_botao_ABRA_SUA_NEON_PEJOTA() throws Throwable {
        dsl.espraInplicita(10, TimeUnit.SECONDS);
        dsl.clicarBotaoIndex(By.cssSelector("li.feature-section__costumers-card span.feature-section__costumers-name"), 1);
    }

    @Quando("^for redirecinoado para a primeira etapa de cadastro$")
    public void for_redirecinoado_para_a_primeira_etapa_de_cadastro() throws Throwable {
        dsl.espraInplicita(10, TimeUnit.SECONDS);
        dsl.trocarJanela(1);
        Assert.assertEquals("primeira etapa do cadastro", dsl.ObterTexto(By.cssSelector("div.grid-container.mobile-content h2")));
    }

    @Entao("^clicar no elemento CONFERIR LISTA$")
    public void clicar_no_elemento_CONFERIR_LISTA() throws Throwable {
        dsl.ClicarBotao(By.cssSelector("div.text-center.mobile-button-wrapper button.button.hollow"));
    }

    @Entao("^devo conseguir validar os documentos necessarios para abrir a conta$")
    public void devo_conseguir_validar_os_documentos_necessarios_para_abrir_a_conta() throws Throwable {
        dsl.ClicarBotao(By.id("signup-documents-panel-content-2-label"));
        Assert.assertEquals("São válidos os documentos RG, CNH ou RNE (no caso de estrangeiros).", dsl.ObterTexto(By.cssSelector("#signup-documents-panel-content-2")));
    }
}
