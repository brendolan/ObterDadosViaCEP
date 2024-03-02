package br.com.brendolan.exceptions;

public class CEPNaoEncontrado extends Exception{
    public CEPNaoEncontrado(String cep){
        super("CEP: " + cep + " não encontrado");
    }
}
