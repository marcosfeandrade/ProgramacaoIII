package marvel;

import java.util.Scanner;

public class Marvel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numIdentif = new int[100];
        int[] classe = new int[100];
        int[] ano = new int[100];
        String[] nome = new String[100];
        String[] poder = new String[100];
        char[] morreuThanos = new char[100];
        int qtd = 0, numeroBuscado;
        char retorno;
        do {
            retorno = menu();
            switch (retorno) {
                case '1':
                    qtd = incluirPersonagem(numIdentif, classe, ano, nome, poder,
                            morreuThanos, qtd);
                    System.out.println("Personagem cadastrado!");
                    break;
                case '2':
                    System.out.println("Número de identificação do "
                            + "personagem buscado: ");
                    numeroBuscado = in.nextInt();
                    int retorno2 = consultarPersonagem(numIdentif, numeroBuscado, qtd);
                    if (retorno2 == -1) {
                        System.out.println("Personagem não encontrado!");
                    } else {
                        System.out.println("Número: " + numIdentif[retorno2]);
                        System.out.println("Nome: " + nome[retorno2]);
                        System.out.println("Classe: " + classe[retorno2]);
                        System.out.println("Poder: " + poder[retorno2]);
                        System.out.println("Ano de criação: " + ano[retorno2]);
                        if (Character.toLowerCase(morreuThanos[retorno2]) == 's') {
                            System.out.println("O personagem" + nome[retorno2]
                                    + " morreu para o Thanos");
                        } else {
                            System.out.println("O personagem " + nome[retorno2]
                                    + " não morreu para o Thanos");
                        }
                    }
                    break;
                case '3':
                    System.out.println("Número de identificação do personagem"
                            + " a ser excluido:");
                    numeroBuscado = in.nextInt();
                    excluirPersonagem(numIdentif, qtd, numeroBuscado);
                    break;
                case '4':
                    listarTodosPersonagens(numIdentif, nome, classe,
                            poder, ano, morreuThanos, qtd);
                    break;
                case '5':
                    System.out.println("Qual classe deseja listar?");
                    System.out.println("Classe do personagem "
                            + "(1- Herói, 2- vilão):");
                    numeroBuscado = in.nextInt();
                    while(numeroBuscado != 1 && numeroBuscado != 2){
                        System.out.println("Número inválido. Insira novamente");
                        numeroBuscado = in.nextInt();
                    }
                    listarClasse(nome, classe, qtd, numeroBuscado);
                    break;
                case '6':
                    listarSobreviventes(nome, morreuThanos, qtd);
                    break;
                case '7':
                    break;
                default:
                    System.out.println("Número inválido.");
                    break;
            }
        } while (retorno != '7');
    }

    public static char menu() {
        Scanner in = new Scanner(System.in);
        char resp;
        System.out.println("Escolha o que você deseja:");
        System.out.println("1- Incluir personagem;");
        System.out.println("2- Consultar personagem;");
        System.out.println("3- Excluir personagem;");
        System.out.println("4- Listar todos os personagens;");
        System.out.println("5- Listar por classe de personagem;");
        System.out.println("6- Listar os personagens sobreviventes ao estalo do"
                + " Thanos.");
        System.out.println("7- Encerrar programa");
        resp = in.next().charAt(0);
        return resp;
    }

    public static int incluirPersonagem(int[] numIdentif, int[] classe,
            int[] ano, String[] nome, String[] poder, char[] morreuThanos,
            int qtd) {
        Scanner in = new Scanner(System.in);
        System.out.println("Numero de identificação do personagem:");
        numIdentif[qtd] = in.nextInt();
        in.nextLine();
        System.out.println("Nome do personagem:");
        nome[qtd] = in.nextLine();
        System.out.println("Classe (1- Herói ou 2- Vilão):");
        classe[qtd] = in.nextInt();
        while (classe[qtd] != 1 && classe[qtd] != 2) {
            System.out.println("Classe inválida. Insira novamente");
            classe[qtd] = in.nextInt();
        }
        in.nextLine();
        System.out.println("Poder principal do personagem: ");
        poder[qtd] = in.nextLine();
        System.out.println("Ano de criação do personagem: ");
        ano[qtd] = in.nextInt();
        in.nextLine();
        System.out.println("O personagem " + nome[qtd] + " foi morto "
                + "pelo Thanos(s para sim e n para não)?");
        morreuThanos[qtd] = in.next().charAt(0);
        while (Character.toLowerCase(morreuThanos[qtd]) != 's'
                && Character.toLowerCase(morreuThanos[qtd]) != 'n') {
            System.out.println("Resposta inválida. Insira novamente:");
            morreuThanos[qtd] = in.next().charAt(0);
        }
        return ++qtd;
    }

    public static int consultarPersonagem(int[] numIdentif,
            int numeroBuscado, int qtd) {
        int achou = -1;
        for (int i = 0; i < qtd; i++) {
            if (numIdentif[i] == numeroBuscado) {
                achou = i;
                break;
            } else {
                achou = -1;
            }
        }
        return achou;
    }

    public static int excluirPersonagem(int[] numIdentif, int qtt,
            int numeroBuscado) {
        int i, aux;
        aux = consultarPersonagem(numIdentif, qtt, numeroBuscado);
        if (aux == -1) {
            System.out.println("Personagem não cadastrado.");
        } else {
            for (i = 0; i < qtt; i++) {
                if (numIdentif[i] == numeroBuscado) {
                    numIdentif[i] = numIdentif[i + 1];
                }
            }
        }
        return --qtt;
    }

    public static void listarTodosPersonagens(int[] numIdentif, String[] nome,
            int[] classe, String[] poder, int[] ano,
            char[] morreuThanos, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.println("Personagem " + (i + 1));
            System.out.println("Número: " + numIdentif[i]);
            System.out.println("Nome: " + nome[i]);
            System.out.println("Classe: " + classe[i]);
            System.out.println("Poder: " + poder[i]);
            System.out.println("Ano de criação: " + ano[i]);
            if (Character.toLowerCase(morreuThanos[i]) == 's') {
                System.out.println("O personagem" + nome[i]
                        + " morreu para o Thanos");
            } else {
                System.out.println("O personagem " + nome[i]
                        + " não morreu para o Thanos");
            }
        }
    }
    
    public static void listarClasse (String[] nome,int [] classe, 
            int qtd, int numeroBuscado){
        for (int i = 0; i < qtd; i++) {
            if(classe[i] == numeroBuscado){
            System.out.println("Nome: " + nome[i]);
        }
        }
    }
    
    public static void listarSobreviventes (String[] nome,char[] morreuThanos, 
            int qtd){
        System.out.println("Personagens que sobreviveram ao estalo do Thanos:");
        for (int i = 0; i < qtd; i++) {
            if(Character.toLowerCase(morreuThanos [i]) == 'n'){
                System.out.println("Nome: " + nome[i]);
            }
        }
    }
}
