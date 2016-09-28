package mx.com.rteck.puppy;

import android.app.ProgressDialog;
import android.content.pm.PackageInstaller;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class Contacto extends AppCompatActivity {

    private final Properties properties = new Properties();

    private String password;

    private Session session;

    TextInputEditText nombre;
    TextInputEditText email;
    TextInputEditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar miAccionBar = (Toolbar) findViewById(R.id.miAccionBar);
        setSupportActionBar(miAccionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }
    private void init() {

        properties.put("mail.smtp.host", "mail.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port",25);
        properties.put("mail.smtp.mail.sender",email.getText());
        properties.put("mail.smtp.user", "usuario");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);

    }

    public void enviarEmail()
    {
        init();
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getText().toString()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("gerardo.monreal.imt@gmail.com"));
            message.setSubject(nombre.getText().toString());
            message.setText(mensaje.getText().toString());
            Transport t = session.getTransport("smtp");
            t.connect((String)properties.get("mail.smtp.user"), "password");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }catch (MessagingException me){

            return;
        }

    }




}
