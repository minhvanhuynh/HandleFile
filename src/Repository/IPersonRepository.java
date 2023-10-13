/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import model.Person;

/**
 *
 * @author This PC
 */
public interface IPersonRepository {
    public void findPersonInfo(ArrayList<Person> persons);
    
    public void copyTextToNewFile(ArrayList<Person> persons);
    
}
