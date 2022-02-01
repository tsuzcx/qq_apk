package com.tencent.turingfd.sdk.base;

import android.util.Log;

public final class ah
  implements am
{
  public ah(ak paramak, int paramInt) {}
  
  public Grapefruit a(int paramInt1, int paramInt2, String paramString1, String paramString2, Dew paramDew)
  {
    paramDew.Vb = ((ao)cz.a(cm.a())).b;
    paramString1 = new Grapefruit();
    paramString1.hc = -999;
    paramDew.Zb = ag.f;
    paramString1 = (Grapefruit)e.a().a(paramInt1, paramInt2, 2, paramDew, paramString1, 100000L);
    paramString2 = ag.e.s();
    if (paramString1.hc == 0)
    {
      if (ag.g)
      {
        ag.g = false;
        Log.i("TuringFdJava", "success");
      }
      ak localak = this.a;
      localak.c.a(Long.valueOf(System.currentTimeMillis()));
      a.a().a(localak.d, localak.g, localak);
      if ((paramString2 != null) && (cv.a != 0)) {
        paramString2.a(this.b, paramDew.Jb);
      }
    }
    return paramString1;
  }
  
  public void a(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ah
 * JD-Core Version:    0.7.0.1
 */