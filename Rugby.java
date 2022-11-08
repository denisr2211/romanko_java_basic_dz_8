import java.util.concurrent.ThreadLocalRandom;

public class Rugby {
    public static void main(String[] args) {
        new Rugby().execute();
    }
    private void execute() {

        Team white = new Team("Белые");
        Team black = new Team("Черные");

        double whiteAverageAge = white.averageAge();
        double blackAverageAge = black.averageAge();

        System.out.println(white);
        System.out.println("Средний возраст игроков команды " + white.getTeamName() + ": " + whiteAverageAge + " года");
        System.out.println(black);
        System.out.println("Средний возраст игроков команды " + black.getTeamName() + ": " + blackAverageAge + " года");
    }

    static class Team {
        public Person[] player;
        public String teamName;

        public Team(String teamName) {
            this.player = new Person[25];
            this.teamName = teamName;
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < 25; i++) {
                Person person = new Person(random.nextInt(18, 40));
                player[i] = person;
            }

        }

        public String getTeamName() {
            return teamName;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Person person : player) {
                builder.append(person.getAge());
                builder.append(" ");
            }
            return "Возраст игроков команды " + teamName + ": " + builder;
        }

        public double averageAge() {
            double result = 0;
            for (Person person : player) result += person.getAge();
            return result / 25;
        }
    }

    static class Person {
        public int age;
        public int getAge() {
            return age;
        }
        public Person(int age) {
            this.age = age;
        }
    }
}