/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocoformpruebas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 *
 * @author Samantha
 */
public class Query {
 

    
    
    public static void selectJPQL(String[]  parametros,String tabla[], String[][] where)
    {
        String query ="select";
  query+=(" "+parametros[0]);
    int x=0;
      for (String elemento:parametros){
          if(x==0){
          
          }
          else{
          query+=(","+elemento);
          }
          x++;
          
      }
      
      int y=0;
      query+= " from ";
      query+=tabla[0];
      for (String tablas:tabla){
          if(y==0){
          
          }
          else{
          query+=(","+tablas);
          }
          y++;
          
      }
      
    if(where[0][0]==""){
    
    }
    else{
    
     query+= " where ";
      query+=where[0][0]+" "+where[0][1]+" "+where[0][2];
    
    
    }
    
    
    
    
    for (String tablas:tabla){
          if(y==0){
          
          }
          else{
          query+=(","+tablas);
          }
          y++;
          
      }
    
    
    
    
        System.out.println(query);  
      
      
      
      
          System.out.println(query);
      
      
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
