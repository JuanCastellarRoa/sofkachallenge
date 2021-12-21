package co.com.sofka.sofkachallenge.view;

import co.com.sofka.sofkachallenge.service.CategoryService;
import co.com.sofka.sofkachallenge.service.AnswerService;
import co.com.sofka.sofkachallenge.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {
    @Resource
    private CategoryService categoryService;

    @Resource
    private QuestionService questionService;

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
            } catch (Exception e){
                exit();
            }
            if(opcion == 1){
                showInstructions();
                System.out.println("Presiona 1 para regresar al menú anterior o 2 para salir");
                try {
                    opc = in.nextInt();
                } catch (Exception e) {
                    exit();
                }
                if(opc == 1){
                    continue;
                }
                if(opc == 2){
                    System.out.println("El programa ha finalizado satisfactoriamente");
                    System.exit(0);
                } else {
                    exit();
                }
            } else if(opcion == 2){
                play();
            } else if(opcion == 3){
                System.out.println("La opción digitada es 3");
                System.out.println("Presiona 1 para regresar al menú anterior o 2 para salir");
                try {
                    opc = in.nextInt();
                } catch (Exception e) {
                    exit();
                }
                if(opc == 2){
                    System.out.println("El programa ha finalizado satisfactoriamente");
                    System.exit(0);
                } else {
                    continue;
                }
            } else if(opcion == 4){
                System.out.println("El programa ha finalizado satisfactoriamente");
                System.exit(0);
            } else {
                exit();
                continue;
            }
        } while(opcion != 4 );
        in.close();
    }

    public void showMenu(){
        System.out.println("**************************************************");
        System.out.println("¡Bienvenido al concurso de preguntas y respuestas!");
        System.out.println("**************************************************");
        System.out.println("1. Instrucciones");
        System.out.println("2. Jugar");
        System.out.println("3. Mejores Puntajes");
        System.out.println("4. Salir");
        System.out.println("**************************************************");
        System.out.println("Por favor digita una opción entre las anteriores: ");
        System.out.println("**************************************************");
    }

    public void play() {
        System.out.println("Por favor ingresa tu nombre para continuar: ");
        String name = in.nextLine();
    }

    public void showInstructions(){
        System.out.println("INSTRUCCIONES: El concurso consiste en una serie de 5 preguntas de selección múltiple con una única respuesta, por cada ronda acertada acumularás 200 puntos, y antes de la siguiente pregunta podrás decidir si te retiras con el acumulado o continuas. Si decides continuar y tu respuesta es incorrecta el juego finaliza inmediatamente perdiendo la cantidad de puntos acumulados. Finalmente, ganarás el juego si acumulas 1000 puntos.");
    }
}
