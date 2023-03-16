package lessons.lesson4.part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//In Java, collections refer to a group of objects, called elements, that are stored and manipulated as a single unit. The Java Collections Framework provides a set of interfaces and classes that define different types of collections and their operations.
//
//        Collections can be used to store and manipulate data in many different ways, such as lists, sets, maps, queues, and stacks. Some of the most commonly used collection classes in Java are ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, PriorityQueue, and Stack.
//
//        Here's a brief overview of some commonly used collection interfaces and classes in Java:
//
//        Collection: This is the root interface in the Java Collections Framework. It defines the basic operations that can be performed on a group of elements, such as adding, removing, and checking the presence of elements.
//
//        List: This interface extends the Collection interface and provides an ordered collection of elements. The elements can be accessed using an index. ArrayList and LinkedList are commonly used classes that implement the List interface.
//
//        Set: This interface extends the Collection interface and provides a collection of elements with no duplicates. HashSet and TreeSet are commonly used classes that implement the Set interface.
//
//        Map: This interface provides a mapping between a set of keys and their associated values. HashMap and TreeMap are commonly used classes that implement the Map interface.
//
//        Queue: This interface extends the Collection interface and provides a collection of elements that supports insertion and removal at both ends. PriorityQueue is a commonly used class that implements the Queue interface.
//
//        Stack: This class provides a collection of elements that supports last-in-first-out (LIFO) operations. It provides push and pop operations for adding and removing elements from the stack.
public class Main {


    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("one");
        array.add("two");
        array.add("three");
        array.add("four");
        array.add("five");
        array.set(1,"six"); //об'єкт з індексом 1 замінити на "six" в даному випадку
        System.out.println(array);

        //*******************************
//        ArrayList<String> array2 = new ArrayList<>();
//        array2.add("a");
//        array2.add("b");
//        array2.add("c");
//        array2.add("d");
//        System.out.println(array2);

//        array.addAll(array2); // з'єднає 2 масиви
//        System.out.println(array);
//
//        array.removeAll(array2);//видалить із array всі елементи,які повторюються в array2
//        array2.get(0);// a - get by index
//        array2.remove(1); // remove by index. In this case remove "b".

//        array2.forEach(s-> System.out.println(s));//The forEach method is a convenient and concise way to iterate over the elements of a collection and perform some operation on each element.
        // It can be used in place of a traditional for loop or Iterator loop, and can make your code more concise and expressive.
//
//        array2.clear(); -  takes no arguments and simply removes all elements from the collection.The clear() method can be useful when you need to clear a collection of its contents and start fresh.
//        For example, if you have a cache or a temporary storage structure that needs to be emptied periodically, you can use the clear() method to remove all the elements from the collection.

//        array2.isEmpty(); // check if array has some items. Output will be [a, c]


//      boolean containsA = array2.contains("a");//// check if "a" exist in array.
//        System.out.println(containsA);

//        array2.ensureCapacity(5);//The ensureCapacity() method takes a single argument, an integer minCapacity, which specifies the minimum capacity that the collection should have.
        // If the current capacity of the collection is less than minCapacity, the ensureCapacity() method will increase the capacity of the collection to at least minCapacity.
//This method can be useful when you know that you will be adding a large number of elements to a collection and want to avoid the performance overhead of resizing the underlying data structure.
        //*****************
//     array2.removeIf(s -> s.equals("a")); // The removeIf() method can be useful when you need to remove elements from a collection based on a certain condition.
//        System.out.println(array2);

    //також можна видалити таким способом, але його рідко використовують

//        Iterator<String> iterator = array2.iterator();
//        while (iterator.hasNext()){ //check if there is some item to go ahead
//            String next = iterator.next();//this item we pack into variable named "next".And when there will no item returns faulse and ineration will end.
//            System.out.println(next);
//            if (next.equals("a")){ // if variable "next" equals "a" remove this element.
//                iterator.remove();
//            }
//        }

//        array2.sort((t1,t2)->t1.compareTo(t2)); // сортує за алфавітом
//        System.out.println(array2);

//        List<String> sub = array2.subList(1,3); // to get a view of the portion of the List from index 1 to index 3.
//        System.out.println(sub);

    //***********Stream***********
//        Using streams, you can filter, transform, and aggregate data from a collection or array, without having to manually loop through the elements.
//        Streams can be parallelized, which means that the work can be divided among multiple threads for improved performance on multi-core processors.
//
//        ArrayList<String> array3 = new ArrayList<>();
//        array3.add("ufggj");
//        array3.add("b jfjfkjuhju");
//        array3.add("gjc");
//        array3.add("dgtyjhjh");

