/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.fabrica;

/**
 *
 * @author thord
 */
public class MotocicletaGasolina extends Motocicleta{
    int cilindraje;

    public MotocicletaGasolina(int id,String marca, String linea, String modelo,String color,int precio, String descipcion,int cilindraje,String imagen) {
        super(id,marca, linea, modelo, descipcion, imagen);
        this.categoria = "Gasolina";
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
}
