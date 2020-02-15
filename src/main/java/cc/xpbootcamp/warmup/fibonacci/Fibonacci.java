package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public int getFibonacci(int position) {
        if (position==1||position==2){
            return 1;
        }else{
            return getFibonacci(position-1)+getFibonacci(position-2);
        }
    }
}
