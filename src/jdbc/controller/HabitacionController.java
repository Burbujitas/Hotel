package jdbc.controller;

import jdbc.dao.HabitaciónDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Habitacion;
import jdbc.modelo.Huespedes;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class HabitacionController {

    private HabitaciónDao habitaciónDao;

    public HabitacionController()
    {
        Connection connection =new ConnectionFactory().recuperaConexion();
        this.habitaciónDao = new HabitaciónDao(connection);
    }
    public void guardar(Habitacion habitacion)
    {
        this.habitaciónDao.guardar(habitacion);
    }

    public List<Habitacion> listarHabitaciones() {
        return this.habitaciónDao.listarHabitaciones();
    }

    public List<Habitacion> listarHabitacionesId(String id) {
        return this.habitaciónDao.buscarId(id);
    }

    public void actualizar(String nombre, int habitaciones, String direccion, Integer id) {
        this.habitaciónDao.Actualizar(nombre, habitaciones, direccion, id);
    }

    public void Eliminar(Integer id) {
        this.habitaciónDao.Eliminar(id);
    }
}
