package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
    public void run() {
        List<Car> carList = getCarList(inputCarNames());
        int roundCount = getRoundCount();

        System.out.println(roundCount);
    }

    private int getRoundCount() {
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        return scan.nextInt();
    }

    private List<Car> getCarList(String[] carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private String[] inputCarNames() {
        Scanner scan = new Scanner(System.in);
        String[] carNameList;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNameList = scan.next().split(",");
        } while (checkFiveWords(carNameList));

        return carNameList;
    }

    private boolean checkFiveWords(String[] carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                System.out.println("이름이 5자가 넘었습니다. 다시 작성해주세요.");
                return true;
            }
        }
        return false;
    }
}
