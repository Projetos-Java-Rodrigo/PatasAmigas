
import controllers.*;
import java.util.Scanner;
import model.*;
import view.FiltroView;
import view.Menus;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        // Exibe o menu somente até o momento em que o usuário escolhe a opção 'Sair'
        do {
            escolha = Menus.menuPrincipal(scanner, escolha);

            switch (escolha) {
                case 1:
                    int escolhaCadastro = 0;
                    System.out.println();
                    escolhaCadastro = Menus.menuCadastro(scanner, escolhaCadastro);

                    switch (escolhaCadastro) {
                        case 1:
                            PessoaController.cadastrarPessoa(scanner);
                            System.out.println("Pessoa cadastrada com sucesso!");
                            break;
                        case 2:
                            System.out.println();
                            AnimalController.cadastrarAnimal(scanner);
                            System.out.println("\nAnimal cadastrado com sucesso!!!");
                            break;

                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println();
                    Pessoa pessoa = PessoaController.escolherPessoa(scanner);
                    if (pessoa != null) {
                        PessoaController.editarPessoa(scanner, pessoa);
                        System.out.println("Pessoa editada com sucesso!");
                    }
                    break;

                case 3:
                    int escolhaVisualizacao = 0;
                    System.out.println();
                    escolhaVisualizacao = Menus.menuVisualizacao(scanner, escolhaVisualizacao);

                    switch (escolhaVisualizacao) {
                        case 1:
                            PessoaController.visualizarDadosPessoa(scanner);
                            break;

                        case 2:
                            AnimalController.visualizarDadosAnimal(scanner);
                            break;

                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 4:
                    FiltroView.buscaPorFiltro(scanner);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (escolha != 5);
        scanner.close();
    }

}
