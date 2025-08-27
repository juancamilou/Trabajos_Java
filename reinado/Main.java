package reinado;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Personaje> personajes = new ArrayList<>();
        Mago gandalf = new Mago(
            "Anillo escondido en las profundidades ",  
            "Humano",           
            "Hechizo de fuego",  
            "Gandalf",           
            50,                  
            900                  
        );
        Mago carrius = new Mago(
            "No le gusta su habilidad ",  
            "Escarrous",           
            "Hechizo de agua",  
            "Carious",           
            50,                  
            900                  
        );
        
        Barbaros conan = new Barbaros(
            "Tiene un tesoro",   
            "Humano",             
            "Golpe brutal",       
            "Conan",              
            40,                   
            500,                  
            300,
            250                   
        );
        Barbaros guava = new Barbaros(
            "Es cacorro",   
            "Humano",             
            "Escondite masivo",       
            "Careguava",              
            1,                   
            0,                  
            0,
            2                   
        );
        personajes.add(gandalf);
        personajes.add(conan);
        personajes.add(carrius);
        personajes.add(guava);
        System.out.println("------------Combate----------------");
        gandalf.combatir(conan);
        System.out.println("-------------Fin Combate---------------");


        for (Personaje p : personajes) {
            System.out.println("----------------------------");
            p.mostrarDatos();
            System.out.println("----------------------------");
            p.accion();
            System.out.println("----------------------------");
            p.mostrarDatos();
        }
    }
}
