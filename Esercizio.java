//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

public class Esercizio {

    public static void main(String[] args) {ù
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int a, n, i, j, e, m, ora, max;
        System.out.println("Inserisci il numero di pesci che saranno pescati : ");
        a = in.nextInt();
        int[] v = new int[a];
        int[] o = new int[a];
        n = 0;
        m = 0;
        i = 1;
        ora = 9;
        while (i <= a) {
            e = 2 + random.nextInt(9) * 50;
            ora = ora + 1 % 24;
            System.out.println("Pescato pesce di  " + e + " grammi. ");
            n = inserisciInVettore(v, n, e, n);
            m = inserisciInVettore(o, m, ora, m);
            j = 0;
            while (j < n) {
                if (v[j] < v[n - 1]) {
                    System.out.println(Integer.toString(v[j]) + " scappa via. ");
                    n = eliminaDaVettore(v, n, j);
                    m = eliminaDaVettore(o, m, j);
                    max = j;
                } else {
                    max = n - 1;
                    j = j + 1;
                }
            }
            System.out.println("Secchio: ");
            visualizzaVettore(v, n, o);
            i = i + 1;
        }
        System.out.println("Pesce più grosso nel secchio pesa " + v[max] + " grammi pescato alle " + o[max]);
        n = rimuoviDuplicati(v, n);
        System.out.println("Pesci rimasti nel secchio:");
        visualizzaVettore(v, n, o);
    }
    
    public static int eliminaDaVettore(int[] v, int n, int ie) {
        int i, n2;
        n2 = n - 1;
        i = ie;
        while (i <= n - 2) {
            v[i] = v[i + 1];
            i = i + 1;
        }
        
        return n2;
    }
    
    public static int inserisciInVettore(int[] v, int n, int e, int ie) {
        int i, n2;
        n2 = n + 1;
        i = n2 - 1;
        while (i >= ie + 1) {
            v[i] = v[i - 1];
            i = i - 1;
        }
        v[ie] = e;
        
        return n2;
    }
    
    public static int rimuoviDuplicati(int[] v, int n) {
        int i, j;
        i = 0;
        while (i <= n - 2) {
            j = i + 1;
            while (j <= n - 1) {
                if (v[i] == v[j]) {
                    System.out.println("Elimino " + v[j] + " da cella " + j);
                    n = eliminaDaVettore(v, n, j);
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        
        return n;
    }
    
    public static void visualizzaVettore(int[] v, int n, int[] w) {
        int i;
        i = 0;
        while (i < n) {
            System.out.println(Integer.toString(i) + "° pesce: " + v[i] + " grammi ; pescato alle " + w[i]);
            i = i + 1;
        }
    }
}


//LEGGERE LE ISTRUZIONI NEL FILE README.md