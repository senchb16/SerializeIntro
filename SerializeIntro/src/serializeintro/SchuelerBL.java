/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

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
    }
    
}
