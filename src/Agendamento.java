import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {

    private int id;
    private String nomeCliente;
    private LocalTime horario;
    private String servico;

    public Agendamento(int id, String nomeCliente, LocalTime horario, String servico) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.horario = horario;
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getServico() {
        return servico;
    }

    public void exibir() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("ID: " + id
                + " | Cliente: " + nomeCliente
                + " | Horário: " + horario.format(formato)
                + " | Serviço: " + servico);
    }
}