public class Person {
    private String name;
    private int age;
    final static String specie = "Humano";
    static int countHumans = 0;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        countHumans++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
