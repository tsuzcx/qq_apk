package com.tencent.token;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ate
{
  public static String a = "TmsTcpNetwork";
  public ata b = new ata((byte)0);
  public Context c = null;
  public atd d = null;
  ass e = null;
  public boolean f = false;
  public asq g = null;
  private long h = 180000L;
  
  public ate(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public final int a(JceStruct paramJceStruct)
  {
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      byte[] arrayOfByte = arw.a(paramJceStruct);
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
      asq localasq = this.g;
      if (localasq != null) {
        localasq.b();
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
    asq localasq = this.g;
    if (localasq != null) {
      localasq.a(paramLong);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = new atd(paramBoolean);
  }
  
  public final void a(boolean paramBoolean, ass paramass)
  {
    this.f = paramBoolean;
    this.e = paramass;
    if (this.f)
    {
      this.g = new asq(this.c, paramass);
      this.g.a(this.h);
      this.g.a();
      return;
    }
    paramass = this.g;
    if (paramass != null) {
      paramass.b();
    }
    this.g = null;
  }
  
  public final boolean b()
  {
    boolean bool2 = aqz.a();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    a();
    Object localObject = this.d;
    ((atd)localObject).b = ((((atd)localObject).b + 1) % ((atd)localObject).a.size());
    localObject = this.b;
    atd localatd = this.d;
    if (((ata)localObject).a(false, true)) {
      bool1 = ((ata)localObject).a(((ata)localObject).a, localatd);
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
 * Qualified Name:     com.tencent.token.ate
 * JD-Core Version:    0.7.0.1
 */