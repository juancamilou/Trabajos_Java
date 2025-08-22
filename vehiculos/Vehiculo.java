package vehiculos;

public class Vehiculo {
    private String marca;
    private String placa;
    public Integer velocidad;
    private String propietario;

    Vehiculo(String marca, String placa, Integer velocidad, String propietario){
        this.marca = marca;
        this.placa = placa;
        this.velocidad = 0;
        this.propietario = propietario;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getPlaca(){
        return placa;
    }

    public void setpropietario(String propietario){
        this.propietario = propietario;
    }

    public String getpropietario() {
        return propietario;
    }

    public void potencia() {
    };

public String mostrarDatos() {
    return "Propietario Vehiculo: " + getpropietario() +
           " | Velocidad: " + velocidad + " km/h" +
           " | Placa: " + getPlaca() +
           " | Marca: " + getMarca();
}

}