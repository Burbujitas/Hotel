package jdbc.dao;

import jdbc.modelo.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao {
    private Connection con;

    public ReservaDao(Connection con){ this.con = con; }

    public void guardar(Reserva reserva){
        try{
            PreparedStatement statement;
            statement = con.prepareStatement(
                    "insert into Reservar (FechaEntranda,FechaSalida,Valor,FormaPago,habitacionId)" +
                            " values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            try(statement)
            {
                statement.setDate(1, reserva.getFechaEntrada());
                statement.setDate(2,reserva.getFechaSalida());
                statement.setDouble(3, reserva.getValor());
                statement.setString(4, reserva.getFormaPago());
                statement.setInt(5,reserva.getHabitacionId());

                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try(resultSet)
                {
                    while(resultSet.next())
                    {
                        reserva.setId(resultSet.getInt(1));
                        System.out.println("fue insertado la reserva: "+reserva.getId());
                    }
                }
            }

        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
    public List<Reserva> buscar() {
        List<Reserva> reservas = new ArrayList<Reserva>();
        try {
            String sql = "SELECT Id, FechaEntranda, FechaSalida, Valor, FormaPago FROM Reservar";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEnReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reserva> buscarId(String id) {
        List<Reserva> reservas = new ArrayList<Reserva>();
        try {

            String sql = "SELECT Id, FechaEntranda, FechaSalida, Valor, FormaPago FROM Reservar WHERE Id = ?";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                transformarResultSetEnReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Eliminar(Integer id) {
        try (PreparedStatement stm = con.prepareStatement("DELETE FROM Reservar WHERE Id = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
        try (PreparedStatement stm = con
                .prepareStatement("UPDATE Reservar SET FechaEntranda = ?, FechaSalida = ?, Valor = ?, FormaPago = ? WHERE Id = ?")) {
            stm.setDate(1, fechaE);
            stm.setDate(2, fechaS);
            stm.setString(3, valor);
            stm.setString(4, formaPago);
            stm.setInt(5, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Reserva produto = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getDouble(4), rst.getString(5));

                reservas.add(produto);
            }
        }
    }

}
