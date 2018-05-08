
import Appearance.AppSkin;
import OperationsBase.Operations;
import Validation.ValidationCheck;

public class Menu implements AppSkin {
    private Operations operations = new Operations(way());

    public void start() {
        while (true)
            operations.getOperationMap(appSkin());
    }

    private int way() {
        System.out.println("1.Расписание фирмы GsonBus.");
        System.out.println("2.Расписание фирмы BigXmlBus.");
        int integerChoice = new ValidationCheck().wayValidater();
        return integerChoice;
    }

    @Override
    public int appSkin() {
        System.out.println("1.Показать рассписание.");
        System.out.println("2.Поиск.");
        System.out.println("3.Выбрать рассписание.");
        System.out.println("0.Выход.");
        int integerChoice = new ValidationCheck().skinValidater();
        return integerChoice;
    }
}