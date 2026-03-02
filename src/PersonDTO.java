public record PersonDTO(String name, int age) {

    public PersonDTO {
        if (age < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }
    }

    public boolean overAge() {
        return age >= 18;
    }

}
