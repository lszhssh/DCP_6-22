// 6/13/22

// Solution: https://leetcode.com/problems/edit-distance/discuss/2156787/Java-3-Variations-of-same-solution-using-Bottom-up-Tabulization
// Annotations are mine

public class EditDistance {
    public static int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];
        
        // edit dist between a word and an empty string is the length of the word
        for (int i =0; i <=m; i++){ 
            cost[i][0] = i;
        }
        
        for(int i =0; i <=n; i++){
            cost[0][i] = i;
        }
        
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(word1.charAt(i) == word2.charAt(j))
                {
                    cost[i+1][j+1] = cost[i][j]; //why?
                }
                else 
                {
                    int a = cost[i][j];
                    int b = cost[i][j+1];
                    int c = cost[i+1][j];
                    
                    cost[i+1][j+1] =  a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i+1][j+1]++;
                }
            }
        }
        return cost[m][n];
        
    }

    public static void main(String[] args) {
        System.out.println(editDistance("kitten", "sitting"));
    }
}