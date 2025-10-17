package act2_2;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 3000;

        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);

            // Saisie de l'opération
            System.out.print("Entrez le premier nombre : ");
            double a = sc.nextDouble();
            System.out.print("Entrez l'opérateur (+, -, *, /) : ");
            char op = sc.next().charAt(0);
            System.out.print("Entrez le deuxième nombre : ");
            double b = sc.nextDouble();

            // Création et envoi de l'objet Operation
            Operation operation = new Operation(a, op, b);
            oos.writeObject(operation);
            oos.flush();

            // Lecture du résultat
            double result = ois.readDouble();
            System.out.println("Résultat reçu du serveur : " + result);

            // Fermeture des flux et scanner
            oos.close();
            ois.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
