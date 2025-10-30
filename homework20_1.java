

import java.util.Scanner;

public class homework20_1
{
   public static void main(String[] args)
   {
      // read 5 numbs
      Scanner sc = new Scanner(System.in);
      LinkedList llist = new LinkedList();

      int count = 0;
      while (count < 5 && sc.hasNextLine()) {
         String line = sc.nextLine().trim();
         if (line.length() == 0) continue; // skip empty lines bruh 
         String[] parts = line.split("[,\\s]+"); // split on comm or space
         for (String part : parts) {
            if (part.length() == 0) continue;
            int value = Integer.parseInt(part);
            // insert stay sorted
            llist.insertSorted(value);
            count++;
            if (count == 5) break;
         }
      }

      //  delete dupes
      deleteDuplicates(llist);

      // print the goods bud
      System.out.println(llist.toString());
   }

   public static void deleteDuplicates(LinkedList llist)
   {
      // one or empty niode do nun
      ListNode curr = llist.head;
      while (curr != null && curr.next != null) {
         if (curr.value == curr.next.value) {
            // skip over
            curr.next = curr.next.next;
         } else {
            // move forward when dif
            curr = curr.next;
         }
      }
   }
}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){ value = v; }
}

class LinkedList
{
   ListNode head;

   // insert val to stay sort while ascend 
   public void insertSorted(int v) {
      ListNode node = new ListNode(v);

      // if list is empty or new value 
      if (head == null || v <= head.value) {
         node.next = head;
         head = node;
         return;
      }

      // find insert
      ListNode prev = head;
      while (prev.next != null && prev.next.value < v) {
         prev = prev.next;
      }
      node.next = prev.next;
      prev.next = node;
   }

   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }
}
