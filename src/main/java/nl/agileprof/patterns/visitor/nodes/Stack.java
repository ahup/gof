package nl.agileprof.patterns.visitor.nodes;
public class Stack<E>
{
   private E[] elements;
   private int top, nelem;

   @SuppressWarnings("unchecked")
   public Stack(int size)
   {
      if (size < 2)
         throw new IllegalArgumentException(""+size);
      elements = (E[]) new Object[size];
      top = -1; // indicate that stack is empty
      nelem = 0;
   }

   public boolean isEmpty()
   {
      return top == -1;
   }

   public boolean isFull()
   {
      return top+1 == elements.length;
   }

   public void push(E o) throws StackFullException
   {
      if (top+1 == elements.length)
         throw new StackFullException();
      elements[++top] = o;
      nelem++;
   }

   public E peek() throws StackEmptyException
   {
      if (top == -1)
         throw new StackEmptyException();
      return elements[top];
   }

   public E pop() throws StackEmptyException
   {
      if (top == -1)
         throw new StackEmptyException();
      E element = elements[top--];
      nelem--;
      elements[top+1] = null;
      return element;
   }

   public int size()
   {
      return nelem;
   }
}