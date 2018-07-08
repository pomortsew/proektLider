package student;

import constantText.ConstantText;
import dataBase.DBControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//вход в дистанционное обучение студетн
@WebServlet("/in_student")
public class InStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

final String login=req.getParameter("login_student");
final String password=req.getParameter("password_student");
//блок IF сработает при правельно введенных данных если в базе данных есть полученные  логин и пароль
if(DBControl.userVerification(login,password)){
Student student=DBControl.sampling(DBControl.userGettingID(login,password));
req.setAttribute("name",student.getNameStudent());
req.setAttribute("patronymic",student.getPatronymicStudent());
req.setAttribute("massege" , student.getMessageStudent());// добавить поле соообщение в класс студетн и выитать из бызы
req.getRequestDispatcher("/cabinet_student/personal_student_room.jsp").forward(req,resp);
}
//блок ELSE сработает если данные не верны ( нет в базе данных )
else {

    req.setAttribute("error", ConstantText.ERROR_LOG_IN_NOT_TRUE_LOGIN_OR_PASSWORD);

    req.getRequestDispatcher("/cabinet_student/start_student.jsp").forward(req,resp);

}


    }
}
