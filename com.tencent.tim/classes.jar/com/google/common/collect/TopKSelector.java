package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class TopKSelector<T>
{
  private final T[] buffer;
  private int bufferSize;
  private final Comparator<? super T> comparator;
  private final int k;
  private T threshold;
  
  private TopKSelector(Comparator<? super T> paramComparator, int paramInt)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator, "comparator"));
    this.k = paramInt;
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "k must be nonnegative, was %s", paramInt);
      this.buffer = ((Object[])new Object[paramInt * 2]);
      this.bufferSize = 0;
      this.threshold = null;
      return;
    }
  }
  
  public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int paramInt)
  {
    return greatest(paramInt, Ordering.natural());
  }
  
  public static <T> TopKSelector<T> greatest(int paramInt, Comparator<? super T> paramComparator)
  {
    return new TopKSelector(Ordering.from(paramComparator).reverse(), paramInt);
  }
  
  public static <T extends Comparable<? super T>> TopKSelector<T> least(int paramInt)
  {
    return least(paramInt, Ordering.natural());
  }
  
  public static <T> TopKSelector<T> least(int paramInt, Comparator<? super T> paramComparator)
  {
    return new TopKSelector(paramComparator, paramInt);
  }
  
  private int partition(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.buffer[paramInt3];
    this.buffer[paramInt3] = this.buffer[paramInt2];
    int i;
    for (paramInt3 = paramInt1; paramInt1 < paramInt2; paramInt3 = i)
    {
      i = paramInt3;
      if (this.comparator.compare(this.buffer[paramInt1], localObject) < 0)
      {
        swap(paramInt3, paramInt1);
        i = paramInt3 + 1;
      }
      paramInt1 += 1;
    }
    this.buffer[paramInt2] = this.buffer[paramInt3];
    this.buffer[paramInt3] = localObject;
    return paramInt3;
  }
  
  private void swap(int paramInt1, int paramInt2)
  {
    Object localObject = this.buffer[paramInt1];
    this.buffer[paramInt1] = this.buffer[paramInt2];
    this.buffer[paramInt2] = localObject;
  }
  
  private void trim()
  {
    int i = 0;
    int j = this.k * 2 - 1;
    int i3 = IntMath.log2(j - 0, RoundingMode.CEILING);
    int n = 0;
    int m = 0;
    for (;;)
    {
      int i1 = i;
      int i2;
      if (m < j)
      {
        i2 = partition(m, j, m + j + 1 >>> 1);
        if (i2 <= this.k) {
          break label166;
        }
        j = i2 - 1;
      }
      for (;;)
      {
        n += 1;
        if (n < i3 * 3) {
          break;
        }
        Arrays.sort(this.buffer, m, j, this.comparator);
        i1 = i;
        label166:
        do
        {
          this.bufferSize = this.k;
          this.threshold = this.buffer[i1];
          i = i1 + 1;
          while (i < this.k)
          {
            if (this.comparator.compare(this.buffer[i], this.threshold) > 0) {
              this.threshold = this.buffer[i];
            }
            i += 1;
          }
          i1 = i;
        } while (i2 >= this.k);
        m = Math.max(i2, m + 1);
        i = i2;
      }
    }
  }
  
  public void offer(@Nullable T paramT)
  {
    if (this.k == 0) {}
    do
    {
      do
      {
        do
        {
          return;
          if (this.bufferSize == 0)
          {
            this.buffer[0] = paramT;
            this.threshold = paramT;
            this.bufferSize = 1;
            return;
          }
          if (this.bufferSize >= this.k) {
            break;
          }
          arrayOfObject = this.buffer;
          i = this.bufferSize;
          this.bufferSize = (i + 1);
          arrayOfObject[i] = paramT;
        } while (this.comparator.compare(paramT, this.threshold) <= 0);
        this.threshold = paramT;
        return;
      } while (this.comparator.compare(paramT, this.threshold) >= 0);
      Object[] arrayOfObject = this.buffer;
      int i = this.bufferSize;
      this.bufferSize = (i + 1);
      arrayOfObject[i] = paramT;
    } while (this.bufferSize != this.k * 2);
    trim();
  }
  
  public void offerAll(Iterable<? extends T> paramIterable)
  {
    offerAll(paramIterable.iterator());
  }
  
  public void offerAll(Iterator<? extends T> paramIterator)
  {
    while (paramIterator.hasNext()) {
      offer(paramIterator.next());
    }
  }
  
  public List<T> topK()
  {
    Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
    if (this.bufferSize > this.k)
    {
      Arrays.fill(this.buffer, this.k, this.buffer.length, null);
      this.bufferSize = this.k;
      this.threshold = this.buffer[(this.k - 1)];
    }
    return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TopKSelector
 * JD-Core Version:    0.7.0.1
 */