package act2_1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Connecté au serveur.");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            System.out.print("Saisir une opération (ex: 55 * 25) : ");
            String operation = sc.nextLine();
            if (!operation.matches("\\d+\\s*[\\+\\-\\*/]\\s*\\d+")) {
                System.out.println("⚠️  Format invalide. Ex: 25 + 3");
            } else {
                
                out.println(operation);

                
                String resultat = in.readLine();
                System.out.println("Réponse du serveur : " + resultat);
            }
            sc.close();
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
