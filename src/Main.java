import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Иван", "Пётр", "Андрей", "Роман", "Денис", "Альберт", "Алексей");
        List<String> namesWoman = Arrays.asList("Алёна", "Мария", "Наталья", "Марина", "Елена", "Ольга", "Маргарита");
        List<String> surnames = Arrays.asList("Иванов", "Петров", "Андреев", "Денисов", "Романов", "Альбертов", "Алексеев", "Саяпов");
        List<String> surnamesWoman = Arrays.asList("Иванова", "Петрова", "Андреева", "Денисова", "Альбертова", "Романова", "Алексеева", "Саяпова");

        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            Sex sex = Sex.values()[new Random().nextInt(Sex.values().length)];
            String name;
            String surname;
            if (sex.equals(Sex.MAN)) {
                name = names.get(new Random().nextInt(names.size()));
                surname = surnames.get(new Random().nextInt(surnames.size()));
            } else {
                name = namesWoman.get(new Random().nextInt(namesWoman.size()));
                surname = surnamesWoman.get(new Random().nextInt(surnamesWoman.size()));
            }
            persons.add(new Person(
                    name,
                    surname,
                    new Random().nextInt(100),
                    sex,
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long countTeenager = persons.stream()
                .filter(person -> person.getAge() < 18)
                .mapToInt(person -> person.getAge())
                .count();

        System.out.println(persons);
        System.out.println();
        System.out.println("Количество несовершеннолетних = " + countTeenager);

        List<String> futureMilitary = persons.stream()
                .filter(person -> surnames.contains(person.getSurname()))
                .filter(person -> (person.getAge() >= 18 && person.getAge() <= 27))
                .map(person -> person.getSurname())
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Список призывников: " + "\n" + futureMilitary);

        List<String> peopleWithHigherEducation = persons.stream()
                .filter(person -> {
                    if (person.getSex().equals(Sex.MAN)) {
                        return person.getAge() >= 18 && person.getAge() <= 65;
                    }
                    return person.getAge() >= 18 && person.getAge() <= 60;
                })
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(person -> person.getSurname()))
                .map(person -> person.getSurname())
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Работоспособные люди с высшим образованием: " + "\n" + peopleWithHigherEducation);


    }

}
