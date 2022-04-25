package DataStructureWithMosh.linkedLists;

import javax.swing.text.html.parser.Entity;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedList<E> {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void addLast(int value){
        Node node = new Node(value);
        if(first == null)
            first = last = node;
        else{
            last.next =node;
            last = node;
        }
        size++;
    }
    public void addFirst(int value){
        Node node = new Node(value);
        if(first == null)
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public int deleteFirst(){
        if(first == null){
            throw  new NoSuchElementException();
        }
        if(first == last){
            int val = first.value;
            first = last = null;
            return val;
        }
        int value = first.value;
        Node second = first.next;
        first.next = null;
        first = second;
        size--;
        return value;
    }

    public void deleteLast(){
        Node node = getPrevious(last);
        node.next= null;
        last = node;
        size--;
    }

    public Node getPrevious(Node node){
        Node current = first;
        while (current!=null){
            if(current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int value){
        if(first == null){
            throw  new NoSuchElementException();
        }
        return indexOf(value)!=-1;
    }


    public int indexOf(int value){
        if(first == null){
            throw  new NoSuchElementException();
        }
        int index=0;
        Node node = first;
        while (node!=null){
            if(node.value == value)
                return index;
            node=node.next;
            index++;
        }
        return -1;
    }

    public void reverse(){
        Node current = last;
        while (current!=first){
            Node node = getPrevious(current);
            current.next = node;
            current= current.next;
        }
        current.next = null;
        first = last;
        last = current;
    }

    public int [] toArray(){
        int [] array = new int[size];
        Node current = first;
        int index=0;
        while (current!=null){
            array[index++] = current.value;
            current=current.next;
        }
        return array;
    }

    public void findKthNode(int k){
        if(first == null)
            throw  new IllegalStateException();

        Node pointer1 = first;
        Node pointer2 = first;
        int j =1;
        while (j<= k-1){
            pointer2=pointer2.next;
            if(pointer2== null)
                throw new IllegalArgumentException();
            j++;
        }
        while (pointer2!=last){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        System.out.println(pointer1.value);
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int value = sc.nextInt();
        int n = sc.nextInt();
        int i=0;
        while (i<n){
            list.addLast(sc.nextInt());
            i++;
        }
        list.addLast(value);
        int [] array = list.toArray();
        for(int j = 0 ; j< array.length ; j++){
            System.out.print(array[j]+" ");
        }
    }
}



