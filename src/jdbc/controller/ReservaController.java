package jdbc.controller;

import jdbc.dao.ReservaDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reserva;

import java.sql.Date;
import java.util.List;

public class ReservaController {

    private ReservaDao reservaDao;

    public ReservaController()
    {
        var factory = new ConnectionFactory();
        this.reservaDao = new ReservaDao(factory.recuperaConexion());
    }

    public void guardar(Reserva reserva)
    {
        reservaDao.guardar(reserva);
    }
    public List<Reserva> buscar() {
        return this.reservaDao.buscar();
    }

    public List<Reserva> buscarId(String id) {
        return this.reservaDao.buscarId(id);
    }

    public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
        this.reservaDao.Actualizar(fechaE, fechaS, valor, formaPago, id);
    }

    public void Eliminar(Integer id) {
        this.reservaDao.Eliminar(id);
    }
}
