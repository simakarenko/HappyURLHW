package academy.prog.sample2;

import org.springframework.stereotype.Component;

@Component
public class EmailTransport extends Transport {
    public EmailTransport(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected void DoSendMessage(String text) {
        System.out.println("Message sent via e-mail: " + text);
    }
}
