    public class Character {
        //status
        String name;
        String element;
        String path;
        String weapon;
        String action;
        int level;
        int age;
        int strength;
        int agility;
        int magic;    
        int hp;
        int damage;

        //mechanics
        public void attack(Character that) throws InterruptedException { 
            that.hp = that.hp - (this.strength);

            if (that.hp <0) {
                that.hp = 0;
            }
            System.out.println(this.name + " has attacked! ");
            Thread.sleep(1000);

            System.out.println(that.name + " takes " + this.strength  + " damage!");
            Thread.sleep(1000);

            System.out.println(that.name + " is " + that.hp + " HP left!");  
            Thread.sleep(1000);
        
            
                if (that.hp > 0) {
                    System.out.println(that.name + " will revide! ");
                    Thread.sleep(1000);  
                    that.attack(this);
                }
        
                else {
                    System.err.println(that.name + " has been defeated!");
                    Thread.sleep(1000);
                    System.err.println("Good job " + this.name + "! ");
                }
                
        }
        
        public void run(Character that) {

            if (this.agility >= that.agility) {
                System.out.println(this.name + " has escaped!");
            }
            else {
                System.out.println("There's no way to escape!");
            }
        }
    }