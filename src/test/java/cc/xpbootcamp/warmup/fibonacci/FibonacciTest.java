package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FibonacciTest {

    @Test
    public void should_return_1_when_get_fibonacci_given_position_is_1(){

        Fibonacci fibonacci = new Fibonacci();
        long result=fibonacci.getFibonacci(1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_1_when_get_fibonacci_given_position_is_2(){

        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_2_when_get_fibonacci_given_position_is_3(){

        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_3_when_get_fibonacci_given_position_is_4(){

        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(4);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_return_89_when_get_fibonacci_given_position_is_11(){

        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(11);

        assertThat(result).isEqualTo(89);
    }

    @Test
    public void should_return_89_when_get_fibonacci_given_position_is_50(){

        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(50);

        assertThat(result).isEqualTo(12586269025L);
    }
}
