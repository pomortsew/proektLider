package student;

/* клас студент промежуточный класс между базой данных и сервлетом **/
public class Student {

    private final String surnameStudent;                   //фамилия  студента
    private final String nameStudent;                      //имя студента
    private final String patronymicStudent;                //отчество студента
    private final String identificationNumberStudent;      //индетификационный номер студента
    private final String contactStudent;                   //контакты студента
    private final String gradeStudent;                     //класс студента
    private final String loginStudent;                     //логин студента
    private final String passwordStudent;                  // пароль студента
    private final String professionStudent;                //профессия студента
    private final boolean earlyStudentRegistration;          //индикатор предыдущих регистраций
    private final boolean deduct;                           //отчисление приостановка
    private final String receiptDate;                        //дата зачисления
    private final String dateOfRegistration;                 //дата регистрации
    private final int cours;                                 //курс обучения
    private final int onTheBase;                             // на базе 9 или 11 класов
    private final String messageStudent;                    //сообщение студенту

    public int getCours() {
        return cours;
    }


    public String getSurnameStudent() {
        return surnameStudent;
    }

    public String getMessageStudent() {
        return messageStudent;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getPatronymicStudent() {
        return patronymicStudent;
    }

    public String getIdentificationNumberStudent() {
        return identificationNumberStudent;
    }

    public String getContactStudent() {
        return contactStudent;
    }

    public String getGradeStudent() {
        return gradeStudent;
    }

    public String getLoginStudent() {
        return loginStudent;
    }

    public String getPasswordStudent() {
        return passwordStudent;
    }

    public String getProfessionStudent() {
        return professionStudent;
    }

    public boolean getEarlyStudentRegistration() {
        return earlyStudentRegistration;
    }

    public boolean getDeduct() {
        return deduct;
    }

    Student(final StudentBuilder studentBuilder) {
        this.surnameStudent = studentBuilder.getSurnameStudent();
        this.nameStudent = studentBuilder.getNameStudent();
        this.patronymicStudent = studentBuilder.getPatronymicStudent();
        this.identificationNumberStudent = studentBuilder.getIdentificationNumberStudent();
        this.contactStudent = studentBuilder.getContactStudent();
        this.gradeStudent = studentBuilder.getGradeStudent();
        this.loginStudent = studentBuilder.getLoginStudent();
        this.passwordStudent = studentBuilder.getPasswordStudent();
        this.professionStudent = studentBuilder.getProfessionStudent();
        this.earlyStudentRegistration = studentBuilder.getEarlyStudentRegistration();
        this.deduct = studentBuilder.getDeduct();
        this.receiptDate = studentBuilder.getReceiptDate();
        this.dateOfRegistration = studentBuilder.getDateOfRegistration();
        this.cours = studentBuilder.getCoursStudent();
        this.onTheBase = studentBuilder.getOnTheBaseStudent();
        this.messageStudent = studentBuilder.getMessageStudent();
    }


}

