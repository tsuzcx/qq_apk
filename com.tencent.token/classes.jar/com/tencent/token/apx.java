package com.tencent.token;

import java.util.Arrays;
import java.util.List;

public final class apx
  implements apt
{
  final String a;
  final List<apt> b;
  
  public apx(String paramString, List<apt> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public final ara a(avt paramavt, apz paramapz)
  {
    return new arb(paramavt, paramapz, this);
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
 * Qualified Name:     com.tencent.token.apx
 * JD-Core Version:    0.7.0.1
 */