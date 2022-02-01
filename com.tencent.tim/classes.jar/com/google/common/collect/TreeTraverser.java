package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@Beta
@GwtCompatible
public abstract class TreeTraverser<T>
{
  public static <T> TreeTraverser<T> using(Function<T, ? extends Iterable<T>> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    return new TreeTraverser.1(paramFunction);
  }
  
  public final FluentIterable<T> breadthFirstTraversal(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    return new TreeTraverser.4(this, paramT);
  }
  
  public abstract Iterable<T> children(T paramT);
  
  UnmodifiableIterator<T> postOrderIterator(T paramT)
  {
    return new PostOrderIterator(paramT);
  }
  
  public final FluentIterable<T> postOrderTraversal(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    return new TreeTraverser.3(this, paramT);
  }
  
  UnmodifiableIterator<T> preOrderIterator(T paramT)
  {
    return new PreOrderIterator(paramT);
  }
  
  public final FluentIterable<T> preOrderTraversal(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    return new TreeTraverser.2(this, paramT);
  }
  
  final class BreadthFirstIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T>
  {
    private final Queue<T> queue = new ArrayDeque();
    
    BreadthFirstIterator()
    {
      Object localObject;
      this.queue.add(localObject);
    }
    
    public boolean hasNext()
    {
      return !this.queue.isEmpty();
    }
    
    public T next()
    {
      Object localObject = this.queue.remove();
      Iterables.addAll(this.queue, TreeTraverser.this.children(localObject));
      return localObject;
    }
    
    public T peek()
    {
      return this.queue.element();
    }
  }
  
  final class PostOrderIterator
    extends AbstractIterator<T>
  {
    private final ArrayDeque<TreeTraverser.PostOrderNode<T>> stack = new ArrayDeque();
    
    PostOrderIterator()
    {
      Object localObject;
      this.stack.addLast(expand(localObject));
    }
    
    private TreeTraverser.PostOrderNode<T> expand(T paramT)
    {
      return new TreeTraverser.PostOrderNode(paramT, TreeTraverser.this.children(paramT).iterator());
    }
    
    protected T computeNext()
    {
      while (!this.stack.isEmpty())
      {
        Object localObject = (TreeTraverser.PostOrderNode)this.stack.getLast();
        if (((TreeTraverser.PostOrderNode)localObject).childIterator.hasNext())
        {
          localObject = ((TreeTraverser.PostOrderNode)localObject).childIterator.next();
          this.stack.addLast(expand(localObject));
        }
        else
        {
          this.stack.removeLast();
          return ((TreeTraverser.PostOrderNode)localObject).root;
        }
      }
      return endOfData();
    }
  }
  
  static final class PostOrderNode<T>
  {
    final Iterator<T> childIterator;
    final T root;
    
    PostOrderNode(T paramT, Iterator<T> paramIterator)
    {
      this.root = Preconditions.checkNotNull(paramT);
      this.childIterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
    }
  }
  
  final class PreOrderIterator
    extends UnmodifiableIterator<T>
  {
    private final Deque<Iterator<T>> stack = new ArrayDeque();
    
    PreOrderIterator()
    {
      Object localObject;
      this.stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(localObject)));
    }
    
    public boolean hasNext()
    {
      return !this.stack.isEmpty();
    }
    
    public T next()
    {
      Iterator localIterator = (Iterator)this.stack.getLast();
      Object localObject = Preconditions.checkNotNull(localIterator.next());
      if (!localIterator.hasNext()) {
        this.stack.removeLast();
      }
      localIterator = TreeTraverser.this.children(localObject).iterator();
      if (localIterator.hasNext()) {
        this.stack.addLast(localIterator);
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeTraverser
 * JD-Core Version:    0.7.0.1
 */