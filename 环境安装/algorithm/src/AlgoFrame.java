import javax.swing.*;

public class AlgoFrame extends JFrame {
    public AlgoFrame(String title, int canvasWidth,int canvasHeight){
        super(title);
        setSize(canvasWidth,canvasHeight);//相当于this.setSize，设置窗口大小
        setResizable(false); //禁止改变窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x，窗口自动关闭

        setVisible(true);//关键！显示窗口！
    }
}
