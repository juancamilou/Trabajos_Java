package vehiculos;

public class Carro extends Vehiculo {
    public String numPuertas;
    public String color;

    Carro(String marca, String placa, Integer velocidad, String propietario, String numPuertas, String color) {
        super(marca, placa, velocidad, propietario);
        this.numPuertas = numPuertas;
        this.color = color;
    }

    public void setpropietario(String propietario) {
        super.setpropietario(propietario);
    }

    public String getpropietario() {
        return super.getpropietario();
    }

    public String getMarca() {
        return super.getMarca();
    }

    public String getPlaca() {
        return super.getPlaca();
    }

public String mostrarDatos() {
    return "Propietario Carro: " + getpropietario() +
           " | Velocidad: " + velocidad + " km/h" +
           " | Placa: " + getPlaca() +
           " | Marca: " + getMarca() +
           " | Puertas: " + numPuertas;
}

    @Override
    public void potencia(){
        if(velocidad == 0){
            System.out.println("El carro ha acelerado 50km/h");
            velocidad = 50;
        } else {
            velocidad += 20;
            System.out.println("La moto acelero 20km/h ahora va a: " + velocidad + "km/h");
        }
    }


}