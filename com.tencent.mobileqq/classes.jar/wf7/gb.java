package wf7;

import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.tencent.wifisdk.services.common.api.b.b;
import com.tencent.wifisdk.services.common.api.c;

public class gb
  implements b.b, bc
{
  private c rQ;
  
  public gb(c paramc)
  {
    this.rQ = paramc;
  }
  
  public void a(bb parambb, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      parambb.a(paramVarArgs);
      i = parambb.F();
      if ((i != -1) && (this.rQ != null))
      {
        parambb = new q(parambb.E().bN);
        this.rQ.a(i, parambb);
      }
      return;
    }
    catch (Throwable paramVarArgs)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.rQ != null) {
      this.rQ.b(paramInt, paramString);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    TMSDKWifiManager.getCustomConfig().onCustomReport(paramInt1, paramInt2);
    if (this.rQ != null) {
      this.rQ.c(paramInt1, paramInt2);
    }
  }
  
  public void eR()
  {
    if (this.rQ != null) {
      this.rQ.fl();
    }
  }
  
  public void r(int paramInt)
  {
    TMSDKWifiManager.getCustomConfig().onCustomReport(paramInt, 0);
    if (this.rQ != null) {
      this.rQ.r(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.gb
 * JD-Core Version:    0.7.0.1
 */