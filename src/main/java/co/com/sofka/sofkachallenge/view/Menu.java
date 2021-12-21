package co.com.sofka.sofkachallenge.view;

import co.com.sofka.sofkachallenge.model.Category;
import co.com.sofka.sofkachallenge.model.Game;
import co.com.sofka.sofkachallenge.model.Player;
import co.com.sofka.sofkachallenge.model.Question;
import co.com.sofka.sofkachallenge.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {
    @Resource
    private CategoryService categoryService;

    @Resource
    private PlayerService playerService;

    @Resource
    private QuestionService questionService;

    @Resource
    private GameService gameService;

    @Resource
    private AnswerService answerService;

    private Scanner in = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        this.run();
    }

    public void exit() {
        System.out.println("Lo siento, pero la opción digitada no es válida ¡Suerte para la próxima!");
        System.exit(0);
    }

    public void run() {
        int opcion = 0;
        int opc = 0;
        do {
            showMenu();
            try {
                opcion = in.nextInt();
            } catch (Exception e) {
                exit();
            }
            if (opcion == 1) {
                showInstructions();
                System.out.println("Presiona 1 para regresar al menú anterior o 2 para salir");
                try {
                    opc = in.nextInt();
                } catch (Exception e) {
                    exit();
                }
                if (opc == 1) {
                    continue;
                }
                if (opc == 2) {
                    System.out.println("El programa ha finalizado satisfactoriamente");
                    System.exit(0);
                } else {
                    exit();
                }
            } else if (opcion == 2) {
                play();
            } else if (opcion == 3) {
                printScores();
                System.out.println("Presiona 1 para regresar al menú anterior o 2 para salir");
                try {
                    opc = in.nextInt();
                } catch (Exception e) {
                    exit();
                }
                if (opc == 2) {
                    System.out.println("El programa ha finalizado satisfactoriamente");
                    System.exit(0);
                } else {
                    continue;
                }
            } else if (opcion == 4) {
                System.out.println("El programa ha finalizado satisfactoriamente");
                System.exit(0);
            } else {
                exit();
                continue;
            }
        } while (opcion != 4);
        in.close();
    }

    public void showMenu() {
        System.out.println("**************************************************");
        System.out.println("¡Bienvenido al concurso de preguntas y respuestas!");
        System.out.println("**************************************************");
        System.out.println("1. Instrucciones");
        System.out.println("2. Jugar");
        System.out.println("3. Puntajes Históricos");
        System.out.println("4. Salir");
        System.out.println("**************************************************");
        System.out.println("Por favor digita una opción entre las anteriores: ");
        System.out.println("**************************************************");
    }

    public void play() {
        System.out.println("Por favor ingresa tu nombre para continuar: ");
        String name = in.next();
        Player player = playerService.findByName(name);
        if (player == null) {
            Player newPlayer = new Player();
            newPlayer.setName(name);
            player = playerService.createPlayer(newPlayer);
        }

        Game game = new Game();
        game.setPlayer(player);
        Integer score = 0;
        int categoryNumber = 1;
        boolean answer = false;
        do {
            answer = askQuestion(new Category(categoryNumber));
            if (answer) {
                score+=200;
                if (score < 1000) {
                    System.out.println("Felicidades, quieres seguir jugando (si) " +
                            "o te retiras con el acumulado de " + score + ". (no)");
                    answer = in.next().equals("si");
                } else {
                    System.out.println("Felicidades, has ganado el juego! Tu score fue: " + score);
                }
                categoryNumber++;
            } else {
                System.out.println("Respuesta Incorrecta. Vuelva a intentarlo." );
                score = 0;
            }
        } while(answer && categoryNumber < 6);

        game.setScore(score);
        gameService.createGame(game);

    }

    private boolean askQuestion(Category category) {
        List<Question> questionsCategoryOne = questionService.findByCategory(category);
        Random rand = new Random();
        Question question = questionsCategoryOne.get(rand.nextInt(questionsCategoryOne.size()));
        System.out.println(question.getText());
        System.out.println(question.getAnswer().getText());
        String answer = in.next();
        return question.getAnswer().getCorrectAnswer().equalsIgnoreCase(answer);
    }


    public void printScores() {
        List<Game> games = gameService.findAll();
        for (Game game : games) {
            System.out.println("Jugador: " + game.getPlayer().getName() + " - Score: " + game.getScore());
        }
    }

    public void showInstructions() {
        System.out.println("INSTRUCCIONES: El concurso consiste en una serie de 5 preguntas de selección múltiple con una única respuesta, por cada ronda acertada acumularás 200 puntos, y antes de la siguiente pregunta podrás decidir si te retiras con el acumulado o continuas. Si decides continuar y tu respuesta es incorrecta el juego finaliza inmediatamente perdiendo la cantidad de puntos acumulados. Finalmente, ganarás el juego si acumulas 1000 puntos.");
    }
}
