package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class MultitransformedIterator<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> backingIterator;
  private Iterator<? extends T> current = Iterators.emptyIterator();
  private Iterator<? extends T> removeFrom;
  
  MultitransformedIterator(Iterator<? extends F> paramIterator)
  {
    this.backingIterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
  }
  
  public boolean hasNext()
  {
    Preconditions.checkNotNull(this.current);
    if (this.current.hasNext()) {
      return true;
    }
    while (this.backingIterator.hasNext())
    {
      Iterator localIterator = transform(this.backingIterator.next());
      this.current = localIterator;
      Preconditions.checkNotNull(localIterator);
      if (this.current.hasNext()) {
        return true;
      }
    }
    return false;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.removeFrom = this.current;
    return this.current.next();
  }
  
  public void remove()
  {
    if (this.removeFrom != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.removeFrom.remove();
      this.removeFrom = null;
      return;
    }
  }
  
  abstract Iterator<? extends T> transform(F paramF);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultitransformedIterator
 * JD-Core Version:    0.7.0.1
 */