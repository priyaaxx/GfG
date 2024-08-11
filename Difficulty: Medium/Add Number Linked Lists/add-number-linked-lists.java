//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
     static Node reverse(Node head)
    {
        Node prev=null;
        Node curr=head;
        Node nex=null;
        while(curr!=null)
        {
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
    static Node addTwoLists(Node first, Node second){
        Node l1=reverse(first);
        Node l2=reverse(second);
        
        Node temp=new Node(0);
        Node temp2=temp;
        
        int carry =0;
        int sum=0;
        while(l1!=null || l2!=null|| carry!=0)
        {
            sum=carry;
            if(l1!=null)
            {
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.data;
                l2=l2.next;       
            }
            carry=sum/10;
            Node n=new Node(sum%10);
            temp2.next=n;
            temp2=temp2.next;
        }
        Node ans=reverse(temp.next);
        // while(ans.data==0 && ans.next!=null){
        //     ans=ans.next;
        // }
        return ans;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends