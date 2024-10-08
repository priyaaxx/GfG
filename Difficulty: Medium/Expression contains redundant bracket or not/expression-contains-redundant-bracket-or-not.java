//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '+' || ch=='-' || ch=='*' || ch=='/'){
                st.push(ch);
            } else if(ch == ')'){
                if(st.peek() == '('){
                    ans = 1;
                    return ans;
                }
                while(st.peek() == '+' || st.peek()=='-' || st.peek()=='*' || st.peek()=='/'){
                    st.pop();
                }
                st.pop();
            }
        }
        return ans;
    }
}
        
