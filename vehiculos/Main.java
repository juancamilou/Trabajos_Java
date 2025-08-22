package vehiculos;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Moto("BMW", "BWM18H", 0, "Rojo", "Marcos"));
        vehiculos.add(new Carro("Mazda", "MZH921", 0, "Camilo", "4", "Negro"));
        vehiculos.add(new Moto("Yamaha", "YMH777", 0, "Azul", "Laura"));

        for (Vehiculo v : vehiculos) {
            System.out.println("----------------------------");
            System.out.println(v.mostrarDatos());
            v.potencia();
            System.out.println(v.mostrarDatos());
        }
    }
}
