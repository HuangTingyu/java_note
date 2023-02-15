import java.awt.*;

public class AlgoVisHelper {
    private AlgoVisHelper(){}

    public static void setStrokeWidth(Graphics2D g2d, int w){
        int strokeWidth = w;
        // strokeWidth设置线条粗细
        // BasicStroke.CAP_ROUND 设置线条末端的点（使绘制更加平滑）
        // BasicStroke.JOIN_ROUND 设置线条拐点（使绘制更加平滑）
        g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND)); //设置线条粗细
    }


}
