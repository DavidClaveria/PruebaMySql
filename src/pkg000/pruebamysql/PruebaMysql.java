
package pkg000.pruebamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PruebaMysql {

    public static void main(String[] args) {
        
        //Necesitamos una librearia externa. Descargando de IE. Sirve de conexion entre aplicaion y servidor
        
        //1º) DATOS DE ACCESO A LA BD MYSQL.
        
        String usuario = "root";
        String pass = "root";
        String driver = "com.mysql.jdbc.Driver";
        String host = "jdbc:mysql://localhost:8889/t119";
        
        //2º) EL PROCESO DE CONEXION 
        //CONECTAR CON BD
        try {
            Class.forName(driver);
        Connection con = DriverManager.getConnection(host, usuario, pass);
        
        String SQL = "insert into tablacoches (modelo,color,potencia) values ( 'Kuga', 'blanco', '130cv')";
        
            Statement st = con.createStatement();
            st.execute(SQL);
            String select = "SELECT * FROM tablacoches";
            ResultSet resultado = st.executeQuery(select);
            while ( resultado.next()){
                System.out.println("Modelo: " + resultado.getString("modelo"));
            }
            
            st.close();
            con.close();            
        
                    
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            
        }
        
        
      
        
        
        
        
    }
    
}
