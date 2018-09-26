/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.time.LocalDate;

/**
 *
 * @author Christoph
 */
public class Schueler {
    private String name;
    private int age;
    private LocalDate birthday;

    public Schueler(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.age = LocalDate.now().getYear()-birthday.getYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
  
    
}
