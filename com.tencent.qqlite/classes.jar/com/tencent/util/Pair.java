package com.tencent.util;

import java.io.Serializable;

public class Pair
  implements Serializable
{
  public final Object first;
  public final Object second;
  
  public Pair(Object paramObject1, Object paramObject2)
  {
    this.first = paramObject1;
    this.second = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Pair)) {
        return false;
      }
      try
      {
        paramObject = (Pair)paramObject;
        if ((!this.first.equals(paramObject.first)) || (!this.second.equals(paramObject.second))) {
          return false;
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.first.hashCode() + 527) * 31 + this.second.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.Pair
 * JD-Core Version:    0.7.0.1
 */