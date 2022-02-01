package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;

@GwtCompatible(emulated=true, serializable=true)
final class ImmutableEnumSet<E extends Enum<E>>
  extends ImmutableSet<E>
{
  private final transient EnumSet<E> delegate;
  @LazyInit
  private transient int hashCode;
  
  private ImmutableEnumSet(EnumSet<E> paramEnumSet)
  {
    this.delegate = paramEnumSet;
  }
  
  static ImmutableSet asImmutable(EnumSet paramEnumSet)
  {
    switch (paramEnumSet.size())
    {
    default: 
      return new ImmutableEnumSet(paramEnumSet);
    case 0: 
      return ImmutableSet.of();
    }
    return ImmutableSet.of(Iterables.getOnlyElement(paramEnumSet));
  }
  
  public boolean contains(Object paramObject)
  {
    return this.delegate.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof ImmutableEnumSet)) {
      localObject = ((ImmutableEnumSet)paramCollection).delegate;
    }
    return this.delegate.containsAll((Collection)localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof ImmutableEnumSet)) {
      localObject = ((ImmutableEnumSet)paramObject).delegate;
    }
    return this.delegate.equals(localObject);
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = this.delegate.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return this.delegate.isEmpty();
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.unmodifiableIterator(this.delegate.iterator());
  }
  
  public int size()
  {
    return this.delegate.size();
  }
  
  public String toString()
  {
    return this.delegate.toString();
  }
  
  Object writeReplace()
  {
    return new EnumSerializedForm(this.delegate);
  }
  
  static class EnumSerializedForm<E extends Enum<E>>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final EnumSet<E> delegate;
    
    EnumSerializedForm(EnumSet<E> paramEnumSet)
    {
      this.delegate = paramEnumSet;
    }
    
    Object readResolve()
    {
      return new ImmutableEnumSet(this.delegate.clone(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableEnumSet
 * JD-Core Version:    0.7.0.1
 */