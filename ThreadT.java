class RunnableNew implements Runnable{
    private Thread thread;
    private String tname;

    RunnableNew(String name){
        tname=name;
        System.out.println("Creating "+tname);
    }

    public void run(){
        System.out.println("Running "+tname);
        try{
            for(int i=0;i<10;i++){
                System.out.println("Thread "+tname+" step "+i);
                thread.sleep(1);//The thrower :p
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread "+tname+" complete");
    }
    public void start() {
        System.out.println("Starting "+tname);
        if(thread==null){
            thread=new Thread(this,tname);
            thread.start();
        }
    }
}
public class ThreadT {
    public static void main(String args[]){
    RunnableNew r1=new RunnableNew("thr1");
    RunnableNew r2=new RunnableNew("thr2");
    r1.start();
    r2.start();}

}
//credits https://www.tutorialspoint.com/java/java_multithreading.htm