package br.com.neon.pages;

import br.com.neon.core.Dsl;
import org.junit.Assert;
import org.openqa.selenium.By;

public class cadastroPage {

    private  Dsl dsl;

    public cadastroPage() {
        this.dsl = new Dsl();
    }

    public void validarTelaCadastro(){
        dsl.trocarJanela(1);
        Assert.assertEquals("primeira etapa do cadastro", dsl.ObterTexto(By.cssSelector("div.grid-container.mobile-content h2")));
    }

    public void botaoConferirALista(){
        dsl.ClicarBotao(By.cssSelector("div.text-center.mobile-button-wrapper button.button.hollow"));
    }

    public void validarLista(){
        dsl.ClicarBotao(By.id("signup-documents-panel-content-2-label"));
        Assert.assertEquals("São válidos os documentos RG, CNH ou RNE (no caso de estrangeiros).", dsl.ObterTexto(By.cssSelector("#signup-documents-panel-content-2")));
    }
}
