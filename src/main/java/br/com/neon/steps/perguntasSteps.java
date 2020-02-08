package br.com.neon.steps;

import br.com.neon.core.Dsl;
import br.com.neon.core.driverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static br.com.neon.core.driverFactory.getDriver;
import static br.com.neon.core.driverFactory.killDriver;

public class perguntasSteps {
    Dsl dsl;

    public perguntasSteps() {
        this.dsl = new Dsl();
    }

    @Dado("^que eu esteja na home da neon$")
    public void que_eu_esteja_na_home_da_neon() throws Throwable {
        getDriver().get("https://neon.com.br/");

    }

    @Quando("^clico na aba \"([^\"]*)\"$")
    public void clico_na_aba(String arg1) throws Throwable {
        dsl.esperaExplicita(10,By.cssSelector("li.header__nav-list-item a[href='/perguntas']"));
        dsl.ClicarBotao(By.cssSelector("li.header__nav-list-item a[href='/perguntas']"));

    }

    @Quando("^preencho o campo busca com \"([^\"]*)\"$")
    public void preencho_o_campo_busca_com(String duvida) throws Throwable {
        dsl.Escreve(By.id("txtBusca"), duvida);
        getDriver().findElement(By.id("txtBusca")).sendKeys(Keys.ENTER);
    }

    @Entao("^devo conseguir validar o resultado da pergunta$")
    public void devo_conseguir_validar_o_resultado_da_pergunta() throws Throwable {
        dsl.esperaExplicita(10,By.cssSelector("li.question-search__result-breadcrumb-type"));
        Assert.assertEquals("Cancelamento", dsl.ObterTexto(By.cssSelector("#content-wrapper div:nth-child(2) li:nth-child(3)")));
    }

    @After(order = 1)
    public void screenShot(Scenario cenario){
        File file = ((TakesScreenshot)driverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+ ".jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @After (order = 0)
    public void fecharDriver(){
        killDriver();
    }
}
