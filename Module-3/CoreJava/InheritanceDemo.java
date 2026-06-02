// Exercise 18: Inheritance Example
public class InheritanceDemo {

    static class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound.");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog says: Bark!");
        }
    }

    static class Cat extends Animal {
        @Override
        void makeSound() {
            System.out.println("Cat says: Meow!");
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();

        a.makeSound();
        d.makeSound();
        c.makeSound();
    }
}
