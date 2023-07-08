import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalLabirinto {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Digite o nome do arquivo do labirinto: ");
        String nomeArquivo = scanner.nextLine();
        
        Labirinto labirinto = new Labirinto();
        char[][] labirintoArray = labirinto.carregaLabirinto(nomeArquivo);
        
        if(labirinto.labirinto(labirintoArray, 0, 0)) {
            System.out.println("Existe um caminho para o labirinto");
            escreveArquivo("saidaLabirinto.txt", "Existe um caminho para o labirinto");
        } else {
            System.out.println("Não existe um caminho para o labirinto");
            escreveArquivo("saidaLabirinto.txt", "Não existe um caminho para o labirinto");
        }
    }
    
    public static void escreveArquivo(String nomeArquivo, String conteudo) {
        try {
            File arquivo = new File(nomeArquivo);
            FileWriter escritor = new FileWriter(arquivo);
            escritor.write(conteudo);
            escritor.close();
        } catch(IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}
