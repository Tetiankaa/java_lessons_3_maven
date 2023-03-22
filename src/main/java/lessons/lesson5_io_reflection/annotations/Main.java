package lessons.lesson5_io_reflection.annotations;

import java.lang.reflect.Field;
import java.util.Objects;


//REFLECTION
//Reflection is implemented in Java through a set of classes in the java.lang.reflect package, such as Class, Constructor, Field, and Method. These classes provide methods to retrieve information about the structure
// and behavior of classes and objects, and to modify their values and behavior dynamically. Reflection can be a powerful and flexible tool, but it can also be complex, error-prone, and potentially dangerous if used improperly.
public class Main {
    public static void main(String[] args) {
        User user = new User(-1,"kokos");

        Class<? extends User> uzer = user.getClass();
    //This line of code obtains the runtime class of the user object using the getClass() method. The Class object representing the class of the user object is assigned to the variable uzer.
        Field[] declaredFields = uzer.getDeclaredFields();
        //This line of code retrieves an array of Field objects representing the fields of the User class using the getDeclaredFields() method of the Class object. The getDeclaredFields() method returns an array of Field objects that represent all the fields declared by the User class, including private, protected, and public fields.
        for (Field field : declaredFields) {
            System.out.println(field.getModifiers() + " " + field.getName());
        }

        try {
            foobar(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        //This code iterates over each Field object in the declaredFields array, and prints the modifiers and name of each field to the console using the System.out.println() method.
        //
        //The getModifiers() method of the Field class returns an integer value that represents the access modifiers of the field, such as public, private, protected, static, final, etc.
        //
        //The getName() method of the Field class returns a String object that represents the name of the field.
        //
        //So, in summary, this code uses reflection to obtain the runtime class of a User object, retrieve the fields of the User class, and print their modifiers and names to the console.


    }
    public static void foobar(User user) throws Exception {
        Class<? extends  User> aClass = user.getClass();
        Field[] declaredFields = aClass.getDeclaredFields(); // get all declared   class
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Validator.class)){ // якщо поле анотовано анотацією Validator то робимо слідуючі дії
                field.setAccessible(true);//Цей рядок робить поточне поле доступним, щоб можна було отримати його значення.
    /*жорстке переведення типів: int id = (int)  */ int id = (int)  field.get(user); //Цей рядок отримує значення поточного поля для об’єкта User, переданого як параметр.
                if (id<0){
                    Validator annotation = field.getAnnotation(Validator.class);
                    String msg = annotation.msg();
                    throw new Exception(msg);
                }
            }
        }
    }
}

class User{
    @Validator
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}