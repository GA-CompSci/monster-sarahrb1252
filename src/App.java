import java.util.Scanner;
import java.util.Set;

public class App {
    // CLASS VARIABLE
    private static Monster[] monsters;

    // PLAYER STATS
    private static int health = 100;
    private static int speed = 10;
    private static int sheild = 50;
    private static int damage = 50;
    private static int heal = 50;
    // Player state
    private static boolean isDefending = false;

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
        // PICK YOUR BUILD

        System.out.println("(1) Assasin");
        System.out.println("(2) tank");
        System.out.println("(3) healer");
        System.out.println("(4) Ninja");
        System.out.println("Choice :");
        int choice = input.nextInt(); // TODO error handle on bad input
        // Customize build
        if (choice == 1) {
            // fighters have little healing and little shild
            sheild -= (int) (Math.random() * 45 + 1) + 5;
            heal -= (int) (Math.random() * 45 + 1) + 5;
        } else if (choice == 2) {
            speed -= (int) (Math.random() * 9) + 1;
            damage -= (int) (Math.random() * 26) + 5;
        } else if (choice == 3) {
            damage -= (int) (Math.random() * 26) + 5;
            sheild -= (int) (Math.random() * 46) + 5;
        } else {
            heal -= (int) (Math.random() * 46) + 5;
            health -= (int) (Math.random() * 21) + 5;
        }

        // WHAT IS THE % OF DEFETED MONSTERS?
        double result = percentComplete();
        System.out.println("Current progress" + result + " %");

        reportMonsters();

        // DISPLAY MONSTER STATUS
        reportMonsters();

        // PICK A MONSTER
        Monster currrenMonster = getNextMonster();

        // GAME LOOP
        while (monsterCount(0) > 0) {
            // sometyhing?
            isDefending = false;
            // who goes first

            // OPTIONS
            System.out.println("-----OPTIONS-----");
            System.out.println("(1) Attack");
            System.out.println("(2) heal");
            System.out.println("(3) Defend");
            System.out.println("(4) Pass");
            System.out.println("Choice :");
            choice = input.nextInt(); // TODO error handle on bad input
            // ATACK
            if (choice == 1) {
                int dmg = (int) (Math.random() * damage + 1);
                if (dmg == damage)
                    dmg = currrenMonster.health();
                else if (dmg == 0) {
                    System.out.println("----CRITICAL FAIL----");
                    System.out.println("Your attack missed so bad you hit yourself");
                    health -= 10;
                } else
                    currrenMonster.takedamage(dmg);
                // Shelid
            } else if (choice == 2) {
                isDefending = true;
                System.out.println("----SHEILDS UP----");
                // HEALTH
            } else if (choice == 3) {
                int h = (int) (Math.random() * heal + 1);
                health += h;
                System.out.println("You healed for " + h + " points. Current health" + health);
                // PASS
            } else {
                speed++;
                System.out.println("your speed has inscresd. Current Speed : " + speed);
            }
            // DO I NEED A NEW MONSTER?
            if (currrenMonster.health() >= 0) {
                System.out.println(("\n!!! YOU HAVE SLAYN A MONSTER!!!"));
                currrenMonster = getNextMonster();
                continue; // take it too the top of the loop
            }
            // Monsters turn
            int speedCheck = (int) (Math.random() * 100);
            if (speedCheck <= speed) {// bonus turn
                System.out.println("----Bonus turn----");
                continue;
            } else {
                int incomingDamage = (int) (Math.random() * currrenMonster.damage() + 1);
                if (isDefending) {
                    incomingDamage -= sheild;
                    if (incomingDamage < 0)
                        incomingDamage = 0; // dont go negitive
                    System.out.println(" CLANG1 your shelid absored" + sheild + " damage");
                }
                health -= incomingDamage;
            }
            // is our playrt defeted ?

            if (health <= 0) {
                System.out.println("\n\n ---------YOU LOSE---------");
                break;
            }
        }
    }

    public static double percentComplete() {
        return monsterCount(0) / monsters.length * 100;

        // file acess + ____ + output type + parameter
    }

    // Display Monster status
    public static void reportMonsters() {
        System.out.println("\n------------PLAYER REPORT------------");
        System.out.println("Health" + health);
        System.out.println("ATTACK POWER" + damage);
        System.out.println("SPEED" + speed);
        System.out.println("SHEILD" + sheild);
        System.out.println("HEAL" + heal);
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