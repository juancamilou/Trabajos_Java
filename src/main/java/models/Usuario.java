package src.main.java.models;

public class Usuario {
    private Long id;
    private String nombre;
    private Long edad;

    public Usuario(String nombre, Long edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public Usuario(Long id, String nombre, Long edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public Long getEdad() {
        return edad;
    }
    public Long getId() {
        return id;
    }
}
