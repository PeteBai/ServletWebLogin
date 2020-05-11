import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LCapachaServer extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("image/img");
        LCapacha l = new LCapacha();
        String corr = l.getCapacha();
        req.getSession().setAttribute("salt", corr);
        l.createImg(resp.getOutputStream());
    }
}