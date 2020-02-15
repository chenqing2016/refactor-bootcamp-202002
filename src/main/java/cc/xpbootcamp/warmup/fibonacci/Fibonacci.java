package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public int getFibonacci(int rankSize) {
        if (rankSize==1||rankSize==2){
            return 1;
        }else if(rankSize==3){
            return getFibonacci(rankSize-1)+getFibonacci(rankSize-2);
        }
        return 0;
    }
}
