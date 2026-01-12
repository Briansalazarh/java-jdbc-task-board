package persistence;

import dto.BoardDetailsDTO;
import dto.CardDTO;
import entity.Board;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {

    public void insert(final Board entity) {
        String sql = "INSERT INTO boards (name) VALUES (?);";
        try (var connection = ConnectionFactory.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BoardDetailsDTO findById(final Long id) {
        String sql = "SELECT b.id, b.name, c.id as card_id, c.title, c.status FROM boards b LEFT JOIN cards c ON c.board_id = b.id WHERE b.id = ?;";
        BoardDetailsDTO dto = new BoardDetailsDTO();
        dto.setCards(new ArrayList<>());

        try (var connection = ConnectionFactory.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();

            while(resultSet.next()){
                dto.setId(resultSet.getLong("id"));
                dto.setName(resultSet.getString("name"));

                if (resultSet.getLong("card_id") > 0) {
                    CardDTO card = new CardDTO();
                    card.setId(resultSet.getLong("card_id"));
                    card.setTitle(resultSet.getString("title"));
                    card.setStatus(resultSet.getString("status"));
                    dto.getCards().add(card);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}