package Exercise;

import java.util.Set;
import java.util.TreeSet;

public class B4_ETS {
    public static void visitedCities(String a, String b) {
        Set<Character> R1 = new TreeSet<>();
        Set<Character> R2 = new TreeSet<>();

        for (int i = 0; i < a.length(); i++)
            R1.add(a.charAt(i));
        for (int i = 0; i < b.length(); i++)
            R2.add(b.charAt(i));

        Set<Character> Rtemp = new TreeSet<>();
        Rtemp.addAll(R1);
        Rtemp.addAll(R2);

        Set<Character> Remove = new TreeSet<>();
        Remove.addAll(R1);
        Remove.retainAll(R2);

        Rtemp.removeAll(Remove);

        for(Character c : Rtemp)
            System.out.print(c);
       
    }

    public static void main(String[] args) {
        String[] exInput1 = {"ABCBA","DCAEF"};
        String[] exInput2 = {"KLACK","ADAM"};
        String[] exInput3 = {"ABC","DEF"};

        visitedCities(exInput1[0], exInput1[1]);
        visitedCities(exInput2[0], exInput2[1]);
        visitedCities(exInput3[0], exInput3[1]);
        System.out.println();
    }
}
