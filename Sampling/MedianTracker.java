    public class MedianTracker {
        private PriorityQueue<Integer> smallerHalf;
        private PriorityQueue<Integer> largerHalf;

        public MedianTracker() {
            // we care about the smallest number of the larger half, and
            // largest number of the smaller half
            // So for the smaller half we use a max heap, and for the 
            // larger half we use a min heap
            smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
            largerHalf = new PriorityQueue<>();
        }

        public void read(int value) {
            // we maintain the property
            // size(smallerHalf) == size(largerHalf) when there are even number values 
            if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
                smallerHalf.offer(value);
            } else {
                largerHalf.offer(value);
            }
            // After we insert the value 
            // only when size(smallerHalf) == size(largerHalf) + 2 or 
            // size(smallerHalf) == size(largerHalf) - 1 will break 
            // the balanced, we need to adjust accordingly 
            if (smallerHalf.size() - largerHalf.size() >= 2) {
                largerHalf.offer(smallerHalf.poll());
            } else if (largerHalf.size() > smallerHalf.size()) {
                smallerHalf.offer(largerHalf.poll());
            }
        }

        public Double median() {
            int size = size();
            // by the property we maintained, it is easy to know that if the 
            // numeber of values read is odd, the largest one in the
            // smallerhalf is the MEDIAN we want
            if (size == 0) {
                return null;
            } else if (size % 2 != 0) {
                return (double) (smallerHalf.peek());
            } else {
                return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
            }
        }

        public int size() {
            return smallerHalf.size() + largerHalf.size();
        }
    }
