package com.google.common.base;

import java.util.AbstractList;

final class Joiner$3
  extends AbstractList<Object>
{
  Joiner$3(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2) {}
  
  public Object get(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.val$rest[(paramInt - 2)];
    case 0: 
      return this.val$first;
    }
    return this.val$second;
  }
  
  public int size()
  {
    return this.val$rest.length + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Joiner.3
 * JD-Core Version:    0.7.0.1
 */