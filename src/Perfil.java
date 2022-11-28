public class Perfil {
    String nome;
    String login;
    String senha;

    Post[] posts = new Post[100];
    int quantPosts = 0;

    public void postar(String data, String hora, String texto){
        Post p = new Post();
        p.data = data;
        p.hora = hora;
        p.texto = texto;
        System.out.println();
        System.out.println("Post enviado com sucesso!");
        this.posts[quantPosts++] = p;
    }
    public void imprimirPerfil(){
        System.out.println();
        System.out.println("Timeline de: " + nome);
        System.out.println("Login: " + login);
        System.out.println("Posts:");
        for (int i = 0; i < this.quantPosts; i++) {
            posts[i].imprimirPost();
        }
    }
}
