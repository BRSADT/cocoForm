/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocoformpruebas;

/**
 *
 * @author Samantha
 */
public class CocoFormpruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Query sentencia= new Query();

    
    String[] datos={"nombre","edad","tipousuario"};
   String[] tablas={"persona","usuarios"};
     String[][] where={{"nombre", "==", "brenda","&&"}, {"edad","<","18"," "}};
   
   String[][] whereo={{""}};
 sentencia.selectJPQL(datos,tablas,where);
    
    
    }
    
}
