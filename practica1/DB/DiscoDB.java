package mx.upiicsa.web.servlets.practica1.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.upiicsa.web.servlets.practica1.discoBean.Disco;

public class DiscoDB extends DataBase {
    String insertQuery = "insert into disco (nombre, autor) values (?, ?)";

    public List<Disco> consultaDiscos() {
        connectDatabase();
        List<Disco> album=new ArrayList<Disco>();
        try {
            Statement stm= connection.createStatement();
            System.out.print("--->1 "+stm);
            ResultSet rs=stm.executeQuery("select * from disco");
            System.out.print("--->2 "+stm);
            System.out.print("--->"+rs.wasNull());
            while (rs.next()) {
                Disco disco=new Disco();
                disco.setAutor(rs.getString("autor"));
                disco.setNombre(rs.getString("nombre"));
                album.add(disco);
            }
        }catch(Exception e) {
            e.printStackTrace();

        }
        desconectar();
        return album;
    }

    public int registraDisco(Disco disco){
        int res = 0;
        try(Connection con = connectDatabase();){
            try(PreparedStatement pst = con.prepareStatement(insertQuery)){
                pst.setString(1, disco.getNombre());
                pst.setString(2, disco.getAutor());
                res = pst.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
