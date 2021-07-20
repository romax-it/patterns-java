package singleton;

public class DbSingletonDemo {
    public static void main(String[] args) {
        DbSingleton instance =  DbSingleton.getInstance();
        System.out.println(instance);
        DbSingleton otherInstance = DbSingleton.getInstance();
        System.out.println(otherInstance);
    }
}
