package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

public class PrivateMessagesList {
    private static final PrivateMessagesList pmList = new PrivateMessagesList();
    private final Map<String, List<Message>> pm = new HashMap<>();
    private List<Message> list = new LinkedList<>();
    private Gson gson;
    private UsersList ul = UsersList.getInstance();
    private String username = "";

    public static PrivateMessagesList getInstance() {
        return pmList;
    }

    private PrivateMessagesList() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public synchronized void add(String to, Message message) {
        if (ul.checkRecipient(to) == true) {
            if (pm.containsKey(to) == false) {
                List<Message> l = new LinkedList<>();
                pm.put(to, l);
                l.addAll(pm.get(to));
                pm.put(to, l);
            } else {
                List<Message> l = new LinkedList<>();
                l.addAll(pm.get(to));
                pm.put(to, l);
                generateList(to);
            }
        } else {
            System.out.println("ERROR SVETA");
        }
    }

    public synchronized void generateList(String name) {
        username = name;
        list = null;
        list.addAll(pm.get(username));
        username = "";
    }

    public synchronized String toJSON(int n) {
        if (n >= list.size()) return null;
        return gson.toJson(new JsonMessages(list, n));
    }

    public synchronized List<Message> backList(String login) {
        List<Message> l = new LinkedList<>();
        l.addAll(pm.get(login));
        return l;
    }
}
