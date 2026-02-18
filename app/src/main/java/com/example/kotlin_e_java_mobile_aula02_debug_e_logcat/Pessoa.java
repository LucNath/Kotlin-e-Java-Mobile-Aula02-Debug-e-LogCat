package com.example.kotlin_e_java_mobile_aula02_debug_e_logcat;

public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(){

        this.nome = nome;
        this.idade = idade;

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nIdade: " + idade;
    }

}
