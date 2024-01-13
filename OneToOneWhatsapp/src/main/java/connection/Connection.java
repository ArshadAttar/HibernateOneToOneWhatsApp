package connection;

import model.Contact;
import model.WhatsApp;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    public static SessionFactory connectionHelper(){
        Configuration cfg=new Configuration().configure();
        cfg.addAnnotatedClass(Contact.class);
        cfg.addAnnotatedClass(WhatsApp.class);

        SessionFactory factory=cfg.buildSessionFactory();
        return factory;
    }
}
