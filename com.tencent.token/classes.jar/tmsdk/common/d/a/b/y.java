package tmsdk.common.d.a.b;

import android.os.Process;
import com.qq.taf.jce.JceStruct;
import d.b.a;
import java.lang.ref.WeakReference;

public class y
  implements x
{
  private long a;
  private r b;
  
  public y(long paramLong)
  {
    this.a = paramLong;
    this.b = ((r)tmsdk.common.a.b.a(r.class));
    new StringBuilder().append("pid: ").append(Process.myPid()).append("SharkQueueProxy mSharkProtocolQueue: ").append(this.b.hashCode()).toString();
  }
  
  public d.b.b a(int paramInt1, int paramInt2)
  {
    return this.b.a(paramInt1, paramInt2);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, a parama)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, parama);
  }
  
  public WeakReference a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, a parama, long paramLong)
  {
    return this.b.a(this.a, paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, parama, paramLong);
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, d.b.b paramb)
  {
    this.b.a(paramInt1, paramJceStruct, paramInt2, paramb);
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