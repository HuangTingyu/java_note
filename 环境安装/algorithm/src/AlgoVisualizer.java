import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        circles = new Circle[N];
        int R = 50;
        for(int i = 0; i < N; i++){
            // 防止球出边界，圆心取值范围(R, sceneWith-R), (R, sceneHeight-R)
            int x = (int)(Math.random()*(sceneWidth-2*R))+R;
            int y = (int)(Math.random()*(sceneHeight-2*R))+R;
            // 速度取值(-5, 5)
            // 因为Math.random取值范围[0, 1)取不到1，所以乘以11
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x,y,R,vx,vy);
        }

        // EventQueue开启一个新线程，方便同步显示结果
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("welcome",sceneWidth,sceneHeight);

            // 添加键盘事件
            frame.addKeyListener(new AlgoKeyListener());

            // 添加鼠标事件
            frame.addMouseListener(new AlgoMouseListener());

            // new Thread开启一个新线程
            new Thread(()->{
                run(sceneWidth,sceneHeight);
            }).start();

        });
    }

    private void run (int sceneWidth, int sceneHeight){
        // 动画逻辑
        while(true){
            // 绘制部分
            frame.render(circles);
            AlgoVisHelper.pause(20); //20ms

            // 更新部分
            // 配合键盘事件
            if(isAnimated)
                for(Circle circle: circles)
                    circle.move(0, 0, sceneWidth, sceneHeight);
        }
    }

    private class AlgoKeyListener extends KeyAdapter{
        // 键盘事件
        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }

    private class AlgoMouseListener extends MouseAdapter{
        // 鼠标事件
//        @Override
        public void mousePressed(MouseEvent event){
            event.translatePoint(-8, -31);
//            System.out.println(frame.getBounds().height);
//            System.out.println(frame.getBounds().width);
//            System.out.println(frame.getCanvasHeight());

            System.out.println(event.getPoint());
        }

    }

    public static void main(String[] args) {
//        System.out.println("Hello world!");
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
