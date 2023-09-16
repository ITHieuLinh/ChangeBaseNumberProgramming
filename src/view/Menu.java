package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mChon;
    protected String exitMessage;

    public Menu() {
    }

    public Menu(String td, String[] mc, String exit) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) {
            mChon.add((T) s);
        }
        exitMessage = exit;
    }
//-------------------------------------------

    public void display() {
        System.out.println(title);
        System.out.println("-------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + "." + mChon.get(i));
        }
        System.out.println("0." + exitMessage);
        System.out.println("--------------------------------");
    }
//----------------------------------------------

    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter selection..");
        int choice = mChon.size() + 1;
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            
        }
        return choice;
    }
//--------------------------------------------------

    public abstract void execute(int n);
//--------------------------------------------------

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if ((n == 0)) {
                break;
            }
            if (n>mChon.size()) System.out.printf("Please input a number from 0 to %d\n",mChon.size());
        }
    }
}
