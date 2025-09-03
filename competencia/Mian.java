package competencia;

import java.util.ArrayList;

public class Mian {
    public static void main(String[] args) {
        ArrayList<Inventor> participantes = new ArrayList<>();
        Mecanica lau = new Mecanica("Laura", 25, 20, 5, "La optimus", 6, "Industrial",0);
        Software car = new Software("Carlos", 27, 50, 3, "Good barner", 10, "Java,Postgres,React",0);
        Quimico max = new Quimico("Maximus", 30, 90, 10, "El debora", 12, "Cianuro,Acido,Bicarbonato",0);

        participantes.add(lau);
        participantes.add(car);
        participantes.add(max);
        
        for (Inventor v : participantes) {
            v.mostrarInv();
        }
        for (Inventor p : participantes) {
            System.out.println("--------Presentación De Inventos--------");
            p.presentaciónInv();
            System.out.println("------------------------------------");
        }
        lau.setPuntos(20);
        car.setPuntos(30);
        max.setPuntos(10);
        
        for (Inventor v : participantes) {
            v.mostrarInv();
        }
        if (lau.getPuntos() > car.getPuntos() && lau.getPuntos() > max.getPuntos()) {
            System.out.println("La ganadora es Laura con " + lau.getPuntos() + " puntos");
        } else if (car.getPuntos() > lau.getPuntos() && car.getPuntos() > max.getPuntos()) {
            System.out.println(" El ganador es Carlos con " + car.getPuntos() + " puntos");
        } else {
            System.out.println("El ganador es Maximus con " + max.getPuntos() + " puntos");
        }

    }
}
