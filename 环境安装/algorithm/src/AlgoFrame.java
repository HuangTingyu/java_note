import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {
    // private防止canvasWidth，canvasHeight遭到篡改
    private int canvasWidth;
    private int canvasHeight;
    public AlgoFrame(String title, int canvasWidth,int canvasHeight){
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        // 画布相关
        AlgoCanvas canvas = new AlgoCanvas();
//        canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        setContentPane(canvas);//将canvas设置为内容面板
        pack(); // 自动调整Algoframe窗口大小
        // ---------画布相关

        // 窗口相关
        // setSize(canvasWidth,canvasHeight);//相当于this.setSize，设置窗口大小
        setResizable(false); //禁止改变窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x，窗口自动关闭

        setVisible(true);//关键！显示窗口！
        //----------窗口相关

    }
    // 提供访问的接口
    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    private class AlgoCanvas extends JPanel{
        public  AlgoCanvas(){
            super(true);
        }

        @Override
        public void paintComponent(Graphics g){
            // paintComponent是JPanel中自带的方法，用于绘制
            // 这里的Graphics相当于h5 canvas中的cxt var cxt = cnv.getContext('2d')
            super.paintComponent(g); //继承父类paintComponent的方法
            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            // （1）画实心的圆形
            AlgoVisHelper.setColor(g2d, Color.cyan);
            AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2,200);
            // ------（1）画实心的圆形

            //（2）画空心的圆形

            AlgoVisHelper.setStrokeWidth(g2d, 5); //设置线条粗细
            AlgoVisHelper.setColor(g2d, Color.blue);
            AlgoVisHelper.strokeCircle(g2d, canvasWidth/2, canvasHeight/2,200);
            // ------（2）画空心的圆形
        }

        @Override
        public Dimension getPreferredSize(){
            // 此处设置了canvas画布的大小
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
