package com.tencent.qmsp.sdk.g.a;

import android.content.Context;
import android.os.IBinder;
import com.tencent.qmsp.sdk.base.IVendorCallback;

public class c
  implements com.tencent.qmsp.sdk.base.b, b
{
  private IVendorCallback a;
  private String b = "";
  private String c = "";
  private d d;
  private boolean e = false;
  private boolean f = false;
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = paramIVendorCallback;
    this.d = new d(paramContext);
    this.d.a(this);
  }
  
  public void a(a parama)
  {
    for (;;)
    {
      try
      {
        this.b = parama.c();
        str = this.b;
        if (str == null) {
          this.b = "";
        }
      }
      catch (Exception localException2)
      {
        String str;
        continue;
      }
      try
      {
        this.c = parama.h();
        str = this.c;
        if (str == null) {
          this.c = "";
        }
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        this.f = parama.g();
        this.e = true;
        parama = this.a;
        if (parama != null) {
          parama.onResult(this.f, this.c, this.b);
        }
        return;
      }
      catch (Exception parama) {}
    }
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void c()
  {
    this.d.a(this);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public void f()
  {
    if (this.e)
    {
      d locald = this.d;
      if (locald != null) {
        locald.a();
      }
    }
  }
  
  public void g()
  {
    IVendorCallback localIVendorCallback = this.a;
    if (localIVendorCallback != null) {
      localIVendorCallback.onResult(false, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.a.c
 * JD-Core Version:    0.7.0.1
 */