import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AttributesList {
    static Attribute voltage = new Attribute(0, "Voltage", "int", 10, 220);
    static Attribute connector = new Attribute(1, "Connector", "array", new ArrayList(Arrays.asList("AV", "HDMI")));
    static ArrayList<Attribute> attributes = new ArrayList(Arrays.asList(voltage, connector));

    static void addAttribute(Element element, String io) {
        Scanner in = new Scanner(System.in);
        ShortAttribute newAttribute;
        System.out.println("Choose attribute to add:");
        for (int i = 0; i < attributes.size(); i++)
            System.out.println(i + 1 + ". " + attributes.get(i).getName());
        int index=in.nextInt();
        while(index<1 || index>(attributes.size()+1))
            index=in.nextInt();
        if (attributes.get(index-1).type=="int"){
            System.out.println(attributes.get(index-1).getName()+":");
            System.out.println("Minimal value: "+attributes.get(index-1).minValue);
            System.out.println("Maximal value: "+attributes.get(index-1).maxValue);
            int value=in.nextInt();
            while(value<attributes.get(index-1).minValue || value>attributes.get(index-1).maxValue)
                value=in.nextInt();
            newAttribute = new ShortAttribute(index-1, value);
        }else{
            System.out.println(attributes.get(index-1).getName()+":");
            for(int i=0; i< attributes.get(index-1).valuesList.size(); i++)
                System.out.println(i+1+". " + attributes.get(index-1).valuesList.get(i));
            int value=in.nextInt();
            while(value<1|| value> attributes.get(index-1).valuesList.size()+1)
                value=in.nextInt();
            newAttribute = new ShortAttribute(index-1, value-1);
        }
        if(io=="input" && !App.checkEntrance(newAttribute, element.inputAttributes))
            element.inputAttributes.add(newAttribute);
        if(io=="output" && !App.checkEntrance(newAttribute, element.outputAttributes))
            element.outputAttributes.add(newAttribute);
    }
}
