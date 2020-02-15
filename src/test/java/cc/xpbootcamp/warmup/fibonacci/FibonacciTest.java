package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FibonacciTest {

    @Test
    public void should_return_one_when_has_a_number(){

        Fibonacci fibonacci = new Fibonacci();
        int result=fibonacci.getFibonacci(1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_one_when_have_two_numbers(){

        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.getFibonacci(2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_two_when_have_three_numbers(){

        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.getFibonacci(3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_three_when_have_four_numbers(){

        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.getFibonacci(4);

        assertThat(result).isEqualTo(3);
    }

}