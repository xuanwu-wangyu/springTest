package jvmTest;



public class test1 {
    public static void main(String[] args) {
        javavm javavm = new javavm();
        try {
            javavm.stackLeak();
        }catch (Throwable e){
            System.out.println(javavm.stackLength);
            e.printStackTrace();
        }

    }
}
class javavm{
    public int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
}