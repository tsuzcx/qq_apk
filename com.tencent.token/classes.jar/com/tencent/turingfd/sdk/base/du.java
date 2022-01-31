package com.tencent.turingfd.sdk.base;

import android.util.Log;
import com.tencent.token.fh;

public final class du
  implements ev
{
  public du(eg parameg) {}
  
  public Ginkgo a(int paramInt1, int paramInt2, String paramString1, String paramString2, Damson paramDamson)
  {
    paramDamson.Yb = ((bg)((ee)ed.a(ed.b())).a).b;
    paramString1 = new Ginkgo();
    paramString1.kc = -999;
    paramDamson.bc = ef.f;
    paramString1 = (Ginkgo)((z)z.a.b()).a(paramInt1, paramInt2, 2, paramDamson, paramString1, 100000L);
    paramString2 = ef.e.p();
    if (paramString1.kc == 0)
    {
      if (ef.g)
      {
        ef.g = false;
        Log.i("TuringFdJava", "success");
      }
      localeg = this.a;
      localeg.c.a(Long.valueOf(System.currentTimeMillis()));
      ai.a().a(localeg.d, localeg.g, localeg);
      if (paramString2 != null) {
        paramString2.a(paramDamson.Mb);
      }
    }
    while (paramString2 == null)
    {
      eg localeg;
      return paramString1;
    }
    paramString2.b();
    return paramString1;
  }
  
  public void a(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.du
 * JD-Core Version:    0.7.0.1
 */