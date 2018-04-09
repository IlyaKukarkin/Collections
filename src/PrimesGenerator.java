import java.util.ListIterator;

public class PrimesGenerator implements ListIterator {

    private Integer[] primes;
    private int currentSize;
    private int currentIndex;

    public void CreatePrimes(int n) {
        primes = new Integer[n];
        currentSize = n;
        currentIndex = 0;

        int index = 0;
        int i = 2;
        while (index < n) {
            if (isPrime(i))
                primes[index++] = i;
            i++;
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < currentSize;
    }

    @Override
    public Integer next() {
        return primes[currentIndex++];
    }

    @Override
    public boolean hasPrevious()
    {
        return currentIndex <= currentSize && currentIndex > 0;
    }

    @Override
    public Integer previous() {
        currentIndex--;
        return primes[currentIndex];
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Object o) {

    }

    @Override
    public void add(Object o) {

    }
}

