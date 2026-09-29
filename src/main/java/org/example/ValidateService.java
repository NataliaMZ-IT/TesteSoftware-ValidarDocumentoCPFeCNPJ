package org.example;

public class ValidateService {
    public boolean validarCPF(String cpf){
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        cpf = cpf.trim();

        //Regra 1: Validar tamanho
        if (cpf.length() != 11){
            return false;
        };

        //Regra 2: Validar os caracteres
        if (!cpf.matches("[0-9]+")){
            return false;
        }

        //Regras 3: Validar se é o mesmo número repetido várias vezes
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")){
            return false;
        }

        //Regra 4: Validar o primeiro dígito verificador do CPF
        int sum = 0;
        int multiplica = 10;
        for (int i = 0; i < 9; i++) {
            int cpfNum = (int)(cpf.charAt(i) - 48);
            sum += (cpfNum * multiplica);
            multiplica--;
        }

        int dV1 = (sum * 10) % 11;
        if ((dV1 != cpf.charAt(9)) && (dV1 == 10 && cpf.charAt(9) != 0)){
            return false;
        };

        //Regra 5: Validar o segundo dígito verificador do CPF
        sum = 0;
        multiplica = 11;
        for (int i = 0; i < 10; i++) {
            int cpfNum = (int)(cpf.charAt(i) - 48);
            sum += (cpfNum * multiplica);
            multiplica--;
        }

        int dV2 = (sum * 10) % 11;
        if ((dV2 != cpf.charAt(10)) && (dV1 == 10 && cpf.charAt(10) != 0)){
            return false;
        };

        return true;
    }

    public boolean validarCNPJ(String cnpj){
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("/", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.trim();

        //Regra 1: Validar tamanho
        if (cnpj.length() != 14){
            return false;
        };

        //Regra 2: Validar os caracteres
        if (!cnpj.matches("[0-9]+")){
            return false;
        }

        //Regras 3: Validar se é o mesmo número repetido várias vezes
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999")){
            return false;
        }

        //Regra 4: Validar o primeiro dígito verificador do CNPJ
        int sum = 0;
        int multiplica = 6;
        for (int i = 0; i < 12; i++) {
            int cpfNum = (int)(cnpj.charAt(i) - 48);
            sum += (cpfNum * multiplica);
            multiplica = (multiplica == 9) ? 2 : multiplica + 1;
        }

        int dV1 = sum % 11;
        if ((dV1 != cnpj.charAt(12)) && (dV1 == 10 && cnpj.charAt(12) != 0)){
            return false;
        };

        //Regra 5: Validar o segundo dígito verificador do CNPJ
        sum = 0;
        multiplica = 5;
        for (int i = 0; i < 13; i++) {
            int cpfNum = (int)(cnpj.charAt(i) - 48);
            sum += (cpfNum * multiplica);
            multiplica = (multiplica == 9) ? 2 : multiplica + 1;
        }

        int dV2 = sum % 11;
        if ((dV1 != cnpj.charAt(13)) && (dV1 == 10 && cnpj.charAt(13) != 0)){
            return false;
        };

        return true;
    }
}
