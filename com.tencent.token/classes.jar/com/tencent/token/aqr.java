package com.tencent.token;

import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

public final class aqr
  implements aqq
{
  private long a = 0L;
  private aqk b = (aqk)aov.a(aqk.class);
  
  public aqr()
  {
    StringBuilder localStringBuilder = new StringBuilder("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkQueueProxy mSharkProtocolQueue: ");
    localStringBuilder.append(this.b.hashCode());
  }
  
  public final agy a(int paramInt1, int paramInt2)
  {
    return this.b.a(paramInt1, paramInt2);
  }
  
  public final WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, agx paramagx)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramagx);
  }
  
  public final WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, agx paramagx, long paramLong)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramagx, paramLong);
  }
  
  public final void a()
  {
    aqk.a(5);
  }
  
  public final void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, agy paramagy)
  {
    this.b.a(paramInt1, paramJceStruct, paramInt2, paramagy);
  }
  
  public final void b()
  {
    aqk.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqr
 * JD-Core Version:    0.7.0.1
 */