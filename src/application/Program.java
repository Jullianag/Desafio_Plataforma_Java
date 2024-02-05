package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();

        List<Lesson> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            System.out.printf("%nDados da %dº aula:%n", i+1);
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Título: ");
            sc.nextLine();
            String title = sc.nextLine();

            if (ch == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                list.add(new Video(title, url, seconds));
            }
            else if (ch == 't') {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int quantity = sc.nextInt();
                list.add(new Task(title, description, quantity));
            }

        }

        int sum = 0;
        for (Lesson lessons : list) {
            sum += lessons.duration();
        }

        System.out.println();
        System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos%n", sum);

        sc.close();
    }
}
