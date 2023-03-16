package lessons.lesson4.part3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // • HashMap is a class in Java that implements the Map interface using a hash table data structure. It stores a collection of key-value pairs, where each key is unique and maps to a single value.
        // HashMap provides constant-time performance for basic operations such as get(), put(), and remove(), assuming that the hash function used to compute the keys distributes the keys evenly across the hash table.
      //public class HashMapExample {
        //    public static void main(String[] args) {
        //        HashMap<String, Integer> map = new HashMap<>();
        //        map.put("apple", 1);
        //        map.put("banana", 2);
        //        map.put("orange", 3);
        //        map.put("banana", 4); // adding duplicate key
        //
        //        System.out.println(map); // prints {apple=1, orange=3, banana=4}
        //        System.out.println(map.get("banana")); // prints 4
        //    }
        //}

        //In this example, we create a HashMap that maps strings to integers and add four key-value pairs to it. Since "banana" is added twice as a key, the value associated with it is overwritten with the new value.
        // When we print the map, it shows the key-value pairs in an arbitrary order. When we call get("banana"), it returns the value associated with the key "banana", which is 4 in this case.
        //Note that because HashMap uses a hash table to store its key-value pairs, the order in which the elements are returned when iterating over the map is not guaranteed.

        HashMap<String,Friend> friendHashMap = new HashMap<>();
        friendHashMap.put("vaska",new Friend("vasia",25));
        friendHashMap.put("tanka",new Friend("tanya",26));
        friendHashMap.put("zhenia",new Friend("Yevhen",27));

        System.out.println(friendHashMap);

        Friend friend = friendHashMap.get("vaska");
        System.out.println(friend); // output will be- Friend(name=vasia, age=25)
        friendHashMap.containsKey("tanka"); // output will be - true
//        friendHashMap.isEmpty("tanka"); // Returns true if this map contains no key-value mappings
//        friendHashMap.remove("tanka"); // remove by key
        friendHashMap.replace("tanka",new Friend("ola",30));//replace tanka to another object.
        friendHashMap.putIfAbsent("katka",new Friend("katerina",16));// якщо об'єкт з даним ключем вже існує, то він його не запише. А якщо не існує, то запише як новий об'єкт.
        System.out.println(friendHashMap);
    }
}

@Data
@AllArgsConstructor
class Friend{
    private String name;
    private int age;
}
