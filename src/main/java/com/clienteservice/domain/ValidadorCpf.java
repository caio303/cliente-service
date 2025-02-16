package com.clienteservice.domain;

public class ValidadorCpf {

    private static final String CPF_REGEX = "^\\d{11}$";

    public static boolean ehCPFValido(String cpf) {
        return cpf != null && cpf.matches(CPF_REGEX);
    }

}
