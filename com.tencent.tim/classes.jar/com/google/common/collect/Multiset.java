package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface Multiset<E>
  extends Collection<E>
{
  @CanIgnoreReturnValue
  public abstract int add(@Nullable E paramE, int paramInt);
  
  @CanIgnoreReturnValue
  public abstract boolean add(E paramE);
  
  public abstract boolean contains(@Nullable Object paramObject);
  
  public abstract boolean containsAll(Collection<?> paramCollection);
  
  public abstract int count(@Nullable Object paramObject);
  
  public abstract Set<E> elementSet();
  
  public abstract Set<Entry<E>> entrySet();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract Iterator<E> iterator();
  
  @CanIgnoreReturnValue
  public abstract int remove(@Nullable Object paramObject, int paramInt);
  
  @CanIgnoreReturnValue
  public abstract boolean remove(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  public abstract boolean removeAll(Collection<?> paramCollection);
  
  @CanIgnoreReturnValue
  public abstract boolean retainAll(Collection<?> paramCollection);
  
  @CanIgnoreReturnValue
  public abstract int setCount(E paramE, int paramInt);
  
  @CanIgnoreReturnValue
  public abstract boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  public abstract String toString();
  
  public static abstract interface Entry<E>
  {
    public abstract boolean equals(Object paramObject);
    
    public abstract int getCount();
    
    public abstract E getElement();
    
    public abstract int hashCode();
    
    public abstract String toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multiset
 * JD-Core Version:    0.7.0.1
 */