package com.tencent.qmsp.sdk.g.i;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import java.lang.reflect.Method;

public class b
  implements com.tencent.qmsp.sdk.base.b
{
  a a;
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = Class.forName("android.os.SystemProperties");
      Method localMethod = paramString2.getMethod("get", new Class[] { String.class, String.class });
      paramString1 = (String)localMethod.invoke(paramString2, new Object[] { paramString1, "unknown" });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public String a()
  {
    return this.a.a(0, "");
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = new a(paramContext);
  }
  
  public String b()
  {
    return null;
  }
  
  public void c() {}
  
  public boolean d()
  {
    return true;
  }
  
  public boolean e()
  {
    return "1".equals(a("persist.sys.identifierid.supported", "0"));
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.i.b
 * JD-Core Version:    0.7.0.1
 */