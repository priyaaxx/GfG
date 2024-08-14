//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Function to sort the given linked list using Merge Sort.
    public static Node merge2Lists(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(l1!=null && l2!=null){
            if(l1.data<=l2.data){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            temp.next = l1;
        } else if(l2!=null){
            temp.next = l2;
        }
        return dummy.next;
    }
    public static Node findMiddle(Node head){
        if(head==null || head.next == null){
            return head;
        }
        
        Node slow = head;
        Node fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    static Node mergeSort(Node head) {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge2Lists(left, right);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends