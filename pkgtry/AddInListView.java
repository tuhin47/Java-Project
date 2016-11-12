/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry;

import java.io.File;
import java.util.Scanner;
import javafx.scene.control.ListView;


public class AddInListView {
    private Scanner sc;
    
   
    public ListView<String> add( ListView<String> listView ) 
    {
        try{
        File a=new File(String.format("F:\\folder\\%s.txt",Try.str));
        sc= new Scanner(a);
        while(sc.hasNextLine()){
            listView.getItems().add(sc.nextLine());
            
        }
        }
        catch(Exception e)
        {
            //System.out.println("TADA "+e);
        }
        
       
        //System.out.println("File Close");
        sc.close();
        return listView;
    }
}
