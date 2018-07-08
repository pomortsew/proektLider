package curator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Setting_message")
public class SetingMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        if (req.getParameter("button1")!=null){
            req.getRequestDispatcher("/metodist/enlistement.jsp").forward(req,resp);
        }else if (req.getParameter("button2")!=null){
            req.setAttribute("textt", req.getParameter("text"));
            req.getRequestDispatcher("/metodist/setting_message.jsp").forward(req,resp);
        }
    }
}
