import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Part1");
        System.out.println();
        Part1();
        System.out.println();
        System.out.printf("Part2");
        System.out.println();
        Part2();
        System.out.println();
        System.out.println();
        System.out.printf("Part3");
        System.out.println();
        Part3();
    }

    public static void print(Iterable iterable, String previewMessage) {
        System.out.println(previewMessage);
        for (Object i : iterable) {
            if (i.getClass() == Human.class)
            {
                Human a = (Human)i;
                System.out.printf(a.toString());
            }
            else
                System.out.printf("%4d", i);
        }
        System.out.println();
    }

    public static void print(Integer[] integers, String previewMessage) {
        System.out.println(previewMessage);
        for (Object i : integers) {
            System.out.printf("%4d", i);
        }
        System.out.println();
    }

    public static void Part1() {
        int n = 10;
        Integer[] array = new Integer[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(6);
        }

        print(array, "Array:");


        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        print(list, "List:");

        ArrayList<Integer> list2 = new ArrayList<>(list);

        Collections.sort(list);
        print(list, "Sorted List:");

        Collections.sort(list, Collections.reverseOrder());
        print(list, "Back sorted List:");

        Collections.shuffle(list);
        print(list, "Shuffle:");

        Collections.rotate(list, 1);
        print(list, "Shift by 1 position");

        ArrayList<Integer> unique = new ArrayList(list.stream().distinct().collect(Collectors.toList()));
        print(unique, "Only unique");

        unique.forEach(x -> list.remove(list.indexOf(x)));
        ArrayList<Integer> duplicates = new ArrayList<>(list.stream().distinct().collect(Collectors.toList()));
        print(duplicates, "Only duplicates");

        Integer[] arr = new Integer[list2.size()];
        list2.toArray(arr);
        print(arr, "Original array from list");
    }

    public static void Part2() {
        PrimesGenerator primesGenerator = new PrimesGenerator();
        primesGenerator.CreatePrimes(10);



        while (primesGenerator.hasNext()) {
            System.out.printf("%4d", primesGenerator.next());
        }

        System.out.println();

        while (primesGenerator.hasPrevious()) {
            System.out.printf("%4d", primesGenerator.previous());
        }

    }

    public static void Part3() {
        Human Misha = new Human("Михаил", "Михайлович", 10);
        Human Alex = new Human("Алексей", "Попов", 20);
        Human Ivan = new Human("Иван", "Иванов", 12);
        Human Sidor = new Human("Сидор", "Сидоров", 28);
        Human Petr = new Human("Петр", "Петров", 21);
        Human Andrey = new Human("Андрей", "Андреев", 22);

        HashSet<Human> humans = new HashSet<Human>();
        humans.add(Misha);
        humans.add(Alex);
        humans.add(Petr);
        humans.add(Sidor);
        humans.add(Ivan);
        humans.add(Andrey);

        print(humans, "Humans");

        LinkedHashSet<Human> linkedHashSet = new LinkedHashSet<Human>(humans);
        print(linkedHashSet, "LinkedHashSet");

        TreeSet<Human> treeSet = new TreeSet<>(humans);
        print(treeSet, "TreeSet");

        TreeSet<Human> newTree = new TreeSet<Human>( new HumanComparatorByName());
        newTree.addAll(humans);
        print(newTree, "Tree with HumanComporatorByName");

        TreeSet<Human> tree = new TreeSet<Human>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.age.compareTo(o2.age);
            }
        });
        tree.addAll(humans);
        print(tree, "Tree with anonymous comparator by age");
    }
}

