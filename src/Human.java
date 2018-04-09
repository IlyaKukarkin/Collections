public class Human implements Comparable<Human> {

    Integer age;
    String name;
    String lastName;

    public Human(String name, String lastName, Integer age)
    {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }


    @Override
    public int compareTo(Human o) {
        int result = 0;

        if (this.equals(o)) return 0;

        result = name.compareTo(o.name);
        if (result!=0) return result;
        else result = lastName.compareTo(o.lastName);
        if (result!=0) return result;
        else return age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return lastName + " " + name + " "+ age + " ";
    }
}
