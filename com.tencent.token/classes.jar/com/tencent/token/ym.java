package com.tencent.token;

import btmsdkobf.bx;
import btmsdkobf.cj;
import btmsdkobf.cm;
import btmsdkobf.dj;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

public final class ym
  implements avd
{
  public final WeakReference<Object> a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, final avg paramavg)
  {
    bx.ar().a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new cj()
    {
      public final void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        paramavg.a(paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousJceStruct);
      }
    }, 0L);
    return null;
  }
  
  public final void a(JceStruct paramJceStruct, final avh paramavh)
  {
    bx.ar().a(13560, paramJceStruct, 2, new cm()
    {
      public final dj<Long, Integer, JceStruct> a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
      {
        paramavh.a(paramAnonymousLong, paramAnonymousInt2, paramAnonymousJceStruct);
        throw new NullPointerException();
      }
    });
  }
  
  static final class a
  {
    private static final ym a = new ym();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ym
 * JD-Core Version:    0.7.0.1
 */