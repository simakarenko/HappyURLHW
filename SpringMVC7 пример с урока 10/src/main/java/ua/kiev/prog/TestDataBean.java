package ua.kiev.prog;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// DB -> JDBC -> H -> JPA -> E1..EN -> DAO/Repo -> S(T) -> V? -> C

@Component
public class TestDataBean {
    private final ContactService contactService;

    public TestDataBean(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void fillData() {
        Group group = new Group("Test");
        Contact contact;

        contactService.addGroup(group);

        for (int i = 0; i < 25; i++) {
            contact = new Contact(null, "Name" + i, "Surname" + i, "1234567" + i, "user" + i + "@test.com");
            contactService.addContact(contact);
        }
        for (int i = 0; i < 12; i++) {
            contact = new Contact(group, "Other" + i, "OtherSurname" + i, "7654321" + i, "user" + i + "@other.com");
            contactService.addContact(contact);
        }
    }
}
