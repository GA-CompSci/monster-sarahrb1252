public class Monster {
    //INSANTCE VARIABLES (properties)
    private int health;
    private double damage;
    private int speed;
    private String special;

    // CONSTRUCTOR
    public Monster (){
        //randomly generate health, damgae, and speed
        health = (int) (Math.random() * 81) + 20;
        //random 10-50
        damage = (Math.random() * 41) + 10;
        //speed : random 1-10
        speed = (int)(Math.random()*10) + 1;
        // by default, the monster does not have a special name 
        special ="";
    }
    // OVERLOADED CONSTRUCTOR
    public Monster(String special){
        this();
        this.special = special;

    }
    // ACCESOR METHODS
    public int  health(){return health;}
    public double damage () {return Math.round(damage * 100.0 )/100.0;}
    public int speed () { return this.speed;}
    public String special (){ return this.special;}
}
