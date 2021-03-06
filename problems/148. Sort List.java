/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//要断尾！！！！
class Solution {
    public ListNode sortList(ListNode head) {
        //只有一个的时候要终止！！！！终止条件要想好
        if(head == null || head.next == null)return head;
        ListNode midNode = findMid(head);
        
        ListNode frontHead = head;
        ListNode endHead = midNode.next;
        //set front tail null!!!!!
        midNode.next = null;

        ListNode front = sortList(frontHead);
        ListNode end = sortList(endHead);

        //combine two sortedList
        ListNode newEmptyNode = new ListNode(0);
        newEmptyNode.next = null;
        ListNode newTempNode = newEmptyNode;
        while(front != null && end != null){
            if(front.val < end.val){
                newTempNode.next = front;
                front = front.next;
            }else{
                newTempNode.next = end;
                end = end.next;
            }
            newTempNode = newTempNode.next;
        }
        //deal with the lagacy list
        if(front != null){
            newTempNode.next = front;
        }else if(end != null){
            newTempNode.next = end;
        }
        return newEmptyNode.next; 
    }

    //end is longer than front 
    public ListNode findMid(ListNode head){
        //quick-slow find mid
        if(head == null)return null;
        ListNode quick = head;
        ListNode slow = head;
        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}