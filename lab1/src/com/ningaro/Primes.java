package com.ningaro;

//Класс который находит простые числа в диапозоне от 2 до 100(вкл.)
public class Primes {
    //Основная функция
    public static void main(String[] args){
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
    }
    //Функция isPrime которая получает на вход число и возвращяет логическое значение является ли число простым или нет.
    public static boolean isPrime(int n)
    {
        boolean ans = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) ans = false;
        }
        return ans;
    }
}
