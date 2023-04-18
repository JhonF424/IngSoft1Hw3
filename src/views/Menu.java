package views;

import controllers.RegalosController;
import models.Producto;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;
public class Menu {
    static Scanner in;

    public Menu(){

    }

    public void startApp(){
        in = new Scanner(System.in);

        RegalosController controlador = new RegalosController();

        System.out.println("Ingrese la edad de quien recibirá el regalo: ");
        int edad = in.nextInt();
        System.out.println("Ingrese su presupuesto para el regalo: ");
        double presupuesto = in.nextDouble();
        List<Producto> regalosRecomendados = controlador.buscarRegalos(edad, presupuesto);

        for (Producto regalo : regalosRecomendados) {
            System.out.println(regalo);
        }

        if(regalosRecomendados.size() == 0)
            System.out.println("No se tiene productos para esa edad o precio");
    }
}
