package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@Beta
@GwtCompatible(emulated=true)
public abstract class ForwardingSortedMultiset<E>
  extends ForwardingMultiset<E>
  implements SortedMultiset<E>
{
  public Comparator<? super E> comparator()
  {
    return delegate().comparator();
  }
  
  protected abstract SortedMultiset<E> delegate();
  
  public SortedMultiset<E> descendingMultiset()
  {
    return delegate().descendingMultiset();
  }
  
  public NavigableSet<E> elementSet()
  {
    return (NavigableSet)super.elementSet();
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return delegate().firstEntry();
  }
  
  public SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return delegate().headMultiset(paramE, paramBoundType);
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return delegate().lastEntry();
  }
  
  public Multiset.Entry<E> pollFirstEntry()
  {
    return delegate().pollFirstEntry();
  }
  
  public Multiset.Entry<E> pollLastEntry()
  {
    return delegate().pollLastEntry();
  }
  
  protected Multiset.Entry<E> standardFirstEntry()
  {
    Object localObject = entrySet().iterator();
    if (!((Iterator)localObject).hasNext()) {
      return null;
    }
    localObject = (Multiset.Entry)((Iterator)localObject).next();
    return Multisets.immutableEntry(((Multiset.Entry)localObject).getElement(), ((Multiset.Entry)localObject).getCount());
  }
  
  protected Multiset.Entry<E> standardLastEntry()
  {
    Object localObject = descendingMultiset().entrySet().iterator();
    if (!((Iterator)localObject).hasNext()) {
      return null;
    }
    localObject = (Multiset.Entry)((Iterator)localObject).next();
    return Multisets.immutableEntry(((Multiset.Entry)localObject).getElement(), ((Multiset.Entry)localObject).getCount());
  }
  
  protected Multiset.Entry<E> standardPollFirstEntry()
  {
    Iterator localIterator = entrySet().iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
    localEntry = Multisets.immutableEntry(localEntry.getElement(), localEntry.getCount());
    localIterator.remove();
    return localEntry;
  }
  
  protected Multiset.Entry<E> standardPollLastEntry()
  {
    Iterator localIterator = descendingMultiset().entrySet().iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
    localEntry = Multisets.immutableEntry(localEntry.getElement(), localEntry.getCount());
    localIterator.remove();
    return localEntry;
  }
  
  protected SortedMultiset<E> standardSubMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
  
  public SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    return delegate().subMultiset(paramE1, paramBoundType1, paramE2, paramBoundType2);
  }
  
  public SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return delegate().tailMultiset(paramE, paramBoundType);
  }
  
  public abstract class StandardDescendingMultiset
    extends DescendingMultiset<E>
  {
    public StandardDescendingMultiset() {}
    
    SortedMultiset<E> forwardMultiset()
    {
      return ForwardingSortedMultiset.this;
    }
  }
  
  public class StandardElementSet
    extends SortedMultisets.NavigableElementSet<E>
  {
    public StandardElementSet()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingSortedMultiset
 * JD-Core Version:    0.7.0.1
 */