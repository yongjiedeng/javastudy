package test;

/**
 * Created by dengyongjie044 on 2017/5/19.
 */
public class TestSync {
    public static void main(String[] args){
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.run();
        thread2.run();
    }



}

class WoTou{
    private int i;
    public WoTou(int i){
        this.i = i;
    }
}

class StackBag{
    WoTou[] woTouArr = new WoTou[10];
    static int index =0;
    public synchronized void push(WoTou woTou){
        while (index <10){
            index ++;
            woTouArr[index] = woTou;
        }
    }

    public synchronized  WoTou popo(){
        while (index > 0){
            index --;
            return woTouArr[index];
        }
        return null;
    }
}

class Producer implements Runnable{
    StackBag stackBag;

    @Override
    public void run() {
        for(int i=0;i<10; i++){
            WoTou woTou = new WoTou(i);
            stackBag.push(woTou);
            System.out.println("Product Wotuo "+ woTou);
        }
    }
}

class Consumer implements Runnable{
    StackBag stackBag;

    @Override
    public void run() {
        for(int i=0;i<10; i++){
            WoTou woTou = stackBag.popo();
            System.out.println("Product Wotuo "+ woTou);
        }
    }
}
