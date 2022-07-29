/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredriverone;

/**
 *
 * @author Jesse
 */
public class SLList<T> 
{
    public class Node
    {
        private Node next; 
        public T data;
        
        public Node()
        {
            next = null; 
            data = null; 
        }
        
        public Node(T data)
        {
            next = null; 
            this.data = data; 
        }
        
    }
    
    // private data memebers of list
    private Node head; 
    private Node tail; 
    
    
    
    public SLList()
    {
        head = null; 
        tail = null; 
    }
    
    /*Add an element from 0 to (size - 1) index of the list */ 
    public void addElement(int index, T data)
    {
        // Check if valid
        int getSize = (size() == 0) ? (0) : (size());  
        if(index < 0 || index > getSize) 
        {
            throw new RuntimeException("Index out of bounds!");
        }
        // Case if index is 0 add it first 
        if(index == 0)
        {
            addFirst(data); 
        } // Add to end case 
        else if(index == (getSize))
        {
            addLast(data); 
        } // Add inbetween case 
        else
        {
            // Other wise use index to determine the poistion to add our list
            int count = --index; 
            Node cursor = head; 
            
            // Traverse list until index is zero get node prior to position 
            while(count > 0)
            {
                cursor = cursor.next; 
                --count; 
            }
            // Found prior node to position
            Node temp = new Node(data);
            temp.next = cursor.next; 
            cursor.next = temp; 
        }
    }
    
    public T removeElement(int index)
    {
        int getSize = (size() == 0) ? (0) : (size());  
      if(index < 0 || index >= (getSize)) 
        {
            throw new RuntimeException("Index out of bounds!");
        }
      if(index == 0)
      {
          return removeFirst(); 
      }
      else if(index == (getSize) )
      {
          return removeLast(); 
      } // Remove inbetween list 
      else
      {
          // Other wise use index to determine the poistion to reomve our node
            int count = --index; 
            Node cursor = head; 
            
            // Traverse list until index is zero get node prior to position 
            while(count > 0)
            {
                cursor = cursor.next; 
                --count; 
            }
            // Cursor has node prior to target
            T target = cursor.next.data; // got data 
            cursor.next = cursor.next.next; 
           
          return target; 
      }
    }
    
    /* Add reference to a linked list*/
    public void addFirst(T data)
    {
        // Base case if list is empty
        if(head == null)
        {
            head = new Node(data); 
            tail = head; 
        }
        else // Other wise replace old head 
        {
            Node temp = new Node(data); 
            temp.next = head;
            head = temp;
            
        }
    }
    /* T refenceing returing method removes a node on the list 
        and returns a refernce to the data */ 
    public T removeFirst()
    {
        if(head == null)
        {
            throw new RuntimeException("Removing from empty list!"); 
        }
        else
        {
            // Other wise a node exist remove it 
            Node temp = head; 
            head = head.next; // replace head 
            T data = temp.data; 
            return temp.data; 
        }
    }
    /*Void method adds an element at end of the list*/ 
    public void addLast(T data)
    {
        // if list is empty
        if(head == null)
        {
            addFirst(data); 
        } // Other wise traverse list and find node prior to the last
        else
        {
            Node temp = new Node(data);
            tail.next = temp; 
            tail = temp; 
        }
    }
    
    /* T reference returning method remove and returns last node in the list*/ 
    public T removeLast()
    {
        // get address prior to targetted node
        if(head == null)
        {
            throw new RuntimeException("Remove from empty list!"); 
        }
        else if(head == tail)
        {
           return removeFirst(); 
        }
        // Other wise look for target 
        
        Node cursor = head; 
        
        // Traverse the list until next node is sasme address as the tail
        while(cursor.next != tail)
        {
            cursor = cursor.next; 
        }
        // rearrange reference variables 
        T data = tail.data; 
        tail = cursor;
        tail.next = null; 
         return data; 
    }
    
    /* Int returning method traverses the list and returns the number of elements 
        on the list*/
    public int size()
    {
        int count = 0; 
        Node cursor = head;
        // Traverse until null is reached
        while(cursor != null)
        {
            cursor = cursor.next; 
            ++count; 
        }
        return count; 
    }
    
    /*Boolean returing value linear seaches the list and return true 
        if element is found otherwise false*/ 
    public boolean contains(Object data)
    {
        // Data upcasted to Object to compare our data
        Node cursor = head; 
        while(cursor != null)
        {
            if(cursor.data.equals(data))
            {
                return true; 
            }
            cursor = cursor.next; 
        }
        return false; 
    }
    
    /*void method reverses a linked list */ 
    public void reverse()
    {
        Node c1 = head; 
        Node c2 = head; 
        Node c3 = null; 
        
        while(c1 != null)
        {
            c2 = c1.next; 
            c1.next = c3; 
            c3 = c1; 
            c1 = c2; 
        }
        // swap
        Node temp = head;
        head = tail; 
        tail  = temp; 
    
    }
    
    
    public T getTail()
    {
        return this.tail.data; 
    }
    
    public T getHead()
    {
        return this.head.data;
    }
    
    
    
    @Override 
    public String toString()
    {
        String result = " ";
        Node cursor = head; 
        System.out.printf("size %d : ",this.size());
        // Traverse until end of list is reached 
        while(cursor != null)
        {
            result = result.concat(cursor.data.toString() + "--->"); 
            cursor = cursor.next; 
        }
        return result; 
    }
}