    public class Character {
        //status

        String name;
        String element;
        String path;
        String weapon;
        String action;
        int level = 1;
        int xp = 0;
        int xpToNextLevel;
        int age;
        int strength;
        int agility;
        int magic;    
        int hp;
        int damage;
        boolean defeated;
        boolean won;

        //Mechanics
        

        //Attack system

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
                    that.defeated = true;
                    this.won = true;
                    Thread.sleep(1000);
                    this.gainXP(15);

                }
                

                }

        //Run system

        public void run(Character that) {

            if (this.agility >= that.agility) {
                System.out.println(this.name + " has escaped!");
            }
            else {
                System.out.println("There's no way to escape!");
            }
        }

        //XP system

        public void gainXP(int xpGained) { 
            if (this.won) {
                this.xp += xpGained;
                xpToNextLevel = 200 - xp;
                System.out.println("Well done! "+ this.name + " has gained "+ xpGained + "\n" + this.name + " is " + xpToNextLevel + " XP left to the next level!" );
            }
        }

        //Level up

        public void levelUp(int level) {
            if (xpToNextLevel <= 0) { 
                this.level += 1;
                System.out.println("Congratulations! " + this.name + " has leveled up!");
                xpToNextLevel = xpToNextLevel + 200;
            }

        
        }
    }