
import controller.ProgramHandlesFiles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author This PC
 */
public class Main {
    public static void main(String[] args) {
        String title= "========== File Processing =========";
        String[] s= new String[] {"Find person info", "Copy Text to new file", "Exit"};
        new ProgramHandlesFiles(title, s).run();
    }
}
