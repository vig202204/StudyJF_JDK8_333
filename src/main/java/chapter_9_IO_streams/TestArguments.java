package chapter_9_IO_streams;

public class TestArguments {
    public static void main(String[] args) {
        if (args.length !=2) {
            System.out.println("Будь ласка, передайте параметри, наприклад:");
            System.out.println("java TestArguments.java /Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333/src/main/java/chapter_9_IO_streams/cornflower.png 250");
            // Вихід з програми
            System.exit(0);
        }else{
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
}
