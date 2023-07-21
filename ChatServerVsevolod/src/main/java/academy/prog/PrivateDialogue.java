package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

public class PrivateDialogue {

    private Gson gson;
    private final List<Message> list = new LinkedList<>();

    public PrivateDialogue() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }


    public synchronized void add(Message m) {
        list.add(m);
    }

    public synchronized String toJSON(int n) {
        if (n >= list.size()) return null;
        return gson.toJson(new JsonMessages(list, n));
    }
}
