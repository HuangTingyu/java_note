import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        JFrame frame = new JFrame("hello");//hello为窗口标题
        frame.setSize(500,500);//窗口大小
        frame.setResizable(false);//禁止调节窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口的时候结束运行程序
        frame.setVisible(true);
    }
}