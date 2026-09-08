import java.util.Scanner;

public class Main {
public static void main(String[] args) throws InterruptedException {

    Scanner scanner = new Scanner(System.in);
    Character player = new Character();
    Character goblin = new Character();

    
        //Goblin status

        goblin.name = "Goblin";
        goblin.element = "Grass";
        goblin.path = "Rogue";
        goblin.weapon = "Axe";
        goblin.age = 18;
        goblin.strength = 6; 
        goblin.agility = 4;
        goblin.magic = 0;
        goblin.hp = 30;
    

    // First dialogue

    System.out.print("What's your name? ");
    player.name = scanner.nextLine();

     System.out.print("How old are you? ");
    player.age = scanner.nextInt();
    scanner.nextLine();

    if (player.age <= 18) {
        System.out.println("Starting at that age, " + player.name + "? That's brave!");
        Thread.sleep(1000);
    }
    else {
        System.out.println("You know it's time when it's the time right, " + player.name + "? All right!");
        Thread.sleep(1000);
    }

    System.out.print("Which of these elements are you most connected to?\nFire\nThunder\nIce\nWater\nGrass\n " + "\nAnswer: ");
    player.element = scanner.nextLine(); 

    if (player.element.equalsIgnoreCase("Fire")) {
        System.out.println("Oh a hothead huh, All right, it fits you!");
        Thread.sleep(1000);
    }
    else if (player.element.equalsIgnoreCase("Thunder")) {
        System.out.println("Ok! I got it! Calm down! You're so hiperactive!");
        Thread.sleep(1000);
    }
    else if (player.element.equalsIgnoreCase("Ice")) {
        System.out.println("Okay? I thought you would be happier saying that.");
        Thread.sleep(1000);
    }
    else if (player.element.equalsIgnoreCase("Water")) {
        System.out.println("The way your words flow from you... it fits you!");
        Thread.sleep(1000);
    }
    else if (player.element.equalsIgnoreCase("Grass")) {
        System.out.println("... Can you be quicker answering the next?");
        Thread.sleep(1000);
    }
    else {
        System.out.println("Uh? Never heard of it.");
        Thread.sleep(1000);
    }

    System.out.print("Which one of these describes you better?\nWarrior\nMage\nRogue\n " + "\nAnswer: " );
    player.path = scanner.nextLine();
    Thread.sleep(1000);

    // WARRIOR COMBINATIONS

    if (player.path.equalsIgnoreCase("Warrior") && player.element.equalsIgnoreCase("Thunder")) {
        System.out.println("\n!THOR COMBINATION ACTIVATED!\n" + "\nThunder Element + Warrior combination amplified your Thunder skills that uses an Axe!!!");    
        Thread.sleep(1000);
    }
    else if (player.path.equalsIgnoreCase("Warrior")) {
        System.out.println("A strong one huh? I can see you'll be a great " +  player.element + " Warrior someday");
        Thread.sleep(1000);
    }
    else if (player.path.equalsIgnoreCase("Mage") && player.element.equalsIgnoreCase("Fire")) {
        System.out.println("\n!PIROMANCER COMBINATION ACTIVATED!\n" + "\nFire Element + mage combination amplified your Fire skills that uses a Staff!!!");    
        Thread.sleep(1000);
    }
    else if (player.path.equalsIgnoreCase("Mage")) {
        System.out.println("I can see... you're one of these heavy brains huh? You'll be a splendous " +  player.element + " mage!");
        Thread.sleep(1000);
    }
    else if (player.path.equalsIgnoreCase("Rogue")) {
        System.out.println("Hm... A Rogue one... I didn't expected it but okay so, it's your choice after all. ");
        Thread.sleep(1000);
    }
    else {
        System.out.println("I've never heard about this path...");
        Thread.sleep(1000);
    }

    System.out.print("\nLook at your left side, which of these weapons would you like to use?\nAxe\nSword\nBow\nTwin\nKnifes\nStaff\n" + "\nAnswer: ");
    Thread.sleep(1000);
    player.weapon = scanner.nextLine();

    System.out.println(player.weapon + "? That's a good choice!\nNow let's see your status?");
    Thread.sleep(1000);
    
    // Player status
    

if (player.path.equalsIgnoreCase("Warrior")) {
player.strength = 10;
player.agility = 4;
player.magic = 1;
player.hp = 25;
}

else if (player.path.equalsIgnoreCase("Mage")) { 
player.strength = 0; 
player.agility = 5; 
player.magic = 10; 
player.hp = 15;   
}
else if (player.path.equalsIgnoreCase("Rogue")) {
player.strength = 4;
player.agility = 10;
player.magic = 5;
player.hp = 20;
}

    //Weapon combinations

    if (player.weapon.equalsIgnoreCase("Axe")) { 
    player.strength += 7;
    player.agility -= 2;
    }
    else if (player.weapon.equalsIgnoreCase("Sword")) {
    player.strength += 5;
    player.agility -= 1;
    } 
    else if (player.weapon.equalsIgnoreCase("bow")) { 
    player.agility += 7;
    player.magic += 3;
    }
    else if (player.weapon.equalsIgnoreCase("Twin Knifes")) {
    player.strength += 3;
    player.agility += 6;
    player.magic -= 1;
    }
    else if (player.weapon.equalsIgnoreCase("Staff")) { 
    player.magic += 10;
    player.agility -= 4;
    player.strength += 5;
    }

    if (player.path.equalsIgnoreCase("Warrior")) {
    System.out.println("Your status are very good for a beginner Warrior!\n" + "\n" + player.name + " status:\n" + "Age: " + player.age + "\n" + "\n"+ "Path: "  + player.path +"\nElement: " + player.element +"\nWeapon: " + player.weapon + "\n" + "\n" + "Strength = " + player.strength + "\nAgility = " + player.agility +"\nMagic = " + player.magic +"\nHP= " + player.hp  );
    Thread.sleep(1000);
    }
    else if (player.path.equalsIgnoreCase("Rogue")) {
    System.out.println("Your status are very good for a beginner Rogue!\n" + "\n" + player.name + " status:\n" + "Age: " + player.age + "\n" + "\n"+ "Path: "  + player.path +"\nElement: " + player.element +"\nWeapon: " + player.weapon + "\n" + "\n" + "Strength = " + player.strength + "\nAgility = " + player.agility +"\nMagic = " + player.magic +"\nHP= " + player.hp  );
    Thread.sleep(1000);
    }
    else if (player.path.equalsIgnoreCase("Mage")) {
    System.out.println("Your status are very good for a beginner Mage!\n" + "\n" + player.name + " status:\n" + "Age: " + player.age + "\n" + "\n"+ "Path: "  + player.path +"\nElement: " + player.element +"\nWeapon: " + player.weapon + "\n" + "\n" + "Strength = " + player.strength + "\nAgility = " + player.agility +"\nMagic = " + player.magic +"\nHP= " + player.hp  );
    Thread.sleep(1000);
    }

System.out.println("\nOh and look! You have a chance to test this new powers! There's a goblin horde coming to attack the village!");
Thread.sleep(1000);
System.out.print(goblin.name + " has appeared!\nWhat will you do?\n" + "\nAttack\nRun\n" + "\nAnswer: ");
player.action = scanner.nextLine();
     
if (player.action.equalsIgnoreCase("Attack")) {
    player.attack(goblin);
    Thread.sleep(1000);
}
else if (player.action.equalsIgnoreCase("Run")) {
    player.run(goblin);
} 




scanner.close();
    }
}
