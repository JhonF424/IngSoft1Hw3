package controllers;

import models.Almacenamiento;
import models.Producto;
import services.FiltroRegalo;

import java.util.List;

public class RegalosController {
    FiltroRegalo filtro = new FiltroRegalo();

    public RegalosController() {

    }

    public List<Producto> buscarRegalos(int edad, double costo) {
        Almacenamiento almacen = new Almacenamiento();
        almacen.crearRegalos();
        List<Producto> regalos = almacen.getRegalos();
        regalos = filtro.filtrarPorEdad(regalos, edad);
        regalos = filtro.filtrarPorCosto(regalos, costo);

        return regalos;
    }
}