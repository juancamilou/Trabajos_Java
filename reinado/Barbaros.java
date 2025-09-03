package reinado;

public class Barbaros extends Personaje {
    private Integer escudo;
    private Integer fuerza;

    Barbaros(String secreto, String raza, String habilidadInes, String nombre, Integer nivel, Integer poder,
            Integer escudo, Integer fuerza) {
        super(secreto, raza, habilidadInes, nombre, nivel);
        this.escudo = escudo;
        this.fuerza = fuerza;
    }


    public Integer getEscudo() {
        return escudo;
    }
    public Integer getFuerza() {
        return fuerza;
    }
    @Override
    public void accion() {
        System.out.println(getNombre() + " ha llamado a su escuadron, cada uno de ellos tiene un escudo de " + getEscudo());
    }

    public void mostrarDatos() {
        System.out.println("Nombre:" + getNombre() + " | Escudo Del Barbaro " + getEscudo() + " | Raza " + getRaza() + " | Habilidad "+ getHabilidadInes()+" | Nivel " + getNivel()+ " | Secreto " + getSecreto());
    }
    public void combatir(Personaje enemigo) {
        Integer daño = fuerza ; 
        System.out.println(getNombre() + " golpea a " + enemigo.getNombre() + " causando " + daño + " de daño.");
    }    
    
        
}
