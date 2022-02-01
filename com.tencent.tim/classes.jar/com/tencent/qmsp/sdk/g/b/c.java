package com.tencent.qmsp.sdk.g.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.b;
import com.tencent.qmsp.sdk.base.f;
import java.security.MessageDigest;

public class c
  implements b
{
  private Context a;
  private IVendorCallback b;
  private String c = null;
  private boolean d = false;
  
  private String a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramString = localStringBuilder.append("0x1008611").append(paramString);
      paramString = b("0xdzfdweiwu");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private String b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
        int j = arrayOfByte.length;
        int i = 0;
        paramString = "";
        for (;;)
        {
          localObject = paramString;
          if (i >= j) {
            break;
          }
          String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
          localObject = str;
          if (str.length() == 1)
          {
            localObject = new StringBuilder();
            localObject = "0" + str;
          }
          paramString = paramString + (String)localObject;
          i += 1;
        }
        return "";
      }
      catch (Exception paramString) {}
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = paramContext;
    this.b = paramIVendorCallback;
  }
  
  public String b()
  {
    return a(f.a(this.a));
  }
  
  public void c()
  {
    new Thread(new c.a(this)).start();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.c
 * JD-Core Version:    0.7.0.1
 */