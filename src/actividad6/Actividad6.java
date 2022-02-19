package actividad6;

/**
 *
 * @author ADMIN
 */
public class Actividad6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conec = new Conexion();
        //conec.insertar("prueba");
        System.out.println("otra vez el mostrar");
        //conec.actualizar("prueba", "editado");
        conec.eliminar("editado");
        conec.Mostrar();
    }
    
}
