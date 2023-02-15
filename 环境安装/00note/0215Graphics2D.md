### `Graphics2D`

```java
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
            int strokeWidth = 5;
            g2d.setStroke(new BasicStroke(strokeWidth)); //设置线条粗细

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
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
```



#### 类型解释

在`Java`中，`50.2` 是一个 `double` 类型，如果要在`Ellipse2D.Float`中使用，需要转换成`float`类型。转换有以下两种写法

（1）

```
 new Ellipse2D.Float((float) 50.2,50,300,300);
```

（2）

```
 new Ellipse2D.Float(50.2f,50,300,300);
```



或者改用`Ellipse2D.Double` ，这样就不用类型转换。



#### 改颜色

```
g2d.setColor(Color.blue); // 改线条颜色
```



#### 画空心的圆

```java
int strokeWidth = 5;
g2d.setStroke(new BasicStroke(strokeWidth)); //设置线条粗细
g2d.setColor(Color.blue); // 改线条颜色
Ellipse2D circle = new Ellipse2D.Double(50,50,300,300);
g2d.draw(circle);
```



#### 画实心的圆

```java
g2d.setColor(Color.cyan);
Ellipse2D circle2 = new Ellipse2D.Double(50,50,300,300);
g2d.fill(circle2);
```



### `Graphics2D`绘制种类

```
Ellipse2D 圆形
Point2D 点
Line2D 线条
Rectangle2D 长方形
Roud Rectangle2D 圆角长方形
```



### Java基础-static静态类

如果在任何方法上应用static关键字，此方法称为静态方法。

静态方法属于类，而不属于类的对象。**可以直接调用静态方法，而无需创建类的实例。**

静态方法可以访问静态数据成员，并可以更改静态数据成员的值。



### 设置线条粗细

`BasicStroke` 参数

```java
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
```



`BasicStroke.CAP_ROUND`

![BasicStroke_CAP_ROUND](..\image\BasicStroke_CAP_ROUND.png)



`BasicStroke.JOIN_ROUND`

![BasicStroke_JOIN_ROUND](..\image\BasicStroke_JOIN_ROUND.png)



### 绘制圆

```java

```

