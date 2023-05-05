package jdbc.dao;

import jdbc.modelo.Habitacion;
import jdbc.modelo.Huespedes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitaciónDao {
    private Connection con;
    public HabitaciónDao(Connection con)
    {
        this.con = con;
    }
    public void guardar(Habitacion habitacion)
    {
        try {
            String sql = "INSERT INTO Habitacion (nombre, habitaciones, direccion) VALUES (?, ?, ?)";

            try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, habitacion.getNombre());
                pstm.setInt(2, habitacion.getHabitaciones());
                pstm.setString(3, habitacion.getDireccion());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        habitacion.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Habitacion> listarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
        try {
            String sql = "SELECT Id, nombre, habitaciones, direccion FROM Habitacion";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEnHabitacion(habitaciones, pstm);
            }
            return habitaciones;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Habitacion> buscarId(String id) {
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
        try {

            String sql = "SELECT Id, nombre, habitaciones, direccion FROM Habitacion WHERE Id = ?";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                transformarResultSetEnHabitacion(habitaciones, pstm);
            }
            return habitaciones;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar(String nombre, int habitaciones, String direccion, Integer id) {
        try (PreparedStatement stm = con
                .prepareStatement("UPDATE Habitacion SET nombre = ?, habitaciones = ?, direccion = ? WHERE Id = ?")) {
            stm.setString(1, nombre);
            stm.setInt(2, habitaciones);
            stm.setString(3, direccion);
            stm.setInt(4, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Eliminar(Integer id) {
        try (PreparedStatement stm = con.prepareStatement("DELETE FROM Habitacion WHERE Id = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEnHabitacion(List<Habitacion> habitaciones, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Habitacion habitacion = new Habitacion(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4));
                habitaciones.add(habitacion);
            }
        }
    }


}
