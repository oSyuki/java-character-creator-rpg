git --version
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);

    // First dialogue

    System.out.print("What's your name? ");
    String name = scanner.nextLine();

     System.out.print("How old are you? ");
    int age = scanner.nextInt();
    scanner.nextLine();

    if (age <= 18) {
        System.out.println("Starting at that age, " + name + "? That's brave!");
    }
    else {
        System.out.println("You know it's time when it's the time right, " + name + "? All right!");
    }

    System.out.print("Which of these elements are you most connected to: Fire, Thunder, Ice, Water, Grass? ");
    String element = scanner.nextLine(); 

    if (element.equalsIgnoreCase("Fire")) {
        System.out.println("Oh a hothead huh, All right, it fits you!");
    }
    else if (element.equalsIgnoreCase("Thunder")) {
        System.out.println("Ok! I got it! Calm down! You're so hiperactive!");
    }
    else if (element.equalsIgnoreCase("Ice")) {
        System.out.println("Okay? I thought you would be happier saying that.");
    }
    else if (element.equalsIgnoreCase("Water")) {
        System.out.println("The way your words flow from you... it fits you!");
    }
    else if (element.equalsIgnoreCase("Grass")) {
        System.out.println("... Can you be quicker answering the next?");
    }
    else {
        System.out.println("Uh? Never heard of it.");
    }

    System.out.print("Which one of these describes you better? Warrior, Mage or a Rogue? " );
    String path = scanner.nextLine();

    // WARRIOR COMBINATIONS

    if (path.equalsIgnoreCase("Warrior") && element.equalsIgnoreCase("Thunder")) {
        System.out.println("\n!THOR COMBINATION ACTIVATED!\n" + "\nThunder Element + Warrior combination amplified your Thunder skills that uses an Axe!!!");    
    }
    else if (path.equalsIgnoreCase("Warrior")) {
        System.out.println("A strong one huh? I can see you'll be a great " +  element + " Warrior someday");
    }
    else if (path.equalsIgnoreCase("Mage") && element.equalsIgnoreCase("Fire")) {
        System.out.println("\n!PIROMANCER COMBINATION ACTIVATED!\n" + "\nFire Element + mage combination amplified your Fire skills that uses a Staff!!!");    
    }
    else if (path.equalsIgnoreCase("Mage")) {
        System.out.println("I can see... you're one of these heavy brains huh? You'll be a splendous " +  element + " mage!");
    }
    else if (path.equalsIgnoreCase("Rogue")) {
        System.out.println("Hm... A Rogue one... I didn't expected it but okay so, it's your choice after all. ");
    }
    else {
        System.out.println("I've never heard about this path...");
    }

    System.out.print("\nLook at your left side, which of these weapons would you like to use?(Axe, Sword, Bow, Twin Knifes, Staff): ");
    String weapon = scanner.nextLine();

    System.out.println(weapon + "? That's a good choice!\nNow let's see your status?");
    
    // Player status
    
int strength = 0;
int agility = 0;
int magic = 0;
int hp = 0;

if (path.equalsIgnoreCase("Warrior")) {
strength = 10;
agility = 4;
magic = 1;
hp = 10;
}

else if (path.equalsIgnoreCase("Mage")) { 
strength = 0; 
agility = 5; 
magic = 10; 
hp = 5;   
}
else if (path.equalsIgnoreCase("Rogue")) {
strength = 4;
agility = 10;
magic = 5;
hp = 7;
}

    //Weapon combinations

    if (weapon.equalsIgnoreCase("Axe")) { 
    strength += 7;
    agility -= 2;
    }
    else if (weapon.equalsIgnoreCase("Sword")) {
    strength += 5;
    agility -= 1;
    } 
    else if (weapon.equalsIgnoreCase("bow")) { 
    agility += 7;
    magic += 3;
    }
    else if (weapon.equalsIgnoreCase("Twin Knifes")) {
    strength += 3;
    agility += 6;
    magic -= 1;
    }
    else if (weapon.equalsIgnoreCase("Staff")) { 
    magic += 10;
    agility -= 4;
    strength += 5;
    }

    if (path.equalsIgnoreCase("Warrior")) {
    System.out.println("Your status are very good for a beginner Warrior!\n" + "\n" + name + " status:\n" + "Age: " + age + "\n" + "\n"+ "Path: "  + path +"\nElement: " + element +"\nWeapon: " + weapon + "\n" + "\n" + "Strength = " + strength + "\nAgility = " + agility +"\nMagic = " + magic +"\nHP= " + hp  );
    }
    else if (path.equalsIgnoreCase("Rogue")) {
    System.out.println("Your status are very good for a beginner Rogue!\n" + "\n" + name + " status:\n" + "Age: " + age + "\n" + "\n"+ "Path: "  + path +"\nElement: " + element +"\nWeapon: " + weapon + "\n" + "\n" + "Strength = " + strength + "\nAgility = " + agility +"\nMagic = " + magic +"\nHP= " + hp  );
    }
    else if (path.equalsIgnoreCase("Mage")) {
    System.out.println("Your status are very good for a beginner Mage!\n" + "\n" + name + " status:\n" + "Age: " + age + "\n" + "\n"+ "Path: "  + path +"\nElement: " + element +"\nWeapon: " + weapon + "\n" + "\n" + "Strength = " + strength + "\nAgility = " + agility +"\nMagic = " + magic +"\nHP= " + hp  );
    }

scanner.close();
    }
}
