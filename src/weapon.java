public class weapon {
     // instance variables 
     // this . studff
        private int damage;
        private String name;
     //constuctor 
     public weapon(int damage, String name){
        this.damage = damage;
        this.name = name;
        
     }
     // accesssor\
     public String getName (){
        return this.name;
     }
     public int getdamage (){
        return this.damage;
     }
}
