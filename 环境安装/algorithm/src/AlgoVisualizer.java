import java.awt.*;

public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;

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
            for(Circle circle: circles)
                circle.move(0, 0, sceneWidth, sceneHeight);
        }
    }
}
