import java.util.ArrayList;
import java.util.Scanner;

public class Element {
    int id;
    String name;
    ArrayList<ShortAttribute> inputAttributes = new ArrayList();
    ArrayList<ShortAttribute> outputAttributes = new ArrayList();

    public String getName() {
        return name;
    }

    Element(int id) {
        this.id=id;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of the element");
        this.name=in.nextLine();
        while (true) {
            System.out.println("1. Add input attribute\n2. Add output attribute\n3. Show attributes\n4. Finish");
            int answer = in.nextInt();
            while (answer < 1 || answer > 4)
                answer = in.nextInt();
            if (answer == 1)
                AttributesList.addAttribute(this, "input");
            if (answer == 2)
                AttributesList.addAttribute(this, "output");
            if (answer == 3)
                showAttributes();
            if (answer == 4) {
                if (this.inputAttributes.size() == 0 && this.outputAttributes.size() == 0)
                    System.out.println("Attributes are empty. Can't create the element");
                else
                    break;
            }
        }
    }

    public void showAttributes() {
        System.out.println("Input:");
        if (inputAttributes.size() == 0)
            System.out.println("Empty");
        else
            for (int i = 0; i < inputAttributes.size(); i++)
                if (AttributesList.attributes.get(inputAttributes.get(i).id).type == "int")
                    System.out.println(AttributesList.attributes.get(inputAttributes.get(i).id).getName() +
                            ": " + inputAttributes.get(i).value);
                else
                    System.out.println(AttributesList.attributes.get(inputAttributes.get(i).id).getName()+
                            ": " + AttributesList.attributes.get(inputAttributes.get(i).id).valuesList.get(
                                    inputAttributes.get(i).value));
        System.out.println("Output:");
        if (outputAttributes.size() == 0)
            System.out.println("Empty\n");
        else
            for (int i = 0; i < outputAttributes.size(); i++)
                if (AttributesList.attributes.get(outputAttributes.get(i).id).type == "int")
                    System.out.println(AttributesList.attributes.get(outputAttributes.get(i).id).getName() +
                            ": " + outputAttributes.get(i).value);
                else
                    System.out.println(AttributesList.attributes.get(outputAttributes.get(i).id).getName()+
                            ": " + AttributesList.attributes.get(outputAttributes.get(i).id).valuesList.get(
                            outputAttributes.get(i).value));
    }
}
