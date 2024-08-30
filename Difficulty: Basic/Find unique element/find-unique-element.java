//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public int findUnique(int k, int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            } else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        
        for(int key: map.keySet()){
            if(map.get(key)%k != 0){
                return key;
            }
        }
        
        return -1;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(scanner.nextLine().trim());
            String[] inputLine = scanner.nextLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int j = 0; j < inputLine.length; j++) {
                arr[j] = Integer.parseInt(inputLine[j]);
            }

            Solution solution = new Solution();
            System.out.println(solution.findUnique(k, arr));
        }

        scanner.close();
    }
}

// } Driver Code Ends