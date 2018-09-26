/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Christoph
 */
public class SchuelerBL extends AbstractListModel {
    private ArrayList<Schueler> klasse  = new ArrayList<Schueler>();

    @Override
    public int getSize() {
        return klasse.size();
    }

    @Override
    public Object getElementAt(int i) {
        return klasse.get(i);
    }
    public void add(Schueler s){
        klasse.add(s);
    }
    
    public void save(File f)throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Schueler s : klasse) {
            bw.write(s.getAge());
            bw.write(""+s.getAge());
            bw.write(s.getBirthday().toString());
            bw.newLine();
        }
        bw.flush();
    }
    
    public void load(File f)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while((line = br.readLine())!= null){
            String[] parts = line.split(";");
            try{
                add(new Schueler(parts[0],LocalDate.parse(parts[1])));
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Schueler s1 = new Schueler("Hans", LocalDate.of(12,12,2002));
        Schueler s2 = new Schueler("Franz", LocalDate.of(12, Month.MARCH,2014));
        SchuelerBL bl = new SchuelerBL();
        File f = new File("./Data.csv");
        
        try{
            bl.save(f);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    } 
    
}
