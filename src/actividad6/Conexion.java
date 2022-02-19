package actividad6;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Conexion(){
        try{
            Mongo mongo = new Mongo("localhost",27017);
            BaseDatos = mongo.getDB("Actividad6");
            coleccion = BaseDatos.getCollection("Actividad6");
            System.out.println("Conexión establecida");
        }
        catch(UnknownHostException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        
    }
    //Hacer el CRUD
    //Create,Read,Update,Delete
    
    public boolean insertar(String accion){
        document.put("accion",accion);
        coleccion.insert(document);
        return true;
    }
    
    public void Mostrar(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    public boolean actualizar(String accionVieja, String accionNueva){
        document.put("accion", accionVieja);
        BasicDBObject documentNuevo = new BasicDBObject();
        documentNuevo.put("accion",accionNueva);
        coleccion.findAndModify(document, documentNuevo);
        return true;
    }
    public boolean eliminar(String accion){
        document.put("accion",accion);
        coleccion.remove(document);
        return true;
        
    }
}
