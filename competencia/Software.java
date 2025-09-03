package competencia;

public class Software extends Inventor {
    private String lenguaje;
    Software(String nombre, Integer edad, Integer nivelCrea, Integer xp, String nombreInv,Integer horas, String lenguaje,Integer puntos) {
        super(nombre, edad, nivelCrea, xp, nombreInv, horas,puntos);
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lengu) {
        this.lenguaje = lengu.toLowerCase().trim().replace(" ", ",");
    }
    @Override
    public void presentaciónInv() {
        System.out.println("--------Inventor " + nombre + " Categoria: "+ getClass()+"--------");
        System.out.println("Hoy presentare a " + getNomInv() + " este revoluciona todo la tecnologia mediante sensores integrados, todo esto fue hecho con " + getLenguaje()+ " Para este proyecto me tarde alrededor de " + getHor() + " horas, llevo trabajando con Develop " + getXp() + " años");
    }
}
