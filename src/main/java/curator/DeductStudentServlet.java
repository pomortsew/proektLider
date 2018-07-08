package curator;

import dataBase.DBControl;
import student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Select_student_deduct")
public class DeductStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");

List<Student> name3=DBControl.getListStident();

            req.setAttribute("name",name3 );
            String st=req.getParameter("name5");
            req.setAttribute("sts",st);
              req.getRequestDispatcher("metodist/select_deduct.jsp").forward(req,resp);



    }
}
