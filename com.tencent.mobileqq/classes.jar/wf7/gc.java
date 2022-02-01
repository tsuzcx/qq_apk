package wf7;

import com.qq.taf.jce.JceStruct;
import com.tencent.wifisdk.services.common.api.b;
import com.tencent.wifisdk.services.common.api.b.a;
import com.tencent.wifisdk.services.common.api.b.b;

public class gc
  implements b, ax
{
  private fd rR;
  private b.b rS;
  
  public gc(fd paramfd)
  {
    this.rR = paramfd;
  }
  
  private void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, du paramdu)
  {
    if (paramdu == null) {
      return;
    }
    try
    {
      this.rR.a(paramInt1, paramJceStruct, paramInt2, new gc.5(this, paramdu));
      return;
    }
    catch (Throwable paramJceStruct) {}
  }
  
  private void b(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, dq paramdq, long paramLong)
  {
    try
    {
      this.rR.a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, new gc.3(this, paramdq), paramLong);
      return;
    }
    catch (Throwable paramJceStruct1) {}
  }
  
  public void a(int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, b.a parama)
  {
    b(paramInt, paramJceStruct1, paramJceStruct2, 2, new gc.1(this, parama), 0L);
  }
  
  public void a(int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, boolean paramBoolean, aw paramaw, long paramLong)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 2;
    }
    b(paramInt, paramJceStruct1, paramJceStruct2, i, new gc.2(this, paramaw), paramLong);
  }
  
  public void a(int paramInt, JceStruct paramJceStruct, ay paramay)
  {
    if (paramay == null) {
      return;
    }
    a(paramInt, paramJceStruct, 2, new gc.4(this, paramay));
  }
  
  public void a(b.b paramb)
  {
    this.rS = paramb;
  }
  
  public void q(int paramInt)
  {
    this.rR.w(paramInt, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.gc
 * JD-Core Version:    0.7.0.1
 */