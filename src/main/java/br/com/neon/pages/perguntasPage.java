package br.com.neon.pages;

import br.com.neon.core.Dsl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static br.com.neon.core.driverFactory.getDriver;

public class perguntasPage {
    Dsl dsl;

    public perguntasPage() {
        this.dsl = new Dsl();
    }

    public void setBusca(String duvida){
        dsl.Escreve(By.id("txtBusca"), duvida);
        getDriver().findElement(By.id("txtBusca")).sendKeys(Keys.ENTER);
    }

    public void validarPesquisa(){
        dsl.esperaExplicita(10, By.cssSelector("li.question-search__result-breadcrumb-type"));
        Assert.assertEquals("Cancelamento", dsl.ObterTexto(By.cssSelector("#content-wrapper div:nth-child(2) li:nth-child(3)")));
    }
}
