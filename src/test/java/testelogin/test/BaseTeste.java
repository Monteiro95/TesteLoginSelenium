package testelogin.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTeste {
    
    /**
*Driver do navegador da pagina atual
*/

protected static WebDriver driver;
/**
 * Caminho base da URL do sistema a ser testado
 */
    private static final String URL_BASE = "https://the-internet.herokuapp.com/login";

/**
 * Caminho relativo do driver ao projeto referente ao path
 */
    private static final String CAMINHO_DRIVER = "src/test/java/testelogin/resource/chromedriver.exe";


/**
 * Metodo para iniciar o driver do navegador antes de qualquer classe de teste
 */
    //Before sempre com os atributos STATIC
    @BeforeClass //informa q esse metodo sera iniciado antes de qlqr outro
    
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
       
    }

/**
 * Metodo para finaliza o driver do navegador depois  das classe de teste
 */
    //Informa q sempre rodara ao final,depois q toda a classe rodar
    @AfterClass
    public static void finalizar(){
      // driver.quit();
    }

}
