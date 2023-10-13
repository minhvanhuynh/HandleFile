/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.IPersonRepository;
import Repository.PersonRepository;
import java.util.ArrayList;
import model.Person;
import view.Menu;

/**
 *
 * @author This PC
 */
public class ProgramHandlesFiles extends Menu<String>{
    
    private IPersonRepository ipr= new PersonRepository();
    private ArrayList<Person> persons= new ArrayList<>();
    
    public ProgramHandlesFiles(String title, String[] s){
        super(title, s);
    }
    @Override
    public void execute(int n) {       
        switch (n) {
            case 1:
                ipr.findPersonInfo(persons);               
                break;
            case 2:
                ipr.copyTextToNewFile(persons);
                break;
            case 3:
                System.exit(0);
                break;
            
        }
    }
    
}
