/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class MailListReader {

    private String file;
    private List<String> listaCorreos;

    public List<String> read(String fileName){
        file = fileName;
        listaCorreos = new LinkedList<>();

        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null){
                if(linea.contains("@")){
                    listaCorreos.add(linea);
                }
            }
        }catch (IOException e){
            System.out.println("Exception reading file: " + e);
        }
        return listaCorreos;
    }
}
