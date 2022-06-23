package hello.core.singleton;

public class SingletonService {

    //static → class level 에 올려서 딱 하나만 존재
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        //외부에서 new를 못한다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 확인");
    }

}
