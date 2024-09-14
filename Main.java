package estacionamento;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] Args) {
        Estacionamento[] Est = new Estacionamento[100];
        int QtdEst = 0, opcao, h, m, f;
        String p;
        do {
            f = 0;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "[1] Novo Estacionamento\n[2] Registrar Saída\n[3] Pagamento\n[4]Listar\n[0] Fechar\n"));
            switch (opcao) {
                case 1:
                    p = JOptionPane.showInputDialog(null, "Digite a placa do veículo:");
                    h = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a hora:"));
                    m = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o minuto:"));
                    Est[QtdEst++] = new Estacionamento(p, h, m, "Em aberto");
                    break;
                case 2:
                    p = JOptionPane.showInputDialog(null, "Digite a placa do veículo:");
                    f = 0;
                    for (int i = 0; Est[i] != null; i++) {
                        if(Est[i].getPlaca().equals(p)){
                            h = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a hora:"));
                            m = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o minuto:"));
                            Est[i].RegistrarSaida(h, m);
                            f = 1;
                            break;
                        }
                    }
                    if(f == 0) JOptionPane.showMessageDialog(null, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    p = JOptionPane.showInputDialog(null, "Digite a placa do veículo que efetuou o pagamento:");
                    f = 0;
                    for (int i = 0; Est[i] != null; i++) {
                        if(Est[i].getPlaca().equals(p)){
                            Est[i].setStatus("Pago");
                            f = 1;
                        }
                    }
                    if(f == 0) JOptionPane.showMessageDialog(null, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, Estacionamento.TransformaEst(Est));
                    break;
            }
        } while (opcao != 0);
    }
}
