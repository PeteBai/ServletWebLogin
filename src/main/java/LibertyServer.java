import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibertyServer extends HttpServlet
{
    Map<String, String> m;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //设定请求的字符集
		req.setCharacterEncoding("utf-8");
		//设置响应的文本类型
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Get: Hello World!");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        m = new HashMap<String, String>();
        m.put("zura", "zura");
        m.put("chika", "chika");
        m.put("ruby", "ruby");
        String username = req.getParameter("username");
        String pw = req.getParameter("pw");
        if(m.containsKey(username) == false)
        {
            System.out.println("no user");
            resp.sendRedirect("noUser.html");
            return;
        }
        String rpw = m.get(username);
        String corr = req.getSession().getAttribute("salt").toString();
        String capacha = req.getParameter("capacha");
        if(pw.equals(rpw))
        {
            if(corr.equals(capacha))
            {
                resp.sendRedirect("corrPW.html");
                System.out.println("gogo sensation");
            }
            else
            {
                resp.sendRedirect("errCapacha.html");
                System.out.println("start dash");
            }
        }
        else
        {
            resp.sendRedirect("errPW.html");
            System.out.println("niconiconi");
        }
        System.out.println("Post: Hello World!");
    }
}
