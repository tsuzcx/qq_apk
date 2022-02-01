package com.tencent.token;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class amx<V, O>
  implements amw<O>
{
  final List<alz<V>> a;
  final V b;
  
  amx(V paramV)
  {
    this(Collections.emptyList(), paramV);
  }
  
  private amx(List<alz<V>> paramList, V paramV)
  {
    this.a = paramList;
    this.b = paramV;
  }
  
  public boolean b()
  {
    return !this.a.isEmpty();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=");
    localStringBuilder.append(this.b);
    if (!this.a.isEmpty())
    {
      localStringBuilder.append(", values=");
      localStringBuilder.append(Arrays.toString(this.a.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amx
 * JD-Core Version:    0.7.0.1
 */