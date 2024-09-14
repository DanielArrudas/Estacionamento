package estacionamento;

public class Estacionamento {

    private String Placa;
    private Tempo HoraEntrada;
    private Tempo HoraSaida;
    private double ValorPago;
    private String Status;

    public Estacionamento(String P, int H, int M, String Status) {
        this.HoraEntrada = new Tempo(H, M);
        this.Placa = P;
        this.Status = Status;
    }

    public void CalcularValor() {
        int S = HoraSaida.Subtrair(HoraEntrada);
        S = S / 15;
        ValorPago = S * 3;
    }

    public void RegistrarSaida(int H, int M) {
        HoraSaida = new Tempo(H, M);
        CalcularValor();
    }
    
    

    public static String TransformaEst(Estacionamento Est[]) {
        String p = "";
        for (int i = 0; Est[i] != null; i++) {
            p = p + Est[i];
        }
        return p;
    }

    public String toString() {
        return "Placa: " + getPlaca() + "\n" + "Hora de Entrada: " + HoraEntrada
                + "\n" + "Hora de Saída: " + HoraSaida + "\n" + "Valor: " + 
                ValorPago + "\n" + "Status: " + getStatus() + "\n";
    }

    public String getPlaca() {
        return Placa;
    }
    public void setValorPago(double ValorPago) {
        this.ValorPago = ValorPago;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
