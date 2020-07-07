class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((x, y) -> y - x); // max heap
        large = new PriorityQueue<>();        // default min heap

    }
    
    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        // rebalance
        if (small.size() - large.size() >= 2) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        int size = size();
        if (size % 2 != 0) return (double) small.peek();
        else return (small.peek () + large.peek ()) / 2.0;
    }

    private int size() {
        return small.size() + large.size();
    }
}
