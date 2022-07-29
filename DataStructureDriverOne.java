/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredriverone;

/**
 *
 * @author Jesse
 */
public class DataStructureDriverOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SLList<Integer>list = new SLList<Integer>(); 
        
        list.addFirst(2);
                list.addFirst(1);
        list.addFirst(3);

        
        boolean flag = list.contains(0); 
        System.out.println(list); 
       
        
        if(flag == true)
        {
            System.out.println("True");
        }
        else
        {
                        System.out.println("False");
        }
   
       

    }
    
}
