package vehiculos;

public class Moto extends Vehiculo{
    public String color;

    Moto(String marca, String placa,Integer velocidad, String color, String propietario){
        super(marca, placa, velocidad, propietario);
        this.color = color;
    }

    public void setpropietario(String propietario){
        super.setpropietario(propietario);
    }

    public String getpropietario(){
        return super.getpropietario();
    }

    public String getMarca(){
        return super.getMarca();
    }

    public String getPlaca(){
        return super.getPlaca();
    }

public String mostrarDatos() {
    return "Propietario Moto: " + getpropietario() +
           " | Velocidad: " + velocidad + " km/h" +
           " | Placa: " + getPlaca() +
           " | Marca: " + getMarca();
}

    @Override
    public void potencia(){
        if(velocidad == 0){
            System.out.println("La moto ha acelerado 30km/h");
            velocidad = 30;
        } else {
            velocidad += 30;
            System.out.println("La moto acelero 30km/h ahora va a: " + velocidad + "km/h");
        }
    }


}