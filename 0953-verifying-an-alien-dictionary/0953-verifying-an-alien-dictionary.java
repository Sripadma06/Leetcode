class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];

        // Create character → rank mapping
        for (int i = 0; i < 26; i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int minLength = Math.min(word1.length(), word2.length());

            int j = 0;

            while (j < minLength) {

                int rank1 = rank[word1.charAt(j) - 'a'];
                int rank2 = rank[word2.charAt(j) - 'a'];

                if (rank1 < rank2) {
                    // word1 < word2
                    break;
                }

                if (rank1 > rank2) {
                    // word1 > word2
                    return false;
                }

                j++;
            }

            // All common characters are equal.
            // Shorter word must come first.
            if (j == minLength && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}