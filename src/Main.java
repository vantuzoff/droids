import BattleInfo.Battle;
import BattleInfo.Battle2vs2;
import File.FileSystem;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int write;
        System.out.println("Would you like to write fight info in file?\n1. Yes\n2. No");
        Scanner scan = new Scanner(System.in);
        write = scan.nextInt();
        String cacheMain = "";
        cacheMain = cacheMain.concat("Choose battle type:\n1. Battle 1vs1\n2. Battle 2vs2\n");
        System.out.print(cacheMain);
        new FileSystem().appStr(cacheMain);
        int choice;
        scan = new Scanner(System.in);
        choice = scan.nextInt();
        cacheMain = "";
        cacheMain = cacheMain.concat(" " + choice + "\n");
        new FileSystem().appStr(cacheMain);
        if (choice == 1)
            new Battle().battleIni();
        else if (choice == 2)
            new Battle2vs2().battleIni();
        if (write == 1)
            new FileSystem().writeInFile();
    }
}