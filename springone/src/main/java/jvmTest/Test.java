package jvmTest;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
