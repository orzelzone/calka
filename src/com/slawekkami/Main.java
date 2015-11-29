package com.slawekkami;


import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        double start, stop, przedzial, funkcjaXi, calka, funkcjaTi, xi;
        int n, a, b, c;
        Scanner klawiatura = new Scanner(System.in);
        System.out.println("Program oblicza całkę oznaczoną funkcji f(x)= a(x*x)+bx+c");
        System.out.println("gdzie a, b, c są liczbami całkowitymi Podawanymi przez uzytkownika.");
        System.out.println("funkcja może mieć postać 2(x*x)+4x+6 lub 6(x*x)+9x+3");
        System.out.println("Zastanów się i podaj pokolei wartości a, b, c");
        //System.out.println("Podaj a dla wyrażenia a(x*x)+bx+c");
        // a = klawiatura.nextInt();
        a = czytajInt("a");
        System.out.println(a);
        System.out.println("Podaj b dla wyrażenia a(x*x)+bx+c");
        b = klawiatura.nextInt();
        System.out.println("Podaj c dla wyrażenia a(x*x)+bx+c");
        c = klawiatura.nextInt();
        System.out.println("Podaj poczatek przedzialu calkowania");
        start = klawiatura.nextDouble();
        System.out.println("Podaj koniec przedzialu calkowania");
        stop = klawiatura.nextDouble();
        System.out.println("Podaj dokladnosc calkowania");
        n = klawiatura.nextInt();
        klawiatura.close();

        przedzial = (stop - start) / (double) n;

        funkcjaXi = 0;
        funkcjaTi = 0;
        for (int i = 1; i < n; i++) {
            xi = start + i * przedzial;
            funkcjaTi += funkcjaX(xi - przedzial / 2, a, b, c);// funkcja w połowie przedziału ti
            funkcjaXi += funkcjaX(xi, a, b, c); //funkcja w kolejnych przediałach xi
        }
        funkcjaTi += funkcjaX(stop - przedzial / 2, a, b, c);
        calka = (przedzial / 6) * (funkcjaX(start, a, b, c) + funkcjaX(stop, a, b, c) + 2 * funkcjaXi + 4 * funkcjaTi);
        System.out.println("Wartosc calki obliczaną metodą Simpsona wynosi w przyblizeniu " + calka);
    }
    //funkcja dla ktorej obliczamy calke
    private static double funkcjaX(double x, int a, int b, int c) {
        return a * (x * x) + b * x + c;
    }
    private static int czytajInt(String znak){
     int liczba =0;
     boolean ok = true;
     Scanner klawiatura1 = new Scanner(System.in);
     do {
         System.out.println("Podaj " + znak + " dla wyrażenia a(x*x)+bx+c");

         try {
             liczba = klawiatura1.nextInt();
             //return liczba;
         } catch (NoSuchElementException e) {
             System.err.println("Nie wprowadziles zadnego znaku. WPROWADZI JESZCZE RAZ");
             ok = false;
            // return 0;

         } catch (NumberFormatException e) { //gdy wprowadzone dane nie są liczbą

             System.err.println("Wprowadziles  zle znaki. WPROWADZI JESZCZE RAZ");
             ok = false;
             //return 0;
         }
     }while (ok==true);
     klawiatura1.close();
        return  liczba;
    }
}