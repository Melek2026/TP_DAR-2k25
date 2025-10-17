package act2_1;
import java.io.*;
import java.net.*;

public class serveur {

    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(3000);
            System.out.println("Serveur en attente de connexion...");
            Socket socket = serveur.accept();
            System.out.println("Client connecté !");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String operation = in.readLine();
            System.out.println("Opération reçue du client : " + operation);
            String resultat = calculer(operation);
            out.println(resultat);
            System.out.println("Résultat envoyé : " + resultat);
            in.close();
            out.close();
            socket.close();
            serveur.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calculer(String operation) {
        try {
            operation = operation.replaceAll("\\s+", "");
            double resultat = 0;

            if (operation.contains("+")) {
                String[] parts = operation.split("\\+");
                resultat = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
            } else if (operation.contains("-")) {
                String[] parts = operation.split("-");
                resultat = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
            } else if (operation.contains("*")) {
                String[] parts = operation.split("\\*");
                resultat = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
            } else if (operation.contains("/")) {
                String[] parts = operation.split("/");
                resultat = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
            } else {
                return "Erreur : opérateur non reconnu !";
            }

            return "Résultat = " + resultat;

        } catch (Exception e) {
            return "Erreur dans le format de l’opération.";
        }
    }
}
