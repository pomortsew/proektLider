package logicProgramm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationString {


    private static Pattern pattern = Pattern.compile("");
    private static Matcher matcher;

    //валидация введеного пароля, пароль может содержать не менее 8 символов верхнего и нижнего регистра английского алфавита а также символы  ._!#$%^&*
    public static final boolean validationPassword(final String password) {
        boolean flag = false;
        pattern = Pattern.compile("^([\\.\\_\\!\\#\\$\\%\\^\\&\\*\\+0-9A-Za-z]{1,})*$");
        matcher = pattern.matcher(password);
        if (matcher.matches() && password.length() >= 8 && password.trim().length()<40) {
            flag = true;
        }
        return flag;
    }

    //валидация логина только буквы английского алфавита цифры и знаки "_","-","."
    public static final boolean validationLogin(final String login) {
        boolean flag = false;
        pattern = Pattern.compile("^([0-9A-Za-z\\_\\-\\.]{1,})*$");
        matcher = pattern.matcher(login);
        if (matcher.matches() && login.trim().length()>0&&login.trim().length()<40) {
            flag = true;
        }
        return flag;
    }

    //    валидация Имени Фамилии Отчества только буквы русского алфавита.
    public static final boolean validationName(String name) {
//        name.trim();
        pattern = Pattern.compile("([А-Яа-я]*)");
        matcher = pattern.matcher(name);
        boolean flag = false;
        if (matcher.matches() && name.trim().length()>0 &&name.trim().length()<40) {
            flag = true;
        }
        return flag;
    }

    //валидация идентификационого номера шаболн
    //буквы русского и английского алфавита цифры
    //знак "."  или  "_" или "-"или "/" один раз
    //буквы русского и английского алфавита цифры
    //знак "."  или  "_" или "-" или "/" один раз
    //буквы русского и английского алфавита цифры

    public static final boolean validationIdentificationNumber(String number) {
        pattern = Pattern.compile("^([a-zA-ZА-Яа-я0-9]{1,})*\\/([a-zA-ZА-Яа-я0-9]{1,})*\\-([a-zA-ZА-Яа-я0-9]{1,})$");
        matcher = pattern.matcher(number);
        boolean flag = false;
        if (matcher.matches() && number.trim().length()>0 &&number.trim().length()<40 ) {
            flag = true;
        }
        return flag;
    }
//    валидация номера группы формат
//    ТЕКСТ знак "-" или "/" или "_" ТЕКСТ знак "-" или "/" или "_" ТЕКСТ
    public static final boolean validationGrade(String garde) {
        pattern = Pattern.compile("^([a-zA-ZА-Яа-я0-9]{1,})*\\-([a-zA-ZА-Яа-я0-9]{1,})*\\-([a-zA-ZА-Яа-я0-9]{1,})$");
        matcher = pattern.matcher(garde);
        boolean flag = false;
        if (matcher.matches() && garde.trim().length() >0 &&garde.trim().length()<40) {
            flag = true;
        }
        return flag;
    }
    //валидация email, шаблон email@gmail.com e_mail.@gmail.com E-ma_il.@gmail.com и т.д.
    public static final boolean validationEmail(String email) {
        String emailCheck = "^[a-zA-Z0-9]{1,}  ((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,}) *@[a-zA-Z0-9]{1,}" +
                "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*" +
                "\\.[a-zA-Z]{2,}$";
        String str = "('^[\\w-_.]*[\\w-_.]@[\\w].+[\\w]+[\\w]$')";
        pattern = Pattern.compile(emailCheck);
        matcher = pattern.matcher(email);
        boolean flag = false;
        if (matcher.matches() && email.trim().length() >0 &&email.trim().length()<40) {
            flag = true;
        }
        return flag;
    }

    //перводит все символы строки  нижнего регистра в верхний регистр и возвращает строку переписаную в верхний регистр
    public static final String pipelinedToUpperCase(String stringInput) {
        final String result = stringInput;
        return result.toUpperCase();
    }

    //удаляет пробелы в начале и в конце строки
    public static final String notSpaceStartAndEnd(String stringInput) {
        return stringInput.trim();
    }
}
