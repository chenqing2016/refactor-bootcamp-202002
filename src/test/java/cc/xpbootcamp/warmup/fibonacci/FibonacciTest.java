package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FibonacciTest {

    @Test
    public void should_return_one_when_having_a_number(){

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

}
