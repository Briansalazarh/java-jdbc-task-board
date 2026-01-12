package entity;

import lombok.Data;

@Data
public class Card {
    private Long id;
    private String title;
    private String description;
    private String status; // TODO, DOING, DONE
    private Long boardId;
}