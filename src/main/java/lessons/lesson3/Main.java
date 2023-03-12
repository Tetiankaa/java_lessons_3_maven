package lessons.lesson3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(X.ID);

        ArrayList<X> xList=new ArrayList<>();
        xList.add(new User());
        xList.add(new Student());
        for (X x : xList) {
            x.greeting();
            x.bar();
        }

        ArrayList<Y> yList=new ArrayList<Y>();
        yList.add(new User());
        yList.add(new Policeman());

        for (Y y : yList) {
          y.scream("ghgh");
        }
    }//клас Y повинен бути одним цілим з об'єктами типу Юзер, який також нажеть Х.
    //щоб це працювало створюємо інтерфейс Х та У. Та імплементуємо їх до класів.
//імплемент схожий на абстрактний клас


//**********************Реалізувати екзкмпляри інтерфейсу********************
    X x1 = new X(){
    @Override
    public void greeting() {
        System.out.println("hello");
    }
};
//    x1.greeting();

    //АБО !!!
    //потрібно щоб був тільки 1 абстрактний метод, або поставити @FunctialInterface

  /*1*/  Y y1 = new Y(){
        @Override
        public void scream(String whatToScream) {
        }
    };

 /*2*/   Y y1 =@Override
    public void scream(String whatToScream) {}

 /*3*/   Y y1 = (String s /*довільна назва*/)->{
     System.out.println("hello");
    };

 /*4*/   Y y1 = s -> System.out.println("Hello");


//        barfoo(y1);
//        barfoo(whatToScream ->System.out.println("Hello"));


    public static void foobar(X x){
        //.........
    }

    public static void barfoo(Y y){
        //....
    }
}


//The implements keyword is used to implement an interface.
//
//The interface keyword is used to declare a special type of class that only contains abstract methods.
//
//To access the interface methods, the interface must be "implemented" (kinda like inherited) by another class with the implements keyword (instead of extends).
// The body of the interface method is provided by the "implement" class.
interface X{ // доступ маємо тільки до тих полів які зазначені в нащому типі
    void greeting();

    //методи можливо відразу в інтерфейсі прописувати. Можуть бути тільки  static та default.
    // default автоматиячно доступі в будь-якому об'єкті нащого типу :
    static String foo(){
        return "foo";
    }
    default void bar(){

    }

    //всі змінні які визначені в межах інтерфейсу вважаються const:
    /*public static final*/ int ID = 2;
}
interface Y{
    void scream(String whatToScream);
}
class User implements X,Y{
    @Override //Ctrl + I
    public void scream(String whatToScream) {

    }
    public void greeting(){

}
}
class Student implements X{
    public void greeting(){

    }

}
class Policeman implements Y{
    @Override
    public void scream(String whatToScream) {

    }
}

//Interface methods are by default abstract and public
//Interface attributes are by default public, static and final
//An interface cannot contain a constructor (as it cannot be used to create objects)
//To achieve security - hide certain details and only show the important details of an object (interface).

//        Java does not support "multiple inheritance" (a class can only inherit from one superclass). However, it can be achieved with interfaces, because the class can implement multiple interfaces.
//        Note: To implement multiple interfaces, separate them with a comma






