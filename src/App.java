import java.util.Scanner;

public class App {
    //CLASS VARIABLE
    private static Monster [ ] monsters;
    public static void main(String[] args) throws Exception {
        System.out.println("------- MONSTER BATTLE-------");

       // Monster m1 = new Monster();
       // Monster m2 = new Monster ();

       // System.out.println("M1 health: " + m1.health() );
       // System.out.println("M2 health: " + m2.health());

       Scanner input = new Scanner(System.in);
       System.out.print("How many monsters wil you slay?");
       int num = input.nextInt(); // TODO ; HANDLE ERRORS IF ITS NOT A NUMBER
       Monster [] monster = new Monster [num];
        // build all numbers 
        for (int i = 0; i < monster.length; i ++){
                monster[i] = new Monster(); // TODO : add some specials 
        }
        // HOW MANY MONSTERS HAVE MORE THAN 50 HEALTH
        System.out.println (monsterCount(50) + " monsters have more than 50 health") ;
        
    }
    /**
     * how many monters have obvrer the given health 
     * @param health number to check
     * @return number of monster abovew the health
     */
    public static int monsterCount (int health){
        int count = 0;
        // traverse the monster array and find out how many have , 50 health 
        for (Monster m : arr){
            if(m.health() > 50) count++;

        }
        return count;
    }


    public static Monster getNextMonster (){

        for (int i = 0; i < monsters.length; i++);
            if(monsters[i].health()> 0 ) return monsters[i];

    }
    
[]