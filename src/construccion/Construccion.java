/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construccion;
import java.util.*;
import java.util.regex.Pattern;
/**
 *
 * @author enriq
 */
public class Construccion {

    public static void main(String[] args) {
        char respuesta =' ';
        String direccion, pobla, propietario, puerta;
        int numero,cod_postal,n_pisos,planta,metros,n_habitaciones;
        String respuestaDo;
        Edificio e1 = new Edificio ();
        Scanner teclado = new Scanner (System.in);
        String patron_puerta = ("[AB]");

        
        do {
            System.out.println ("1. Construir edificio");
            System.out.println ("2. Construir pisos");
            System.out.println ("3. Modificar un piso dado");
            System.out.println ("4. Buscar un piso");
            System.out.println ("5. Eliminar un piso");
            System.out.println ("6. Mostrar información de todos los pisos");
            System.out.println ("7. Mostrar información del edificio");
            System.out.println ("8. Salir");
            
            System.out.println ("Elige una opción (1-8)");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            
            
            switch (opcion){
                case 1:
                    System.out.println ("Dime la dirección del edificio");
                    direccion = teclado.nextLine();
                    System.out.println ("Dime la población del edificio");
                    pobla = teclado.nextLine();
                    System.out.println ("Dime el número del edificio");
                    numero = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println ("Dime el código postal del edificio");
                    cod_postal = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println ("Dime el número de pisos del edificio");
                    n_pisos = teclado.nextInt();
                    teclado.nextLine();
                    e1 = new Edificio (direccion,pobla,numero,cod_postal,n_pisos);  
                    System.out.println("Edificio creado correctamente");
                    break;
                case 2:
                    System.out.println ("Dime la dirección del edificio donde lo vas a introducir");
                    direccion = teclado.nextLine();
                    System.out.println ("Dime el número del edificio donde vas a insertar los pisos");
                    numero = teclado.nextInt();
                    teclado.nextLine();
                    if (e1.getNumero() == numero && e1.getDireccion().equals(direccion)){
                        System.out.println ("Dime el propietario del piso");
                        propietario = teclado.nextLine();
                        System.out.println ("Dime la puerta del piso");
                        puerta = teclado.nextLine();
                        if (Pattern.matches(patron_puerta,puerta)){
                            System.out.println ("Dime la planta del piso");
                            planta = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println ("Dime los metros cuadrados del piso");
                            metros = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println ("Dime el número de habitaciones del piso");
                            n_habitaciones = teclado.nextInt();
                            teclado.nextLine();
                            if(e1.insertarPiso(propietario, puerta, planta, metros, n_habitaciones) == 0)
                                System.out.println ("Piso introducido con éxito");
                            else if (e1.insertarPiso(propietario, puerta, planta, metros, n_habitaciones) == -1)
                                System.out.println("Array pisos lleno");
                            else if (e1.insertarPiso(propietario, puerta, planta, metros, n_habitaciones) == -2)
                                System.out.println("El piso que querías introducir ya existe");
                        }
                        else 
                            System.out.println("Solo puedes introducir puertas A o B");
                    }
                    else {
                        System.out.println ("El número o la dirección del edificio es incorrecto");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Dime la planta a modificar del piso");
                    planta = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Dime la letra a modificar del piso");
                    puerta = teclado.nextLine();
                    System.out.println ("Dime el nuevo propietario del piso");
                    propietario = teclado.nextLine();
                    if(e1.actualizaPro ( planta,puerta, propietario))
                        System.out.println("Piso actualizado correctamente");
                    else
                        System.out.println("El piso no ha podido ser actualizado");
                    break;
                case 4:
                    System.out.println ("Dime la puerta del piso a buscar");
                    puerta = teclado.nextLine();                   
                    System.out.println ("Dime la planta del piso a buscar");
                    planta = teclado.nextInt();
                    teclado.nextLine();
                    if (e1.buscaPiso(planta, puerta) != -1){
                        int indice = e1.buscaPiso(planta, puerta);
                        System.out.println ("Propietario: "+e1.getPisos()[indice].getPropietario());
                        System.out.println ("Metros: "+e1.getPisos()[indice].getMetros());
                        System.out.println ("N_Habitaciones: "+e1.getPisos()[indice].getHabitaciones());
                                               
                    }
                    else
                        System.out.println("No existe el piso");
                    break;
                case 5:
                    System.out.println ("Dime la puerta del piso a borrar");
                    puerta = teclado.nextLine();                   
                    System.out.println ("Dime la planta del piso a borrar");
                    planta = teclado.nextInt();
                    teclado.nextLine();
                    if(e1.borraPiso(planta, puerta))
                        System.out.println("Piso borrado correctamente");
                    else
                        System.out.println("El piso no ha podido ser borrado");
                    break;
                case 6:
                    e1.listaPisos();
                    break;
                case 7:
                    e1.listaEdificio();
                    break;
                case 8 :
                    break;                   
            }
            if (opcion != 8){
                System.out.println ("¿Quieres salir del programa? S/N");
                respuestaDo = teclado.nextLine();
                respuesta = respuestaDo.toUpperCase().charAt(0);
               /* while (respuesta != 'N' || respuesta != 'S'){
                    System.out.println ("Por favor introduce un valor válido");
                    System.out.println ("¿Quieres salir del programa? S/N");
                    respuestaDo = teclado.nextLine();
                    respuesta = respuestaDo.toUpperCase().charAt(0);              
                }*/
            }
            

        }
        while (respuesta == 'N');
    }
    
}
