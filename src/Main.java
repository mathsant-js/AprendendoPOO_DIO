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
    }
}
