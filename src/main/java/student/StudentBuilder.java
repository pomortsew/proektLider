package student;

/* построитель класса студент **/
public class StudentBuilder {
    private  String surnameStudent;                   //фамилия  студента
    private  String nameStudent;                      //имя студента
    private  String patronymicStudent;                //отчество студента
    private  String identificationNumberStudent;      //индетификационный номер студента
    private  String contactStudent;                   //контакты студента
    private  String gradeStudent;                     //класс студента
    private  String loginStudent;                     //логин студента
    private  String passwordStudent;                  // пароль студента
    private  String professionStudent;                //профессия студента
    private  boolean earlyStudentRegistration;          //индикатор предыдущих регистраций
    private  boolean deduct;                           //отчисление приостановка
    private  String receiptDate;                        //дата зачисления
    private  String dateOfRegistration;                 //дата регистрации
    private  int cours;                                 //курс обучения
    private  int onTheBase;                             // на базе 9 или 11 класов
    private String messageStudent;

    public StudentBuilder(Student student) {
        this.nameStudent = student.getNameStudent();
        this.surnameStudent = student.getSurnameStudent();
        this.patronymicStudent = student.getPatronymicStudent();
        this.identificationNumberStudent = student.getIdentificationNumberStudent();
        this.contactStudent = student.getContactStudent();
        this.gradeStudent = student.getGradeStudent();
        this.professionStudent = student.getProfessionStudent();
        this.earlyStudentRegistration = student.getEarlyStudentRegistration();
        this.deduct = student.getDeduct();
    }

    public StudentBuilder() {

    }


    public StudentBuilder messageStudent(final String messageStudent) {
        this.messageStudent = messageStudent;
        return this;
    }
    public StudentBuilder receiptDate(final String receiptDate) {
        this.receiptDate = receiptDate;
        return this;
    }

    public StudentBuilder onTheBaseStudent(final int onTheBase) {
        this.onTheBase = onTheBase;
        return this;
    }

    public StudentBuilder coursStudent(final int cours) {
        this.cours = cours;
        return this;
    }

    public StudentBuilder dateOfRegistrationStudent(final String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

    public StudentBuilder nameStudent(final String nameStudent) {
        this.nameStudent = nameStudent;
        return this;
    }

    public StudentBuilder surnameStudent(final String surnameStudent) {
        this.surnameStudent = surnameStudent;
        return this;
    }

    public StudentBuilder patronymicStudent(final String patronymicStudent) {
        this.patronymicStudent = patronymicStudent;
        return this;
    }

    public StudentBuilder identificationNumberStudent(final String identificationNumberStudent) {
        this.identificationNumberStudent = identificationNumberStudent;
        return this;
    }

    public StudentBuilder contactStudent(final String contactStudent) {
        this.contactStudent = contactStudent;
        return this;
    }

    public StudentBuilder gradeStudent(final String gradeStudent) {
        this.gradeStudent = gradeStudent;
        return this;
    }

    public StudentBuilder professionStudent(final String professionStudent) {
        this.professionStudent = professionStudent;
        return this;
    }

    public StudentBuilder loginStudent(final String loginStudent) {
        this.loginStudent = loginStudent;
        return this;
    }

    public StudentBuilder passwordStudent(final String passwordStudent) {
        this.passwordStudent = passwordStudent;
        return this;
    }

    public StudentBuilder deduct(final boolean deduct) {
        this.deduct = deduct;
        return this;
    }

    public StudentBuilder earlyStudentRegistration(final boolean registrationFlag) {
        this.earlyStudentRegistration = registrationFlag;
        return this;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public int getOnTheBaseStudent() {
        return onTheBase;
    }

    public int getCoursStudent() {
        return cours;
    }


    public String getSurnameStudent() {
        return surnameStudent;
    }

    public String getMessageStudent() {
        return messageStudent;
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

    public Student builder() {
        return new Student(this);
    }
}