        LinkedList<String> array3 = new LinkedList<>();
        array3.add("ufggj");
        array3.add("b jfjfkjuhju");
        array3.add("gjc");
        array3.add("dgtyjhjh");
        //LinkedList is a class in Java that implements a doubly-linked list data structure.
        //In a linked list, each element is stored as a separate object called a node, and each node contains a reference to its next and previous nodes.
        // This allows elements to be easily inserted or removed from the list, and enables efficient traversal of the list in both forward and backward directions.
        array3.addFirst("fhd");// add 1st element
        array3.addLast("last");// add last element
        array3.add("some");//почне роздавати індекси. За замовчуванням індексів немає.
        array3.offerFirst("first");//поставить в 1 елемент масиву, якщо не можливо туди вставити елемент то  поверне false
        System.out.println(array3);
//
//        Stream<String> stringStream = array3.stream();// пакує в нову обгортку stream. Це можна і не писати. Можна так:List<Integer> collect = array3.stream() та потім через крапку всі його методи.
//        stringStream

//
//        List<Integer> collect = array3.stream()
//                .distinct() // to remove any duplicate elements
//                .map(new Function<String, Integer>() {//we work with String, but we will return Integer

//                    @Override
//                    public Integer apply(String s) {//alt+insert+ implement metods
//                        return s.length();
//
//                    }
                    //OR
//                .map(s->s.length())
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) { //test бере числа та тестує їх. Виведе всі парні.
//                        return integer % 2 ==0;
//                    }})

                //OR
//                .filter(integer -> integer % 2==0)
//                .sorted((t1,t2)->t1 - t2)
//                .collect(Collectors.toList()); // всі виконані зміни переводить в колекцію
//        System.out.println(collect);
        //***************
//        boolean bool = collect.stream().allMatch(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return true; // якщо всі повернуть true,, то виведе true. А якщо  хлча б 1 юуде faulse, то поверне faulse.
//            }
//        })
        //**
//        boolean bool = collect.stream().anyMatch(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return true; // якщо хоча б 1 поверне true,, то загальний результат буде true. А якщо  хлча б 1 юуде faulse, то поверне faulse.
//            }
//        });
//        collect.stream()
//                .skip(2)//перескакує елементи і починає з того який я задала (в нашому випадку 2)
//                .peek(integer -> System.out.println(integer))
                //схожий на forEach(після нього ми вже не можемо інщі методи використолвувати, а після peek можемо)
                //peek() method to print each element of the stream to the console.
                //As you can see, the peek() method allows us to print each element of the stream while still allowing the stream to continue flowing.
                //
                //peek() can be useful for debugging or logging purposes, or for performing some side-effect operation on each element of a stream without modifying the elements themselves. However, it should be used with caution, as it can be a source of subtle bugs if used improperly.
//                .min((t1,t2)->t1-t2)
//                .orElse(10500);//orElse значить що якщо .min((t1,t2)->t1-t2) нічого не повертає, то в такому випадку нам повернеться 10500
//                .orElseGet(new Supplier<Integer>() {//це функціональний інтерфейс
                    //orElseGet() is a method provided by the Java Optional class, which is used to handle null values in a more concise and readable way. Optional is a container object that may or may not contain a non-null value, and provides methods to handle cases where the value is present or absent.
                    //
                    //The orElseGet() method is similar to orElse(), but instead of providing a default value, it takes a Supplier that is used to generate a default value when the Optional object is empty.
                    // If the Optional object contains a value, the value is returned, otherwise the Supplier is called to generate a default value.
                    //String name = null;
                    //
                    //String result = Optional.ofNullable(name)
                    //                        .orElseGet(() -> {
                    //                            return "John";
                    //                        });
                    //
                    //System.out.println(result);
//                    In this example, we have a String variable called name that is set to null. We create an Optional object from name using the ofNullable() method, and then call the orElseGet() method to specify a Supplier that generates a default value of "John". Since name is null, the orElseGet() method calls the Supplier to generate the default value of "John". Finally, we print the result to the console.
//
//                    @Override
//                    public Integer get() {
//                        return null;
//                    }
//                });
        // ANOTHAR WAY TO WRITE orElseGet
//                .orElseGet(()->100500);
    }

    }

