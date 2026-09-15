    public class Character {
        //status

        //Strings
        String name;
        String element;
        String path;
        String weapon;
        String action;
        //Integers
        int levelsRaised = 0;
        int level = 1;
        int baseLevel = 1;
        int xp = 0;
        int xpToNextLevel;
        int age;
        int strength;
        int baseStrength;
        int agility;
        int baseAgility;
        int magic; 
        int baseMagic;   
        int hp;
        int maxHp = 30;
        int damage;
        //Booleans
        boolean defeated;
        boolean won;
        boolean alive;

        //Attack system

        public void attack(Character that) throws InterruptedException { 
            that.hp = that.hp - (this.strength);

            if (that.hp <0) {
                that.hp = 0;
            }
            System.out.println(this.name + " has attacked! ");
            Thread.sleep(500);

            System.out.println(that.name + " takes " + this.strength  + " damage!");
            Thread.sleep(500);

            System.out.println(that.name + " is " + that.hp + " HP left!");  
            Thread.sleep(500);
        
            
                if (that.hp > 0) {
                    System.out.println(that.name + " will revide! ");
                    Thread.sleep(500);
                    that.attack(this);
                }
                else {
                    System.err.println(that.name + " has been defeated!");
                    Thread.sleep(500);
                    System.err.println("Good job " + this.name + "! ");
                    this.hp = this.maxHp;

                    that.defeated = true;
                    this.won = true;
                    this.alive = true;

                    Thread.sleep(500);
                    this.gainXP(30);

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

        //Enemy scaler system

            public void scaleEnemy(Character that) {
                if (this.defeated) {
                    if (that.level > this.level) {
                        // player passed Goblin's level
                        this.defeated = false;
                        that.won = false;
                        this.level = that.level + this.baseLevel;
                        this.strength = this.baseStrength + that.level * 2;
                        this.agility = this.baseAgility + that.level * 2;
                        this.magic = this.baseMagic + that.level * 2;
                        this.hp = this.maxHp + that.level * 2;
                        this.maxHp = this.hp;
                    }
                    else {
                        // player is still at the same level
                        this.hp = this.maxHp;
                        this.defeated = false;
                        that.won = false;
            }
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
            this.hp += 6;
            this.maxHp += 6;
            System.out.println("Your Strength has increased!");
                Thread.sleep(500);
            }
                else if (this.path.equalsIgnoreCase("Mage")) {
            this.magic += 3;                                
            this.strength += 1;
            this.hp += 3;
            this.maxHp += 3;
            System.out.println("Your Magic has increased!");
                Thread.sleep(500);
            }
                else if (this.path.equalsIgnoreCase("Rogue")) {
            this.agility += 2;
            this.magic += 1;
            this.strength += 1;
            this.hp += 4;
            this.maxHp += 4;
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