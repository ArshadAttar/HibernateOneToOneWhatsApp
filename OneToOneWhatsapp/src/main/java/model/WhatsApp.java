package model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "WhatsApp")
@Getter
@Setter

public class WhatsApp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "whatsappId")
    @SequenceGenerator(name = "whatsappId",initialValue = 2001,allocationSize = 2000)
    @Column(name = "whatsappId" )
    private int whatsappId;
    @Column(name = "whatsAppNum")
    private long whatsAppNum;
    @Column(name = "whatsAppName")

    private String whatsAppName;
    @Column(name = "about")
    private String about;

    @Column(name = "accountType")
    private String accType;
}
