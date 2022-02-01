package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;
import java.io.Serializable;

public abstract class Orion
  implements Serializable
{
  public abstract void a(afb paramafb);
  
  public abstract void a(afd paramafd);
  
  public void a(StringBuilder paramStringBuilder) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Orion
 * JD-Core Version:    0.7.0.1
 */