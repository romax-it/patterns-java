package singleton;

public class DbSingleton {
    private static volatile DbSingleton instance = null;
    private  DbSingleton () {
        if(instance != null){
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingleton getInstance(){
        synchronized (DbSingleton.class){
            if( instance == null){
                instance = new DbSingleton();
            }
        }
        return instance;
    }
}
