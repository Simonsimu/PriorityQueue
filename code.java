import java.util.*;
public class PriorityQueue {
 static ArrayList < Integer > data = new ArrayList < Integer > ();
 public static void Insert(int val) {
  if (data.size() == 1) data.add(val);
  else {
   data.add(val);
   int child = data.size() - 1;
   int parent = child / 2;
   while (data.get(parent) < data.get(child)) {
    if (child == 1) break;
    int temp1 = data.get(child);
    int temp2 = data.get(parent);
    data.set(parent, temp1);
    data.set(child, temp2);
    child = parent;
    parent = child / 2;
   }
  }
 }
 public static int Extractmax() {
  if (data.size() == 1) throw new NullPointerException("Heap is empty");
  int max = data.get(1);
  int last = data.get(data.size() - 1);
  data.set(1, last);
  data.remove(data.size() - 1);
  maxHeapify(1);
  return max;
 }
 public static ArrayList < Integer > GetkMax(int k) {
  ArrayList < Integer > ans = new ArrayList < Integer > ();
  try {
   for (int i = 0; i < k; i++) ans.add(Extractmax());
  } catch (Exception E) {
   return ans;
  }
  return ans;
 }
 public static void maxHeapify(int i) {
  int parent = i;
  int child1 = 2 * i;
  int child2 = 2 * i + 1;
  if (child1 < data.size() && data.get(i) < data.get(child1)) parent = child1;
  if (child2 < data.size() && data.get(parent) < data.get(child2)) parent = child2;
  if (parent != i) {
   int temp1 = data.get(i);
   int temp2 = data.get(parent);
   data.set(i, temp2);
   data.set(parent, temp1);
   maxHeapify(parent);
  }
 }
 public static void print() {
  for (int i = 1; i < data.size(); i++) System.out.println(data.get(i));
 }
 public static void main(String args[]) {
  data.add(-1);
  Insert(12);
  Insert(7);
  Insert(6);
  Insert(10);
  Insert(8);
  Insert(20);
  Insert(27);
  Insert(30);
  Insert(40);
  Insert(50);
  Insert(60);
  Insert(70);
  Insert(80);
  Insert(99);
  System.out.println(data);
  System.out.println(Extractmax());
  ArrayList < Integer > max = GetkMax(10);
  System.out.println(max);
 }
}
