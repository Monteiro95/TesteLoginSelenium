package testelogin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    @FindBy(id = "username")
    public WebElement inputUsuario;

    @FindBy(id = "password")
    public WebElement inputSenha;

    @FindBy(css = "button.radius")
    public WebElement buttonLogin;

    @FindBy(css = "div.flash.flash.error")
    public WebElement spamMensagem;

    @FindBy(css = "div.flash.flash")
    public WebElement spamMensagemLogado;

    @FindBy(css = "a.button.secondary.radius")
    public WebElement buttonLogout;

    public LoginPO(WebDriver driver) {
        super(driver);
        
    }

     /**
    * Metodo que obtem a mensagem disparada na tela
    */
    public String obterMensagem(){
        return this.spamMensagem.getText();
    }

    public String obterMensagemLogado(){
        return this.spamMensagemLogado.getText();
    }

    /**
     * Metodo q tenta executar a acao de logar o sistema
     */
    
     public void executarAcaoDeLogar(String usuario, String senha){
        escrever(inputUsuario, usuario);
        escrever(inputSenha, senha);

        buttonLogin.click();

    }

    public void executarAcaoDeDeslogar(){
        
        buttonLogout.click();

    }

    
}
