package curator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet("/registration")
public class SuccessfulEnrollment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");


        HttpSession session = req.getSession();

        String sessionId = session.getId();

        Date sessionCreationDate = new Date(session.getCreationTime());

        Date lastSessionAccess = new Date(session.getLastAccessedTime());

        String userId = "userId";

        req.setAttribute("sesion" ,sessionId);


    }
}
