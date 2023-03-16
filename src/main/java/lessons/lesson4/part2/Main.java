package lessons.lesson4.part2;

import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // •HashSet is a class in Java that implements the Set interface and is used to store a collection of unique elements.
       //In a HashSet, elements are stored in an unordered manner and do not allow duplicates.
        // When an element is added to a HashSet, it is first hashed using the hashCode() method, and then added to the hash table.
        // If an element with the same hash code already exists in the set, then the new element is not added.

//        LinkedHashSet<User> hashSet = new LinkedHashSet<>();
//        HashSet<User> hashSet = new HashSet<>();
          TreeSet<User> hashSet = new TreeSet<>();
        hashSet.add(new User(1,"banana"));
        hashSet.add(new User(2,"kokos"));
        hashSet.add(new User(3,"apple"));
        hashSet.add(new User(4,"orange"));
        hashSet.add(new User(1,"banana"));
//
        System.out.println(hashSet);
//        hashSet.forEach(user -> System.out.println(user.hashCode()));//виведе hashCode клжного юзера. Отримати юзера з хещкоду не можливо.

//       • LinkedHashSet<User> hashSet = new LinkedHashSet<>();//faster than HasSet. it also maintains the order in which the elements were added to the set.
//        This means that when you iterate over the LinkedHashSet, the elements will be returned in the order in which they were added.

//       • TreeSet<User> hashSet = new TreeSet<>(); TreeSet is a class in Java that implements the SortedSet interface using a red-black tree data structure. Like all SortedSet implementations, TreeSet stores a sorted collection of unique elements.
//       The elements are sorted in ascending order by default, but you can provide a Comparator object to define a custom ordering.
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode // This annotation generates code based on the fields of the class, using the same logic as the manually implemented equals() and hashCode() methods.
class User implements Comparable<User>{ // TreeSet(сортування. Потрібно імплементувати Comparable<User>)
    private int id;
    private String name;

    @Override
    public int compareTo(User o) {
        return this.id - o.getId();// посортує згідно id
    }
}