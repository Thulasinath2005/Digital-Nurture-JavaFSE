// Exercise 19: Interface Implementation
public class InterfaceDemo {

    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Guitar: Strumming chords 🎸");
        }
    }

    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Piano: Playing keys 🎹");
        }
    }

    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}
