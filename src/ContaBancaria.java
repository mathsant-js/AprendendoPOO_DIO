public class ContaBancaria {
    private float saldo;
    private float chequeEspecial;
    private boolean usandoChequeEspecial = false;

    ContaBancaria(float saldo) {
        if (valorInvalido(saldo)) {
            throw new IllegalArgumentException("Não pode inserir um valor de saldo menor ou igual a 0");
        } else {
            this.saldo = saldo;
            setChequeEspecial();
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public void depositarDinheiro(float dinheiro) {
        if (valorInvalido(dinheiro)) {
            throw new IllegalArgumentException("O depósito de dinheiro não pode ser menor ou igual a zero");
        } else {
            saldo += dinheiro;
            System.out.println("Dinheiro depositado com sucesso!");
        }
    }

    public void sacarDinheiro(float dinheiro) {
        if (dinheiro > getSaldo()) {
            throw new IllegalArgumentException("O saque não pode ser um valor maior do que o saldo na conta");
        } else {
            saldo -= dinheiro;
        }
    }

    public float getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial() {
        if (getSaldo() <= 500) {
            this.chequeEspecial = getSaldo() * 0.1F;
        } else {
            this.chequeEspecial = getSaldo() * 0.5F;
        }
    }

    public boolean isUsandoChequeEspecial() {
        return usandoChequeEspecial;
    }

    public void setUsandoChequeEspecial(boolean usandoChequeEspecial) {
        this.usandoChequeEspecial = usandoChequeEspecial;
    }

    public boolean valorInvalido(float valor) {
        return (valor >= 0);
    }
}
