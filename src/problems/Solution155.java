package problems;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */

public class Solution155 {
    Stack<Integer> st;
    Stack<Integer> minStack;

    public Solution155() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    // st = 512, -1024, -1024, 512
    // min = 512, -1024, -1024
    public void push(int val) { // O(1)
        // Validar si es el primer elemento en el stack o el val es menor o igual al top del stack
        if(st.isEmpty() || val <= minStack.peek()) {
            st.push(val);
            minStack.push(val);
        } else {
            st.push(val);
        }
    }

    public void pop() { // O(1)
        // validar si el elemento que salio es el mismo que el top del stack
        int val = st.pop();
        if(!st.isEmpty() && minStack.peek() == val) {
            minStack.pop();
        }

    }

    public int top() { // O(1)
        return st.peek();
    }

    public int getMin() { // O(1)
        return minStack.peek();
    }
}
