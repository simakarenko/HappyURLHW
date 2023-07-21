package ua.kiev.prog;

import ua.kiev.prog.Contact;
import ua.kiev.prog.Group;

import java.util.List;

public interface ContactService {
    void addContact(Contact contact);
    void addGroup(Group group);
    void deleteContact(long[] ids);
    List<Group> listGroups();
    List<Contact> listContacts(Group group, int start, int count);
    List<Contact> listContacts(Group group);
    long count();
    Group findGroup(long id);
    List<Contact> searchContacts(String pattern);
}
