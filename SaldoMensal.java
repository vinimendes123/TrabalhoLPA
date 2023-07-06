package Trabalho;
import java.util.Scanner;
public class SaldoMensal {
    public static void inserirProdutos(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;
        mostrarCalendario(matriz, linhas, colunas);
        float saldomensal1 = 0.0f;
        do {
            System.out.println("Informe o mês de inserção: ");
            linha = scanner.nextInt();
            if (linha <1 || linha >12) {
                System.out.println("Opção inválida! Digite uma opção entre 1 e 12.");
            }
        } while (linha < 1 || linha > linhas);

        System.out.println("Mês: ");
        matriz[linha - 1][0] = scanner.next();
        System.out.println("Entradas: ");
        matriz[linha - 1][1] = scanner.next();
        System.out.println("Saídas: ");
        matriz[linha - 1][2] = scanner.next();

        float entradas = Float.parseFloat(matriz[linha - 1][1]);
        float saidas = Float.parseFloat(matriz[linha - 1][2]);
        float saldoMensal = entradas - saidas;
        matriz[linha - 1][3] = String.valueOf(saldoMensal);

        System.out.println("Saldo mensal é de " + saldoMensal);
        System.out.println("Valores adicionados.");
    }
    public static void mostrarCalendario(String [][] matriz, int linhas, int colunas) {

        System.out.println("Mês | Entradas | Saídas | Saldo Mês" );
        for(int i = 0; i < linhas; i++) {
            System.out.print((i+1) + " - ");
            for(int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");

            }
            System.out.println();
        }
    }

    public static void calcularSaldo(String [][] matriz, int linhas) {
        Float valorFinal = 0.0f;
        for(int i = 0; i < linhas; i++) {
            if(matriz[i][0] != null) {
                valorFinal = valorFinal + (Float.parseFloat(matriz[i][1]) - Float.parseFloat(matriz[i][2]));
            }
        }
        System.out.println("Seu saldo total é de R$: " + valorFinal);
    }

    public static void apagarMes(String [][] matriz, int linhas, String nomeMes) {
        boolean encontrado = false;
        for(int i = 0; i < linhas; i++) {
            if(matriz[i][0] != null && matriz[i][0].equals(nomeMes)) {
                encontrado = true;
                matriz[i][0] = null;
                matriz[i][1] = null;
                matriz[i][2] = null;
            }
        }
        if(encontrado) {
            System.out.println("Mês removido.");
        } else {
            System.out.println("Esse mês não foi encontrado no sistema .");
        }
    }



    public static void main(String[] args) {
        String [][] lista;
        int  opcao;
        int colunas = 4;
        int meses = 12;
        Scanner scanner = new Scanner(System.in);
        String nomeMes;

        lista = new String[meses][colunas];

        do {
            System.out.println("\n 1 - Mostrar calendário. \n 2 - Inserir informações. \n 3 - Calcular saldo. \n 4 - Remover mês. \n 0 - Sair.\n Escolha uma opção: ");
            System.out.println();
            opcao = scanner.nextInt();
            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida! Digite uma opção entre 0 e 4.");
                continue;
            }
            switch(opcao) {
                case 0:
                    break;
                case 1:
                    mostrarCalendario(lista, meses, colunas);
                    break;
                case 2:
                    inserirProdutos(lista, meses, colunas);
                    break;
                case 3:
                    calcularSaldo(lista, meses);
                    break;
                case 4:
                    System.out.println("Insira o mês que deseja remover.");
                    nomeMes = scanner.next();
                    apagarMes(lista, meses, nomeMes);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
