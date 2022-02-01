package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class tu
{
  static tu a;
  private static boolean i = true;
  public aba b = new aba();
  public abe c = new abe();
  public abf d = new abf();
  public abl e = new abl();
  public abg f = new abg();
  public abk g = new abk();
  public abj h = new abj();
  
  private tu()
  {
    abj localabj = this.h;
    localabj.b = xy.a();
    localabj.a();
  }
  
  public static tu a()
  {
    if (a == null)
    {
      tu localtu = new tu();
      a = localtu;
      return localtu;
    }
    if (i) {
      i = false;
    }
    return a;
  }
  
  private xt b(te paramte, boolean paramBoolean, xt paramxt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final int a(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public final te a(int paramInt)
  {
    Object localObject = this.c;
    if (paramInt >= 0)
    {
      if (paramInt >= ((abe)localObject).a()) {
        return null;
      }
      localObject = ((abe)localObject).a;
      if (localObject == null) {
        return null;
      }
      return (te)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final te a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.b;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aba)localObject).b(paramBoolean)) {
        return null;
      }
      localObject = ((aba)localObject).a(paramBoolean);
      if (localObject == null) {
        return null;
      }
      return (te)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final xt a(te paramte, boolean paramBoolean, xt paramxt)
  {
    paramxt = b(paramte, paramBoolean, paramxt);
    if (paramxt.b()) {
      paramte.c = paramBoolean;
    }
    return paramxt;
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    return this.b.a(paramJSONArray);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    return this.g.a(paramJSONObject);
  }
  
  public final te b(int paramInt)
  {
    Object localObject = this.d;
    if (paramInt >= 0)
    {
      if (paramInt >= ((abf)localObject).c()) {
        return null;
      }
      localObject = ((abf)localObject).a();
      if (localObject == null) {
        return null;
      }
      return (te)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final boolean b()
  {
    aba localaba = this.b;
    QQUser localQQUser = tt.a().k.b();
    return (localQQUser != null) && (localaba.d == localQQUser.mUin) && (localaba.e);
  }
  
  public final boolean b(JSONArray paramJSONArray)
  {
    return this.f.a(paramJSONArray);
  }
  
  public final boolean c()
  {
    abe localabe = this.c;
    return (tt.a().k.b() != null) && (localabe.c == tt.a().k.b().mUin) && (localabe.d);
  }
  
  public final boolean c(JSONArray paramJSONArray)
  {
    return this.g.a(paramJSONArray);
  }
  
  public final void d(JSONArray paramJSONArray)
  {
    Object localObject = null;
    int j = 0;
    int m = 0;
    int k = 0;
    while (j < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
      if (4 == localJSONObject.getInt("id"))
      {
        te localte = new te();
        if (!localte.a(localJSONObject)) {
          xv.c("object item parse failed: ");
        }
        this.e.a(localte);
        m = 1;
      }
      if (6 == localJSONObject.getInt("id"))
      {
        localObject = localJSONObject.getJSONArray("child");
        if (this.d.a((JSONArray)localObject))
        {
          localObject = localJSONObject;
          k = 1;
        }
        else
        {
          throw new JSONException("parse all services data failed");
        }
      }
      j += 1;
    }
    if ((m != 0) && (k != 0))
    {
      paramJSONArray = this.d;
      paramJSONArray.d = true;
      this.e.c = true;
      paramJSONArray.e = false;
      xy.a("game_protect", ((JSONObject)localObject).toString());
      return;
    }
    throw new JSONException("parse all services data failed");
  }
  
  public final boolean d()
  {
    abf localabf = this.d;
    return (tt.a().k.b() != null) && (localabf.c == tt.a().k.b().mUin) && (localabf.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tu
 * JD-Core Version:    0.7.0.1
 */