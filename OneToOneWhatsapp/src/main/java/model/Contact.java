package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contact1")
@Setter
@Getter

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactId")
    private int contactId;
    @Column(name = "contactNum")
    private long contactNum;
    @Column(name = "holderName")
    private String holderName;
    @Column(name = "serviceProvider")
    private String serviceProvider;
    @Column(name = "fiveGorNot")
        private String fiveGorNot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "whatsAppRef")
    private WhatsApp whatsAppRef;
}
