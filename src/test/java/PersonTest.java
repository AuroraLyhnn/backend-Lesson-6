import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    @Test
    public void testConstructorPerson(){
        Person person1 = new Person("Sisserah", "van der Sluis", 28, "female");
        assertEquals("Sisserah", person1.getName());
        assertEquals("van der Sluis", person1.getLastName());
        assertEquals(28, person1.getAge());
        assertEquals("female", person1.getSex());
    }

    @Test
    public void testConstructorWithMiddleNamePerson(){
        Person person1 = new Person("Sisserah", "Aurora", "van der Sluis", 28, "female");
        assertEquals("Sisserah", person1.getName());
        assertEquals("Aurora", person1.getMiddleName());
        assertEquals("van der Sluis", person1.getLastName());
        assertEquals(28, person1.getAge());
        assertEquals("female", person1.getSex());
    }

    @Test
    public void testAddParents(){
        Person person1 = new Person("Sisserah", "van der Sluis", 28, "female");
        Person mother = new Person("Debora", "van der Sluis", 51, "female");
        Person father = new Person("Matthieu", "van der Sluis", 54, "male");

        person1.addParents(mother, father);

        assertEquals(mother, person1.getMother());
        assertEquals(father, person1.getFather());
    }

    @Test
    public void testAddChild(){
        Person mother = new Person("Debora", "van der Sluis", 51, "female");
        Person child = new Person("Sisserah", "van der Sluis", 28, "female");

        mother.addChild(child);

        assertTrue(mother.getChildren().contains(child));
    }

    @Test
    public void testAddSiblings(){
        Person person1 = new Person("Sisserah", "van der Sluis", 28, "female");
        Person person2 = new Person("Mitch", "van der Sluis", 26, "male");

        person1.addSibling(person2);

        assertTrue(person1.getSiblings().contains(person2));
        assertTrue(person2.getSiblings().contains(person1));
    }

    @Test
    public void testAddPet(){
        Person person1 = new Person("Sisserah", "van der Sluis", 28, "female");
        Pet pet1 = new Pet("Harley", 13, "cat");

        person1.addPet(pet1);

        assertTrue(person1.getPets().contains(pet1));
        assertEquals(person1, pet1.getOwner());
    }

    @Test
    public void testGetGrandChildren(){
        Person person1 = new Person("Anneke", "Ekkel", 73, "female");
        Person person2 = new Person("Debora", "van der Sluis", 51, "female");
        Person person3 = new Person("Sisserah", "van der Sluis", 28, "female");

        person1.addChild(person2);
        person2.addChild(person3);

        assertTrue(person1.getGrandChildren().contains(person3));
    }
}
