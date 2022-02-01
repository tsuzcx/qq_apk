package com.tencent.token;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ari
{
  public static String a = "TmsTcpNetwork";
  public are b = new are((byte)0);
  public Context c = null;
  public arh d = null;
  aqw e = null;
  public boolean f = false;
  public aqu g = null;
  private long h = 180000L;
  
  public ari(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public final int a(JceStruct paramJceStruct)
  {
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      byte[] arrayOfByte = aqa.a(paramJceStruct);
      j = this.b.a(arrayOfByte);
      if (j == 0) {
        return 0;
      }
      i += 1;
    }
    return j;
  }
  
  public final void a()
  {
    this.b.a(false, false);
    if (this.f)
    {
      aqu localaqu = this.g;
      if (localaqu != null) {
        localaqu.b();
      }
    }
  }
  
  public final void a(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public final void a(long paramLong)
  {
    if (this.h == paramLong) {
      return;
    }
    aqu localaqu = this.g;
    if (localaqu != null) {
      localaqu.a(paramLong);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = new arh(paramBoolean);
  }
  
  public final void a(boolean paramBoolean, aqw paramaqw)
  {
    this.f = paramBoolean;
    this.e = paramaqw;
    if (this.f)
    {
      this.g = new aqu(this.c, paramaqw);
      this.g.a(this.h);
      this.g.a();
      return;
    }
    paramaqw = this.g;
    if (paramaqw != null) {
      paramaqw.b();
    }
    this.g = null;
  }
  
  public final boolean b()
  {
    boolean bool2 = apd.a();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    a();
    Object localObject = this.d;
    ((arh)localObject).b = ((((arh)localObject).b + 1) % ((arh)localObject).a.size());
    localObject = this.b;
    arh localarh = this.d;
    if (((are)localObject).a(false, true)) {
      bool1 = ((are)localObject).a(((are)localObject).a, localarh);
    }
    a(this.f, this.e);
    return bool1;
  }
  
  public final boolean c()
  {
    return this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ari
 * JD-Core Version:    0.7.0.1
 */