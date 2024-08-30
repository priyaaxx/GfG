//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            
            int l=sc.nextInt();
			int r=sc.nextInt();
			Solution ob = new Solution();
			ArrayList<Integer> numbers = ob.uniqueNumbers(l,r);
			for(int num : numbers){
			    System.out.print(num+" ");
			}
			System.out.println();

        }
    }
}

// } Driver Code Ends


class Solution{

    static ArrayList<Integer> uniqueNumbers(int L,int R){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=L;i<=R;i++){
            int currNum = i;
            if(isUnique(currNum)){
                ans.add(currNum);
            }
        }
        return ans;
    }
    
    static boolean isUnique(int n){
        String s = String.valueOf(n);
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            } else{
                map.put(ch, map.get(ch)+1);
            }
        }
        
        for(char key: map.keySet()){
            if(map.get(key)>1){
                return false;
            }
        }
        return true;
    }
}