package act2_2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        int port = 3000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur en attente de connexion sur le port " + port + "...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté : " + clientSocket.getInetAddress());

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
/*test*/
            // Lecture de l'objet Operation envoyé par le client
            Operation op = (Operation) ois.readObject();

            // Calcul selon l'opérateur
            double result = 0;
            switch (op.getOperator()) {
                case '+': result = op.getOperand1() + op.getOperand2(); break;
                case '-': result = op.getOperand1() - op.getOperand2(); break;
                case '*': result = op.getOperand1() * op.getOperand2(); break;
                case '/': 
                    if (op.getOperand2() != 0)
                        result = op.getOperand1() / op.getOperand2(); 
                    else
                        System.out.println("Erreur : division par zéro");
                    break;
                default: System.out.println("Opérateur invalide !");
            }

            // Envoi du résultat au client
            oos.writeDouble(result);
            oos.flush();
            System.out.println("Résultat envoyé au client : " + result);

            // Fermeture des flux et socket
            ois.close();
            oos.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
