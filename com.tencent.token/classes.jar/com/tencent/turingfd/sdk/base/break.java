package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
import java.io.Serializable;

public abstract class break
  implements Serializable
{
  public abstract void a(afk paramafk);
  
  public abstract void a(afn paramafn);
  
  public final byte[] a()
  {
    afn localafn = new afn();
    a(localafn);
    return localafn.a();
  }
  
  public String toString()
  {
    return new StringBuilder().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.break
 * JD-Core Version:    0.7.0.1
 */