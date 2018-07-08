package curator;

import dataBase.DBControl;
import student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Info_student")
public class InfoStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");
//
//        String number =req.getParameter("list_student_search");
//        Student student=DBControl.sampling(number);

        String a="ghbdtn gthlfxf ghjbpjikf ecgtiyj";
        String id = (String) req.getParameter("id");
        String number = (String) req.getParameter("student");
//        req.setAttribute("names",student.getNameStudent());
//        req.setAttribute("surnames",student.getSurnameStudent());
//        req.setAttribute("ids",student.getIdentificationNumberStudent());
//        req.setAttribute("num",number);

        req.setAttribute("id ", "id"+id+"14521151");
        req.setAttribute("ids", number);
        req.getRequestDispatcher("metodist/info_student.jsp").forward(req,resp);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");
        String id = (String) req.getParameter("student");

   String number =req.getParameter("list_student_search");
Student student=DBControl.sampling(id);
        String ner="ghbdtn ";
////    req.setAttribute("names",student.getNameStudent());
////    req.setAttribute("surnames",student.getSurnameStudent());
////    req.setAttribute("ids",student.getIdentificationNumberStudent());
//    req.setAttribute("num",id);
//    req.setAttribute("id ", "id"+id);
//    req.setAttribute("names" ,ner);
////        req.setAttribute("ids", number);
//

//        req.setAttribute("surname",student.getSurnameStudent());
        req.setAttribute("name",student.getNameStudent());
        req.setAttribute("patronymic",student.getPatronymicStudent());
        req.setAttribute("id_number",student.getIdentificationNumberStudent());
        req.setAttribute("grade_student",student.getGradeStudent());
        req.setAttribute("profession_student",student.getProfessionStudent());
        req.setAttribute("date_of_registration",student.getDateOfRegistration());
        req.setAttribute("contact_student",student.getContactStudent());
        req.setAttribute("cours_student",student.getCours());

    req.getRequestDispatcher("metodist/info_student.jsp").forward(req,resp);

    }
}
