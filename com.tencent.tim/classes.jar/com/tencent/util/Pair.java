package com.tencent.util;

import java.io.Serializable;

public class Pair<F, S>
  implements Serializable
{
  public final F first;
  public final S second;
  
  public Pair(F paramF, S paramS)
  {
    this.first = paramF;
    this.second = paramS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.util.Pair
 * JD-Core Version:    0.7.0.1
 */