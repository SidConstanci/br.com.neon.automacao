package br.com.neon.pages;

import br.com.neon.core.Dsl;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class pejotaHomePage {
    Dsl dsl;

    public pejotaHomePage() {
        this.dsl = new Dsl();
    }

    public void clicarAbraSuaConta(){
        dsl.espraInplicita(10, TimeUnit.SECONDS);
        dsl.clicarBotaoIndex(By.cssSelector("li.feature-section__costumers-card span.feature-section__costumers-name"), 1);
    }

}
