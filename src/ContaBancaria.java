/*
    *
    *   Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
    *   Consultar saldo
    *   consultar cheque especial
    *   Depositar dinheiro;
    *   Sacar dinheiro;
    *   Pagar um boleto.
    *   Verificar se a conta está usando cheque especial.
    *
    *   Siga as seguintes regras para implementar

    *   A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
    *   O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
    *   Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
    *   Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
    *   Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
    *
    *
 */

import java.util.Scanner;

public class ContaBancaria {
    private float saldo;
    private float chequeEspecial;
    private boolean usandoChequeEspecial = false;
    private final Scanner scanner = new Scanner(System.in);

    ContaBancaria(float saldo) {
        if (valorInvalido(saldo)) {
            throw new IllegalArgumentException("Não pode inserir um valor de saldo menor ou igual a 0");
        } else {
            this.saldo = saldo;
            setChequeEspecial();
        }
    }

    public void mostrarOperacoes() {
        System.out.println(
                """
                        OPERAÇÕES DISPONÍVEIS
                        =======================
                        1 - Consultar saldo da conta
                        2 - Depositar dinheiro na conta
                        3 - Sacar dinheiro da conta
                        4 - Verificar se está usando cheque especial
                        5 - Consultar o valor disponível de cheque especial
                        6 - Usar cheque especial
                        7 - Pagar cheque especial
                        8 - Sair do programa
                """
        );

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> consultarSaldo();
            case 2 -> depositarDinheiro();
            case 3 -> sacarDinheiro();
            case 4 -> consultarSeUsaChequeEspecial();
            case 5 -> consultarValorChequeEspecial();
            case 6 -> usarChequeEspecial();
            case 7 -> pagarBoleto();
            case 8 -> encerrarPrograma();
            default -> System.out.println("Opção inválida!");
        }
    }

    private float getSaldo() {
        return saldo;
    }

    private void consultarSaldo() {
        System.out.println("Saldo na conta: " + getSaldo());
        mostrarOperacoes();
    }

    private void depositarDinheiro() {
        System.out.println("Digite o valor que você deseja depositar na sua conta...");
        float dinheiro = scanner.nextFloat();
        if (valorInvalido(dinheiro)) {
            throw new IllegalArgumentException("O depósito de dinheiro não pode ser menor ou igual a zero");
        } else {
            saldo += dinheiro;
            System.out.println("Dinheiro depositado com sucesso!");
        }
        mostrarOperacoes();
    }

    private void sacarDinheiro() {
        System.out.println("Digite o valor que você deseja sacar da sua conta...");
        float dinheiro = scanner.nextFloat();
        if (dinheiro > getSaldo()) {
            throw new IllegalArgumentException("O saque não pode ser um valor maior do que o saldo na conta");
        } else {
            saldo -= dinheiro;
        }
        mostrarOperacoes();
    }

    private boolean isUsandoChequeEspecial() {
        return usandoChequeEspecial;
    }

    private float getChequeEspecial() {
        return chequeEspecial;
    }

    private void consultarValorChequeEspecial() {
        System.out.println("Valor de cheque especial: " + chequeEspecial);
        mostrarOperacoes();
    }

    private void setChequeEspecial() {
        if (getSaldo() <= 500) {
            chequeEspecial = getSaldo() * 0.1F;
        } else {
            chequeEspecial = getSaldo() * 0.5F;
        }
    }

    private void usarChequeEspecial() {
        System.out.println("Você tem certeza que quer utilizar o cheque especial!");
        String opcao = scanner.next();

        switch (opcao.toLowerCase()) {
            case "sim" -> {
                saldo += chequeEspecial;
                setUsandoChequeEspecial(true);
                System.out.println("Cheque especial utilizado com sucesso!");
            }
            case "não" -> {
                System.out.println("Cheque especial não utilizado!");
                System.out.println("Operação cancelada!");
            }
            default -> {
                System.out.println("Digitação inválida");
                System.out.println("Operação cancelada!");
            }
        }
        mostrarOperacoes();
    }

    private void consultarSeUsaChequeEspecial() {
        System.out.println("Usando cheque especial: " + usandoChequeEspecial);
        mostrarOperacoes();
    }

    private void setUsandoChequeEspecial(boolean usandoChequeEspecial) {
        this.usandoChequeEspecial = usandoChequeEspecial;
    }

    private boolean valorInvalido(float valor) {
        return (valor <= 0);
    }

    private void pagarBoleto() {
        String[] nomesBoleto = {"Cheque especial"}; // Pode adicionar mais boletos para pagar
        float[] valoresBoleto = {getChequeEspecial()}; // Pode adicionar mais valores de boleto para pagar
        if (isUsandoChequeEspecial()) {
            System.out.println("Pague o cheque especial");
            System.out.println(nomesBoleto[0] + " | Valor à pagar:" + valoresBoleto[0]);
            System.out.println("Você gostaria de pagar a conta? | 1 - Sim / 2 - Não");
            int confirmacao = scanner.nextInt();
            if (confirmacao == 1) {
                if (getSaldo() < valoresBoleto[0]) {
                    System.out.println("Não há valor disponível para pagar a conta!");
                    mostrarOperacoes();
                } else {
                    saldo -= valoresBoleto[0];
                    setUsandoChequeEspecial(false);
                    System.out.println("Conta paga com sucesso!");
                    mostrarOperacoes();
                }
            } else {
                System.out.println("Operação cancelada!");
                mostrarOperacoes();
            }
        }
    }

    private void encerrarPrograma() {
        scanner.close();
        System.out.println("Programa encerrado");
    }
}
