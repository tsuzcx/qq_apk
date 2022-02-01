package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
final class Count
  implements Serializable
{
  private int value;
  
  Count(int paramInt)
  {
    this.value = paramInt;
  }
  
  public void add(int paramInt)
  {
    this.value += paramInt;
  }
  
  public int addAndGet(int paramInt)
  {
    paramInt = this.value + paramInt;
    this.value = paramInt;
    return paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Count)) && (((Count)paramObject).value == this.value);
  }
  
  public int get()
  {
    return this.value;
  }
  
  public int getAndSet(int paramInt)
  {
    int i = this.value;
    this.value = paramInt;
    return i;
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void set(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    return Integer.toString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Count
 * JD-Core Version:    0.7.0.1
 */