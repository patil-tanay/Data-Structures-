
 * // Java program to Implement a stack
// using singly linked list
// import package
import static java.lang.System.exit;
 
// Driver code
class GFG {
    public static void main(String[] args)
    {
        // create Object of Implementing class
        StackUsingLinkedlist obj
            = new StackUsingLinkedlist();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
 
        // print Stack elements
        obj.display();
 
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n",
                          obj.peek());
 
        // Delete top element of Stack
        obj.pop();
        obj.pop();
 
        // print Stack elements
        obj.display();
 
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n",
                          obj.peek());
    }
}
 
// Create Stack Using Linked list
class StackUsingLinkedlist {
 
    // A linked list node
    private class Node {
 
        int data; // integer data
        Node link; // reference variable Node type
    }
    // create global top reference variable global
    Node top;
    // Constructor
    StackUsingLinkedlist() { this.top = null; }
 
    // Utility function to add an element x in the stack
    public void push(int x) // insert at the beginning
    {
        // create new node temp and allocate memory
        Node temp = new Node();
 
        // check if stack (heap) is full. Then inserting an
        //  element would lead to stack overflow
        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }
 
        // initialize data into temp data field
        temp.data = x;
 
        // put top reference into temp link
        temp.link = top;
 
        // update top reference
        top = temp;
    }
 
    // Utility function to check if the stack is empty or
    // not
    public boolean isEmpty() { return top == null; }
 
    // Utility function to return top element in a stack
    public int peek()
    {
        // check for empty stack
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
 
    // Utility function to pop top element from the stack
    public void pop() // remove at the beginning
    {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
 
        // update the top pointer to point to the next node
        top = (top).link;
    }
 
    public void display()
    {
        // check for stack underflow
        if (top == null) {
            System.out.printf("\nStack Underflow");
            exit(1);
        }
        else {
            Node temp = top;
            while (temp != null) {
 
                // print node data
                System.out.print(temp.data);
 
                // assign temp link to temp
                temp = temp.link;
                if(temp != null)
                    System.out.print(" -> ");
            }
        }
    }
} change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zohaib Hassan Soomro
 */
package stack;

import java.util.*;

public class LinkedStack implements Stack {

private int size;
private Node top;

private class Node {

private Object object;
private Node next;

public Node(Object object, Node next) {
    this.object = object;
    this.next = next;
}

}

@Override
public Object peek() {
    if (this.isEmpty()) {
        throw new NoSuchElementException("Stack is Empty!");
    }
    return top.object;
}

@Override
public Object pop() {
    if (this.isEmpty()) {
        throw new NoSuchElementException("Stack is Empty!");
    }
    Object obj = top.object;
    top = top.next;
    --size;
    return obj;
}

@Override
public void push(Object obj) {
    top = new Node(obj, top);
    size++;
}

@Override
public int size() {
    return size;
}

@Override
public boolean isEmpty() {
    return (size == 0);
}

/////toString() converts all data of current object into an string
public String toString() {
    if (this.isEmpty()) {
        return "";
    }
    String string = "[";
    for (Node i = top; i != null; i = i.next) {
        string += String.valueOf(i.object + ",");
    }
    string = string.substring(0, string.lastIndexOf(',')) + "]";
    return string;
}

/////equals() compares two  stacks
public boolean equals(Stack obj) {
    if (this.size() != obj.size()) {
        return false;
    }
    Object array[] = new Object[this.size()];
    Object array2[] = new Object[this.size()];  //as size of both are equal
    boolean areEqual = true;
    int i = 0;                                                          //counter variable
    for (; i < array.length; i++) {
        array[i] = this.pop();                //storing elements in array by popping so that we can store later same elements
        array2[i] = obj.pop();
        if (!array[i].equals(array2[i])) {
            areEqual = false;
        }
    }
        while (--i >= 0) {
            this.push(array[i]);        //again inserting those elements in 
            obj.push(array2[i]);
        }
    return areEqual;
}

////findLast() finds last element in the stack
public Object findLast() {
    if (this.isEmpty()) {
        throw new NoSuchElementException("Stack is empty!");
    }
    Node i = top;
    for (; i.next != null; i = i.next) //because if i.next=null it means i will be pointing to the last Object
    {
    }
    return i.object;
}

/////toArrayStack() returns ArrayStack object equivalent to curent LinkedStack object
public ArrayStack toArrayStack() {
    if (this.isEmpty()) {
        return null;
    }
    Object array[] = new Object[this.size];
    int count = 0;
    ArrayStack stack = new ArrayStack(this.size);
    for (Node i = top; i != null; i = i.next) {
        array[count++] = i.object;           //for preserving same order that's why storing elements in an Object array
    }
    for (int i = this.size - 1; i >= 0; i--) {
        stack.push(array[i]);
    }
    return stack;
}

public static void main(String[] args) {
    LinkedStack stack = new LinkedStack();
    stack.push(4);
    stack.push("Hello");
    stack.push(200);
    LinkedStack stack2 = new LinkedStack();
    stack2.push(4);
    stack2.push("Hello");
    stack2.push(200);
    System.out.println("stack.toString(): " + stack.toString());
    System.out.println("stack2.toString(): " + stack2.toString());
    System.out.println("stack.equals(stack2): " + stack.equals(stack2));
    System.out.println("stack.findLast(): " + stack.findLast());
    System.out.println("stack.toArrayStack().toString(): " + stack.toArrayStack().toString());

}

}
