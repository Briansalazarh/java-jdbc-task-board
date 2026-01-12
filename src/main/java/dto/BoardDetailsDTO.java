package dto;

import java.util.List;
import lombok.Data;

@Data
public class BoardDetailsDTO {
    private Long id;
    private String name;
    private List<CardDTO> cards;
}