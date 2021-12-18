package hello.core.singleton;

public class StatefulService {

    private int price;//상태 유지 필드 10000원 → 20000원

    public void order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price; //여기가 충돌 문제 → 해결책
        /**
         * return price 로 변경 해주면 된다.
         */
    }

    public int getPrice() {
        return price;
    }
}
