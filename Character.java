    public class Character {
        //status
        String name;
        String element;
        String path;
        String weapon;
        String action;
        int level;
        int age;
        int strength;
        int agility;
        int magic;    
        int hp;
        int damage;

        //mechanics
        public void attack(Character that) { 
            that.hp = this.damage(this.strength) - that.hp;
            System.out.println(this.name + " has attacked!");
        }
        public void run(Character that) {

            if (this.agility >= that.agility) {
                System.out.println(this.name + " has escaped!");
            }
            else {
                System.out.println("There's no way to escape!");
            }
        }
    }