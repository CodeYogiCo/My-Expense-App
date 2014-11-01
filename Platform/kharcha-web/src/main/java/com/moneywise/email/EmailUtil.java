package com.moneywise.email;
 
import java.io.IOException;
import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.moneywise.model.Inmates;
 
public class EmailUtil {
 
    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     * @return 
     */
    public static String sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
          MimeMessage msg = new MimeMessage(session);
          //set message headers
          msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
          msg.addHeader("format", "flowed");
          msg.addHeader("Content-Transfer-Encoding", "8bit");
 
          msg.setFrom(new InternetAddress("no_reply@journaldev.com", "NoReply-Vishal"));
 
          msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));
 
          msg.setSubject(subject, "UTF-8");
 
          msg.setText(body, "UTF-8");
          msg.setContent(createTemplate(),"text/HTML");
          
         // createTemplate();
 
          msg.setSentDate(new Date());
 
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
          System.out.println("Message is ready");
          Transport.send(msg);  
 
          System.out.println("EMail Sent Successfully!!");
          
        }
        catch (Exception e) {
          e.printStackTrace();
        }
        return "Email Sent Successfully";
    }

	private static String createTemplate() throws IOException {
		// TODO Auto-generated method stub
		Inmates inmates= new Inmates();
		inmates.setInmates_names("vishal");
		
		TemplateLoader loader= new ClassPathTemplateLoader("/templates/",".html");
		Handlebars handlebars= new Handlebars(loader);
		Template template= handlebars.compile("Email");
		return template.apply(inmates);
		
	}
}