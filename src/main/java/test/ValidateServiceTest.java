package test;

import org.example.ValidateService;
import org.junit.Assert;
import org.junit.Test;

public class ValidateServiceTest {
    private final ValidateService vs = new ValidateService();

    @Test
    public void validarCPFTamanho(){
        boolean result = vs.validarCPF("1426854");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCPFLetras(){
        boolean result = vs.validarCPF("14e268f5px4");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCPFInvalido(){
        boolean result = vs.validarCPF("12345678912");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCPFValido(){
        boolean result = vs.validarCPF("52998224725");
        Assert.assertTrue(result);
    }

    @Test
    public void validarCPFMesmoNumero(){
        boolean result = vs.validarCPF("11111111111");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCNPJTamanho(){
        boolean result = vs.validarCNPJ("1426854305");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCNPJLetras(){
        boolean result = vs.validarCNPJ("14sd2685d3054i");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCNPJInvalido(){
        boolean result = vs.validarCNPJ("11.222.333/0001-82");
        Assert.assertFalse(result);
    }

    @Test
    public void validarCNPJIValido(){
        boolean result = vs.validarCNPJ("11.222.333/0001-81");
        Assert.assertTrue(result);
    }
}
