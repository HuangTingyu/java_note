### Java基础

如果在任何方法上应用static关键字，此方法称为静态方法。

静态方法属于类，而不属于类的对象。**可以直接调用静态方法，而无需创建类的实例。**

静态方法可以访问静态数据成员，并可以更改静态数据成员的值。



```java
//Program of changing the common property of all objects(static field).  

class Student9 {
    int rollno;
    String name;
    static String college = "ITS";

    static void change() {
        college = "BBDIT";
    }

    Student9(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    public static void main(String args[]) {
        Student9.change();

        Student9 s1 = new Student9(111, "Karan");
        Student9 s2 = new Student9(222, "Aryan");
        Student9 s3 = new Student9(333, "Sonoo");

        s1.display();
        s2.display();
        s3.display();
    }
}
```

