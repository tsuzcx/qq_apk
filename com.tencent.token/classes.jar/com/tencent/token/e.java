package com.tencent.token;

import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import tmsdk.common.d.a.b.y;

public class e
  implements ei
{
  private static y b;
  private long a;
  
  public e(long paramLong)
  {
    this.a = paramLong;
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new y(paramLong);
      }
      return;
    }
    finally {}
  }
  
  public ef a(int paramInt1, int paramInt2)
  {
    return b.a(paramInt1, paramInt2);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ee paramee)
  {
    return b.a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramee);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ee paramee, long paramLong)
  {
    return b.a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramee, paramLong);
  }
  
  public void a(int paramInt)
  {
    b.a(paramInt);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, ef paramef)
  {
    b.a(paramInt1, paramJceStruct, paramInt2, paramef);
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