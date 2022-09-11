module LearnJPA {
    requires java.sql;
    requires com.h2database;
    requires java.persistence;
    requires java.naming;
    requires java.xml.bind;
    requires com.fasterxml.classmate;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires net.bytebuddy;

    opens org.signature.model;
    opens org.signature;
}