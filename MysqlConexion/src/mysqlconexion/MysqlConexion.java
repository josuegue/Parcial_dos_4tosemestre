/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlconexion;

import com.Dominio.ClassVendedor;
import com.Mysql.ClassVendedorDB;
import java.util.*;

/**
 *
 * @author USUARIOTC
 */
public class MysqlConexion {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassVendedorDB vendedor = new ClassVendedorDB();
        if(vendedor.buscar_Usuario("jos", "56789")){
            System.out.println("EXISTE");
            
        }
        else {
            System.out.println("No existe");
        }
        
        
//        menu();


        // TODO code application logic here
    }
    private static  void menu(){
       ClassVendedorDB n_Vendedores = new ClassVendedorDB();
       Scanner sn = new Scanner(System.in);
       int op=0;
        do {  

            System.out.print("\n-------------- preciona 0 para salir ----------------"
                    + ""
                    + "\n1. - Ingresar informacion "
                    + "\n2. - Actualizar informacion"
                    + "\n3. - Ver lista de vendedores"
                    + "\n4. - Eliminar vendedor "
                    + "\nIngresa la opcion:  ");
            op=sn.nextInt();
            sn.nextLine();
        
        switch(op){
            case 0:
                System.out.println("\nAdios cuate...");
                break;
            case 1:  
                System.out.println("\nIngresa informacion");
                String nombre;
                String apellido;
                double enero;
                double febrero;
                double marzo;
                System.out.print("Ingresa el nombre: ");
                nombre=sn.nextLine();
                System.out.print("Ingresa el apellido: ");
                apellido=sn.nextLine();
                System.out.print("Ingresa la cantidad de enero: ");
                enero=sn.nextDouble();
                System.out.print("Ingresa la cantidad de febrero: ");
                febrero=sn.nextDouble();
                System.out.print("Ingresa la cantidad de marzo: ");
                marzo=sn.nextDouble();
                sn.nextLine();
                n_Vendedores.insertar_informacion(nombre, apellido, enero, febrero, marzo);
                break;
            case 2: 
                System.out.println("\n Actualizar informacion ");
                int id;
                String nom;
                System.out.print("Ingresa el nombre: ");
                nom=sn.nextLine();
                System.out.print("Ingresa el id: ");
                id=sn.nextInt();
                sn.nextLine();
                n_Vendedores.actulaizar_informacion(id, nom);
                break;
            case 3:
                System.out.println("\n-------------------- Lista de vendedores --------------------");
                List <ClassVendedor> vendedores = n_Vendedores.seleccion();
                int i=1;
                for (ClassVendedor vnd: vendedores){
                System.out.println(i+". - Vendedor = "+vnd);
                i++;
                }
                break;
            case 4:
                System.out.println("\n Eliminar vendedor ");
                int id_vnd=0;
                System.out.print("Ingresa el id del vendedor:");
                id_vnd=sn.nextInt();
                sn.nextLine();
                 n_Vendedores.eliminar_informacion(id_vnd);
                break;
                default:
                    System.out.println("\nError de opcion");
                
        }
        
            
        } while (op!=0);
    }
}
