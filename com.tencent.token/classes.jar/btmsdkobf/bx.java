package btmsdkobf;

import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.AbsTMSBaseConfig;

public class bx
{
  public static String TAG = "SharkNetServiceProxy";
  private static volatile bx gT = null;
  private dd gS = null;
  private boolean gU = false;
  
  public static bx ar()
  {
    if (gT == null) {}
    try
    {
      if (gT == null) {
        gT = new bx();
      }
      return gT;
    }
    finally {}
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm)
  {
    if (this.gS == null) {
      return;
    }
    this.gS.a(paramInt1, paramJceStruct, paramInt2, paramcm);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, cj paramcj, long paramLong)
  {
    if (this.gS == null) {
      return;
    }
    this.gS.b(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramcj, paramLong);
  }
  
  public void as()
  {
    eh.f(TAG, "[shark_init]initSharkSync()");
    boolean bool = bc.p();
    String str = bc.o().getTCPServerAdd();
    by localby = by.aw();
    localby.a(true, false, false);
    if (!cx.iS)
    {
      cx.r(bool);
      cx.A(str);
      cx.v(false);
      cx.s(localby.ax());
      cx.t(localby.ay());
      cx.u(localby.az());
      db.bZ().c(localby);
      cx.iS = true;
    }
    this.gS = new dd(4294967296L);
    cx.a(this.gS);
    eh.f(TAG, "[shark_init]initSharkSync() end");
  }
  
  public void at()
  {
    try
    {
      if ((cx.bD()) && (!cx.iS)) {
        throw new RuntimeException("must call initSync() before initAsync()!");
      }
    }
    finally {}
    if (!this.gU)
    {
      this.gU = true;
      ee.cT().addUrgentTask(new Runnable()
      {
        public void run()
        {
          db.bZ().at();
        }
      }, "init SharkProtocolQueue async");
    }
  }
  
  public void au()
  {
    this.gS.bM();
  }
  
  public void av()
  {
    this.gS.av();
  }
  
  public cm e(int paramInt1, int paramInt2)
  {
    return this.gS.e(paramInt1, paramInt2);
  }
  
  public String getGuid()
  {
    return this.gS.getGuid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bx
 * JD-Core Version:    0.7.0.1
 */