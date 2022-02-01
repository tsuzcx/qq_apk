package com.tencent.mobileqq.webview.utils;

import android.net.Uri;
import android.text.TextUtils;
import annx;
import arcv;
import java.net.URLEncoder;
import java.util.HashMap;

public class WebStateReporter$2
  implements Runnable
{
  public WebStateReporter$2(arcv paramarcv, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    int i;
    if (arcv.pE.containsKey(this.Yk))
    {
      i = ((Integer)arcv.pE.get(this.Yk)).intValue();
      if ((1 != i) && (this.val$uin % i != arcv.eep)) {
        break label63;
      }
      i = 1;
      label52:
      if (i != 0) {
        break label68;
      }
    }
    label63:
    label68:
    do
    {
      for (;;)
      {
        return;
        i = 10;
        break;
        i = 0;
        break label52;
        String str3 = "";
        try
        {
          localObject = Uri.parse(this.Yk);
          str1 = str3;
          if (localObject != null)
          {
            str1 = ((Uri)localObject).getHost();
            if ((TextUtils.isEmpty(str1)) || (!str1.endsWith("qq.com"))) {
              continue;
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
      }
    } while (TextUtils.isEmpty(str1));
    localObject = new StringBuilder();
    if (this.this$0.mCurrentStep == 13)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter.2
 * JD-Core Version:    0.7.0.1
 */