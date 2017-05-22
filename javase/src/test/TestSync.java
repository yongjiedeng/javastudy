package test;

/**
 * Created by dengyongjie044 on 2017/5/19.
 */
public class TestSync {
    public static void main(String[] args){
        StackBag stackBag = new StackBag();
        Producer producer = new Producer(stackBag);
        Consumer consumer = new Consumer(stackBag);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }



}

class WoTou{
    private int i;
    public WoTou(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "WoTou:"+i;
    }
}

class StackBag{
    WoTou[] woTouArr = new WoTou[10];
    int index =0;
    public synchronized void push(WoTou woTou) throws InterruptedException {
        if(index == woTouArr.length){
            this.wait();
        }
        this.notify();
        woTouArr[index] = woTou;
        index ++;
    }

    public synchronized  WoTou popo(){
        if(index < 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //this.notify();
        index --;
        return woTouArr[index];

    }
}

class Producer implements Runnable{
    private StackBag stackBag;

    public Producer(StackBag stackBag){
        this.stackBag = stackBag;
    }

    @Override
    public void run() {
        for(int i=0;i<10; i++){
            WoTou woTou = new WoTou(i);
            try {
                stackBag.push(woTou);
                System.out.println("Product Wotuo "+ woTou);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private StackBag stackBag;

    public Consumer(StackBag stackBag){
        this.stackBag = stackBag;
    }

    @Override
    public void run() {
        for(int i=0;i<10; i++){
            WoTou woTou = stackBag.popo();
            System.out.println("Consum Wotuo "+ woTou);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
