package com.tencent.token;

import com.tencent.token.core.bean.QQUser;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ta
{
  static ta a;
  private static boolean i = true;
  public aae b = new aae();
  public aai c = new aai();
  public aaj d = new aaj();
  public aap e = new aap();
  public aak f = new aak();
  public aao g = new aao();
  public aan h = new aan();
  
  private ta()
  {
    aan localaan = this.h;
    localaan.b = xb.a();
    localaan.a();
  }
  
  public static ta a()
  {
    if (a == null)
    {
      ta localta = new ta();
      a = localta;
      return localta;
    }
    if (i) {
      i = false;
    }
    return a;
  }
  
  private wy b(sk paramsk, boolean paramBoolean, wy paramwy)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final int a(boolean paramBoolean)
  {
    return this.b.b(paramBoolean);
  }
  
  public final sk a(int paramInt)
  {
    Object localObject = this.c;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aai)localObject).a()) {
        return null;
      }
      localObject = ((aai)localObject).a;
      if (localObject == null) {
        return null;
      }
      return (sk)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final sk a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.b;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aae)localObject).b(paramBoolean)) {
        return null;
      }
      localObject = ((aae)localObject).a(paramBoolean);
      if (localObject == null) {
        return null;
      }
      return (sk)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final wy a(sk paramsk, boolean paramBoolean, wy paramwy)
  {
    paramwy = b(paramsk, paramBoolean, paramwy);
    if (paramwy.b()) {
      paramsk.c = paramBoolean;
    }
    return paramwy;
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    return this.b.a(paramJSONArray);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    return this.g.a(paramJSONObject);
  }
  
  public final sk b(int paramInt)
  {
    Object localObject = this.d;
    if (paramInt >= 0)
    {
      if (paramInt >= ((aaj)localObject).b()) {
        return null;
      }
      localObject = ((aaj)localObject).a();
      if (localObject == null) {
        return null;
      }
      return (sk)((List)localObject).get(paramInt);
    }
    return null;
  }
  
  public final boolean b()
  {
    aae localaae = this.b;
    QQUser localQQUser = sz.a().k.b();
    return (localQQUser != null) && (localaae.d == localQQUser.mUin) && (localaae.e);
  }
  
  public final boolean b(JSONArray paramJSONArray)
  {
    return this.f.a(paramJSONArray);
  }
  
  public final boolean c()
  {
    aai localaai = this.c;
    return (sz.a().k.b() != null) && (localaai.c == sz.a().k.b().mUin) && (localaai.d);
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
        sk localsk = new sk();
        if (!localsk.a(localJSONObject)) {
          xa.c("object item parse failed: ");
        }
        this.e.a(localsk);
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
      xb.a("game_protect", ((JSONObject)localObject).toString());
      return;
    }
    throw new JSONException("parse all services data failed");
  }
  
  public final boolean d()
  {
    aaj localaaj = this.d;
    return (sz.a().k.b() != null) && (localaaj.c == sz.a().k.b().mUin) && (localaaj.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ta
 * JD-Core Version:    0.7.0.1
 */