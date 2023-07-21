package ua.kiev.prog;

import java.util.List;

public interface ContactDAO {
    void add(Contact contact);
    void delete(long[] ids);
    List<Contact> list(Group group, int start, int count);
    List<Contact> list(String pattern);
    long count();
}
