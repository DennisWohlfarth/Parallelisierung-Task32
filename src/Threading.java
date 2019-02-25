import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Threading extends Thread {
    private int id;
    private ArrayList<Point> toWork = new ArrayList<>();
    private ArrayList<Point> works = new ArrayList<>();

    public Threading(int id)
    {
        this.id = id;
    }
    public void addToWork(Point p){
        toWork.add(p);
    }
    public void run() {
        for (Point p : toWork) {
            check(p.x, p.y);
        }
        System.out.println("thread " + this.id + " done!");
    }

    public void check(int n, int nplus1)
    {
        if (isConsecutivePrime(n)==true && isConsecutivePrime(nplus1)==true) {
            works.add(new Point(n,nplus1));
        }
    }
    public static boolean checkPrime(final long value) {
        if (value <= 2) {
            return (value == 2);
        }
        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isConsecutivePrime(int number)
    {
        ArrayList<Integer> Split = new ArrayList<>();
        Split = primeSpliting(number);
        int counter=0;
        if(Split.size()<=2)
            return false;
        if(Split.get(0)==Split.get(Split.size()-1))
            return false;

        for(int i = 0; i<Split.size();i++)
        {
            if(i != 0)
            {
                if(Split.get(i) != Split.get(i-1))
                {
                    if (Split.get(i)!= counter)
                        return false;
                    else
                        counter = getNextPrime(counter);
                }
            }
            else
            {
                counter = Split.get(0);
                if(checkPrime(Split.get(i))==false)
                    return false;
                else
                    counter = getNextPrime(counter);
            }
        }
        return true;

    }

    public ArrayList<Integer> primeSpliting(int n)
    {
        ArrayList<Integer> primefactors = new ArrayList<>();
        int number = n;
        int nextPrime = 1;
        nextPrime = getNextPrime(nextPrime);
        while (number > 1)
        {
            if(number%nextPrime == 0)
            {
                primefactors.add(nextPrime);
                number = number/nextPrime;
            }
            else
            {
                nextPrime = getNextPrime(nextPrime);
            }
        }
        return primefactors;
    }

    private int getNextPrime(int number){
        if(number < 2) return 2;
        if(number%2 == 0) number = number - 1;
        do{
            number += 2;
        }while(!checkPrime(number));

        return number;
    }


    public ArrayList<Point> getWorks() {
        return works;
    }
}
