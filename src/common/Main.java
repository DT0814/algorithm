package common;

import java.util.Scanner;

public class Main {
    static int[] w;
    static int wMax;
    static int nowWei = 0;
    static int bestWei = 0;

    static int restCargo = 0;
    static int cargo_len = 0;

    static int[] x;
    static int[] bestX;
    static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        wMax = sc.nextInt();
        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        cargo_len = w.length;
        x = new int[cargo_len];
        bestX = new int[cargo_len];
        int i;
        for (i = 0; i < cargo_len; i++) {
            restCargo += w[i];
        }
        solve();
        System.out.print(num);
    }


    static void solve() {
        BackTrace(0);
        System.out.print(bestWei + " ");
    }

    static void BackTrace(int t) {
        num++;
        if (t < cargo_len) {
            restCargo -= w[t];
            if (nowWei + w[t] <= wMax) {
                nowWei += w[t];
                x[t] = 1;
                BackTrace(t + 1);
                nowWei -= w[t];
            }
            if (nowWei + restCargo > bestWei) {
                x[t] = 0;
                BackTrace(t + 1);
            }
            restCargo += w[t];
        } else {
            int a;
            a = 0;
            if (nowWei > bestWei) {

                bestX = x.clone();
                bestWei = nowWei;
            }
        }
    }

}