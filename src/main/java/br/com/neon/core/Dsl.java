package br.com.neon.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static br.com.neon.core.driverFactory.getDriver;

public class Dsl {

    /********* TextField e TextArea ************/

    public void Escreve(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void Escreve(String id_campo, String texto) {
        Escreve(By.id(id_campo), texto);
    }

    public String ObterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    /********* Radio e Check ************/

    public void ClicarRadio(String id) {
        ClicarRadio(By.id(id));
    }

    public void ClicarRadio(By by) {
        getDriver().findElement(by).click();
    }

    public boolean IsRadioMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void ClicarCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean IsCheckMarcado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public void selecionarComboPrime(String radical, String valor) {
        ClicarRadio(By.xpath("//*[@id=\'" + radical + "_input\']/../..//span"));
        ClicarRadio(By.xpath("//*[@id=\'" + radical + "_items\']//li[.='" + valor + "']"));
    }

    public void SelecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void DeselecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String ObterValorCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> ObterValoresCombo(String id) {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int ObterQuantidadeOpcoesCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean VerificarOpcaoCombo(String id, String opcao) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    /********* Botao ************/

    public void ClicarBotao(By by) {
        getDriver().findElement(by).click();
    }

    public String ObterValueElemento(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    /********* Link ************/

    public void ClicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    /********* Textos ************/

    public String ObterTexto(By by) {
        String text =  getDriver().findElement(by).getText();
        System.out.println(text);
        return text;
    }

    public String ObterTexto(String id) {
        return ObterTexto(By.id(id));
    }

    public String ObterTexto(By by, int index) {
        String text = ObterTexto(by);
        text.indexOf(index);
        return text;
    }

    /********* Alerts ************/

    public String AlertaObterTexto() {
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public String AlertaObterTextoEAceita() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String AlertaObterTextoENega() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void AlertaEscrever(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames e Janelas ************/

    public void EntrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void SairFrame() {
        getDriver().switchTo().defaultContent();
    }

    public void TrocarJanela(String id) {
        getDriver().switchTo().window(id);
    }

    public void trocarJanela(int index) {
        getDriver().switchTo().window((String)
                getDriver().getWindowHandles().toArray()[index]);
    }

    /*********** JS ***************/

    public Object ExecutarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    /*********** Tabela ***************/

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

    /*********** Espera ***************/
    public void espraInplicita(int time, TimeUnit unit) {
        getDriver().manage().timeouts().implicitlyWait(time, unit);
    }

    public void esperaExplicita(int time, By by) {
        final WebDriverWait wait = new WebDriverWait(getDriver(), time);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    /*********** Lista ***************/
    public List<WebElement> obterTextoLista(By by) {
        List<WebElement> lista = getDriver().findElements((by));
        System.out.println(lista.size());
        for (WebElement WebElement : lista){
            String texts = WebElement.getText();
            System.out.println(texts);
        }
        System.out.println(lista);
        return lista;
    }

    public List<WebElement> clicarBotaoIndex(By by, int index) {
        List<WebElement> botoes = getDriver().findElements(by);
        botoes.get(index).click();
        return botoes;
    }
}
