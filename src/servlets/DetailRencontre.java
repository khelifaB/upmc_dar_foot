package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import init.Init;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hacene on 13/10/2016.
 */
public class DetailRencontre extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionFactory factory = (SessionFactory)getServletContext().getAttribute(Init.ATT_SESSION_FACTORY);
        Session session = factory.openSession();
        DetailRencontre rencontre = session.get(DetailRencontre.class, 11);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("text/json");
        response.getWriter().print(mapper.writeValueAsString(rencontre));
    }
}
