package wf7;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;

class cx$b
  implements cz.a
{
  public long fi;
  public long ju = System.currentTimeMillis();
  public bh jv;
  public int jw;
  boolean jx = false;
  public List<h> jy;
  public List<bn> jz = new ArrayList();
  
  public cx$b(List<ScanResult> paramList, bh parambh, long paramLong, int paramInt)
  {
    this.jv = paramLong;
    this.jy = j(parambh);
    this.fi = ???;
    int i;
    this.jw = i;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    bh localbh = this.jv;
    if (this.jn.jg != -1)
    {
      paramLong = this.jn.jf;
      paramInt1 = this.jn.jg;
      localbh = this.jn.jh;
      cx localcx = this.jn;
      localcx.jf = -1L;
      localcx.jg = -1;
      localcx.jh = null;
    }
    cx.a(this.jn, localbh, paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  private List<h> j(List<ScanResult> paramList)
  {
    cv.bj().bk();
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = (List<ScanResult>)localObject2;
      for (;;)
      {
        localObject1 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (ScanResult)localIterator.next();
        if (localObject2 != null)
        {
          localObject1 = paramList;
          if (paramList == null) {
            localObject1 = new ArrayList();
          }
          int i = cb.a((ScanResult)localObject2);
          paramList = new h();
          paramList.u = cb.m(((ScanResult)localObject2).BSSID);
          paramList.ssid = cb.j(((ScanResult)localObject2).SSID);
          paramList.C = cb.F(i);
          paramList.frequency = ((ScanResult)localObject2).frequency;
          localObject2 = ((bq)ao.c().i(1)).a(paramList.ssid, i);
          if (localObject2 != null)
          {
            this.jz.add(localObject2);
            boolean bool1;
            if (((bn)localObject2).ac().aj() != null) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            boolean bool2 = bool1;
            if (bool1) {
              bool2 = ((bn)localObject2).ad().S() ^ true;
            }
            paramList.aC = bool2;
          }
          ((List)localObject1).add(paramList);
          paramList = (List<ScanResult>)localObject1;
        }
      }
    }
    return localObject1;
  }
  
  public void a(long paramLong, boolean paramBoolean1, ArrayList<ct> paramArrayList, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cx.b
 * JD-Core Version:    0.7.0.1
 */