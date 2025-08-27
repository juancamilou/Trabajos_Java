package reinado;

public class Mago extends Personaje {
    private Integer poder;

    Mago(String secreto, String raza, String habilidadInes, String nombre, Integer nivel, Integer poder) {
        super(secreto, raza, habilidadInes, nombre, nivel);
        this.poder = poder;

    }
    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public void mostrarDatos() {
        System.out.println("Nombre:" + getNombre() + " | Poder Del Mago " + getPoder() + " | Raza " + getRaza() + " | Habilidad "+ getHabilidadInes()+" | Nivel " + getNivel()+ " | Secreto " + getSecreto());
    }
    @Override
    public void accion() {
        System.out.println(getNombre() + " ha tirado " + getHabilidadInes() + " este mago posee un poder de "
                + getPoder() + " puntos");
    }
    public void combatir(Personaje enemigo) {
        Integer daño = poder; 
        System.out.println(getNombre() + " ataca a " + enemigo.getNombre() + " causando " + daño + " de daño.");
    }
}
