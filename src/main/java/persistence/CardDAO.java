package persistence;

import entity.Card;

import java.sql.SQLException;

public class CardDAO {
    public void insert(final Card entity) {
        String sql = "INSERT INTO cards (title, description, status, board_id) VALUES (?, ?, ?, ?);";
        try (var connection = ConnectionFactory.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getTitle());
            statement.setString(2, entity.getDescription());
            statement.setString(3, "TODO");
            statement.setLong(4, entity.getBoardId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(final Long id, final String newStatus) {
        String sql = "UPDATE cards SET status = ? WHERE id = ?;";
        try (var connection = ConnectionFactory.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, newStatus);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}