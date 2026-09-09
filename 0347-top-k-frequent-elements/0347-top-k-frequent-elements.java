class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequencies
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(
                num,
                frequency.getOrDefault(num, 0) + 1
            );
        }

        // Step 2: Create frequency buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : frequency.keySet()) {

            int freq = frequency.get(num);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // Step 3: Collect from highest frequency
        int[] result = new int[k];
        int index = 0;

        for (int freq = buckets.length - 1;
             freq >= 1 && index < k;
             freq--) {

            if (buckets[freq] != null) {

                for (int num : buckets[freq]) {

                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}