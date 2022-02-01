package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class tb
{
  static tb a;
  private static boolean i = true;
  public aaf b = new aaf();
  public aaj c = new aaj();
  public aak d = new aak();
  public aaq e = new aaq();
  public aal f = new aal();
  public aap g = new aap();
  public aao h = new aao();
  
  private tb()
  {
    aao localaao = this.h;
    localaao.b = xc.a();
    localaao.a();
  }
  
  public static tb a()
  {
    if (a == null)
    {
      tb localtb = new tb();
      a = localtb;
      return localtb;
    }
    if (i) {
      i = false;
    }
    return a;
  }
  
  private wz b(sl paramsl, boolean paramBoolean, wz paramwz)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final int a(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public final sl a(int paramInt)
  {
    Object localObject = this.c;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aaj)localObject).a()) {
        return null;
      }
      localObject = ((aaj)localObject).a;
      if (localObject == null) {
        return null;
      }
      return (sl)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final sl a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.b;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aaf)localObject).b(paramBoolean)) {
        return null;
      }
      localObject = ((aaf)localObject).a(paramBoolean);
      if (localObject == null) {
        return null;
      }
      return (sl)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final wz a(sl paramsl, boolean paramBoolean, wz paramwz)
  {
    paramwz = b(paramsl, paramBoolean, paramwz);
    if (paramwz.b()) {
      paramsl.c = paramBoolean;
    }
    return paramwz;
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    return this.b.a(paramJSONArray);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    return this.g.a(paramJSONObject);
  }
  
  public final sl b(int paramInt)
  {
    Object localObject = this.d;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aak)localObject).b()) {
        return null;
      }
      localObject = ((aak)localObject).a();
      if (localObject == null) {
        return null;
      }
      return (sl)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final boolean b()
  {
    aaf localaaf = this.b;
    QQUser localQQUser = ta.a().k.b();
    return (localQQUser != null) && (localaaf.d == localQQUser.mUin) && (localaaf.e);
  }
  
  public final boolean b(JSONArray paramJSONArray)
  {
    return this.f.a(paramJSONArray);
  }
  
  public final boolean c()
  {
    aaj localaaj = this.c;
    return (ta.a().k.b() != null) && (localaaj.c == ta.a().k.b().mUin) && (localaaj.d);
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
        sl localsl = new sl();
        if (!localsl.a(localJSONObject)) {
          xb.c("object item parse failed: ");
        }
        this.e.a(localsl);
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
      xc.a("game_protect", ((JSONObject)localObject).toString());
      return;
    }
    throw new JSONException("parse all services data failed");
  }
  
  public final boolean d()
  {
    aak localaak = this.d;
    return (ta.a().k.b() != null) && (localaak.c == ta.a().k.b().mUin) && (localaak.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tb
 * JD-Core Version:    0.7.0.1
 */