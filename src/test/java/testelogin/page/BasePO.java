package testelogin.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {
    //BasePO - Page Object
/**
 * Driver base que sera usado pelas pages
 */
protected WebDriver driver;

/**
 * Construtor base para criacao da fabrica de elementos (PageFactory)
    Driver da pagina atual     
 */
public BasePO(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

/**
* Metodo que retorna o titulo da pagina atual
*/
public String obterTituloPagina(){
    return driver.getTitle();
}

/**
* Metodo que sabe escrever em qualquer web element do tipo input e da um TAB ao final
*/
 public void escrever(WebElement input, String texto){
    input.clear();
    input.sendKeys(texto + Keys.TAB);
}
}
