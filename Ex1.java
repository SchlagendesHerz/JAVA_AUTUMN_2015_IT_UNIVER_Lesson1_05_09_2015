package Lesson1_05_09_2015;

public class Ex1 {
    public static void main(String[] args) {

    }
    public static void ex1(){
        int a = 1;
        int b = 1;
        b = b<<4;
        a=a|b;
    }
    public static void ex2(){
        byte a = 1;
        byte b = 1;
        byte c = (byte)(a + b);
    }
    public static void ex3(){
        int a = Integer.MAX_VALUE;
        byte b = (byte)(a);
//        b=1
    }
    public static void ex4(){
        byte a = 1;
        a++;
//        Ошибки нет
    }
    public static void ex5(){
        int a = 1;
        while(a++>0);
//        Цикл ни разу не выполняется
        while(++a>0);
//        Цикл не зацикливается
    }
    public static void ex6(){
        int a = 30000000;
        int b = 30000000;
        int c = a * b;
//        В с - переплнение, но она никак не обнаруживается
    }
    public static void ex7(){
        System.out.println(0.1 + 0.1 + 0.1 == 0.3);
//        Результат false
    }
    public static void ex8(){
        double b = 1.0 / 0;
//        Infinity
        double c = 0.0 / (-0.0);
//        Nan
        double d=Double.POSITIVE_INFINITY;
        int a = (int)d;
        byte e = (byte)d;
    }
    public static void ex9(){
        boolean a = true;
        boolean b = false;
        if (a=b){
//            Результат равен последнему значению
        }
    }
    static class A{
        static int b;
        int d;

        public void method(/*A this,*/int dd){/*В случае нестатического метода*/
            this.d = dd;
        }
        public static void ex10(){
            A pa = new A();
            pa.method(200);
//      A.method(pa,200); - Псевдокод, отражающий принцип работы JVM
            pa.staticMethod(200); /*Нежелательно, лучше через имя класса*/
        }
        public static void staticMethod(int ccc) {

        }
    }
    static class C{
        int m = 0;
        static int b = 0;
        public C(int n){
            m = n;
            System.out.println(n);
            System.out.println(m);
        }
        {
            b = 10;
        }
        public static void main(String[] args) {
            C pc= new C(b);
            A1 pb = new B1();
            A2 pa = new B2();
            pa.show();/*invokevirtual(pa, show); - Механизм виртуализации*/
            /*invokestatic(pa, show); - static отменяет механизм виртуализации*/
        }
    }

    static class A1{
        static int a=B1.fb();
        public static int fa(){
            return a+1;
        }
    }
    static class B1 extends A1{
        static int b=A1.fa();
        public static int fb(){
            return b+1;
        }
    }
    static class A2{
        static int a;
        public void show(){
            System.out.println(a);
        }
    }
    static class B2 extends A2{
        static int b;
        public void show(){
            System.out.println(b);
        }
    }




}
