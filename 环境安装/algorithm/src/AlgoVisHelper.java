import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
    private AlgoVisHelper(){}

    public static void setStrokeWidth(Graphics2D g2d, int w){
        int strokeWidth = w;
        // strokeWidth设置线条粗细
        // BasicStroke.CAP_ROUND 设置线条末端的点（使绘制更加平滑）
        // BasicStroke.JOIN_ROUND 设置线条拐点（使绘制更加平滑）
        g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND)); //设置线条粗细
    }

    public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

    public static void setColor(Graphics2D g2d, Color color){
        g2d.setColor(color);
    }


}
