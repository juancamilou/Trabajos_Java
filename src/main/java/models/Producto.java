package models;

public class Producto {
    private Long id;
    private String nombre;
    private Long precio;
    private String descripcion;
    private Long cantidad_pro;

    public Producto(String nombre, Long precio, String descripcion, Long cantidad_pro) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad_pro = cantidad_pro;
    }

    public Producto(Long id, String nombre, Long precio, String descripcion, Long cantidad_pro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad_pro = cantidad_pro;
    }

    public Long getCantidad_pro() {
        return cantidad_pro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public Long getId() {
        return id;
    }
    
}
