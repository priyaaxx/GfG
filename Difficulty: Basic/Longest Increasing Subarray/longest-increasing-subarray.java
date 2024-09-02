//{ Driver Code Starts
// Initial Template for Java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends
// User function Template for Java
import java.util.*;
class Solution {
    public int lenOfLongIncSubArr(List<Integer> arr) {
        // Your Code goes here.
        int ans=1;
        int finalAns=0;
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)>arr.get(i-1)){
                ans++;
            } else{
                if(ans>finalAns){
                    finalAns = ans;
                }
                ans = 1;
            }
        }
        if(ans>finalAns){
            finalAns = ans;
        }
        return finalAns;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution ob = new Solution();

        while (t-- > 0) {
            String s = scanner.nextLine();
            Scanner lineScanner = new Scanner(s);
            List<Integer> arr = new ArrayList<>();

            while (lineScanner.hasNextInt()) {
                arr.add(lineScanner.nextInt());
            }

            int ans = ob.lenOfLongIncSubArr(arr);
            System.out.println(ans);
        }

        scanner.close();
    }
}
// } Driver Code Ends