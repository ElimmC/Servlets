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

@WebServlet(name = "ServletRegistraDisco" )
class ServletRegistraDisco extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletRegistraDisco() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int res = 0;
        String nombre=request.getParameter("nombre");
        String autor=request.getParameter("autor");

        PrintWriter out=response.getWriter();
        out.print("<!DOCTYPE HTML>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("</head>");
        out.print("<body>");
        DiscoDB discoDB=new DiscoDB();
        Disco disco = new Disco();
        disco.setAutor(autor);
        disco.setNombre(nombre);
        discoDB.registraDisco(disco);

        out.println("<p>el estado del registro fue "+ res + "</p>");

        out.print("</body>");
        out.print("</html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
