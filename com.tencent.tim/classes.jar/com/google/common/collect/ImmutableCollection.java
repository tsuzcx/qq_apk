package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class ImmutableCollection<E>
  extends AbstractCollection<E>
  implements Serializable
{
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList()
  {
    switch (size())
    {
    default: 
      return new RegularImmutableAsList(this, toArray());
    case 0: 
      return ImmutableList.of();
    }
    return ImmutableList.of(iterator().next());
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      paramArrayOfObject[paramInt] = localIterator.next();
      paramInt += 1;
    }
    return paramInt;
  }
  
  abstract boolean isPartialView();
  
  public abstract UnmodifiableIterator<E> iterator();
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    int i = size();
    if (i == 0) {
      return ObjectArrays.EMPTY_ARRAY;
    }
    Object[] arrayOfObject = new Object[i];
    copyIntoArray(arrayOfObject, 0);
    return arrayOfObject;
  }
  
  @CanIgnoreReturnValue
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    Preconditions.checkNotNull(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i) {
      localObject = ObjectArrays.newArray(paramArrayOfT, i);
    }
    for (;;)
    {
      copyIntoArray((Object[])localObject, 0);
      return localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
  }
  
  Object writeReplace()
  {
    return new ImmutableList.SerializedForm(toArray());
  }
  
  static abstract class ArrayBasedBuilder<E>
    extends ImmutableCollection.Builder<E>
  {
    Object[] contents;
    int size;
    
    ArrayBasedBuilder(int paramInt)
    {
      CollectPreconditions.checkNonnegative(paramInt, "initialCapacity");
      this.contents = new Object[paramInt];
      this.size = 0;
    }
    
    private void ensureCapacity(int paramInt)
    {
      if (this.contents.length < paramInt) {
        this.contents = ObjectArrays.arraysCopyOf(this.contents, expandedCapacity(this.contents.length, paramInt));
      }
    }
    
    @CanIgnoreReturnValue
    public ArrayBasedBuilder<E> add(E paramE)
    {
      Preconditions.checkNotNull(paramE);
      ensureCapacity(this.size + 1);
      Object[] arrayOfObject = this.contents;
      int i = this.size;
      this.size = (i + 1);
      arrayOfObject[i] = paramE;
      return this;
    }
    
    @CanIgnoreReturnValue
    public ImmutableCollection.Builder<E> add(E... paramVarArgs)
    {
      ObjectArrays.checkElementsNotNull(paramVarArgs);
      ensureCapacity(this.size + paramVarArgs.length);
      System.arraycopy(paramVarArgs, 0, this.contents, this.size, paramVarArgs.length);
      this.size += paramVarArgs.length;
      return this;
    }
    
    @CanIgnoreReturnValue
    public ImmutableCollection.Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      if ((paramIterable instanceof Collection))
      {
        Collection localCollection = (Collection)paramIterable;
        int i = this.size;
        ensureCapacity(localCollection.size() + i);
      }
      super.addAll(paramIterable);
      return this;
    }
  }
  
  public static abstract class Builder<E>
  {
    static final int DEFAULT_INITIAL_CAPACITY = 4;
    
    static int expandedCapacity(int paramInt1, int paramInt2)
    {
      if (paramInt2 < 0) {
        throw new AssertionError("cannot store more than MAX_VALUE elements");
      }
      int i = (paramInt1 >> 1) + paramInt1 + 1;
      paramInt1 = i;
      if (i < paramInt2) {
        paramInt1 = Integer.highestOneBit(paramInt2 - 1) << 1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = 2147483647;
      }
      return paramInt2;
    }
    
    @CanIgnoreReturnValue
    public abstract Builder<E> add(E paramE);
    
    @CanIgnoreReturnValue
    public Builder<E> add(E... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        add(paramVarArgs[i]);
        i += 1;
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        add(paramIterable.next());
      }
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterator<? extends E> paramIterator)
    {
      while (paramIterator.hasNext()) {
        add(paramIterator.next());
      }
      return this;
    }
    
    public abstract ImmutableCollection<E> build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableCollection
 * JD-Core Version:    0.7.0.1
 */