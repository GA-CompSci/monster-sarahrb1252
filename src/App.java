import java.util.Scanner;

public class App {
    // CLASS VARIABLE
    private static Monster[] monsters;

    public static void main(String[] args) throws Exception {
        System.out.println("------- MONSTER BATTLE-------");

        Scanner input = new Scanner(System.in);
        System.out.print("How many monsters wil you slay?: ");
        int num = input.nextInt(); // TODO ; HANDLE ERRORS IF ITS NOT A NUMBER
        monsters = new Monster[num];
        // build all numbers
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster(); // TODO : add some specials
        }
        // HOW MANY MONSTERS HAVE MORE THAN 50 HEALTH
        System.out.println(monsterCount(50) + " monsters have more than 50 health");

        // WHAT IS THE % OF DEFETED MONSTERS?
        double result = percentComplete();
        System.out.println("Current progress" + result + " %");
        reportMonsters();
    }

    public static double percentComplete() {
        int stillAlive = 0;
        return monsterCount(0) / monsters.length * 100;

        // file acess + ____ + output type + parameter
    }

    // Display Monster status
    public static void reportMonsters() {
        System.out.println("\n------------MONSTER REPORT------------");

        // FULL TRAVERSAL
        for (int i = 0; i < monsters.length; i++) {
            System.out.print("[" + i + "]");
            System.out.print(" Health : " + monsters[i].health());
            System.out.print(" Dmg : " + monsters[i].damage());
            System.out.print(" Speed: : " + monsters[i].speed());
            if (!monsters[i].special().equals(""))
                System.out.println(" - Special: " + monsters[i].special());

            System.out.println();

        }
    }

    /**
     * how many monters have obvrer the given health
     * 
     * @param health number to check
     * @return number of monster abovew the health
     */
    public static int monsterCount(int health) {
        int count = 0;
        // traverse the monster array and find out how many have , 50 health
        for (Monster m : monsters) {
            if (m.health() > 50)
                count++;

        }
        return count;
    }

    public static Monster getNextMonster() {

        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].health() > 0)
                return monsters[i];
        }
        return null;
    }
}