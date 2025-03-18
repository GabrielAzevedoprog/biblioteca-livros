package code;

import java.util.Scanner;

public class Main {

    /* VARIAVEIS */
    static Scanner scanner = new Scanner(System.in);
    static String[] titulo = new String[50];
    static String[] autor = new String[50];
    static int contador = 0;
    static boolean encontrou;

    /* METODO MAIN PRINCIPAL */
    public static void main(String[] args) {

        boolean finalizar = false;
        int opcao;

        while (!finalizar) {

            System.out.println("--------------------MENU---------------------");
            System.out.println("1- Adicionar Novo Livro");
            System.out.println("2- Pesquisar Livro por Título");
            System.out.println("3- Excluir Livro pelo Título");
            System.out.println("4- Listar Todos os Livros");
            System.out.println("5- Sair do Sistema");
            System.out.println("---------------------------------------------");

            System.out.println("Qual opção deseja? ");
            opcao = Integer.parseInt(scanner.nextLine());
            System.out.println("---------------------------------------------");

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivroTitulo();
                    break;
                case 3:
                    excluirLivro();
                    break;
                case 4:
                    listarLivro();
                    break;
                case 5:
                    System.out.println("Agradecemos por utilizar nossa biblioteca.");
                    System.out.println("---------------------------------------------");
                    finalizar = true;
                    scanner.close();
            }
        }
    }

    /* METODO ADICIONAR LIVRO */
    public static void adicionarLivro() {

        if (contador < titulo.length) {
            System.out.println("Digite o titulo: ");
            String nomeTitulo = scanner.nextLine();

            System.out.println("Digite o autor: ");
            String nomeDescricao = scanner.nextLine();

            if (nomeTitulo.isEmpty() || nomeDescricao.isEmpty()) {
                System.out.println("Por favor, preencha todos os campos obrigatórios.");

            } else {
                System.out.println("Livro cadastrado com sucesso!");
                System.out.println("---------------------------------------------");

                titulo[contador] = nomeTitulo;
                autor[contador] = nomeDescricao;

                contador++;
            }
        }
    }

    /* METODO LISTAR LIVRO */
    public static void listarLivro() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Livro ID "+ i);
            System.out.println("Titulo: " + titulo[i]);
            System.out.println("Descrição: " + autor[i]);
            System.out.println("---------------------------------------------");
        }
        if (titulo[0] == null) {
            System.out.println("Nenhum livro cadastrado!");
        }
    }

    /* METODO LISTAR LIVRO ESPECIFICO */
    public static void listarLivroTitulo() {
        System.out.println("Informe o livro que deseja procurar: ");
        String nome = scanner.nextLine();

        for (int i = 0; i < contador; i++) {
            if (titulo[i].equalsIgnoreCase(nome)) {
                encontrou = true;
                System.out.println("Livro " + nome + " foi encontrado no ID " + i);
                System.out.println("Titulo: " + titulo[i]);
                System.out.println("Autor: " + autor[i]);
                break;
            }
        }
        retornarNao();
    }

    /* METODO EXCLUIR LIVRO ESPECIFICO */
    public static void excluirLivro() {
        System.out.println("Informe o livro que deseja excluir: ");
        String nome = scanner.nextLine();

        for (int i = 0; i < contador; i++) {
            if (titulo[i].equalsIgnoreCase(nome)) {
                encontrou = true;
                titulo[i] = null;
                autor[i] = null;
                System.out.println("Livro excluido com sucesso!");
                break;
            }
        }
        retornarNao();
    }

    /* METODO RETORNAR SE NÃO ENCONTROU */
    public static void retornarNao() {
        if (!encontrou) {
            System.out.println("Livro não encontrado.");
        }
    }
}