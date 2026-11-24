import java.util.ArrayList;
import java.util.List;

public class Barbearia {

    private List<Agendamento> agendamentos = new ArrayList<>();

    // Cadastrar agendamento
    public void adicionar(Agendamento agendamento) {
        agendamentos.add(agendamento);
        System.out.println("Agendamento cadastrado com sucesso!");
    }

    // Remover agendamento pelo ID
    public void remover(int id) {
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).getId() == id) {
                agendamentos.remove(i);
                System.out.println("Agendamento removido com sucesso!");
                return;
            }
        }

        System.out.println("Agendamento não encontrado.");
    }

    // Listar agendamentos na ordem em que foram cadastrados
    public void listar() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado.");
            return;
        }

        System.out.println("\n--- AGENDAMENTOS ---");

        for (Agendamento agendamento : agendamentos) {
            agendamento.exibir();
        }
    }

    // Bubble Sort por horário
    public void ordenarPorHorario() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado.");
            return;
        }

        for (int i = 0; i < agendamentos.size() - 1; i++) {
            for (int j = 0; j < agendamentos.size() - 1 - i; j++) {

                if (agendamentos.get(j).getHorario()
                        .isAfter(agendamentos.get(j + 1).getHorario())) {

                    Agendamento temp = agendamentos.get(j);

                    agendamentos.set(j, agendamentos.get(j + 1));
                    agendamentos.set(j + 1, temp);
                }
            }
        }

        System.out.println("Agendamentos ordenados por horário!");
        listar();
    }
}