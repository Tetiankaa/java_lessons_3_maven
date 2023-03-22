package lessons.lesson5_io_reflection.exceptions;


//an exception is an event that occurs during the execution of a program that disrupts the normal flow of the program's instructions.
//
//        When an exception occurs, the normal flow of the program is interrupted, and the program jumps to a predefined exception handler. The exception handler can then deal with the exception in a way that makes sense for the program.
//
//        Java has a built-in mechanism for handling exceptions, using the try-catch-finally block. The try block contains the code that might throw an exception, and the catch block contains the code that handles the exception. The finally block contains code that is always executed, regardless of whether an exception was thrown or not.
public class Main {
    public static void main(String[] args) {

//        try {
//            System.out.println(10/0); // AE
//        }catch (Exception e){
//            e.printStackTrace();//покаже помилку але не зупинить сам код.
//
//        System.out.println("----");
        //************
//        try {
//            System.out.println(10/0); // AE
//            int[] ints = {1,2};
//            System.out.println(ints[100]);//execute element that not exist. It returns error named AIOBE(ArrayIndexOutOfBoundsException)
//        }catch (ArithmeticException e){ // відхопить помилку з System.out.println(10/0);
//            e.printStackTrace();//покаже помилку але не зупинить сам код.
//        }catch (ArrayIndexOutOfBoundsException e){
//            e.printStackTrace(); // відхопить помилку з  System.out.println(ints[100])
//        }catch (Exception e){
//            e.printStackTrace();// якщо код не відхоплюється попередніми catch, то цим уже точно відхопиться. Це так званий загальний catch.
//            //Але 1 його не ставити, бо якщо поставити 1, то він відхопить усі помилки а останні catch не спрацюють.
//        }
//        System.out.println("----");
        //***********************************
        try{
            foobar(10,0);
        }catch (RuntimeException e){

        }
    }
    public static double foobar(int a, int b ) throws RuntimeException {
        if (b==0){
            throw new RuntimeException("b equal 0");
        }
        return a/b;
    }
}

