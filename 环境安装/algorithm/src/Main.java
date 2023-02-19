import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        // circle定义部分
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;
        Circle[] circles = new Circle[N];
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

        // ------circle定义部分
//        EventQueue开启一个新线程
        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("welcome",sceneWidth,sceneHeight);

            new Thread(()->{
                while(true){
                    // 绘制部分
                    frame.render(circles);
                    AlgoVisHelper.pause(20); //20ms

                    // 更新部分
                    for(Circle circle: circles)
                        circle.move(0, 0, sceneWidth, sceneHeight);
                }
            }).start();

        });

    }
}