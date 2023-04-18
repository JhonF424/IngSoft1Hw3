package models;


import Repository.*;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Almacenamiento {
    private ILecturaJSON<Proveedor> provedoresJson = new ProveedorJSON();
    private ILecturaJSON<Producto> productosJson = new ProductoJSON();
    private List<Producto> regalos = new ArrayList<Producto>();

    public boolean crearRegalos() {

        try {
            for (Producto producto : productosJson.cargarDatos()) {
                for (Proveedor proveedor : provedoresJson.cargarDatos()) {
                    if (producto.getProveedor().equals(proveedor.getNombre())) {
                        Producto nuevoRegalo = new Producto(
                                producto.getNombre(), producto.getEdad(), producto.getPrecioBase(), proveedor.getNombre(), proveedor.getPrecioEnvio()
                        );
                        regalos.add(nuevoRegalo);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return true;
    }



    public List<Producto> getRegalos() {
        return regalos;
    }
}
