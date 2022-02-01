package com.tencent.qmsp.sdk.c;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

class k$c
  extends k.i
{
  k$c(k paramk)
  {
    super(paramk, null);
  }
  
  public void a()
  {
    if (this.a) {
      k.f(this.c).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) }));
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ((paramInt4 != 1) && (paramInt4 != 2))
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("Invalid mode: %d", new Object[] { Integer.valueOf(paramInt4) }));
      return;
    }
    j.a locala = k.f(this.c).a(paramInt1);
    if (locala != null) {
      k.f(this.c).a(locala.a, false);
    }
    for (;;)
    {
      locala.a = paramInt1;
      locala.b = paramInt2;
      locala.c = paramInt3;
      locala.e = paramString1;
      locala.d = paramString2;
      k.f(this.c).a(locala, false);
      this.a = true;
      com.tencent.qmsp.sdk.f.g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libId = %d", new Object[] { Integer.valueOf(paramInt1) }));
      if ((paramInt4 != 1) || (k.g(this.c).a(paramInt1) != 1)) {
        break;
      }
      k.f localf = (k.f)k.b(this.c).get(Integer.valueOf(paramInt1));
      if (localf == null) {
        break label277;
      }
      k.a(this.c, localf, paramString2, paramString1);
      if (localf.d == 0) {
        break;
      }
      k.b(this.c).remove(Integer.valueOf(localf.a));
      return;
      locala = new j.a();
    }
    label277:
    paramString1 = k.a(this.c, locala);
    k.a(this.c, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k.c
 * JD-Core Version:    0.7.0.1
 */