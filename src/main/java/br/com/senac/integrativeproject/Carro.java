package br.com.senac.integrativeproject;

public class Carro {

    private int identificaçãoSerial;
    private String modelo;
    private String marca;
    private String ano;
    private String serial;

    public Carro(String modelo, String marca, String ano, String serial) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        if (serial.isEmpty()){
            this.serial = "default";
        } else {
            this.serial = serial;
        }
        identificaçãoSerial = (int)(Math.random() * 999999 ) + 1;
        identificaçãoSerial += 1000000;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getIdentificaçãoSerial() {
        return identificaçãoSerial;
    }

    @Override
    public String toString() {
        return "Marca: " + this.getMarca() + " _Modelo: " + this.getModelo() +
                " _Ano: " + this.getAno() + " _Serial: " + this.getSerial();
    }
}
