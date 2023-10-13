/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import model.Person;
import view.Validation;

/**
 *
 * @author This PC
 */
public class PersonDao {
    
    private static PersonDao instance= null;
    private Validation validation;
    
    public PersonDao(){
        validation= new Validation();
    }
    public static PersonDao Instance(){
        if(instance==null){
            synchronized (PersonDao.class) {
                if(instance==null){
                    instance= new PersonDao();
                }
            }
        }
        return instance;
    }
    
    public void findPersonInfor(ArrayList<Person> persons){        
        String pathFile= validation.checkFile("Enter Path: ");       
        getListPerson(persons, pathFile);       
        double money= validation.checkMoney("Enter Money: ");
        printListPerson(persons, money);
    }
    
    public void getListPerson(ArrayList<Person> persons, String pathFile){
        File file= new File(pathFile);       
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] inforPerson = line.split(";");
                persons.add(new Person(inforPerson[0], inforPerson[1], validation.checkSalary(inforPerson[2])));
            }
        } catch (Exception e) {
            System.err.println("Can't read file!");
        }
    }
    
    public void printListPerson(ArrayList<Person> persons, double money){        
        Collections.sort(persons, (o1, o2) -> (int) (o1.getSalary()-o2.getSalary()));
        System.out.println("-------------------- Result -------------------");
        System.out.println(String.format("%-20s%-20s%-20s", "Name","Address", "Money"));
        for (Person person : persons) {
            if(person.getSalary()>=money){
                System.out.println(person);
            }
        }
        System.out.println("Max: "+persons.get(persons.size()-1).getName());
        System.out.println("Min: "+persons.get(0).getName());
    }
    
    public void copyFile(ArrayList<Person> persons){
        System.out.println("---------- Copy Text ----------");       
        String pathIn= validation.checkFile("Enter Source: ");
        System.out.print("Enter new file name: ");
        String pathOut= validation.checkInputString();
        String content= getNewContent(pathIn, persons);
        writeNewFile(pathOut, content);        
    }
    
    public String getNewContent(String pathIn, ArrayList<Person> persons){
        HashSet<String> newContent= new HashSet<>();        
        getListPerson(persons, pathIn);
        try {            
            for (Person person : persons) {
                String[] arrayName= person.getName().split(" ");
                for (String string : arrayName) {
                    newContent.add(string+" ");
                }
                String[] arrayAdd= person.getAddess().split(" ");
                for (String string : arrayAdd) {
                    newContent.add(string+" ");
                }               
                newContent.add(person.getSalary()+" ");
            }
        } catch (Exception e) {
            System.err.println("Can't read file!");
        }
        String content="";
        for (String string : newContent) {
            content+=string;
        }
        return content;
    }
    
    public void writeNewFile(String pathOut, String content){
        File file= new File(pathOut);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.err.println("Error created File!");
            }
        }
        try {
            FileWriter fw= new FileWriter(file);
            BufferedWriter br= new BufferedWriter(fw);
            br.write(content);
            br.close();
            fw.close();
            System.out.println("Copy done...");
        } catch (Exception e) {
            System.err.println("Can't write file!");
        }
    }

}
