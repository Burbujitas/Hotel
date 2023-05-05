package jdbc.modelo;

import java.sql.Date;

public class Reserva {

    private int Id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private double valor;
    private String formaPago;
    private int habitacionId;
    public Reserva(Date fechaEntrada, Date fechaSalida, double valor, String formaPago,int habitacionId) {

        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
        this.habitacionId = habitacionId;
    }
    public Reserva(int Id, Date fechaEntrada, Date fechaSalida, double valor, String formaPago,int habitacionId) {
        this.Id = Id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
        this.habitacionId = habitacionId;
    }
    public Reserva(int Id, Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
        this.Id = Id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
        this.habitacionId = habitacionId;
    }

    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

}
