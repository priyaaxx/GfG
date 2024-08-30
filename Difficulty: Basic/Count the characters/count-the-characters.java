//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int n = sc.nextInt();

    		System.out.println (new Sol().getCount (s, n)); 
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int getCount (String S, int N)
    {
        // your code here
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(S.charAt(0), 1);
        for(int i=1; i<S.length();i++){
            char ch = S.charAt(i);
            if(map.containsKey(ch)){
                if(S.charAt(i-1) == S.charAt(i)){
                    map.put(ch, map.get(ch));
                } else{
                    map.put(ch, map.get(ch)+1);
                }
                
            } else{
                map.put(ch, 1);
            }
        }
        
        int count = 0;
        for(char key : map.keySet()){
            if(map.get(key)==N){
                count++;
            }
        }
        return count;
    }
}