import java.util.Scanner;

public class Character {
        //status

        //Strings
        String name;
        String element;
        String path;
        String weapon;
        String action;
        String enemy;
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
        int baseHp = 30;
        int damage;
        //Booleans
        boolean defeated;
        boolean won;
        boolean alive;

        // imports
        Scanner scanner = new Scanner(System.in);


        // First dialogue method
        public void firstDialogue() throws InterruptedException {
            System.out.print("What's your name? ");
            this.name = scanner.nextLine();

            System.out.print("How old are you? ");
            this.age = scanner.nextInt();
            scanner.nextLine();

            if (this.age <= 18) {
                System.out.println("Starting at that age, " + this.name + "? That's brave!");
                Thread.sleep(500);
            } else {
                System.out.println("You know it's time when it's the time right, " + this.name + "? All right!");
                Thread.sleep(500);
            }
            System.out.print("""
            Which one of these do you have most connection with?
            ╔══════════════════════════════════╗
            ║           💥ELEMENTS             ║
            ╠══════════════════════════════════╣
            ║        🔥Fire                    ║
            ║         ⚡Thunder                 ║
            ║        ❄️Ice                     ║
            ║        💧Water                   ║
            ║        🌿Grass                   ║
            ╚══════════════════════════════════╝
            Your choice:\s""");
            this.element = scanner.nextLine();


            System.out.print("""
            Which one of these describes you better?
            ╔══════════════════════════════════╗
            ║           💥ELEMENTOS            ║
            ╠══════════════════════════════════╣
            ║        ⚔️Warrior                 ║
            ║        🪄Mage                    ║
            ║        🗡️Rogue                   ║
            ╚══════════════════════════════════╝
            Your choice:\s""");
            this.path = scanner.nextLine();
            Thread.sleep(500);

            // WARRIOR COMBINATIONS
            System.out.println(
                    "I can see you'll be such a great " + this.element + " " + this.path + "Someday! "
            );


            System.out.print("""
            Which one of these fits you better?
            ╔══════════════════════════════════╗
            ║           💥WEAPONS              ║
            ╠══════════════════════════════════╣
            ║        🪓Axe                     ║
            ║        🗡️Sword                   ║
            ║        🏹Bow                     ║
            ║        ⚔️Twin Knifes             ║
            ║        🪄Staff                   ║
            ╚══════════════════════════════════╝
            Your choice:\s""");
            Thread.sleep(500);
            this.weapon = scanner.nextLine();

            System.out.println(
                    this.weapon + "? That's a good choice!\nNow let's see your status!"
            );
            Thread.sleep(500);
        }

        // Player status method
        public void playerBaseStatus() throws InterruptedException {

            if (this.path.equalsIgnoreCase("Warrior")) {
                this.strength = 10;
                this.agility = 4;
                this.magic = 1;
                this.hp = 25;
            } else if (this.path.equalsIgnoreCase("Mage")) {
                this.strength = 0;
                this.agility = 5;
                this.magic = 10;
                this.hp = 15;
            } else if (this.path.equalsIgnoreCase("Rogue")) {
                this.strength = 4;
                this.agility = 10;
                this.magic = 5;
                this.hp = 20;
            }

            //Weapon combinations
            if (this.weapon.equalsIgnoreCase("Axe")) {
                this.strength += 7;
                this.agility -= 2;
            } else if (this.weapon.equalsIgnoreCase("Sword")) {
                this.strength += 5;
                this.agility -= 1;
            } else if (this.weapon.equalsIgnoreCase("bow")) {
                this.agility += 7;
                this.magic += 3;
            } else if (this.weapon.equalsIgnoreCase("Twin Knifes")) {
                this.strength += 3;
                this.agility += 6;
                this.magic -= 1;
            } else if (this.weapon.equalsIgnoreCase("Staff")) {
                this.magic += 10;
                this.agility -= 4;
                this.strength += 5;
            }

            Thread.sleep(500);
            System.out.println("""
            And... that's your status!
            ╔══════════════════════════════════╗
            ║        🌟 %s 🌟                  ║
            ╠══════════════════════════════════╣
            ║ Path: %s         Level: %d       ║
            ║ Age: %d          HP: %d          ║
            ║ Element: %s      Strength: %d    ║
            ║ Weapon: %s       Agility: %d     ║
            ║                  Magic: %d       ║
            ╚══════════════════════════════════╝
            Your choice:\s""".formatted(
                    this.name,
                    this.path,
                    this.level,
                    this.age,
                    this.hp,
                    this.element,
                    this.strength,
                    this.weapon,
                    this.agility,
                    this.magic
            ));
        }



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

        // Damage method
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
        // Set victory method
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
            // Damage method (calculate)
            public void calculateDamage() {
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
                        // this passed Goblin's level
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
                        // this is still at the same level
                        this.hp = this.maxHp;
                        this.defeated = false;
                        that.won = false;
            }
        }
    }
        // Show enemy status
     public void showEnemy(Character target) throws InterruptedException {
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
                System.out.println("""
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