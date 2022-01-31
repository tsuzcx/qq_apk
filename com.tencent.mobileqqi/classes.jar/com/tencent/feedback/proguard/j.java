package com.tencent.feedback.proguard;

import java.io.Serializable;

public abstract class j
  implements Serializable
{
  public abstract void a(h paramh);
  
  public abstract void a(i parami);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public final byte[] a()
  {
    i locali = new i();
    a(locali);
    return locali.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.j
 * JD-Core Version:    0.7.0.1
 */