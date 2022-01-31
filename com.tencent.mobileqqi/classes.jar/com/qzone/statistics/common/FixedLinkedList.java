package com.qzone.statistics.common;

import java.util.LinkedList;

public class FixedLinkedList<V>
  extends LinkedList<V>
{
  private final int mCapacity;
  private final boolean mTrimHead;
  
  public FixedLinkedList(int paramInt)
  {
    this(paramInt, true);
  }
  
  public FixedLinkedList(int paramInt, boolean paramBoolean)
  {
    this.mCapacity = paramInt;
    this.mTrimHead = paramBoolean;
  }
  
  private void ensureCapacity()
  {
    for (;;)
    {
      if ((this.mCapacity <= 0) || (size() <= this.mCapacity)) {
        return;
      }
      if (this.mTrimHead) {
        removeFirst();
      } else {
        removeLast();
      }
    }
  }
  
  public void add(int paramInt, V paramV)
  {
    if (paramV == null) {
      return;
    }
    super.add(paramInt, paramV);
    ensureCapacity();
  }
  
  public boolean add(V paramV)
  {
    if (paramV == null) {
      return false;
    }
    boolean bool = super.add(paramV);
    ensureCapacity();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.statistics.common.FixedLinkedList
 * JD-Core Version:    0.7.0.1
 */