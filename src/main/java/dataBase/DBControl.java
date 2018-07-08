package dataBase;

import student.Student;
import student.StudentBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DBControl {
    private static final String URL_DATA_BASE = "jdbc:mysql://127.0.0.1:3306/Lider_data_base?useUnicode=true&characterEncoding=utf8";
    private static final String LOGIN_DATA_BASE = "root";
    private static final String PASSWORD_DATA_BASE = "pomortsew";
    private static final String ERROR_LOADING_DBMYSQL = "невозможно загрузить драйвер MySQL";

    // метод возвращает соединение с базой данных
    private static Connection getConectionBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // объявление драйвера базы данных
            Connection connectionMySQL = DriverManager// создание подключения к базе данных
                    .getConnection(URL_DATA_BASE, LOGIN_DATA_BASE, PASSWORD_DATA_BASE); // подключение к базе данных
            return connectionMySQL;
        } catch (SQLException e) {
            System.out.println(ERROR_LOADING_DBMYSQL);
        } catch (ClassNotFoundException e) {
            System.out.println(ERROR_LOADING_DBMYSQL);
        }
        return null;
    }

    // зачисление студента на обучение (добавление в базу данных сведений о студенте)
    public final static void enlistementStudent(Student studentInfo) {
        Date date=new Date(new java.util.Date().getTime());
        try {
            PreparedStatement preparedStatement = getConectionBD()
                    .prepareStatement("INSERT  INTO student (" +
                            "surname_student," +
                            "name_student, " +
                            "patronymic_student, " +
                            "table_number_student," +
                            "grade_student, " +
                            "contact_student," +
                            "profession_student," +
                            "registration,deduct,receipt_date) VALUES (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, String.valueOf(studentInfo.getSurnameStudent()));
            preparedStatement.setString(2, String.valueOf(studentInfo.getNameStudent()));
            preparedStatement.setString(3, String.valueOf(studentInfo.getPatronymicStudent()));
            preparedStatement.setString(4, String.valueOf(studentInfo.getIdentificationNumberStudent()));
            preparedStatement.setString(5, String.valueOf(studentInfo.getGradeStudent()));
            preparedStatement.setString(6, String.valueOf(studentInfo.getContactStudent()));
            preparedStatement.setString(7, String.valueOf(studentInfo.getProfessionStudent()));
            preparedStatement.setBoolean(8, studentInfo.getEarlyStudentRegistration());
            preparedStatement.setBoolean(9, studentInfo.getDeduct());
            preparedStatement.setDate(10,date );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Регистрация студента на обучение добавление лоигн- пароль студентом
    public final static void registrationStudent(Student student) {

        try {
//            PreparedStatement preparedStatement=getConectionBD()
//                    .prepareStatement("INSERT INTO students(login,password) VALUES (?,?)");
            PreparedStatement preparedStatement = getConectionBD()
                    .prepareStatement("UPDATE student set login_student=?" +
                            ", password_student=?" +
                            ",registration=?," +
                            "contact_student=? where table_number_student=?");
            preparedStatement.setString(1, student.getLoginStudent());
            preparedStatement.setString(2, student.getPasswordStudent());
            preparedStatement.setBoolean(3, student.getEarlyStudentRegistration());
            preparedStatement.setString(4, student.getContactStudent());
            preparedStatement.setString(5, student.getIdentificationNumberStudent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // метод проверяет существует ли полученый логин в базе данных, если совпадений нет возвращаеn false
    public final static boolean scaningLogin(String login) {
        boolean flag = false;
        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement = getConectionBD()
                    .prepareStatement("SELECT * FROM lider_data_base.student WHERE login_student=?");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next() && resultSet.getString("login_student").equals(login)) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // метод проверяет существует ли полученый номер в базе данных, если совпадений  нет возвращаеn false
    public final static boolean scaningIditificationNumber(String inditificationNumber) {
        boolean flag = false;
        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement = getConectionBD()
                    .prepareStatement("SELECT * FROM lider_data_base.student WHERE table_number_student=?");
            preparedStatement.setString(1, inditificationNumber);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next() && resultSet.getString("table_number_student").equals(inditificationNumber)) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    // метод проверяет введеный пользователем логин и пароль на соответствие в базе данных если все совпадает возвращает true
    public static boolean userVerification(String login, String password) {
        boolean flag = false;

        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            preparedStatement = getConectionBD()
                    .prepareStatement("SELECT * FROM lider_data_base.student WHERE  login_student=?");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                if (password.equals(resultSet.getString("password_student"))) {
                    flag = true;
                    return flag;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

//    возвращает ID студента из базы данных по полученому логину и паролю
public static String userGettingID(String login, String password) {
        String flag;

        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            preparedStatement = getConectionBD()
                    .prepareStatement("SELECT * FROM lider_data_base.student WHERE  login_student=?");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                if (password.equals(resultSet.getString("password_student"))) {
                    flag = resultSet.getString("table_number_student");
                    return flag;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag=null;
    }


    // метод возвращает информацию о студенте из базы данных
    public static Student sampling(String id) {
        Student student;
        try {
            PreparedStatement preparedStatement = getConectionBD().
                    prepareStatement("SELECT * FROM lider_data_base.student WHERE table_number_student=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                         student = new StudentBuilder()
                        .nameStudent(resultSet.getString("name_student"))//иям
                        .surnameStudent(resultSet.getString("surname_student"))//фамилия
                        .patronymicStudent(resultSet.getString("patronymic_student"))//отчество
                        .identificationNumberStudent(resultSet.getString("table_number_student"))//номер
                        .gradeStudent(resultSet.getString("grade_student"))//класс
                        .professionStudent(resultSet.getString("profession_student"))//профессия
                        .earlyStudentRegistration(resultSet.getBoolean("registration"))//регистрация
                        .receiptDate(resultSet.getString("receipt_date"))//дата зачисления
                                 .messageStudent(resultSet.getString("message_student"))
                        .builder();
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student = null;
    }


//возвращает список всех студентов
    public static List<Student> getListStident() {
        Student student;
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConectionBD().
                    prepareStatement("SELECT * FROM lider_data_base.student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new StudentBuilder()
                        .nameStudent(resultSet.getString(1))
                        .surnameStudent(resultSet.getString(2))
                        .patronymicStudent(resultSet.getString(3))
                        .identificationNumberStudent(resultSet.getString(4))
                        .gradeStudent(resultSet.getString(5))
                        .professionStudent(resultSet.getString(6))
                        .earlyStudentRegistration(resultSet.getBoolean(7))
                        .passwordStudent(resultSet.getString(8))
                        .contactStudent(resultSet.getString(9))
                        .loginStudent(resultSet.getString(11))
                        .builder();
                studentList.add(student);
            }
            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList = null;
    }


    public static List<Student> getListStidentOfGrade(String grade) {
        Student student;
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConectionBD().
                    prepareStatement("SELECT * FROM lider_data_base.student WHERE grade_student=?");
            preparedStatement.setString(1, grade);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new StudentBuilder()
                        .nameStudent(resultSet.getString("name_student"))
                        .surnameStudent(resultSet.getString("surname_student"))
                        .patronymicStudent(resultSet.getString(3))
                        .identificationNumberStudent(resultSet.getString(4))
                        .gradeStudent(resultSet.getString(5))
                        .professionStudent(resultSet.getString(6))
                        .earlyStudentRegistration(resultSet.getBoolean(7))
                        .passwordStudent(resultSet.getString(8))
                        .contactStudent(resultSet.getString(9))
                        .loginStudent(resultSet.getString(11))
                        .builder();
                studentList.add(student);
            }
            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList = null;
    }

    //метод возвращает список классов
    public static final List<String> gradeList() {
        List<String> grade = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConectionBD().
                    prepareStatement("SELECT * FROM lider_data_base.student ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            grade.add(resultSet.getString("grade_student"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Set set = new TreeSet(grade);
        grade = new ArrayList<String>(set);
        return grade;
    }


    public static void messageStudentInstal(String message, String id){

        try {
//            PreparedStatement preparedStatement=getConectionBD()
//                    .prepareStatement("INSERT INTO students(login,password) VALUES (?,?)");
            PreparedStatement preparedStatement = getConectionBD()
                    .prepareStatement("UPDATE student set message_student=? where table_number_student=?");

            preparedStatement.setString(1,message);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

