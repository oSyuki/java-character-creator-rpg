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

        // Game loop
        boolean gameActive = true;

        while (gameActive) {
            player.firstDialogue();
            player.playerBaseStatus();

            System.out.println("\nYou have a chance to test this new powers! There's some monsters coming to attack the village!");
            Thread.sleep(500);

            player.alive = true;

            boolean battleActive = true;

            // Enemy randomizer
            int enemyChoice = random.nextInt(6);
            Character enemy = null;

            if (enemyChoice == 0) {
                enemy = goblin;
            } else if (enemyChoice == 1) {
                enemy = orc;
            } else if (enemyChoice == 2) {
                enemy = skeleton;
            } else if (enemyChoice == 3) {
                enemy = fireDragon;
            } else if (enemyChoice == 4) {
                enemy = thunderDragon;
            } else {
                enemy = waterDragon;
            }

            while (battleActive) {

                enemy.scaleEnemy(player);
                player.showEnemy(enemy);
                player.action = scanner.nextLine();

                if (player.action.equalsIgnoreCase("Attack") || player.action.equalsIgnoreCase("1")) {

                    player.attack(enemy);
                    Thread.sleep(500);

                } else if (player.action.equalsIgnoreCase("Run") || player.action.equalsIgnoreCase("2")) {

                    boolean escaped = player.run(enemy);

                    if (escaped) {
                        battleActive = false;
                    }
                }

                if (enemy.defeated) {
                    battleActive = false;
                }

                if (player.hp <= 0) {

                    battleActive = false;
                    player.defeated = true;

                    System.out.println("""
                            ╔═════════════════════════════════╗
                            ║          ⚔️ YOU LOST            ║
                            ╠═════════════════════════════════╣
                            ║       %s HAS DEFEATED YOU       ║
                            ╠═════════════════════════════════╣
                            ║       Level: %d                 ║
                            ║       HP: %d                    ║
                            ║       Strength: %d              ║
                            ║       Agility: %d               ║
                            ║       Magic: %d                 ║
                            ╚═════════════════════════════════╝
                            """
                            .formatted(
                                    enemy.name,
                                    player.level,
                                    player.hp,
                                    player.strength,
                                    player.agility,
                                    player.magic
                            ));
                }
            }

            gameActive = gameOver(player, scanner);
        }

        scanner.close();
    }

    // Restart method
    public static boolean gameOver(Character player, Scanner scanner) {

        if (player.defeated) {

            System.out.println("""
                    ╔════════════════════════════════╗
                    ║ %s You want to try again?      ║
                    ╠════════════════╦═══════════════╣
                    ║      YES       ║       NO      ║
                    ╚════════════════╩═══════════════╝
                    Your choice:\s""".formatted(
                    player.name
            ));

            String restart = scanner.nextLine();

            if (restart.equalsIgnoreCase("Yes")) {

                player.level = 1;
                player.xp = 0;
                player.hp += player.baseHp;
                player.defeated = false;
                player.won = false;
                player.alive = true;

                return true;

            } else {

                System.out.println("""
                        ╔═══════════════════════════════╗
                        ║           GAME OVER           ║
                        ╚═══════════════════════════════╝
                        """);

                return false;
            }
        }

        return false;
    }
}