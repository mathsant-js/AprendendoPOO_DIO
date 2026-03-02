public class Main {
    public static void main(String[] args) {
        // Criando objetos com argumentos
        Person male = new Person("João", 15);
        Person female = new Person("Ana", 22);

        // Imprimindo os atributos desses objetos
        System.out.println("Nome: " + male.getName() + " | Idade: " + male.getAge());
        System.out.println("Nome: " + female.getName() + " | Idade: " + female.getAge());

        // Sobrescrevendo os atributos desses objetos
        male.setName("Matheus");
        male.setAge(18);
        female.setName("Maria");
        female.setAge(20);

        // Imprimindo esses novos valores
        System.out.println("Nome: " + male.getName() + " | Idade: " + male.getAge());
        System.out.println("Nome: " + female.getName() + " | Idade: " + female.getAge());

        // Imprimindo as variáveis estáticas desses objetos
        System.out.println("Espécie: " + Person.specie);
        System.out.println("Quantidade de humanos: " + Person.countHumans);

        // Trabalhando com Record
        PersonDTO personDTO = new PersonDTO("Lucas", 18);

        // personDTO.name("Marcos"); -> Record trabalha com atributos final, ou seja, imútaveis
        // System.out.println(personDTO.getName()); -> Record não trabalha desse jeito

        // Imprimindo os dados do DTO
        System.out.println("Nome: " + personDTO.name() + " | Idade: " + personDTO.age());
        System.out.println(personDTO.overAge()); // -> Consulta a idade do personDTO
    }
}
