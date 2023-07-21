package academy.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        try {
            System.out.println("Enter your login: ");
            String login = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            System.out.println("Send a private message? (Enter: Y (yes) or N (no))");
            String privateMessege = scanner.nextLine();
            String to = "";
            if (privateMessege.equals("Y")) {
                System.out.println("Enter the recipient's login:");
                to = scanner.nextLine();
            }
            if (!to.equals("")) {
                Thread thP = new Thread(new GetPrivateThread());
                thP.setDaemon(true);
                thP.start();
            } else {
                Thread th = new Thread(new GetThread());
                th.setDaemon(true);
                th.start();
            }

            System.out.println("Enter your message: ");
            while (true) {
                String text = scanner.nextLine();
                if (text.isEmpty()) break;

                // @login message
                // users

                Message m = new Message(login, text, password, to);
                if (!m.getTo().equals("")) {
                    res = m.send(Utils.getURL() + "/private_add");
                } else {
                    res = m.send(Utils.getURL() + "/add");
                }
                if (res != 200) { // 200 OK
                    System.out.println("HTTP error occurred: " + res);
                    return;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
