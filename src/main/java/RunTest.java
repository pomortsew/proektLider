import dataBase.DBControl;
import student.Student;

public class RunTest {




        public static void main(String[] args) {
            final String login="pomortsew";
            final String password="qwerty";

            if(DBControl.userVerification(login,password)){
                Student student=DBControl.sampling(DBControl.userGettingID(login,password));
                System.out.println(student.getNameStudent());
            }else {

            }

//            System.out.println(DBControl.userVerification("qwerty","qwer"));
//            System.out.println(DBControl.scaningLogin("qwerty"));
//            List stud=DBControl.getListStident();
//
//            System.out.println(DBControl.getListStident().get(2).getNameStudent());
//Student student= (Student) stud.get(1);
//student.getIdentificationNumberStudent();
//            System.out.println(student.getNameStudent());
//
//            List<Student> name3=DBControl.getListStident();
//
//           String mmm= name3.iterator().next().getNameStudent();
//
//            System.out.println(name3);
//            System.out.println(name3.listIterator().next().getNameStudent());
//
//            String grade ="успех";
//            List<Student> student=DBControl.getListStidentOfGrade(grade);
//            System.out.println(student);
//            Date date=new Date();
//            System.out.println(date.toString());
//            ArrayList<String> arrayList=new ArrayList<>();
//            arrayList.add("001");
//            arrayList.add("001");
//            arrayList.add("001");
//            arrayList.add("002");
//            arrayList.add("002");
//            arrayList.add("002");
//            arrayList.add("003");
//            arrayList.add("003");
//            arrayList.add("003");
//            arrayList.add("004");
//            System.out.println(DBControlMetodist.gradeList(arrayList).toString());
//            System.out.println(DBControl.gradeList().toString());
//
//
//            System.out.println(arrayList.toString());
//
//
DBControl.messageStudentInstal("Привет это сообщение персональное  " ,"45/25-654444");
























            //            String s=new String();
////            s.trim();
//            System.out.println(ValidationString.validationGrade("аа-15-78"));
//            System.out.println(ValidationString.validationIdentificationNumber("кс"));
//            System.out.println(ValidationString.validationLogin("griii)))y_141140"));
//            System.out.println(DBControl.getListStident());
////            System.out.println(ValidationString.pipelinedToUpperCase("dhfjgkd"));
////
////            System.out.println(ValidationString.validationName("   Имя".trim()));
////            System.out.println(ValidationString.validationPassword("prive!erty"));
////            System.out.println(ValidationString.validationLogin(s.trim()));
////
//            System.out.println( DBControl.userVerification("a","w"));
////
//            String str=ValidationString.pipelinedToUpperCase("nnnnnnn");
//            System.out.println(str.toUpperCase());
//            System.out.println(ValidationString.validationEmail("pomortsew@mail.ru"));
//            System.out.println(ValidationString.validationIdentificationNumber("КС//12-87"));
//
//Student st=new StudentBuilder()
//        .nameStudent("wer")
//        .builder();
//        System.out.println(st.getNameStudent());
//        Student student=new StudentBuilder(DBControl.sampling("14081987"))
//                .loginStudent("login1")
//                .passwordStudent("password1")
//                .builder();
//        System.out.println(student.getIdentificationNumberStudent());
//        System.out.println(student.getSurnameStudent());
//        System.out.println(student.getLoginStudent());
//        System.out.println(student.getPasswordStudent());
//        System.out.println(student.getNameStudent());
//        System.out.println(student.getProfessionStudent());
//        System.out.println(student.getPatronymicStudent());
//        System.out.println(student.getGradeStudent());
//        System.out.println(student.getEarlyStudentRegistration());
//        //System.out.println(DBControl.scaningIditificationNumber("14081987"));



        }




    }


