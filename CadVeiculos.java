import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main() {

    IO.println("Bem vindo ao Sistema CadVeiculos");

    String menu = """
            MENU DE OPÇÕES
            1 - Cadastrar Veículo
            2 - Listar Veículos
            3 - Remover Veículo por Índice
            4 - Buscar Veículo por Nome
            5 - Editar Veículo
            6 - Remover Veículo por Nome
            0 - Sair
            """;

    int opcao;

    do {

        IO.println(menu);

        opcao = Input.scanInt("Digite a opção desejada: ");

        switch (opcao) {

            case 1 -> {
                cadastrar();
                IO.readln("Pressione Enter para continuar");
            }

            case 2 -> {
                listar();
                IO.readln("Pressione Enter para continuar");
            }

            case 3 -> {
                excluir();
                IO.readln("Pressione Enter para continuar");
            }

            case 4 -> {
                buscar();
                IO.readln("Pressione Enter para continuar");
            }

            case 5 -> {
                editar();
                IO.readln("Pressione Enter para continuar");
            }

            case 6 -> {
                removerPorNome();
                IO.readln("Pressione Enter para continuar");
            }

            case 0 -> {
                IO.println("Volte sempre!!!");
            }

            default -> {
                IO.println("Opção inválida");
                IO.readln("Pressione Enter para continuar");
            }
        }

    } while (opcao != 0);

}

void cadastrar() {

    String veiculo = IO.readln("Digite o nome do novo veículo: ");

    veiculo = veiculo.trim();

    if (veiculo.isEmpty()) {
        IO.println("Nome do veículo inválido!");
        return;
    }

    for (int i = 0; i < veiculos.size(); i++) {

        if (veiculos.get(i).equalsIgnoreCase(veiculo)) {

            IO.println("Veículo já cadastrado!");
            return;

        }
    }

    veiculos.add(veiculo);

    IO.println("Veículo cadastrado com sucesso!");

}

void listar() {

    if (veiculos.size() == 0) {

        IO.println("A lista de veículos está vazia.");
        return;

    }

    ordenar();

    IO.println("Lista de veículos:");

    for (int i = 0; i < veiculos.size(); i++) {

        IO.println((i + 1) + " - " + veiculos.get(i));

    }

    IO.println("Total de veículos: " + veiculos.size());

}

void excluir() {

    if (veiculos.size() == 0) {

        IO.println("A lista está vazia.");
        return;

    }

    listar();

    int indice = Input.scanInt("Digite o índice do veículo a ser removido: ");

    if (indice > veiculos.size() || indice <= 0) {

        IO.println("Veículo não encontrado");

    } else {

        veiculos.remove(indice - 1);

        IO.println("Veículo removido com sucesso!");

    }

}

void buscar() {

    if (veiculos.size() == 0) {

        IO.println("A lista de veículos está vazia.");
        return;

    }

    ordenar();

    String nome = IO.readln("Digite o nome do veículo: ");

    boolean encontrado = false;

    for (int i = 0; i < veiculos.size(); i++) {

        if (veiculos.get(i).equalsIgnoreCase(nome)) {

            IO.println("Veículo encontrado: " + veiculos.get(i));
            encontrado = true;

        }

    }

    if (!encontrado) {

        IO.println("Veículo não encontrado.");

    }

    IO.println("Total de veículos cadastrados: " + veiculos.size());

}

void editar() {

    if (veiculos.size() == 0) {

        IO.println("A lista está vazia.");
        return;

    }

    listar();

    int indice = Input.scanInt("Digite o índice do veículo a editar: ");

    if (indice > veiculos.size() || indice <= 0) {

        IO.println("Veículo não encontrado");
        return;

    }

    String novoNome = IO.readln("Digite o novo nome do veículo: ");

    novoNome = novoNome.trim();

    if (novoNome.isEmpty()) {

        IO.println("Nome inválido");
        return;

    }

    for (int i = 0; i < veiculos.size(); i++) {

        if (veiculos.get(i).equalsIgnoreCase(novoNome)) {

            IO.println("Já existe um veículo com esse nome.");
            return;

        }

    }

    veiculos.set(indice - 1, novoNome);

    IO.println("Veículo atualizado com sucesso!");

}

void removerPorNome() {

    if (veiculos.size() == 0) {

        IO.println("A lista está vazia.");
        return;

    }

    String nome = IO.readln("Digite o nome do veículo a remover: ");

    for (int i = 0; i < veiculos.size(); i++) {

        if (veiculos.get(i).equalsIgnoreCase(nome)) {

            veiculos.remove(i);

            IO.println("Veículo removido com sucesso!");

            return;

        }

    }

    IO.println("Veículo não encontrado.");

}

void ordenar() {

    for (int i = 0; i < veiculos.size() - 1; i++) {

        for (int j = 0; j < veiculos.size() - 1 - i; j++) {

            String a = veiculos.get(j);
            String b = veiculos.get(j + 1);

            if (a.compareToIgnoreCase(b) > 0) {

                String temp = veiculos.get(j);

                veiculos.set(j, veiculos.get(j + 1));

                veiculos.set(j + 1, temp);

            }

        }

    }

}
