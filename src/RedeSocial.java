import java.util.Scanner;

public class RedeSocial {

    static Scanner scan = new Scanner(System.in);
    static Perfil[] perfis = new Perfil[100];
    static int quantPerfis = 0;

    public static void main(String[] args) {

        String opcao = null;
        do {
            System.out.println();
            System.out.println("Seja bem vindo(a) ao Mateusverso!");
            System.out.println("Digite 'C' para cadastrar-se, 'E' para entrar ou 'F' para fechar");
            opcao = scan.next();
            if (opcao.equalsIgnoreCase("C")) {
                cadastrarPerfil();
            } else if (opcao.equalsIgnoreCase("E")) {
                entrar();
            }
        } while (! opcao.equalsIgnoreCase("F"));
        System.out.println("Programa encerrado");
    }

    static void cadastrarPerfil() {
        Perfil perfil = new Perfil();
        System.out.println("Digite o nome do perfil: ");
        String a = scan.nextLine();
        perfil.nome = scan.nextLine();
        if (perfil.nome.equals("")){
            System.out.println("O nome do perfil não pode ser vazio");
            return;
        }
        System.out.println("Digite o login do perfil: ");
        perfil.login = scan.nextLine();
        if (perfil.login.equals("")){
            System.out.println("O login do perfil não pode ser vazio");
            return;
        }
        for (int i = 0; i < quantPerfis; i++) {
            if (perfis[i].login.equalsIgnoreCase(perfil.login)) {
                System.out.println("Esse login já está sendo utilizado");
                return;
            }
        }
        System.out.println("Digite a senha do perfil: ");
        perfil.senha = scan.nextLine();
        if (perfil.senha.equals("")){
            System.out.println("A senha do perfil não pode ser vazia");
            return;
        } else System.out.println("Login cadastrado com sucesso!");

        perfis[quantPerfis] = perfil;
        quantPerfis++;
    }

    static void entrar(){
        System.out.println("Digite o login: ");
        String a = scan.nextLine();
        String loginX = scan.nextLine();
        System.out.println("Digite a senha:");
        String senhaX = scan.nextLine();

        for (int i = 0; i < quantPerfis; i++) {
            if (perfis[i].login.equalsIgnoreCase(loginX)) {
                if (perfis[i].senha.equals(senhaX)){
                    System.out.println("Login aprovado");
                    menuPerfil(i);
                } else {
                    System.out.println("Senha incorreta");
                }
            }else {
                System.out.println("Login não encontrado");
            }
        }
    }

    static void menuPerfil(int i){
        String opcao = null;
        System.out.println();
        System.out.println("Bem-vindo(a), " + perfis[i].nome + "!");
        do {
            System.out.println();
            System.out.println("Digite 'P' para postar, 'T' para visualizar a sua timeline ou 'S' para sair");
            opcao = scan.next();
            if (opcao.equalsIgnoreCase("P")) {
                System.out.println("Digite a data: ");
                String a = scan.nextLine();
                String data = scan.nextLine();
                System.out.println("Digite a hora: ");
                String hora = scan.nextLine();
                System.out.println("Digite o texto: ");
                String texto = scan.nextLine();

                perfis[i].postar(data, hora, texto);
            } else if (opcao.equalsIgnoreCase("T")) {
                perfis[i].imprimirPerfil();
            }
        } while (! opcao.equalsIgnoreCase("S"));
        System.out.println("Até logo, " + perfis[i].nome + "!");
    }
}
