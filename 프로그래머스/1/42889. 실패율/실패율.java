import java.util.Arrays;

class Solution {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] stageCount = new int[N+1];
        for(int stage : stages) {
            if(stage <= N) {
                stageCount[stage]++;
            }
        }

        int totalCount = stages.length;
        StageFailure[] failureRates = new StageFailure[N];
        for(int i=1; i<=N; i++) {
            if(stageCount[i] > 0){
//                System.out.println("stage: " + i + ", stageCount: " + stageCount[i] + ", totalCount: " + totalCount + " " + (double) stageCount[i] / totalCount);
                StageFailure stageFailure = new StageFailure(i, (double) stageCount[i] / totalCount);
                failureRates[i-1] = stageFailure;
                totalCount -= stageCount[i];
            }else{
                StageFailure stageFailure = new StageFailure(i, 0);
                failureRates[i-1] = stageFailure;
            }
        }

        Arrays.sort(failureRates);

        for(int i=1; i<=N; i++) {
//            System.out.printf(failureRates[i-1].stage +" "+ failureRates[i-1].failureRate);
            System.out.printf(failureRates[i-1].stage+" ");
            answer[i-1] = failureRates[i-1].stage;
        }

        return answer;
    }

    public static void main(String[] args){
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution(4, new int[]{4,4,4,4,4});
    }

    static class StageFailure implements Comparable<StageFailure> {
        int stage;
        double failureRate;

        public StageFailure(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(StageFailure o) {
            if(o.failureRate == this.failureRate) {
                return this.stage - o.stage;
            }
            return o.failureRate > this.failureRate ? 1 : -1;
        }
    }

}