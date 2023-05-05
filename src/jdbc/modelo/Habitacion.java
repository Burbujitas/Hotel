package jdbc.modelo;

public class Habitacion {
    private int id;
    private String nombre;
    private int habitaciones;
    private String direccion;

    public Habitacion(int id, String nombre, int habitaciones,String direccion)
    {
        this.id= id;
        this.nombre = nombre;
        this.habitaciones = habitaciones;
        this.direccion= direccion;
    }
    public Habitacion(String nombre ,int habitaciones,String direccion)
    {
        this.nombre = nombre;
        this.habitaciones = habitaciones;
        this.direccion = direccion;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
