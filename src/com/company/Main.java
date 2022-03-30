package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        spausdinti();
        String testiarne = "Taip";
        while (testiarne.equals("Taip") || testiarne.equals("taip")) {
            spausdinti("Įveskite norimo atlikti veiksmo ženklą (sudėtis '+', atimtis '-', daugyba '*', dalyba '/')");
            char zenklas;
            zenklas = S.next().charAt(0);
            if (zenklas == '+') {
                spausdinti("Įveskite pirmą skaičių:");
                int sk1 = S.nextInt();
                spausdinti("Įveskite antrą skaičių:");
                int sk2 = S.nextInt();
                System.out.println(sk1 + " + " + sk2 + " = " + sudeti(sk1, sk2));
            } else if (zenklas == '-') {
                atimti();
            } else if (zenklas == '*') {
                spausdinti("Įveskite pirmą skaičių:");
                int sk1 = S.nextInt();
                spausdinti("Įveskite antrą skaičių:");
                int sk2 = S.nextInt();
                dauginti(sk1, sk2);
            } else if (zenklas == '/') {
                dalinti();
            } else if (zenklas == '&') {
                spausdinti("Įveskite pirmą skaičių:");
                double sk1 = S.nextInt();
                spausdinti("Įveskite antrą skaičių:");
                double sk2 = S.nextInt();
                skaiciuotiFormule(sk1, sk2);
            } else {
                spausdinti("Įvedėte netinkamą ženklą, operacija negalima.");
            }
            spausdinti("Norėdami tęsti skaičiavimus įrašykite 'Taip', jei norite baigti įrašykite 'Ne' ");
            testiarne = S.next();
        }
        {
            spausdinti("Programa darbą baigė.");
        }
    }

    /**
     * Funkcija grąžinanti reikšmę be parametrų skaičiuojanti atimį.
     *
     * @return apskaičiuotas atimties rezultatas.
     */
    static double atimti() {
        Scanner S = new Scanner(System.in);
        spausdinti("Įveskite pirmą skaičių:");
        double sk1 = S.nextInt();
        spausdinti("Įveskite antrą skaičių:");
        double sk2 = S.nextInt();
        double ats = sk1 - sk2;
        spausdinti(sk1 + " - " + sk2 + " = " + ats);
        return ats;
    }

    /**
     * Funkcija grąžinanti reikšmę su parametrais skaičiuojanti sudėtį.
     *
     * @param sk1 pirmas vartotojo įvestas skaičius.
     * @param sk2 antras vartotojo įvestas skaičius.
     * @return apskaičiuotas sudėties rezultatas.
     */
    static double sudeti(int sk1, int sk2) {
        double ats = sk1 + sk2;
        return ats;
    }

    /**
     * Funkcija negrąžinanti reikšmės be parametrų su kuria yra apskaičiuojama bei atspausdinama dalyba.
     */
    static void dalinti() {
        Scanner S = new Scanner(System.in);
        spausdinti("Įveskite pirmą skaičių:");
        double sk1 = S.nextInt();
        spausdinti("Įveskite antrą skaičių:");
        double sk2 = S.nextInt();
        double ats = sk1 / sk2;
        try {
            if (sk2 == 0)
                throw new ArithmeticException("Dalyba iš nulio yra negalima");
            System.out.println(sk1 + " / " + sk2 + " = " + ats);
        } catch (ArithmeticException n) {
            System.out.println("Dalyba iš nulio yra negalima.");
        }
    }

    /**
     * Funkcija negrąžintanti reikšmės su parametrais skaičiuojanti daugybą.
     *
     * @param sk1 pirmas vartotojo įvestas skaičius.
     * @param sk2 antras vartotojo įvestas skaičius.
     */
    static void dauginti(int sk1, int sk2) {
        double ats = sk1 * sk2;
        System.out.println(sk1 + " * " + sk2 + " = " + ats);
    }

    /**
     * Funkcija negrąžintanti reikšmės su parametrais skirta išvesti tekstą vartotojui.
     *
     * @param x spausdinamas tekstas.
     */
    static void spausdinti(String x) {
        System.out.println(x);
    }

    /**
     * Funkcija negrąžinanti reikšmės be parametrų skirta išvesti tekstą vartotojui.
     */
    static void spausdinti() {
        System.out.println("Skaičiavimo programa");
        System.out.println("Šioje programoje skaičiuojama sudėtis, atimtis, daugyba ir dalyba.");
    }

    /**
     *
     * @param sk1 pirmas vartotojo įvestas skaičius.
     * @param sk2 antras vartotojo įvestas skaičius.
     * @return return 0, nes su return funkcija negalima grąžinti daugiau nei vienos reikšmės.
     */
    static double skaiciuotiFormule(double sk1, double sk2) {
        double i;
        for (i = 101; i < 200; i++) {
            double rez = (sk2 + sk1) * sk2 + (sk2 - sk1) / sk1 * i;
            if (rez < 100) {
                System.out.println("(" + sk2 + " + " + sk1 + ")" + " * " + sk2 + " + " + "(" + sk2 + " - " + sk1 + ") " + "/ " + sk1 + " * " + i + " = " + rez + " < " + 100);
            }
            else if (rez == 100) {
                System.out.println("(" + sk2 + " + " + sk1 + ")" + " * " + sk2 + " + " + "(" + sk2 + " - " + sk1 + ") " + "/ " + sk1 + " * " + i + " = " + rez + " == " + 100);
            }
            else if (rez > 100) {
                System.out.println("(" + sk2 + " + " + sk1 + ")" + " * " + sk2 + " + " + "(" + sk2 + " - " + sk1 + ") " + "/ " + sk1 + " * " + i + " = " + rez + " > " + 100);
            }
        }
        return 0;
    }
}
