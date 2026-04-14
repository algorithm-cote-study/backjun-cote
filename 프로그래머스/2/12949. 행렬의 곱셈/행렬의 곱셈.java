class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int arr1FirstIndex = arr1.length;
        int arr1SecondIndex = arr1[0].length;
        int arr2FirstIndex = arr2[0].length;
        
        
        int[][] answer = new int[arr1FirstIndex][arr2FirstIndex];

        for(int i=0; i<arr1FirstIndex; i++){
            for(int j=0; j<arr2FirstIndex; j++){
                for(int x=0; x<arr1SecondIndex; x++){
                    answer[i][j] += (arr1[i][x] * arr2[x][j]);
                }
            }
        }
        
        
        return answer;
    }
}