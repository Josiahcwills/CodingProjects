import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Scores {
    public class PQExample {
        public static class MaxComparator implements Comparator<Integer>{

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }
    public static void main(String[] args) {
        Scores scores = new Scores();
        scores.print();
    }
        private void print(){
            Scanner input = new Scanner(System.in);
            while(!input.equals("quit")){
                PriorityQueue<Integer> queue = new PriorityQueue<>(new MaxComparator());
                System.out.println("Please enter a number");
                int n1 = input.nextInt();
                queue.add(n1);
                System.out.println("The biggest number was: " + queue);
                while(queue.size() !=0){
                    
                }
                    System.out.println(minHeap.poll());

                }
                System.out.println("The smallest number was: " + queue);
            }
        }

}
