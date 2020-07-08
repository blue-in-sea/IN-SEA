public class ReservoirSampling {
    // how many number has been read so far 
    private int count;
    // only need to maintain the current sample
    private Integer sample;

    public ReservoirSampling() {
        // count is intialized to be 0 since there is
        // no single number read at the beginning
        this.count = 0;
        this.sample = null;
    }

    public void read(int value) {
        count++;
        int prob = (int) (Math.random() * count);
        // the current read value has the prob (1 / count)
        // to be into the current sample
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}
