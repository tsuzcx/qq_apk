package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
import java.io.Serializable;

public abstract class break
  implements Serializable
{
  public abstract void a(afl paramafl);
  
  public abstract void a(afo paramafo);
  
  public final byte[] a()
  {
    afo localafo = new afo();
    a(localafo);
    return localafo.a();
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