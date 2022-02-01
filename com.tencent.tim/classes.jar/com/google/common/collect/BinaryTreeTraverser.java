package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

@Beta
@GwtCompatible
public abstract class BinaryTreeTraverser<T>
  extends TreeTraverser<T>
{
  private static <T> void pushIfPresent(Deque<T> paramDeque, Optional<T> paramOptional)
  {
    if (paramOptional.isPresent()) {
      paramDeque.addLast(paramOptional.get());
    }
  }
  
  public final Iterable<T> children(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    return new BinaryTreeTraverser.1(this, paramT);
  }
  
  public final FluentIterable<T> inOrderTraversal(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    return new BinaryTreeTraverser.2(this, paramT);
  }
  
  public abstract Optional<T> leftChild(T paramT);
  
  UnmodifiableIterator<T> postOrderIterator(T paramT)
  {
    return new PostOrderIterator(paramT);
  }
  
  UnmodifiableIterator<T> preOrderIterator(T paramT)
  {
    return new PreOrderIterator(paramT);
  }
  
  public abstract Optional<T> rightChild(T paramT);
  
  final class InOrderIterator
    extends AbstractIterator<T>
  {
    private final BitSet hasExpandedLeft = new BitSet();
    private final Deque<T> stack = new ArrayDeque(8);
    
    InOrderIterator()
    {
      Object localObject;
      this.stack.addLast(localObject);
    }
    
    protected T computeNext()
    {
      while (!this.stack.isEmpty())
      {
        Object localObject = this.stack.getLast();
        if (this.hasExpandedLeft.get(this.stack.size() - 1))
        {
          this.stack.removeLast();
          this.hasExpandedLeft.clear(this.stack.size());
          BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(localObject));
          return localObject;
        }
        this.hasExpandedLeft.set(this.stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(localObject));
      }
      return endOfData();
    }
  }
  
  final class PostOrderIterator
    extends UnmodifiableIterator<T>
  {
    private final BitSet hasExpanded;
    private final Deque<T> stack = new ArrayDeque(8);
    
    PostOrderIterator()
    {
      Object localObject;
      this.stack.addLast(localObject);
      this.hasExpanded = new BitSet();
    }
    
    public boolean hasNext()
    {
      return !this.stack.isEmpty();
    }
    
    public T next()
    {
      for (;;)
      {
        Object localObject = this.stack.getLast();
        if (this.hasExpanded.get(this.stack.size() - 1))
        {
          this.stack.removeLast();
          this.hasExpanded.clear(this.stack.size());
          return localObject;
        }
        this.hasExpanded.set(this.stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(localObject));
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(localObject));
      }
    }
  }
  
  final class PreOrderIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T>
  {
    private final Deque<T> stack = new ArrayDeque(8);
    
    PreOrderIterator()
    {
      Object localObject;
      this.stack.addLast(localObject);
    }
    
    public boolean hasNext()
    {
      return !this.stack.isEmpty();
    }
    
    public T next()
    {
      Object localObject = this.stack.removeLast();
      BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(localObject));
      BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(localObject));
      return localObject;
    }
    
    public T peek()
    {
      return this.stack.getLast();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.BinaryTreeTraverser
 * JD-Core Version:    0.7.0.1
 */