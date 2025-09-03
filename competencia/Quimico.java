package competencia;

public class Quimico extends Inventor {
    private String componts;

    Quimico(String nombre, Integer edad, Integer nivelCrea, Integer xp, String nombreInv, Integer horas,String componts,Integer puntos) {
        super(nombre, edad, nivelCrea, xp, nombreInv, horas,puntos);
        this.componts = componts;
    }

    public String getCompo() {
        return componts;
    }

    public void setCompo(String compo) {
        this.componts = compo.toLowerCase().trim().replace(" ", ",");
    }
    @Override
    public void presentaciónInv() {
        System.out.println("--------Inventor " + nombre + " Categoria: "+ getClass()+ "--------");
        System.out.println("Sean todos bienvenidos a la nueva era de la ciencia, hoy les presento a "+ getNomInv()+ " mi mejor invento, este  fue realizado mediante "+ getCompo() + " tardandome así alrededor de " + getHor()+ " para finalizarlo, ademas llevo " + getXp()+ " años "+ " en esta industria");
    }
}
