module br.com.senac.integrativeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens br.com.senac.integrativeproject to javafx.fxml;
    exports br.com.senac.integrativeproject;
    exports br.com.senac.integrativeproject.SQL;
    opens br.com.senac.integrativeproject.SQL to javafx.fxml;
}