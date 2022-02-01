package com.tencent.token;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class auc
{
  public static String a = "TmsTcpNetwork";
  public aty b = new aty((byte)0);
  public Context c = null;
  public aub d = null;
  atq e = null;
  public boolean f = false;
  public ato g = null;
  private long h = 180000L;
  
  public auc(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public final int a(JceStruct paramJceStruct)
  {
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      byte[] arrayOfByte = asu.a(paramJceStruct);
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
      ato localato = this.g;
      if (localato != null) {
        localato.b();
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
    ato localato = this.g;
    if (localato != null) {
      localato.a(paramLong);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = new aub(paramBoolean);
  }
  
  public final void a(boolean paramBoolean, atq paramatq)
  {
    this.f = paramBoolean;
    this.e = paramatq;
    if (this.f)
    {
      this.g = new ato(this.c, paramatq);
      this.g.a(this.h);
      this.g.a();
      return;
    }
    paramatq = this.g;
    if (paramatq != null) {
      paramatq.b();
    }
    this.g = null;
  }
  
  public final boolean b()
  {
    boolean bool2 = arx.a();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    a();
    Object localObject = this.d;
    ((aub)localObject).b = ((((aub)localObject).b + 1) % ((aub)localObject).a.size());
    localObject = this.b;
    aub localaub = this.d;
    if (((aty)localObject).a(false, true)) {
      bool1 = ((aty)localObject).a(((aty)localObject).a, localaub);
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
 * Qualified Name:     com.tencent.token.auc
 * JD-Core Version:    0.7.0.1
 */