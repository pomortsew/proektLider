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


//формирование страницы отображающей студентов в группе
@WebServlet("/Existing_groups")
public class GradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");

String grade =req.getParameter("grade_list");
        List<Student> student=DBControl.getListStidentOfGrade(grade);
        req.setAttribute("name",student);
       req.setAttribute("list_student_grade",student);
        req.getRequestDispatcher("metodist/student_in_grade.jsp").forward(req,resp);
    }
}
