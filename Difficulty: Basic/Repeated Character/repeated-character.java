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
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    char firstRep(String S)
    {
        // your code here
        HashMap<Character, Integer> map = new HashMap<>();
        char ans = '#';
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            } else{
                map.put(ch, 1);
            }
        }
        
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(map.get(ch)>1){
                ans = ch;
                return ans;
            }
        }
        return ans;
    }
}