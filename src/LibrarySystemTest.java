import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {
    Book book = new Book("Islands","Ackerley","Acton","Adamaris",1991,"1234100000000",1002);
    LibMember member = new  LibMember("Carter","William",'M',10176535,"34567281");
    LibrarySystem library = new LibrarySystem();

    /*
    Test the following functions
    1. addBook
    2. deleteBook
    3. searchBook
    4. issuedBook
    5. isIssuedBook
     */

    @Test
    void addBookNewCorrectValueTest() {
        assertTrue(library.addBook(book));
    }

    @Test
    void addDuplicateBook(){
        Book book = new Book("Islands","Ackerley","Acton","Adamaris",1991,"1234100000000",1002);
        library.addBook(this.book);
        assertFalse(library.addBook(book));
    }

    @Test
    void addBookWithTwoEmptyBookObjects(){
        Book book1 = new Book();
        Book book2 = new Book();
        library.addBook(book1);
        assertFalse(library.addBook(book2));
    }

    @Test
    void deleteBookExists(){
        library.addBook(book);
        assertTrue(library.deleteBook(this.book.getAccessionNum()));
    }

    @Test
    void deleteBookDoseNotExists(){
        library.addBook(book);
        Book book1 = new Book();
        assertFalse(library.deleteBook(book1.getAccessionNum()));
    }

    @Test
    void searchBookExists(){
        library.addBook(book);
        assertEquals(0, library.searchBook(this.book.getAccessionNum()));
    }

    @Test
    void searchBookDoseNotExists() {
        assertEquals(-1, library.searchBook(book.getAccessionNum()));
    }

    @Test
    void issueBookThatExists() {

        library.addBook(book);
        library.addMember(member);
        assertTrue(library.issueBook(book.getAccessionNum(), member.getCprNum()));
    }

    @Test
    void issueBookDoseNotExists(){
        library.addMember(member);
        assertFalse(library.issueBook(book.getAccessionNum(), member.getCprNum()));
    }

    @Test
    void issuedBookToMemberDoseNotExists(){
        library.addBook(book);
        assertFalse(library.issueBook(book.getAccessionNum(), member.getCprNum()));
    }


    @Test
    void issuedAnIssuedBook(){
        LibMember member1 = new LibMember("Olive","Henry",'F',10176534,"34567282");
        library.addBook(book);
        library.addMember(member);
        library.addMember(member1);
        library.issueBook(book.getAccessionNum(),member.getCprNum());
        assertFalse(library.issueBook(book.getAccessionNum(),member1.getCprNum()));
    }

    @Test
    void issuedBookWithMoreThan10BooksIssued(){
        Book obj1 =new Book("Islands","Ackerley","Acton","Adamaris",1991,"1234100000000",1001);
        Book obj2 =new Book("Sea","Aaliyah","Sabina","Sachi",1992,"1234100000001",1002);
        Book obj3 =new Book("Explore","Marley","Peyton","Presley",1993,"1234100000002",1003);
        Book obj4 =new Book("Forest","Tobin","Shaw","Oscar",1994,"1234100000003",1004);
        Book obj5 =new Book("Animal","Winston","Oberon","Sawyer",1995,"1234100000004",1005);
        Book obj6 =new Book("Trust","Oberon","Kinsley","Lily",1996,"1234100000005",1006);
        Book obj7 =new Book("What","Juliet","Birch","Garrison",1997,"1234100000006",1007);
        Book obj8 = new Book("Journey", "Evelyn", "Rowan", "Madeline", 1998, "1234100000007", 1008);
        Book obj9 = new Book("Harmony", "Zane", "Kendall", "Maximus", 1999, "1234100000008", 1009);
        Book obj10 = new Book("Wonders", "Bianca", "Quincy", "Ezekiel", 2000, "1234100000009", 1010);
        Book obj11 = new Book("Reflections", "Sylvia", "Nash", "Vivian", 2001, "1234100000010", 1011);

        library.addBook(obj1);
        library.addBook(obj2);
        library.addBook(obj3);
        library.addBook(obj4);
        library.addBook(obj5);
        library.addBook(obj6);
        library.addBook(obj7);
        library.addBook(obj8);
        library.addBook(obj9);
        library.addBook(obj10);
        library.addBook(obj11);


        library.addMember(member);

        library.issueBook(obj1.getAccessionNum(),member.getCprNum());
        library.issueBook(obj2.getAccessionNum(),member.getCprNum());
        library.issueBook(obj3.getAccessionNum(),member.getCprNum());
        library.issueBook(obj4.getAccessionNum(),member.getCprNum());
        library.issueBook(obj5.getAccessionNum(),member.getCprNum());
        library.issueBook(obj6.getAccessionNum(),member.getCprNum());
        library.issueBook(obj7.getAccessionNum(),member.getCprNum());
        library.issueBook(obj8.getAccessionNum(),member.getCprNum());
        library.issueBook(obj9.getAccessionNum(),member.getCprNum());
        library.issueBook(obj10.getAccessionNum(),member.getCprNum());
        assertFalse(library.issueBook(obj11.getAccessionNum(),member.getCprNum()));
    }

    @Test
    void isBookIssuedExistsIssuedBook() {
        library.addBook(book);
        library.addMember(member);
        library.issueBook(book.getAccessionNum(),member.getCprNum());
        assertTrue(library.isBookIssued(book.getAccessionNum()));
    }

    @Test
    void isBookIssuedBookNotIssuedTest(){
        library.addBook(book);
        assertFalse(library.isBookIssued(book.getAccessionNum()));
    }

    @Test
    void isBookIssuedBookDoseNotExists(){
        assertFalse(library.isBookIssued(book.getAccessionNum()));
    }
}