class Solution {
    
    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int arr1FirstIndex = arr1.length;
        int arr1SecondIndex = arr1[0].length;

        int arr2FirstIndex = arr2.length;
        int arr2SecondIndex = arr2[0].length;

        int[][] answer = new int[arr1FirstIndex][arr2SecondIndex];

        for(int i=0; i<arr1FirstIndex; i++) {
            for(int j=0; j<arr2SecondIndex; j++) {
                int sum = 0;
                for(int k=0; k<arr1SecondIndex; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
    
}