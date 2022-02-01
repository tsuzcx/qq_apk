package com.tencent.mobileqq.webview.swift.component;

import android.net.Uri;
import android.text.TextUtils;
import annx;
import arbz;
import arbz.b;
import java.net.URLEncoder;
import jml;

public class SwiftBrowserStatistics$3
  implements Runnable
{
  public SwiftBrowserStatistics$3(arbz paramarbz, String paramString, int paramInt) {}
  
  public void run()
  {
    String str3 = "";
    try
    {
      localObject = Uri.parse(this.Yk);
      str1 = str3;
      if (localObject != null)
      {
        str1 = ((Uri)localObject).getHost();
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        if ((!this.this$0.cXV) && (!jml.a().dc(str1))) {
          return;
        }
        str1 = URLEncoder.encode(this.Yk);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str1;
        localException.printStackTrace();
        String str2 = str3;
        continue;
        str3 = "0";
      }
    }
    if (!TextUtils.isEmpty(str1))
    {
      localObject = new StringBuilder();
      if (this.this$0.a.mCurrentStep == 13)
      {
        str3 = "1";
        ((StringBuilder)localObject).append(str3).append("|");
        ((StringBuilder)localObject).append(String.valueOf(-this.eei)).append("|");
        ((StringBuilder)localObject).append(str1).append("|");
        ((StringBuilder)localObject).append(str1).append("|");
        ((StringBuilder)localObject).append(this.eei);
        annx.b(null, "dc00757", ((StringBuilder)localObject).toString(), true);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3
 * JD-Core Version:    0.7.0.1
 */