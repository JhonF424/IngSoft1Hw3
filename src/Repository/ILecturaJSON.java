package Repository;

import java.io.IOException;
import java.util.List;

public interface ILecturaJSON<T> {
    List<T> cargarDatos()throws IOException;
    void obtenerDatosJSON() throws IOException;
}
