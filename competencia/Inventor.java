// En una feria de ciencia se organiza una competencia de inventores.
// Todos los inventores tienen datos en común como nombre, edad y nivel de creatividad, pero cada uno desarrolla un tipo diferente de invento.

// Unos construyen máquinas mecánicas.

// Otros crean programas de software.

// Algunos diseñan experimentos químicos.

// La organización de la feria exige reglas claras:

// Los datos sensibles (como el nivel de creatividad) deben estar protegidos y solo se pueden modificar mediante métodos específicos, por ejemplo, al ganar puntos en la competencia.

// Cada inventor debe mostrar su invento de forma única frente al jurado.

// Tu misión

// Crea una clase base que represente a un inventor con sus datos principales y métodos controlados.

// Diseña al menos tres tipos de inventores, cada uno con una forma distinta de “presentar su invento”.

// Aplica herencia, encapsulamiento y polimorfismo para que, al recorrer una lista de inventores, cada uno muestre su estilo particular de presentación.

// Haz un programa principal donde se registren varios inventores, se les otorguen puntos de creatividad según la competencia, y finalmente todos presenten sus inventos al jurado.
package competencia;

public class Inventor {
    public String nombre;
    public Integer edad;
    private Integer nivelCrea;
    private Integer xp;
    private String nombreInv;
    private Integer horas;
    private Integer puntos;

    Inventor(String nombre, Integer edad, Integer nivelCrea, Integer xp, String nombreInv, Integer horas,
            Integer puntos) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivelCrea = nivelCrea;
        this.nombreInv = nombreInv;
        this.horas = horas;
        this.puntos = puntos;
    }

    public Integer getNivel() {
        return nivelCrea;
    }

    public void setNivel(Integer nivel) {
        if (nivel >= 0) {
            this.nivelCrea = nivel;
        }
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xpInv) {
        if (xpInv >= 0) {
            this.xp = xpInv;
            System.out.println("El invventor " + nombre + " tiene una experiencia haciendo estos inventos de " + xp);
        }
    }

    public void mostrarInv() {
        System.out.println("--------Inventor--------");
        System.out.println("Categoria: " + getClass() + " |Nombre: " + nombre + " |Edad: " + edad
                + " |Nivel De Creatividad: " + nivelCrea + " |Puntos: " + getPuntos());
        System.out.println("----------------------");
    }

    public void presentaciónInv() {
    }

    public String getNomInv() {
        return nombreInv;
    }

    public void setNomInv(String name) {
        this.nombreInv = name.toLowerCase().trim();
    }

    public Integer getHor() {
        return horas;
    }

    public void setHor(Integer hr) {
        if (hr == 0) {
            System.out.println("El numero de horas debe ser mayor a 0 ");
        } else {
            this.horas = hr;
        }
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer points) {
        if (points > 0) {
            this.puntos += points;
        }
    }
}
