import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for(int i=0; i<mats.length/2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length -1 -i];
            mats[mats.length -1 -i] = temp;
        }
        
        int rows = park.length;
        int cols = park[0].length;
        
        for (int matSize : mats) {
            if (canPlaceMat(rows, cols, matSize, park)) {
                return matSize;
            }
        }
        
        return -1;
    }
    
    private boolean canPlaceMat(int rows, int cols, int matSize, String[][] park) {
        for (int i=0; i<=rows-matSize; i++) {
            for(int j=0; j<=cols - matSize; j++) {
                if(isMatPlaceable(i, j, matSize, park)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isMatPlaceable(int startRow, int startCol, int matSize, String[][] park) {
        for (int i=startRow; i<startRow+matSize; i++) {
            for (int j=startCol; j<startCol+matSize; j++) {
                if(!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}