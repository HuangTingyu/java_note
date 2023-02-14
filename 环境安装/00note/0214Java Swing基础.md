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

