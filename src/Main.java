import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Barbearia barbearia = new Barbearia();

        int proximoId = 1;
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE BARBEARIA =====");
            System.out.println("1 - Cadastrar agendamento");
            System.out.println("2 - Remover agendamento");
            System.out.println("3 - Listar agendamentos");
            System.out.println("4 - Ordenar por horário (Bubble Sort)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    System.out.println("\n--- NOVO AGENDAMENTO ---");

                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();

                    LocalTime horario;
                    String entradaHorario;

                    while (true) {
                        System.out.print("Horário (HH:mm): ");
                        entradaHorario = sc.nextLine();

                        try {
                            horario = LocalTime.parse(entradaHorario);
                            break;
                        } catch (Exception e) {
                            System.out.println("Horário inválido! Digite novamente (ex: 14:30).");
                        }
                    }

                    System.out.print("Serviço: ");
                    String servico = sc.nextLine();

                    Agendamento novo = new Agendamento(
                            proximoId,
                            nome,
                            horario,
                            servico
                    );

                    barbearia.adicionar(novo);
                    proximoId++;
                    break;

                case 2:
                    System.out.println("\n--- REMOVER AGENDAMENTO ---");

                    barbearia.listar();

                    System.out.print("\nDigite o ID do agendamento que deseja remover: ");

                    try {
                        int id = Integer.parseInt(sc.nextLine());
                        barbearia.remover(id);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido.");
                    }
                    break;

                case 3:
                    barbearia.listar();
                    break;

                case 4:
                    barbearia.ordenarPorHorario();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}