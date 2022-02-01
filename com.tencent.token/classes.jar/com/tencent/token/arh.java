package com.tencent.token;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class arh
{
  public static String a = "TmsTcpNetwork";
  public ard b = new ard((byte)0);
  public Context c = null;
  public arg d = null;
  aqv e = null;
  public boolean f = false;
  public aqt g = null;
  private long h = 180000L;
  
  public arh(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public final int a(JceStruct paramJceStruct)
  {
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      byte[] arrayOfByte = apz.a(paramJceStruct);
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
      aqt localaqt = this.g;
      if (localaqt != null) {
        localaqt.b();
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
    aqt localaqt = this.g;
    if (localaqt != null) {
      localaqt.a(paramLong);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = new arg(paramBoolean);
  }
  
  public final void a(boolean paramBoolean, aqv paramaqv)
  {
    this.f = paramBoolean;
    this.e = paramaqv;
    if (this.f)
    {
      this.g = new aqt(this.c, paramaqv);
      this.g.a(this.h);
      this.g.a();
      return;
    }
    paramaqv = this.g;
    if (paramaqv != null) {
      paramaqv.b();
    }
    this.g = null;
  }
  
  public final boolean b()
  {
    boolean bool2 = apc.a();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    a();
    Object localObject = this.d;
    ((arg)localObject).b = ((((arg)localObject).b + 1) % ((arg)localObject).a.size());
    localObject = this.b;
    arg localarg = this.d;
    if (((ard)localObject).a(false, true)) {
      bool1 = ((ard)localObject).a(((ard)localObject).a, localarg);
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
 * Qualified Name:     com.tencent.token.arh
 * JD-Core Version:    0.7.0.1
 */