import java.util.ArrayList;

public class Attribute {
    int id;
    String name;
    String type;
    int minValue;
    int maxValue;
    ArrayList valuesList=new ArrayList();

    Attribute(int id, String name, String type, int minValue, int maxValue) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    Attribute(int id, String name, String type, ArrayList valuesList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.valuesList = valuesList;
    }

    public String getName() {
        return name;
    }
}
