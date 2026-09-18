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

        //Battle system

        public void showAttack(Character target) throws InterruptedException {
            // Show attack method

            System.out.println(
                    this.name + " has attacked! "
            );
            Thread.sleep(500);

            System.out.println(
                    target.name + " takes " + this.damage + " damage!"
            );
            Thread.sleep(500);

            System.out.println(
                    target.name + " has " + target.hp + " HP left!"
            );
        }

        public void attack(Character target) throws InterruptedException {
            // Set damage
            calculateDamage();
            applyDamage(target);
            // Loop
            if (target.hp <= 0) {
                target.hp = 0;
            }
            // Show damage and enemy's info
            showAttack(target);

            if (target.hp > 0) {
                // If enemy is still alive
                System.out.println(
                        target.name + " will counterattack!"
                );
                Thread.sleep(500);

                target.attack(this);
            }
            else {
                setVictory(target);
            }
        }

        public void setVictory(Character target) throws InterruptedException {
            // Victory logic
            if (target.hp == 0) {
                System.err.println(
                        target.name + " has been defeated!"
                );
                Thread.sleep(500);
                System.err.println(
                        "Good job " + this.name + "! "
                );
                this.hp = this.maxHp;

                target.defeated = true;
                this.won = true;
                this.alive = true;

                Thread.sleep(500);
                this.gainXP(30);
            }
        }
            public void calculateDamage() {
                // Damage method (calculate)
                if (this.path.equalsIgnoreCase("Warrior")) {
                    damage = this.strength;
                } else if (this.path.equalsIgnoreCase("Mage")) {
                    damage = this.magic;
                } else {
                    damage = this.strength;
                }
            }

            public void applyDamage(Character target) {
            // Damage method (deal the calculated damage)
                    target.hp -= damage;
                }


            public boolean run(Character target) {
                // Run method
                if (this.agility >= target.agility) {
                    System.out.println(this.name + " has escaped!");
                    return true;
                }
                else {
                    System.out.println("There's no way to escape!");
                    return false;
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
     public void showEnemy(Character target) throws InterruptedException {
         // Show enemy status
         System.out.println("""
                 ╔══════════════════════════════════╗
                 ║          ⚔️ %s                   ║
                 ╠══════════════════════════════════╣
                 ║       A %s HAS APPEARED!         ║
                 ╠══════════════════════════════════╣
                 ║       Level: %d                  ║
                 ║       HP: %d                     ║
                 ║       Strength: %d               ║
                 ║       Agility: %d                ║        
                 ║       Magic: %d                  ║ 
                 ╠══════════════════════════════════╣                                           
                 ║       [1] Attack                 ║
                 ║       [2] Run                    ║                                 
                 ╚══════════════════════════════════╝
                 Your choice: """.formatted(
                 target.name,
                 target.name,
                 target.level,
                 target.hp,
                 target.strength,
                 target.agility,
                 target.magic
         ));
     }
        //XP system

        public void gainXP(int xpGained) throws InterruptedException {
            if (this.won) {
                this.xp += xpGained;
                xpToNextLevel = (200 * this.level) - this.xp;

                System.out.println(
                        "Well done! " + this.name + " has gained " + xpGained + " XP!");
                System.out.println(
                        "Current XP: " + this.xp
                );

                if (xpToNextLevel <= 0) {
                    System.out.println(
                            this.name + " has earned enough XP to level up!"
                    );

                    this.levelUp();
                } else {
                    System.out.println(
                            this.name + " needs " + xpToNextLevel + " more XP to level up!"
                    );
                }
            }
        }


        //Level up system

        public void levelUp() throws InterruptedException {

            while (xpToNextLevel <= 0) {
                this.level += 1;
                levelsRaised += 1;
                System.out.println(
                        "Congratulations! " + this.name + " has leveled up!"
                );
                Thread.sleep(500);

                if (this.path.equalsIgnoreCase("Warrior")) {
            this.strength += 3;
            this.agility += 1;
            this.hp += 6;
            this.maxHp += 6;
            System.out.println(
                    "Your Strength has increased!"
            );
                Thread.sleep(500);
            }
                else if (this.path.equalsIgnoreCase("Mage")) {
            this.magic += 3;
            this.strength += 1;
            this.hp += 3;
            this.maxHp += 3;
            System.out.println(
                    "Your Magic has increased!"
            );
                Thread.sleep(500);
            }
                else if (this.path.equalsIgnoreCase("Rogue")) {
            this.agility += 2;
            this.magic += 1;
            this.strength += 1;
            this.hp += 4;
            this.maxHp += 4;
            System.out.println(
                    "Your Agility has increased!"
            );
                Thread.sleep(500);
            }
            xpToNextLevel = (200 * this.level) - this.xp;
            }
            if (xpToNextLevel > 0) {
                System.out.println(
                        "Congratulations! " + this.name + " has leveled up " + levelsRaised + " times! "
                );
                levelsRaised = 0;
                System.out.println(
                        """
                           ╔══════════════════════════════════╗
                           ║          🌟 LEVEL UP 🌟          ║
                           ╠══════════════════════════════════╣
                           ║                                  ║
                           ║       Level: %d                  ║
                           ║       HP: %d                     ║
                           ║       Strength: %d               ║
                           ║       Agility: %d                ║        
                           ║       Magic: %d                  ║
                           ╚══════════════════════════════════╝
                           """.formatted(
                                this.level,
                                this.hp,
                                this.strength,
                                this.agility,
                                this.magic
                        ));
            }
        }
    }