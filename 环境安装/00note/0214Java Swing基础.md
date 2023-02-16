### Java Swing基础

Java Swing指的是一个窗口，可以分为`MenuBar`(菜单栏) 和 `Content Pane(Container)` (内容窗口)。

接下来的绘制，要使用`JPanel`来充当内容面板。



### 窗口代码保存

`src/Main.java`

```java
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        EventQueue开启一个新线程
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("hello");//hello为窗口标题
            frame.setSize(500,500);//窗口大小
            frame.setResizable(false);//禁止调节窗口大小
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口的时候结束运行程序
            frame.setVisible(true);
        });

    }
}
```



### 窗口代码优化

在`src` 目录下右键，`New` - `Java Class`

![new_java_class](..\image\new_java_class.png)



`src/AlgoFrame.java`

```
import javax.swing.*;

public class AlgoFrame extends JFrame {
    public AlgoFrame(String title, int canvasWidth,int canvasHeight){
        super(title);
        setSize(canvasWidth,canvasHeight);//相当于this.setSize，设置窗口大小
        setResizable(false); //禁止改变窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x，窗口自动关闭

        setVisible(true);//关键！显示窗口！
    }
}

```



### 私有变量

防止`canvasWidth`，`canvasHeight`遭到篡改

```java
public class AlgoFrame extends JFrame {
    // private防止canvasWidth，canvasHeight遭到篡改
    private int canvasWidth;
    private int canvasHeight;
    public AlgoFrame(String title, int canvasWidth,int canvasHeight){
        ......
    	this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        ......
    }
    // 提供访问的接口
    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}
}
```



### 添加画布

注意，这里添加了画布，把画布设置为内容面板以后，不要再去用`setSize`调节窗口大小。不然会导致后面绘制的时候，图形的位置跑偏！

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
//        canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        setContentPane(canvas);//将canvas设置为内容面板
        pack(); // 自动调整Algoframe窗口大小
        // ---------画布相关

        // 窗口相关
        // setSize(canvasWidth,canvasHeight);//相当于this.setSize，设置窗口大小
        setResizable(false); //禁止改变窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x，窗口自动关闭

        setVisible(true);//关键！显示窗口！
        //----------窗口相关

    }
```



测试代码，尝试画出圆

```java
private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            // paintComponent是JPanel中自带的方法，用于绘制
            // 这里的Graphics相当于h5 canvas中的cxt var cxt = cnv.getContext('2d')
            super.paintComponent(g); //继承父类paintComponent的方法
            g.drawOval(50,50,300,300); //50圆心x坐标，50圆心y坐标，300宽，300高
        }
    }
```



### 屏幕坐标系

<img src="..\image\screen_coordinate.png" alt="screen_coordinate" style="zoom:30%;" />





### 优化创建画布

将 ` canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));`

替换成以下代码

```
private class AlgoCanvas extends JPanel{
		......
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
```

