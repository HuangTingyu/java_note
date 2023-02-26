import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class AlgoVisualizer {

    private static int DELAY = 40; //40ms, 调帧率1000/40=25帧
    // TODO: 创建自己的数据
    private int[] money;
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        // TODO: 初始化数据
        money = new int[100];
        for(int i = 0; i < money.length; i++)
            money[i] = 100; // 每个人手里100元

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
        while (true){

            Arrays.sort(money); //从少到多排序，更直观的展示
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            //每一次动画分50次钱，加快模拟速度
            for(int k=0; k<50; k++){
                // 模拟分钱的部分
                for(int i =0; i<money.length;i++){
//                    if(money[i]>0){
                        int j = (int)(Math.random()*money.length); //取0-100之间的随机数
                        // 随机挑一个人给1元
                        money[i]-=1;
                        money[j]+=1;
//                    }
                }
            }

        }
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
