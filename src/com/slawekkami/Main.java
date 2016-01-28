package com.slawekkami;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Program oblicza całkę oznaczoną funkcji f(x)= ax^2+bx+c");
        System.out.println("gdzie a, b, c są liczbami całkowitymi Podawanymi przez uzytkownika.");
        System.out.println("funkcja może mieć postać 2x^2+4x+6 lub 6x^2+9x+3 itp.");
        System.out.println("Zastanów się i podaj pokolei wartości a, b, c");
        System.out.println("Wartosc calki obliczaną metodą Simpsona wynosi w przyblizeniu " + obliczCalka());
    }
    private static double obliczCalka(){
        double start, stop, przedzial, funkcjaXi, funkcjaTi, xi;
        int n, a, b, c;
        a = czytajInt("a");
        b = czytajInt("b");
        c = czytajInt("c");
        start = czytajDouble("poczatek przedzialu calkowania");
        stop = czytajDouble("koniec przedzialu calkowania");
        while (start>=stop)
        {
            System.err.println("Koniec przedziału całkowania musi być większy od początku przedziału");
            System.err.println("Sprubój jeszcze raz");
            stop = czytajDouble("koniec przedzialu calkowania");
        }
        n = czytajInt("dokladnosc calkowania");
        przedzial = (stop - start) / (double)n;
        funkcjaXi = 0;
        funkcjaTi = 0;
        for (int i = 1; i < n; i++) {
            xi = start + i * przedzial;
            funkcjaTi += funkcjaX(xi - przedzial / 2, a, b, c);// funkcja w połowie przedziału ti
            funkcjaXi += funkcjaX(xi, a, b, c); //funkcja w kolejnych przediałach xi
        }
        funkcjaTi += funkcjaX(stop - przedzial / 2, a, b, c);
        return (przedzial / 6) * (funkcjaX(start, a, b, c) + funkcjaX(stop, a, b, c) + 2 * funkcjaXi + 4 * funkcjaTi);
        //System.out.println("Wartosc calki obliczaną metodą Simpsona wynosi w przyblizeniu " + calka);
    }

    //funkcja dla ktorej obliczamy calke
    private static double funkcjaX(double x, int a, int b, int c) {
        return a * (x * x) + b * x + c;
    }
    // odczytywanie liczb całkowitych
    private static int czytajInt(String znak) {
        int liczba = 0;
        boolean ok = false;
        System.out.println("Podaj " + znak + " dla wyrażenia ax^2+bx+c");
        BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
        while (!ok) {
            try {
                liczba = Integer.parseInt(odczyt.readLine());
                ok = true;
            } catch (NumberFormatException e) { //gdy wprowadzone dane nie są liczbą
                System.err.println("Wprowadziles  zle znaki. WPROWADZI JESZCZE RAZ");
                System.out.println("Podaj " + znak + " dla wyrażenia ax^2+bx+c");
                ok = false;
            } catch (IOException e) {
                System.err.println("błąd danych");
                ok = false;
            }
        }
        return liczba;
    }
    //Odczytywanie liczb zmienno przecinkowych
    private static double czytajDouble(String znak) {
        double liczba = 0;
        boolean ok = false;
        System.out.println("Podaj " + znak);
        BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
        while (!ok) {
            try {
                liczba = Double.parseDouble(odczyt.readLine());
                ok = true;
            } catch (NumberFormatException e) { //gdy wprowadzone dane nie są liczbą
                System.err.println("Wprowadziles  zle znaki. WPROWADZI JESZCZE RAZ");
                System.out.println("Podaj " + znak);
                ok = false;
            } catch (IOException e) {
                System.err.println("błąd danych");
                ok = false;
            }
        }
        return liczba;
    }
}