package curator;

import constantText.ConstantText;
import dataBase.DBControl;
import logicProgramm.ValidationString;
import student.Student;
import student.StudentBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Enlistement")
public class EnlistementSudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html; charset=UTF-8"); //устанавливает кокодировку сервлета
        req.setCharacterEncoding("UTF-8");

        HttpSession session=req.getSession();
        String sessionId = session.getId();
        session.setAttribute("ID",sessionId);


        req.setAttribute("a","ghbdtn" );
        req.setAttribute("sesion", sessionId+"ghbdtn");
        if (ValidationString.validationName(req.getParameter("name").trim()) &&
                ValidationString.validationName(req.getParameter("surname").trim()) &&
                ValidationString.validationName(req.getParameter("patronymic").trim())) {
            if (ValidationString.validationIdentificationNumber(req.getParameter("identification-number").trim())) {
                if (ValidationString.validationGrade(req.getParameter("grade").trim())) {

                    if (!DBControl.scaningIditificationNumber(req.getParameter("identification-number").trim())) {

                        Student student = new StudentBuilder()
                                .nameStudent(ValidationString.pipelinedToUpperCase(req.getParameter("name").trim()))
                                .surnameStudent(ValidationString.pipelinedToUpperCase(req.getParameter("surname").trim()))
                                .patronymicStudent(ValidationString.pipelinedToUpperCase(req.getParameter("patronymic").trim()))
                                .professionStudent(ValidationString.pipelinedToUpperCase(req.getParameter("profession").trim()))
                                .identificationNumberStudent(ValidationString.pipelinedToUpperCase(req.getParameter("identification-number").trim()))
                                .gradeStudent(ValidationString.pipelinedToUpperCase(req.getParameter("grade").trim()))
                                .deduct(false)
                                .builder();

                        DBControl.enlistementStudent(student);
                        student = DBControl.sampling(student.getIdentificationNumberStudent());
                        req.setAttribute("name", student.getNameStudent());
                        req.setAttribute("surname", student.getSurnameStudent());
                        req.setAttribute("patronymic", student.getPatronymicStudent());
                        req.setAttribute("grade", student.getGradeStudent());
                        req.setAttribute("identification", student.getIdentificationNumberStudent());
                        req.setAttribute("profession", student.getProfessionStudent());
                        req.getRequestDispatcher("metodist/successful_enrollment.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("error_identification_number", ConstantText.ERROR_BUSY_IDENTIFICATION_NUMBER);
                        req.setAttribute("name", req.getParameter("name"));
                        req.setAttribute("surname", req.getParameter("surname"));
                        req.setAttribute("patronymic", req.getParameter("patronymic"));
                        req.setAttribute("grade", req.getParameter("grade"));
                        req.getRequestDispatcher("metodist/enlistement.jsp").include(req, resp);
                    }
                } else {/* код ошибки ввода фамилии имени и отчества*/
                    req.setAttribute("error_identification_number", ConstantText.ERROR_NOT_TEMPLATE_GRADE);
                    req.setAttribute("name", req.getParameter("name"));
                    req.setAttribute("surname", req.getParameter("surname"));
                    req.setAttribute("patronymic", req.getParameter("patronymic"));
                    req.getRequestDispatcher("metodist/enlistement.jsp").include(req, resp);
                }
            } else {/*кодошибки не верно введеного идентификационого номера*/
                req.setAttribute("error_identification_number", ConstantText.ERROR_NOT_TEMPLATE_IDENTIFICATION_NUMBER);
                req.setAttribute("name", req.getParameter("name"));
                req.setAttribute("surname", req.getParameter("surname"));
                req.setAttribute("patronymic", req.getParameter("patronymic"));
                req.setAttribute("grade", req.getParameter("grade"));
                req.getRequestDispatcher("metodist/enlistement.jsp").include(req, resp);
            }
        } else {
            req.setAttribute("error_input_name", ConstantText.ERROR_ENLISTEMENT_INPUT_NAME);
            req.setAttribute("name", req.getParameter("name"));
            req.setAttribute("surname", req.getParameter("surname"));
            req.setAttribute("patronymic", req.getParameter("patronymic"));
            req.setAttribute("grade", req.getParameter("grade"));
            req.setAttribute("identification", req.getParameter("identification"));
            req.getRequestDispatcher("metodist/enlistement.jsp").include(req, resp);
        }

    }

}