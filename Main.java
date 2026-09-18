import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Character player = new Character();
        Character goblin = new Character();
        Character orc = new Character();
        Character skeleton = new Character();
        Character fireDragon = new Character();
        Character thunderDragon = new Character();
        Character waterDragon = new Character();

    // Enemies status

        // Goblin status
        goblin.name = "Goblin";
        goblin.level = 1;
        goblin.element = "Grass";
        goblin.path = "Rogue";
        goblin.weapon = "Twin Knife";
        goblin.strength = 6;
        goblin.agility = 4;
        goblin.magic = 0;
        goblin.hp = 30;
        goblin.baseStrength = 6;
        goblin.baseAgility = 4;
        goblin.baseMagic = 0;
        goblin.maxHp = 30;
        // Orc status
        orc.name = "Orc";
        orc.level = 1;
        orc.element = "Grass";
        orc.path = "Warrior";
        orc.weapon = "Axe";
        orc.strength = 13;
        orc.agility = 2;
        orc.magic = 0;
        orc.hp = 55;
        orc.baseStrength = 13;
        orc.baseAgility = 2;
        orc.baseMagic = 0;
        orc.maxHp = 60;
        // Skeleton status
        skeleton.name = "Skeleton";
        skeleton.level = 1;
        skeleton.element = "Ice";
        skeleton.path = "Rogue";
        skeleton.weapon = "Sword";
        skeleton.strength = 12;
        skeleton.agility = 8;
        skeleton.magic = 6;
        skeleton.hp = 50;
        skeleton.baseStrength = 12;
        skeleton.baseAgility = 8;
        skeleton.baseMagic = 6;
        skeleton.maxHp = 50;
        // Dragons status
        fireDragon.name = "Fire Dragon";
        fireDragon.level = 5;
        fireDragon.element = "Fire";
        fireDragon.path = "Mage";
        fireDragon.weapon = "Staff";
        fireDragon.strength = 15;
        fireDragon.agility = 13;
        fireDragon.magic = 20;
        fireDragon.hp = 70;
        fireDragon.baseStrength = 15;
        fireDragon.baseAgility = 13;
        fireDragon.baseMagic = 20;
        fireDragon.maxHp = 70;

        thunderDragon.name = "Thunder Dragon";
        thunderDragon.level = 5;
        thunderDragon.element = "Thunder";
        thunderDragon.path = "Mage";
        thunderDragon.weapon = "Staff";
        thunderDragon.strength = 15;
        thunderDragon.agility = 13;
        thunderDragon.magic = 20;
        thunderDragon.hp = 70;
        thunderDragon.baseStrength = 15;
        thunderDragon.baseAgility = 13;
        thunderDragon.baseMagic = 20;
        thunderDragon.maxHp = 70;

        waterDragon.name = "Water Dragon";
        waterDragon.level = 5;
        waterDragon.element = "Water";
        waterDragon.path = "Mage";
        waterDragon.weapon = "Staff";
        waterDragon.strength = 15;
        waterDragon.agility = 13;
        waterDragon.magic = 20;
        waterDragon.hp = 70;
        waterDragon.baseStrength = 15;
        waterDragon.baseAgility = 13;
        waterDragon.baseMagic = 20;
        waterDragon.maxHp = 70;

        // First dialogue
        System.out.print("What's your name? ");
        player.name = scanner.nextLine();

        System.out.print("How old are you? ");
        player.age = scanner.nextInt();
        scanner.nextLine();

        if (player.age <= 18) {
            System.out.println("Starting at that age, " + player.name + "? That's brave!");
            Thread.sleep(500);
        } else {
            System.out.println("You know it's time when it's the time right, " + player.name + "? All right!");
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
        player.element = scanner.nextLine();


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
        player.path = scanner.nextLine();
        Thread.sleep(500);

        // WARRIOR COMBINATIONS
        if (player.path.equalsIgnoreCase("Warrior") && player.element.equalsIgnoreCase("Thunder")) {
            System.out.println("\n!THOR COMBINATION ACTIVATED!\n" + "\nThunder Element + Warrior combination amplified your Thunder skills that uses an Axe!!!");
            Thread.sleep(500);
        } else if (player.path.equalsIgnoreCase("Warrior")) {
            System.out.println("A strong one huh? I can see you'll be a great " + player.element + " Warrior someday");
            Thread.sleep(500);
        } else if (player.path.equalsIgnoreCase("Mage") && player.element.equalsIgnoreCase("Fire")) {
            System.out.println("\n!PYROMANCER COMBINATION ACTIVATED!\n" + "\nFire Element + mage combination amplified your Fire skills that uses a Staff!!!");
            Thread.sleep(500);
        } else if (player.path.equalsIgnoreCase("Mage")) {
            System.out.println("I can see... you're one of these heavy brains huh? You'll be a splendours " + player.element + " mage!");
            Thread.sleep(500);
        } else if (player.path.equalsIgnoreCase("Rogue")) {
            System.out.println("Hm... A Rogue one... I didn't expected it but okay so, it's your choice after all. ");
            Thread.sleep(500);
        } else {
            System.out.println("I've never heard about this path...");
            Thread.sleep(500);
        }

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
        player.weapon = scanner.nextLine();

        System.out.println(player.weapon + "? That's a good choice!\nNow let's see your status?");
        Thread.sleep(500);

        // Player status
        if (player.path.equalsIgnoreCase("Warrior")) {
            player.strength = 10;
            player.agility = 4;
            player.magic = 1;
            player.hp = 25;
        } else if (player.path.equalsIgnoreCase("Mage")) {
            player.strength = 0;
            player.agility = 5;
            player.magic = 10;
            player.hp = 15;
        } else if (player.path.equalsIgnoreCase("Rogue")) {
            player.strength = 4;
            player.agility = 10;
            player.magic = 5;
            player.hp = 20;
        }

        //Weapon combinations
        if (player.weapon.equalsIgnoreCase("Axe")) {
            player.strength += 7;
            player.agility -= 2;
        } else if (player.weapon.equalsIgnoreCase("Sword")) {
            player.strength += 5;
            player.agility -= 1;
        } else if (player.weapon.equalsIgnoreCase("bow")) {
            player.agility += 7;
            player.magic += 3;
        } else if (player.weapon.equalsIgnoreCase("Twin Knifes")) {
            player.strength += 3;
            player.agility += 6;
            player.magic -= 1;
        } else if (player.weapon.equalsIgnoreCase("Staff")) {
            player.magic += 10;
            player.agility -= 4;
            player.strength += 5;
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
                player.name,
                player.path,
                player.level,
                player.age,
                player.hp,
                player.element,
                player.strength,
                player.weapon,
                player.agility,
                player.magic
        ));

        System.out.println("\nYou have a chance to test this new powers! There's some monsters coming to attack the village!");
        Thread.sleep(500);
        player.alive = true;

        boolean battleActive = true;

        // Enemy randomizer
        int enemyChoice = random.nextInt(6);
        Character enemy = null;
        if (enemyChoice == 0) {
            enemy = goblin;
        }
        else if (enemyChoice == 1) {
            enemy = orc;
        }
        else if (enemyChoice == 2) {
            enemy = skeleton;
        }
        else if (enemyChoice == 3) {
            enemy = fireDragon;
        }
        else if (enemyChoice == 4) {
            enemy = thunderDragon;
        }
        else if (enemyChoice == 5) {
            enemy = waterDragon;
        }

        while (battleActive) {

            enemy.scaleEnemy(player);
            player.showEnemy(enemy);
            player.action = scanner.nextLine();

            if (player.action.equalsIgnoreCase("Attack") || player.action.equalsIgnoreCase("1")) {
                player.attack(enemy);
                Thread.sleep(500);
            }
            else if (player.action.equalsIgnoreCase("Run") || player.action.equalsIgnoreCase("2")) {
                boolean escaped = player.run(enemy);

                if (escaped) {
                    battleActive = false;
                }
            }
            if (enemy.defeated) {
                battleActive = false;
            }
        }
        scanner.close();
    }
}

