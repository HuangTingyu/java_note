import java.awt.*;
import java.util.LinkedList;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private static int DELAY = 40;
    private Circle circle;
    private LinkedList<Point> points;
    private AlgoFrame frame;    // 视图
    private int N;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        if(sceneWidth != sceneHeight)
            throw new IllegalArgumentException("Must be a square window.");
        this.N = N;
        circle = new Circle(sceneWidth/2, sceneHeight/2, sceneWidth/2);
        points = new LinkedList<Point>();

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get Pi with Monte Carlo", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        for(int i = 0; i < N; i++){
            frame.render(circle, points);
            AlgoVisHelper.pause(DELAY);
            int x = (int)(Math.random()*frame.getCanvasWidth());
            int y = (int)(Math.random()*frame.getCanvasHeight());

            Point p = new Point(x, y);
            points.add(p);
        }

    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
