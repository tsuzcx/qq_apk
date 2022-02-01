package tmsdk.common.d.a.b;

import android.os.Process;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.ef;
import com.tencent.token.eg;
import java.lang.ref.WeakReference;
import tmsdk.common.a.b;

public class y
  implements x
{
  private long a;
  private r b;
  
  public y(long paramLong)
  {
    this.a = paramLong;
    this.b = ((r)b.a(r.class));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkQueueProxy mSharkProtocolQueue: ");
    localStringBuilder.append(this.b.hashCode());
    localStringBuilder.toString();
  }
  
  public eg a(int paramInt1, int paramInt2)
  {
    return this.b.a(paramInt1, paramInt2);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ef paramef)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramef);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, ef paramef, long paramLong)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramef, paramLong);
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, eg parameg)
  {
    this.b.a(paramInt1, paramJceStruct, paramInt2, parameg);
  }
  
  public void b(int paramInt)
  {
    this.b.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.y
 * JD-Core Version:    0.7.0.1
 */