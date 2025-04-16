import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;

        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();
        this.pets = new ArrayList<>();
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;

        this.children = new ArrayList<>();
        this.siblings = new ArrayList<>();
        this.pets = new ArrayList<>();
    }

    public void addParents(Person mother, Person father) {
        this.father = father;
        this.mother = mother;
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.sex.equalsIgnoreCase("female")){
            child.setMother(this);
        } else if (this.sex.equalsIgnoreCase("male")){
            child.setFather(this);
        }
    }

    public void addSibling(Person sibling) {
        if (!siblings.contains(sibling)) {
            siblings.add(sibling);
            if (!sibling.getSiblings().contains(this)) {
                sibling.addSibling(this);
            }
        }
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
        pet.setOwner(this);
    }

    public List<Person> getGrandChildren(){
        List<Person> grandChildren = new ArrayList<>();
        for (Person child : children){
            grandChildren.addAll(child.getChildren());
        }
        return grandChildren;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
