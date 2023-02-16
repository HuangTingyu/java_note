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
public class AlgoVisHelper {
	public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }
}
```

调用

```java
//            Ellipse2D circle = new Ellipse2D.Double(50,50,300,300);
//            g2d.draw(circle);
            AlgoVisHelper.strokeCircle(g2d,200,200,150);
```

解释，`Ellipse2D.Double` 这里定义的圆的xy坐标是指圆左上角的位置。

<img src="..\image\Elli2D.png" alt="Elli2D" style="zoom:25%;" />

`AlgoVisHelper.strokeCircle` 定义的圆的位置，是从圆心开始计算的。



### 绘制水平垂直居中的圆

到这里为止，如果发现画出来的圆不水平垂直居中。**请检查一下代码，是否有用了`setSize`设置窗口大小，记得把`setSize` 相关的代码注释掉。**因为将画布设置为内容面板后，窗口宽高会跟着 `canvas` 画布的宽高，如果再使用`setSize` ，会导致图形位置跑偏！



```java
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
        setContentPane(canvas);//将canvas设置为内容面板
        pack(); // 自动调整Algoframe窗口大小
        // ---------画布相关

        // 窗口相关
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
```

