package student;
import constantText.ConstantText;
import dataBase.DBControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration_student")
public class RegistrationStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("login_student").trim().length()!=0 &&
                req.getParameter("password_student").trim().length()!=0 &&
                req.getParameter("email_student").trim().length()!=0 &&
                req.getParameter("identification_number").trim().length()!=0) {
            String identificationNumber = String.valueOf(req.getParameter("identification_number"));
            final boolean resultScaningID = DBControl.scaningIditificationNumber(identificationNumber); //результат проверки существования ID в базе данных
            // Значение TRUE если ID существует
            final boolean resultScaningLogin = DBControl.scaningLogin(req.getParameter("login_student"));//результать проверки существования Login в базе данный
            //Значение TRUE если логин существует
//        final boolean earlyStudentRegistrationFlag = DBControl.sampling(identificationNumber).getEarlyStudentRegistration();//результат проверки прежних регистраци по ID
            //Значение TRUE Если раньше были регистрации
            //блок if сработает если в базе нанных есть полученный ID, то есть студента зачислили на обучение
            if (resultScaningID) {
                //блок if сработает если не был ранее зарегистрирован
                if (!DBControl.sampling(identificationNumber).getEarlyStudentRegistration()) {
                    //блок if сработает если полученый логин не существует в базе данных и внесет в базу данных информацию о регистрации студента
                    //и переведет на страницу личного кабинета
                    if (!resultScaningLogin) {
                        Student student = new StudentBuilder(DBControl.sampling(identificationNumber))
                                .loginStudent(req.getParameter("login_student").trim())
                                .passwordStudent(req.getParameter("password_student").trim())
                                .contactStudent(req.getParameter("email_student").trim())
                                .earlyStudentRegistration(true)
                                .builder();
                        DBControl.registrationStudent(student);
                        req.setAttribute("name", student.getNameStudent().trim());
                        req.setAttribute("patronymic", student.getPatronymicStudent().trim());
                        req.getRequestDispatcher("cabinet_student/personal_student_room.jsp").forward(req, resp);
                        //блок else сработае если логин уже занят
                    } else {
                        req.setAttribute("identificationNumber", req.getParameter("identification_number").trim());
                        req.setAttribute("mail", req.getParameter("email_student").trim());
                        req.setAttribute("errorRegistration", ConstantText.ERROR_REGISTRATION_LOGIN);
                        req.getRequestDispatcher("cabinet_student/registration_student.jsp").include(req, resp);
                    }//блок else сработает если по полученному ID ранее была произведена регистрация
                } else {
                    req.setAttribute("loginStudent", req.getParameter("login_student").trim());
                    req.setAttribute("mail", req.getParameter("email_student").trim());
                    req.setAttribute("errorRegistration", ConstantText.ERROR_REGISTRATION_IDENTIFICATION_NUMBER);
                    req.getRequestDispatcher("cabinet_student/registration_student.jsp").include(req, resp);


            }  //блок else сработает если студент не был зачислен на обучение (нет ID в базе данных )
            } else {
                req.setAttribute("loginStudent", req.getParameter("login_student").trim());
                req.setAttribute("mail", req.getParameter("email_student").trim());
                req.setAttribute("errorRegistration", ConstantText.ERROR_REGISTRATION_NOT_IDENTIFICATION_NUMBER);
                req.getRequestDispatcher("cabinet_student/registration_student.jsp").include(req, resp);

            } //блок else сработает если заполнены не все поля
        } else {
            req.setAttribute("loginStudent", req.getParameter("login_student").trim());
            req.setAttribute("identificationNumber", req.getParameter("identification_number").trim());
            req.setAttribute("mail", req.getParameter("email_student").trim());
            req.setAttribute("errorRegistration", ConstantText.ERROR_REGISTRATION_EMPTY_FIELDS);
            req.getRequestDispatcher("cabinet_student/registration_student.jsp").include(req, resp);

        }
    }
}


