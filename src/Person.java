public class Person {
    private String name;
    private String surname;
    private int age;
    private Sex sex;
    private Education education;

    public Person(String name, String surname, int age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Персона:" + "\n"
                + " Имя = " + name + "\n"
                + " Фамилия = " + surname + "\n"
                + " Восзраст = " + age + "\n"
                + " Пол = " + sex + "\n"
                + " Образование = " + education + "\n";
    }
}
