//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        head1 = removePrecedingZeros(head1);
        head2 = removePrecedingZeros(head2);
        if (head1 == null && head2 == null) {
            return new Node(0);
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        int length1 = length(head1);
        int length2 = length(head2);
        Node difference;
        if (length1 > length2) {
            difference = subtract(head1, head2);
        } else if (length2 > length1) {
            difference = subtract(head2, head1);
        } else {
            Node[] minMax = getMinMax(head1, head2);
            if (minMax[0] == null) {
                difference = new Node(0);
            } else {
                difference = subtract(minMax[1], minMax[0]);
            }
        }
        return difference;
    }
    
    private Node[] getMinMax(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node big = null;
        Node small = null;
        while (temp1 != null && temp2 != null) {
            if (temp1.data > temp2.data) {
                big = temp1;
                small = temp2;
            } else if (temp1.data < temp2.data) {
                big = temp2;
                small = temp1;
            }
            if (big != null) {
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return new Node[]{small, big};
    }
    
    private Node subtract(Node big, Node small) {
        big = reverse(big);
        small = reverse(small);
        Node dummy = new Node(-1);
        Node result = dummy;
        boolean borrow = false;
        while (big != null && small != null) {
            if (borrow) {
                if (big.data == 0) {
                    big.data = 9;
                } else {
                    big.data = big.data - 1;
                    borrow = false;
                }
            }
            if (small.data > big.data) {
                borrow = true;
                dummy.next = new Node(10 + big.data - small.data);
            } else {
                dummy.next = new Node(big.data - small.data);
            }
            dummy = dummy.next;
            big = big.next;
            small = small.next;
        }
        while (big != null) {
            if (borrow) {
                if (big.data == 0) {
                    big.data = 9;
                } else {
                    big.data = big.data - 1;
                    borrow = false;
                }
            }
            dummy.next = new Node(big.data);
            dummy = dummy.next;
            big = big.next;
        }
        result = reverse(result.next);
        return removePrecedingZeros(result);
    }
    
    private Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    private int length(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    
    private Node removePrecedingZeros(Node node) {
        while (node != null) {
            if (node.data != 0) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}

