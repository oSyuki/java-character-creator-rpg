    public class Character {
        //status

        String name;
        String element;
        String path;
        String weapon;
        String action;

        int levelsRaised = 0;
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
                    this.gainXP(1200);

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

        public void gainXP(int xpGained) throws InterruptedException {
            if (this.won) {
                this.xp += xpGained;
                xpToNextLevel = (200 * this.level) - this.xp;

                System.out.println("Well done! "+ this.name + " has gained "+ xpGained + "\n" + this.name + " has earned enough XP to level up! " );

                if (xpToNextLevel <= 0) {
                this.levelUp();
                }
            }
        }
        

        //Level up system

        public void levelUp() throws InterruptedException { 

            while (xpToNextLevel <= 0) { 
                this.level += 1;
                levelsRaised += 1;
                System.out.println("Congratulations! " + this.name + " has leveled up!");
                Thread.sleep(500);
                
                if (this.path.equalsIgnoreCase("Warrior")) {
            this.strength += 3;
            this.agility += 1;
            System.out.println("Your Strength has increased!");
                Thread.sleep(500);
            }
                else if (this.path.equalsIgnoreCase("Mage")) {
            this.magic += 3;                                
            this.strength += 1;
            System.out.println("Your Magic has increased!");
                Thread.sleep(500);
            }
                else if (this.path.equalsIgnoreCase("Rogue")) {
            this.agility += 2;
            this.magic += 1;
            this.strength += 1;
            System.out.println("Your Agility has increased!");
                Thread.sleep(500);
            }
            xpToNextLevel = (200 * this.level) - this.xp;
            }
            if (xpToNextLevel > 0) {
                System.out.println("Congratulations! " + this.name + " has leveled up " + levelsRaised + " times! ");  
                levelsRaised = 0;
                System.out.println("This is your new status! " + "\n" + "\n" + "Strength = " + this.strength + "\nAgility = " + this.agility +"\nMagic = " + this.magic +"\nHP= " + this.hp  );
            }
            

        
        }
    }