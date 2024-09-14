package estacionamento;

import java.util.*;

public class Tempo {

    private int Hora;
    private int Minuto;
    private int Segundo;

    public Tempo() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        Calendar C = Calendar.getInstance();
        this.Hora = C.get(Calendar.HOUR_OF_DAY);
        this.Minuto = C.get(Calendar.MINUTE);
        this.Segundo = C.get(Calendar.SECOND);
    }

    public Tempo(int Hora, int Minuto) {
        if (Hora < 0 || Hora > 23) {
            Hora = Minuto = Segundo = 0;
        } else if (Minuto < 0 || Minuto > 59) {
            Hora = Minuto = Segundo = 0;
        }
        this.Hora = Hora;
        this.Minuto = Minuto;
        this.Segundo = 0;
    }

    public void setTempo(int Hora, int Minuto, int Segundo) {
        if (Hora < 0 || Hora > 23) {
            Hora = Minuto = Segundo = 0;
        } else if (Minuto < 0 || Minuto > 59) {
            Hora = Minuto = Segundo = 0;
        } else if (Segundo < 0 || Segundo > 59) {
            Hora = Minuto = Segundo = 0;
        }
        this.Hora = Hora;
        this.Minuto = Minuto;
        this.Segundo = Segundo;
    }

    public String toString() {
        return "Hora: " + Hora + ":" + Minuto + ":" + Segundo;
    }

    public int Subtrair(Tempo T) {
        int sec_time = 0, Tsec_time = 0;
        sec_time = Hora * 3600 + Minuto * 60 + Segundo;
        Tsec_time = T.Hora * 3600 + T.Minuto * 60 + T.Segundo;

        return (sec_time - Tsec_time) / 60;
    }
}
