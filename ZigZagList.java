package DataStructureWithMosh.linkedLists;

import java.util.LinkedList;
import java.util.Scanner;

public class ZigZagList {
    static LinkedList<Integer> list1= new LinkedList<>();
    static LinkedList<Integer> list2 = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i =0;
        while (i<n){
            int val = sc.nextInt();
            list1.addFirst(val);
            i++;
        }
        while(!list1.isEmpty()){
            int val =list1.remove();
            list2.add(val);
            System.out.print(val+"->");
        }
        System.out.println("NULL");

        i =0;
        while (!list2.isEmpty()){
            int top = list2.remove();
            if(i%2 ==0){
                if(!list2.isEmpty() &&top > list2.peek()){
                    int temp = list2.remove();
                    list2.addFirst(top);
                    list1.addLast(temp);
                }else
                    list1.addLast(top);
            }else{
                if(!list2.isEmpty() &&top <list2.peek()){
                    int temp = list2.remove();
                    list2.addFirst(top);
                    list1.addLast(temp);
                }else
                    list1.addLast(top);
            }
            i++;
        }

        while (!list1.isEmpty()){
            System.out.print(list1.remove()+"->");
        }
        System.out.print("NULL");
    }


}
