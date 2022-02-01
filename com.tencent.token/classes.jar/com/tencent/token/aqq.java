package com.tencent.token;

import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

public final class aqq
  implements aqp
{
  private long a = 0L;
  private aqj b = (aqj)aou.a(aqj.class);
  
  public aqq()
  {
    StringBuilder localStringBuilder = new StringBuilder("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkQueueProxy mSharkProtocolQueue: ");
    localStringBuilder.append(this.b.hashCode());
  }
  
  public final agx a(int paramInt1, int paramInt2)
  {
    return this.b.a(paramInt1, paramInt2);
  }
  
  public final WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, agw paramagw)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramagw);
  }
  
  public final WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, agw paramagw, long paramLong)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramagw, paramLong);
  }
  
  public final void a()
  {
    aqj.a(5);
  }
  
  public final void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, agx paramagx)
  {
    this.b.a(paramInt1, paramJceStruct, paramInt2, paramagx);
  }
  
  public final void b()
  {
    aqj.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqq
 * JD-Core Version:    0.7.0.1
 */