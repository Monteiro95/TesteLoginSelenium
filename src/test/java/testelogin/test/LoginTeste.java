package testelogin.test;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.BeforeClass;
import org.junit.runners.MethodSorters;
import org.junit.Test;


import testelogin.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class LoginTeste extends BaseTeste{

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComLoginESenhaVazios(){
        
        loginPage.executarAcaoDeLogar("","");

        String mensagem = loginPage.obterMensagem();

        // esperado vs resultado atual
        assertEquals(mensagem, "Your username is invalid!\n" + "×");
       
        
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComLoginVazio(){
        
        loginPage.executarAcaoDeLogar("","teste");

        String mensagem = loginPage.obterMensagem();

        // esperado vs resultado atual
        assertEquals(mensagem, "Your username is invalid!\n" + "×");
       
        
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComSenhaVazio(){
        
        loginPage.executarAcaoDeLogar("teste","");

        String mensagem = loginPage.obterMensagem();

        // esperado vs resultado atual
        assertEquals(mensagem, "Your username is invalid!\n" + "×");
       
        
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComLoginCertoESenhaErrada(){
        
        loginPage.executarAcaoDeLogar("tomsmith","teste");

        String mensagem = loginPage.obterMensagem();

        // esperado vs resultado atual
        assertEquals(mensagem, "Your password is invalid!\n" + "×");
       
        
    }

    @Test
    public void TC005_deveLogarNoSistemaComLoginESenhaCertos(){
        
        loginPage.executarAcaoDeLogar("tomsmith","SuperSecretPassword!");

        String mensagem = loginPage.obterMensagemLogado();

        // esperado vs resultado atual
        assertEquals(mensagem, "You logged into a secure area!\n" + "×");
       
        
    }

    @Test
    public void TC006_deveDeslogarDoSite(){
        
       // TC005_deveLogarNoSistemaComLoginESenhaCertos();

        loginPage.executarAcaoDeDeslogar();;

        String mensagem = loginPage.obterMensagemLogado();

        // esperado vs resultado atual
        assertEquals(mensagem, "You logged out of the secure area!\n" + "×");
       
        
    }

    
}
