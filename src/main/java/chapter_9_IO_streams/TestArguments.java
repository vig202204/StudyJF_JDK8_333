package chapter_9_IO_streams;

public class TestArguments {
    public static void main(String[] args) {
        //Скількі отримано аргументів?
        int numberOfArgs = args.length;
        for (int i = 0; i < numberOfArgs; i++) {
            System.out.println("I've got "+ args[i]);
        }
// Оптимізація від IntellJ IDEA
        for (String arg : args) {
            System.out.println("optimal visualise of  \"I've got\" : " + arg);
        }
    }
}
