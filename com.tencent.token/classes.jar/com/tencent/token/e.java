package com.tencent.token;

import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import tmsdk.common.d.a.b.y;

public class e
  implements el
{
  private static y b;
  private long a;
  
  public e(long paramLong)
  {
    this.a = paramLong;
    if (b == null) {
      try
      {
        if (b == null) {
          b = new y(paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public ei a(int paramInt1, int paramInt2)
  {
    return b.a(paramInt1, paramInt2);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, eh parameh)
  {
    return b.a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, parameh);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, eh parameh, long paramLong)
  {
    return b.a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, parameh, paramLong);
  }
  
  public void a(int paramInt)
  {
    b.a(paramInt);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, ei paramei)
  {
    b.a(paramInt1, paramJceStruct, paramInt2, paramei);
  }
  
  public void b(int paramInt)
  {
    b.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.e
 * JD-Core Version:    0.7.0.1
 */