import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

    private char[][] arrayLabirinto;
    private int linhas;
    private int colunas;

    public char[][] carregaLabirinto(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        this.linhas = Integer.parseInt(br.readLine().trim());
        this.colunas = Integer.parseInt(br.readLine().trim());
        this.arrayLabirinto = new char[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            String line = br.readLine();
            for (int j = 0; j < colunas; j++) {
                this.arrayLabirinto[i][j] = line.charAt(j);
            }
        }
        br.close();
        return arrayLabirinto;
    }


    public boolean labirinto(char[][] labirinto, int linhaAtual, int colunaAtual) {
        return labirinto(linhaAtual, colunaAtual);
    }

    private boolean labirinto(int linhaAtual, int colunaAtual) {
        if (linhaAtual < 0 || linhaAtual >= linhas || colunaAtual < 0 || colunaAtual >= colunas) {
            return false;
        }
        if (arrayLabirinto[linhaAtual][colunaAtual] == 'D') {
            return true;
        }
        if (arrayLabirinto[linhaAtual][colunaAtual] == 'X') {
            return false;
        }
        arrayLabirinto[linhaAtual][colunaAtual] = 'X';
        boolean resultado = labirinto(linhaAtual + 1, colunaAtual) || labirinto(linhaAtual - 1, colunaAtual)
                || labirinto(linhaAtual, colunaAtual + 1) || labirinto(linhaAtual, colunaAtual - 1);
        arrayLabirinto[linhaAtual][colunaAtual] = ' ';
        return resultado;
    }

}
