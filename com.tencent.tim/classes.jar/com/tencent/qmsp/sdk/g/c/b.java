package com.tencent.qmsp.sdk.g.c;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;

public class b
  implements com.tencent.qmsp.sdk.base.b, c.b
{
  private c a;
  private IVendorCallback b;
  
  public String a()
  {
    Object localObject;
    if (!e()) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = this.a.a();
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.b = paramIVendorCallback;
    this.a = new c(paramContext, this);
  }
  
  public void a(c paramc)
  {
    try
    {
      if (this.b != null) {
        this.b.onResult(e(), b(), a());
      }
      return;
    }
    catch (Exception paramc)
    {
      do
      {
        paramc = this.b;
      } while (paramc == null);
      paramc.onResult(false, null, null);
    }
  }
  
  public String b()
  {
    Object localObject;
    if (!e()) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = this.a.c();
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public void c() {}
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    c localc = this.a;
    if (localc != null) {
      return localc.b();
    }
    return false;
  }
  
  public void f()
  {
    c localc = this.a;
    if (localc != null) {
      localc.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.b
 * JD-Core Version:    0.7.0.1
 */