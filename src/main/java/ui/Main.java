package ui;

import entity.Board;
import entity.Card;
import persistence.BoardDAO;
import persistence.CardDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardDAO boardDAO = new BoardDAO();
        CardDAO cardDAO = new CardDAO();

        System.out.println("WELCOME TO PROJECT BOARD CLI");
        var option = -1;

        while(true) {
            System.out.println("\n1 - Create Board | 2 - Select Board | 3 - Exit");
            option = scanner.nextInt();

            if (option == 1) {
                System.out.println("Board Name:");
                String name = scanner.next();
                Board board = new Board();
                board.setName(name);
                boardDAO.insert(board);
                System.out.println("Board created!");
            }
            else if (option == 2) {
                System.out.println("Enter Board ID:");
                Long id = scanner.nextLong();
                var board = boardDAO.findById(id);
                System.out.println("BOARD: " + board.getName());
                board.getCards().forEach(c -> System.out.println(" - ["+c.getStatus()+"] " + c.getTitle() + " (ID:"+c.getId()+")"));

                System.out.println("1 - Create Card | 2 - Move Card | 3 - Back");
                int subOption = scanner.nextInt();

                if (subOption == 1) {
                    System.out.println("Card Title:");
                    String title = scanner.next();
                    Card card = new Card();
                    card.setTitle(title);
                    card.setBoardId(id);
                    cardDAO.insert(card);
                } else if (subOption == 2) {
                    System.out.println("Card ID:");
                    Long cardId = scanner.nextLong();
                    System.out.println("New Status (TODO, DOING, DONE):");
                    String status = scanner.next();
                    cardDAO.updateStatus(cardId, status);
                }
            }
            else {
                System.out.println("Bye!");
                break;
            }
        }
        scanner.close();
    }
}