package mx.upiicsa.web.servlets.practica1.discoBS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import mx.upiicsa.web.servlets.practica1.DB.DiscoDB;
import mx.upiicsa.web.servlets.practica1.discoBean.Disco;

@WebServlet(name = "ConsultaDiscoServlet")
class ConsultaDiscoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConsultaDiscoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.print("<!DOCTYPE HTML>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("</head>");
        out.print("<body>");
        List<Disco> listaDiscos;
        DiscoDB discoDB=new DiscoDB();
        listaDiscos=discoDB.consultaDiscos();

        for(Disco disco:listaDiscos) {
            out.print("<p>" + disco.getAutor()+" / " +disco.getNombre()+"</p>" );
        }

        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
