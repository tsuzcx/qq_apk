package com.tencent.qmsp.sdk.g.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.f;

public class e
  implements com.tencent.qmsp.sdk.base.b, c
{
  private b a;
  private Context b;
  private IVendorCallback c;
  
  public String a()
  {
    Object localObject = "";
    if (e())
    {
      String str = this.a.b();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    return localObject;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    if (b.a(paramContext))
    {
      String str = f.a(paramContext);
      if (!TextUtils.isEmpty(str)) {
        b.a(paramContext, str);
      }
      this.a = new b(paramContext, this);
      this.c = paramIVendorCallback;
      this.b = paramContext;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    IVendorCallback localIVendorCallback = this.c;
    if (localIVendorCallback != null) {
      localIVendorCallback.onResult(e(), b(), a());
    }
  }
  
  public String b()
  {
    Object localObject = "";
    if (e())
    {
      String str = this.a.a();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    return localObject;
  }
  
  public void c()
  {
    b localb = this.a;
    if (localb != null)
    {
      localb.a(f.a(this.b));
      return;
    }
    g();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    b localb = this.a;
    if (localb != null) {
      return localb.c();
    }
    return false;
  }
  
  public void f()
  {
    b localb = this.a;
    if (localb != null) {
      localb.d();
    }
  }
  
  public void g()
  {
    IVendorCallback localIVendorCallback = this.c;
    if (localIVendorCallback != null) {
      localIVendorCallback.onResult(false, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.e
 * JD-Core Version:    0.7.0.1
 */