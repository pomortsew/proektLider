package logicProgramm;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SenderEmail {

public void dispatchEmailStudent (String message, String recipientAddress) {

    try {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
//        email.setAuthenticator(new DefaultAuthenticator("pomortsew1897@gmail.com", "yflt;lfgtnhjdyf"));
        email.setAuthenticator(new DefaultAuthenticator("pomortsew1897@gmail.com", "yflt;lfgtnhjdyf"));
        email.setSSLOnConnect(true);
        email.setFrom("pomortsew1897@gmail.com");
        email.setSubject("Тест Отправки");
        email.setMsg(message);
        email.addTo(recipientAddress);
        email.send();
        System.out.println("сообщение отправлено");
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
