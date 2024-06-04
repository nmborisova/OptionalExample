package bg.smg;

import java.util.Optional;

public class Main {

    private static Person generateNewPerson(){
        Person person = new Person("john", 26);
        return person;
    }

    private static Person generateNewPersonNull(){
//        Person person = new Person("john", 26);
        return null;
    }

    public static void main(String[] args) {

        Optional<Person> personOptional = Optional.of(generateNewPerson());

        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);

        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        System.out.println(name1.equals("john"));

        String name = personOptional
                .flatMap(Person::getName)
                .orElse("");
        System.out.println(name.equals("john"));
    }
}
