// En un reino lejano, diferentes tipos de personajes habitan y cada uno guarda un secreto. Todos comparten rasgos comunes que los hacen parte del mismo mundo, pero a la hora de actuar, cada uno responde de manera única: algunos sorprenden con su fuerza, otros con su inteligencia, y otros con habilidades inesperadas.

// Sin embargo, no cualquiera puede modificar sus datos más importantes, ya que están protegidos bajo reglas estrictas que solo permiten cambios de forma controlada.

// Tu misión es crear en Java un programa que modele este mundo de personajes, asegurando que:

// Los aspectos comunes estén organizados en un mismo lugar.

// Cada tipo de personaje pueda expresar sus propias variaciones en las acciones.

// La información delicada esté resguardada para que no cualquiera la manipule directamente.
package reinado;
public class Personaje {
    private String secreto;
    private String raza;
    private String habilidadInes;
    private String nombre;
    private Integer nivel;

    Personaje(String secreto, String raza, String habilidadInes, String nombre,Integer nivel) {
        this.secreto = secreto;
        this.raza = raza;
        this.habilidadInes = habilidadInes;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getSecreto()
    {
        return secreto;
    }

    public String getRaza() {
        return raza;
    }
    public String getNombre() {
        return nombre;
    }
    

    public String getHabilidadInes() {
        return habilidadInes;
    }

    public Integer getNivel() {
        return nivel;
    }
    
    public void setHabilidadInes(String habilidadInes) {
        this.habilidadInes = habilidadInes;
    }


    public void setNivel(Integer subirnivel) {
        this.nivel = subirnivel;
        System.out.println();
    }

    public void setSecreto(String nuevosecreto) {
        this.secreto = nuevosecreto;
    }

    public void accion() {}

    public void mostrarDatos() {
    };
    public void combatir(Personaje enemigo){};

}
