import java.util.Scanner;

public class Carro {
    private float velocidade;
    private boolean carroLigado;
    private static final int[] marchas = {0, 1, 2, 3, 4, 5, 6};
    private int marchaSelecionada;
    private final static Scanner scanner = new Scanner(System.in);

    public Carro() {
        velocidade = 0;
        carroLigado = false;
        marchaSelecionada = marchas[0];
    }

    private float getVelocidade() {
        return velocidade;
    }

    private boolean isCarroLigado() {
        return carroLigado;
    }

    private void setCarroLigado(boolean carroLigado) {
        this.carroLigado = carroLigado;
    }

    public void mostrarOpcoesCarro() {
        System.out.println("""
                1 - Ligar Carro
                2 - Desligar Carro
                3 - Verificar Velocidade
                4 - Acelerar Carro
                5 - Desacelerar Carro
                6 - Aumentar Marcha
                7 - Diminuir Marcha
                8 - Virar para Esquerda
                9 - Virar para Direita
                10 - Encerrar Programa
                """);

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> ligarCarro();
            case 2 -> desligarCarro();
            case 3 -> verificarVelocidade();
            case 4 -> acelerarCarro();
            case 5 -> desacelerarCarro();
            case 6 -> aumentarMarcha();
            case 7 -> diminuirMarcha();
            case 8 -> virarParaEsquerda();
            case 9 -> virarParaDireita();
            case 10 -> encerrarPrograma();
            case 11 -> System.out.println("Opção inválida");
        }
    }

    private void ligarCarro() {
        if (isCarroLigado()) {
            System.out.println("O carro já está ligado!");
            mostrarOpcoesCarro();
        } else {
            setCarroLigado(true);
            mostrarOpcoesCarro();
        }
    }

    private void desligarCarro() {
        if (getVelocidade() == 0 && marchaSelecionada == 0) {
            setCarroLigado(false);
            System.out.println("O carro foi desligado!");
        } else {
            System.out.println("O carro não pode ser desligado, porque a sua velocidade está acima de 0 e não está no ponto morto");
        }
        mostrarOpcoesCarro();
    }

    private void acelerarCarro() {
        if (getVelocidade() == 0 && marchaSelecionada == 0 && !isCarroLigado()) {
            System.out.println("O carro não pode acelerar, porque está no ponto morto");
        } else if (getVelocidade() <= 20 && marchaSelecionada == 1) {
            velocidade++;
        } else if (getVelocidade() <= 40 && marchaSelecionada == 2) {
            velocidade++;
        } else if (getVelocidade() <= 60 && marchaSelecionada == 3) {
            velocidade++;
        } else if (getVelocidade() <= 80 && marchaSelecionada == 4) {
            velocidade++;
        } else if (getVelocidade() <= 100 && marchaSelecionada == 5) {
            velocidade++;
        } else if (getVelocidade() <= 120 && marchaSelecionada == 6) {
            velocidade++;
        } else {
            System.out.println("Você deve trocar de marcha quando atingir a velocidade máxima da marcha atual");
        }
        mostrarOpcoesCarro();
    }

    private void desacelerarCarro() {
        if (getVelocidade() == 0 && marchaSelecionada == 0 && !isCarroLigado()) {
            System.out.println("O carro não pode desacelerar, porque está no ponto morto");
        } else if (getVelocidade() <= 20 && marchaSelecionada == 1) {
            velocidade--;
        } else if (getVelocidade() <= 40 && marchaSelecionada == 2) {
            velocidade--;
        } else if (getVelocidade() <= 60 && marchaSelecionada == 3) {
            velocidade--;
        } else if (getVelocidade() <= 80 && marchaSelecionada == 4) {
            velocidade--;
        } else if (getVelocidade() <= 100 && marchaSelecionada == 5) {
            velocidade--;
        } else if (getVelocidade() <= 120 && marchaSelecionada == 6) {
            velocidade--;
        } else {
            System.out.println("Você deve trocar de marcha quando atingir a velocidade mínima da marcha atual");
        }
        mostrarOpcoesCarro();
    }

    private void aumentarMarcha() {
        if (getVelocidade() == 0 && marchaSelecionada == 0 && !isCarroLigado()) {
            System.out.println("O carro não pode trocar de marcha, porque está no ponto morto");
        } else if (getVelocidade() <= 20) {
            marchaSelecionada = marchas[1];
        } else if (getVelocidade() <= 40) {
            marchaSelecionada = marchas[2];
        } else if (getVelocidade() <= 60) {
            marchaSelecionada = marchas[3];
        } else if (getVelocidade() <= 80) {
            marchaSelecionada = marchas[4];
        } else if (getVelocidade() <= 100) {
            marchaSelecionada = marchas[5];
        } else if (getVelocidade() <= 120) {
            marchaSelecionada = marchas[6];
        } else {
            System.out.println("Você deve ter a velocidade suficiente para trocar de marcha");
            System.out.println("Velocidade atual: " + getVelocidade() + "Km/h");
        }
        mostrarOpcoesCarro();
    }

    private void diminuirMarcha() {
        if (getVelocidade() == 0 && marchaSelecionada == 0 && !isCarroLigado()) {
            System.out.println("O carro não pode trocar de marcha, porque está no ponto morto");
        } else if (getVelocidade() >= 120) {
            marchaSelecionada = marchas[6];
        } else if (getVelocidade() >= 100) {
            marchaSelecionada = marchas[5];
        } else if (getVelocidade() >= 80) {
            marchaSelecionada = marchas[4];
        } else if (getVelocidade() >= 60) {
            marchaSelecionada = marchas[3];
        } else if (getVelocidade() >= 40) {
            marchaSelecionada = marchas[2];
        } else if (getVelocidade() >= 20) {
            marchaSelecionada = marchas[1];
        } else {
            System.out.println("Você deve ter a velocidade mínima para trocar de marcha");
            System.out.println("Velocidade atual: " + getVelocidade() + "Km/h");
        }
        mostrarOpcoesCarro();
    }

    private void virarParaEsquerda() {
        if (podeVirar() && isCarroLigado()) {
            System.out.println("O carro virou para a esquerda!");
        } else {
            System.out.println("O carro não pode virar a mais de 40Km/h!");
            System.out.println("Velocidade atual: " + getVelocidade() + "Km/k");
        }
        mostrarOpcoesCarro();
    }

    private void virarParaDireita() {
        if (podeVirar()) {
            System.out.println("O carro virou para a direita!");
        } else {
            System.out.println("O carro não pode virar a mais de 40Km/h!");
            System.out.println("Velocidade atual: " + getVelocidade() + "Km/k");
        }
        mostrarOpcoesCarro();
    }

    private boolean podeVirar() {
        return (getVelocidade() <= 40);
    }

    private void verificarVelocidade() {
        System.out.println("Velocidade Atual: " + getVelocidade() + "Km/h");
        mostrarOpcoesCarro();
    }

    private void encerrarPrograma() {
        scanner.close();
        System.out.println("Programa Encerrado");
    }
}
