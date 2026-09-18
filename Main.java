import java.util.Scanner;

public class Main {
public static void main(String[] args) throws InterruptedException {

    Scanner scanner = new Scanner(System.in);
    Character player = new Character();
    Character goblin = new Character();


    //Goblin status

    goblin.name = "Goblin";
    goblin.level = 1;
    goblin.element = "Grass";
    goblin.path = "Rogue";
    goblin.weapon = "Axe";
    goblin.strength = 6;
    goblin.agility = 4;
    goblin.magic = 0;
    goblin.hp = 30;
    goblin.baseStrength = 6;
    goblin.baseAgility = 4;
    goblin.baseMagic = 0;
    goblin.maxHp = 30;


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
        System.out.println("\n!PIROMANCER COMBINATION ACTIVATED!\n" + "\nFire Element + mage combination amplified your Fire skills that uses a Staff!!!");
        Thread.sleep(500);
    } else if (player.path.equalsIgnoreCase("Mage")) {
        System.out.println("I can see... you're one of these heavy brains huh? You'll be a splendous " + player.element + " mage!");
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

    System.out.println("\nOh and look! You have a chance to test this new powers! There's a goblin horde coming to attack the village!");
    Thread.sleep(500);
    player.alive = true;

    boolean battleActive = true;

    while (battleActive) {

        goblin.scaleEnemy(player);
        player.showEnemy(goblin);
        player.action = scanner.nextLine();

        if (player.action.equalsIgnoreCase("Attack") || player.action.equalsIgnoreCase("1")) {
            player.attack(goblin);
            Thread.sleep(500);

        } else if (player.action.equalsIgnoreCase("Run") || player.action.equalsIgnoreCase("2")) {
            player.run(goblin);
            boolean escaped = player.run(goblin);
            if (escaped) {
                battleActive = false;
            }
        }
    }
    scanner.close();
}

