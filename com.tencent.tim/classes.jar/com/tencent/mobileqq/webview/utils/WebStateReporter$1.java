package com.tencent.mobileqq.webview.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anot;
import arcv;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WebStateReporter$1
  implements Runnable
{
  public WebStateReporter$1(arcv paramarcv, boolean paramBoolean, String paramString1, Context paramContext, long paramLong, String paramString2) {}
  
  public void run()
  {
    boolean bool3 = this.cYX;
    if (!TextUtils.isEmpty(this.czC)) {
      bool2 = bool3;
    }
    for (;;)
    {
      try
      {
        localObject = Uri.parse(this.czC);
        bool2 = bool3;
        str1 = ((Uri)localObject).getQueryParameter("hasRedDot");
        bool1 = bool3;
        bool2 = bool3;
        if (!TextUtils.isEmpty(str1))
        {
          bool2 = bool3;
          bool1 = str1.equalsIgnoreCase("1");
        }
        bool2 = bool1;
        localObject = ((Uri)localObject).getQueryParameter("crashFrom");
        bool2 = bool1;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        bool2 = bool1;
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception localException1)
      {
        String str1;
        int i = -1;
        boolean bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.e("WebStateReporter_report", 2, "parse url got some problem!", localException1);
        }
        continue;
        Object localObject = (Integer)arcv.pE.get("sample_rate");
        continue;
        int j = 0;
        continue;
        if (i != -1)
        {
          String str2 = localException1 + "?type=" + i;
          if (QLog.isColorLevel()) {
            QLog.d("WebStateReporter_report", 2, "try report web status,  step: " + this.this$0.mCurrentStep + ", hasRedDot : " + bool1 + ", crashFrom : " + i + ", stepTime: " + (this.this$0.aiB - this.this$0.mClickTime) + ", totalTime: " + (System.currentTimeMillis() - this.this$0.mClickTime) + "\n" + str2);
          }
          if (!TextUtils.isEmpty(this.this$0.czB))
          {
            localObject = this.this$0.czB;
            String str3 = this.bhz;
            if (bool1)
            {
              i = 1;
              anot.b(null, "P_CliOper", "WebStatusReport", "", (String)localObject, str3, i, 1, this.this$0.mCurrentStep, str2, Build.VERSION.RELEASE, String.valueOf(this.this$0.aiB - this.this$0.mClickTime), String.valueOf(System.currentTimeMillis() - this.this$0.mClickTime));
            }
          }
          else
          {
            localObject = "unknown";
            continue;
          }
          i = 0;
          continue;
        }
        i = -1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebStateReporter_report", 2, "parse url, redDot : " + str1 + ", urlFromType : " + (String)localObject);
        }
        j = this.czC.indexOf("?");
        str1 = this.czC;
        if (j == -1) {
          continue;
        }
        str1 = str1.substring(0, j);
      }
      catch (Exception localException2)
      {
        continue;
        continue;
      }
    }
    if (arcv.pE.isEmpty())
    {
      this.this$0.fM(this.val$context);
      if (arcv.pE.isEmpty()) {
        arcv.pE.put("sample_rate", Integer.valueOf(10));
      }
    }
    if (arcv.pE.containsKey(str1))
    {
      localObject = (Integer)arcv.pE.get(str1);
      j = ((Integer)localObject).intValue();
      if ((1 != j) && (this.val$uin % j != arcv.eep)) {
        break label315;
      }
      j = 1;
      if (j != 0) {
        break label320;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter.1
 * JD-Core Version:    0.7.0.1
 */