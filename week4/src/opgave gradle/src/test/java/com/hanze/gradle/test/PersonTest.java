// package
// import

public class PersonTest {
    @Test
    public void test() {
        Person person = new Person("Jeremy");
        assertEquals(person.getName(), "Jeremy");
    }
}
