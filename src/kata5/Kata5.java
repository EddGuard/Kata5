/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MailListReader lector = new MailListReader();
        String ruta = "email.txt";
        List<String> lista = lector.read(ruta);
        SelectApp app = new SelectApp(lista);
        app.createNewTableEmail();
        app.insert();
        app.list();
    }
    
}
