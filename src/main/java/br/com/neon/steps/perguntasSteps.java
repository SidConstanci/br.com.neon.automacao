package br.com.neon.steps;

import br.com.neon.core.driverFactory;
import br.com.neon.pages.homePage;
import br.com.neon.pages.perguntasPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.neon.core.driverFactory.killDriver;

public class perguntasSteps {
    private homePage homepage = new homePage();
    private perguntasPage perguntasPage = new perguntasPage();

    @Dado("^que eu esteja na home da neon$")
    public void que_eu_esteja_na_home_da_neon() throws Throwable {
        homepage.entrarUrl();
    }

    @Quando("^clico na aba perguntas$")
    public void clico_na_aba() throws Throwable {
        homepage.clicarPerguntas();
    }

    @Quando("^preencho o campo busca$")
    public void preencho_o_campo_busca_com() throws Throwable {
        perguntasPage.setBusca("Quero cancelar minha conta. Como faço?");
    }

    @Entao("^devo conseguir validar o resultado da pergunta$")
    public void devo_conseguir_validar_o_resultado_da_pergunta() throws Throwable {
        perguntasPage.validarPesquisa();
    }

    @After(order = 1)
    public void screenShot(Scenario cenario) {
        File file = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void fecharDriver() {
        killDriver();
    }
}
