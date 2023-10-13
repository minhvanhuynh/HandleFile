/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;




/**
 *
 * @author This PC
 */
public class Validation {
    private final static Scanner sc= new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int check= Integer.parseInt(sc.nextLine().trim());
                if(check < min || check > max)
                    throw new Exception();
                else return check;             
            }catch(Exception e){
                System.out.println("Please input number in range ["+min+", "+max+"]!");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public String checkInputString() {
        while (true) {
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }
           
    public boolean checkInputYesNo(){
        while(true){
            String result= checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }else if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }   
    } 
    
    public double checkSalary(String salary){
        double resultSalary= 0;
        try {
            resultSalary= Double.parseDouble(salary);
            if(resultSalary<0){
                resultSalary=0;
            }            
        } catch (Exception e) {
            resultSalary=0;
        }
        return resultSalary;
    }
    
    public double checkMoney(String sentences){
        while(true){
            try {
                System.out.print(sentences);
                String s = checkInputString();
                double money = Double.parseDouble(s);
                if (money >= 0) {
                    return money;
                }
                continue;
            } catch (Exception e) {
                System.err.println("Must be enter number!");
                continue;
            }
        }
    }
    
    public String checkFile(String sentences){
        while(true){
            System.out.print(sentences);
            String nameFile= checkInputString();
            File file= new File(nameFile);
            if(!file.exists() || !file.isFile()){
                System.err.println("Path doesn't exist!");
                continue;
            }
            return nameFile;
        }
    }
    
}