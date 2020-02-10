package br.com.neon.pages;

import br.com.neon.core.Dsl;
import org.openqa.selenium.By;

import static br.com.neon.core.driverFactory.getDriver;

public class homePage{
    Dsl dsl;

    public homePage() {
        this.dsl = new Dsl();
    }

    public void entrarUrl(){
        getDriver().get("https://neon.com.br/");
    }

    public void clicarPerguntas(){
        dsl.ClicarBotao(By.cssSelector("li.header__nav-list-item a[href='/perguntas']"));
    }

    public void clicarPejota(){
        dsl.ClicarBotao(By.cssSelector("li.header__nav-list-item a[href='/pejota']"));
    }
}
