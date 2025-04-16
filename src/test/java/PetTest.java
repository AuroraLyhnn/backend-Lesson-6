import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTest {

    @Test
    public void testConstructorPet(){
        Pet pet1 = new Pet("Harley", 13, "cat");
        assertEquals("Harley", pet1.getName());
        assertEquals(13, pet1.getAge());
        assertEquals("cat", pet1.getSpecies());
    }
}
