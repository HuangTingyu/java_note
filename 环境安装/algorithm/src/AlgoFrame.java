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
        setSize(canvasWidth,canvasHeight);//相当于this.setSize，设置窗口大小
        setResizable(false); //禁止改变窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x，窗口自动关闭

        setVisible(true);//关键！显示窗口！
        //----------窗口相关

    }
    // 提供访问的接口
    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            // paintComponent是JPanel中自带的方法，用于绘制
            // 这里的Graphics相当于h5 canvas中的cxt var cxt = cnv.getContext('2d')
            super.paintComponent(g); //继承父类paintComponent的方法
            Graphics2D g2d = (Graphics2D) g;
//            g.drawOval(50,50,300,300); //50圆心x坐标，50圆心y坐标，300宽，300高
//            Ellipse2D circle = new Ellipse2D.Float((float) 50.2,50,300,300); //50圆心x坐标，50圆心y坐标，300宽，300高

            //（1）画空心的圆形
//            int strokeWidth = 5;
//            g2d.setStroke(new BasicStroke(strokeWidth)); //设置线条粗细
            AlgoVisHelper.setStrokeWidth(g2d, 5);

            g2d.setColor(Color.blue); // 改线条颜色
            Ellipse2D circle = new Ellipse2D.Double(50,50,300,300);
            g2d.draw(circle);
            // ------（1）画空心的圆形

            // （2）画实心的圆形
            g2d.setColor(Color.cyan);
            Ellipse2D circle2 = new Ellipse2D.Double(50,50,300,300);
            g2d.fill(circle2);
            // ------（2）画实心的圆形
        }

        @Override
        public Dimension getPreferredSize(){
            // 此处设置了canvas画布的大小
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
