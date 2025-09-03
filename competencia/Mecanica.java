package competencia;

public class Mecanica extends Inventor {
    private String tipoMaq;
    
    Mecanica(String nombre, Integer edad, Integer nivelCrea,Integer xp,String nombreInv,Integer horas,String tipoMaq,Integer puntos) {
        super(nombre, edad, nivelCrea, xp, nombreInv, horas,puntos);
        this.tipoMaq = tipoMaq;
    }

    public String getTipo() {
        return tipoMaq;
    }

    public void setTipo(String tp) {
        this.tipoMaq = tp.toLowerCase().trim();
    }

    @Override
    public void presentaciónInv() {
        System.out.println("--------Inventor " + nombre + " Categoria: "+ getClass()+ " --------");
        System.out.println("Buenas dias, Hoy presentare el invento a el cual denomine " + getNomInv()+ " este es un proyecto de mecanica de tipo "+ getTipo() + ". El cual me tarde realizando " + getHor() + " horas, agregando que mi familiarización con esta mecanica es de " +getXp() + " años");
    }
}
