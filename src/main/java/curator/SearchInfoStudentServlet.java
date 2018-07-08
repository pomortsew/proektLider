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

//поиск информации о студенте
@WebServlet("/Search_info_student")
public class SearchInfoStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");
        List<Student> name3=DBControl.getListStident();
List<String> gradeList= DBControl.gradeList();
//        req.setAttribute("name",name3 );
        req.setAttribute("list_students", name3);
        req.setAttribute("list_grade", gradeList);
        req.getRequestDispatcher("metodist/search_info_student.jsp").forward(req, resp);
    }
}
