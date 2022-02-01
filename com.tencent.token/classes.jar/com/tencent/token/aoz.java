package com.tencent.token;

import java.util.Arrays;
import java.util.List;

public final class aoz
  implements aov
{
  final String a;
  final List<aov> b;
  
  public aoz(String paramString, List<aov> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public final aqc a(auv paramauv, apb paramapb)
  {
    return new aqd(paramauv, paramapb, this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ShapeGroup{name='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("' Shapes: ");
    localStringBuilder.append(Arrays.toString(this.b.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoz
 * JD-Core Version:    0.7.0.1
 */