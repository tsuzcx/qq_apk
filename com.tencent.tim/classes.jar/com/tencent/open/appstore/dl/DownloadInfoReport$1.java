package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import anot;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

public final class DownloadInfoReport$1
  implements Runnable
{
  public DownloadInfoReport$1(int paramInt1, String paramString, Object paramObject, int paramInt2) {}
  
  public void run()
  {
    try
    {
      switch (this.val$scene)
      {
      case 1: 
      case 11: 
        if (!TextUtils.isEmpty(this.val$url)) {
          if ((this.val$url != null) && (this.val$url.contains("204002177")))
          {
            String str1 = "";
            if ((this.bq instanceof DownloadInfo)) {
              str1 = ((DownloadInfo)this.bq).packageName;
            }
            anot.a(null, "dc00898", "", "", "0X800A80C", "0X800A80C", this.val$scene, this.Iu, "1", "1", this.val$url, str1);
            return;
          }
        }
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("UniformDownloadEvent", 2, localThrowable, new Object[] { " in reportSpecialCareAPKDownloadInfo" });
        return;
        if ((this.val$url != null) && (this.val$url.contains("weseeugg.qq.com/download")))
        {
          String str2 = "";
          if ((this.bq instanceof DownloadInfo)) {
            str2 = ((DownloadInfo)this.bq).packageName;
          }
          anot.a(null, "dc00898", "", "", "0X800A80C", "0X800A80C", this.val$scene, this.Iu, "2", "1", this.val$url, str2);
          return;
          if ((this.bq instanceof DownloadInfo))
          {
            String str3 = ((DownloadInfo)this.bq).urlStr;
            if (!TextUtils.isEmpty(str3))
            {
              int i;
              int j;
              if (str3.contains("204002177"))
              {
                i = this.val$scene;
                j = this.Iu;
                if (TextUtils.isEmpty(((DownloadInfo)this.bq).packageName)) {}
                for (str2 = "empty";; str2 = ((DownloadInfo)this.bq).packageName)
                {
                  anot.a(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i, j, "1", "1", str3, str2);
                  return;
                }
              }
              if (str3.contains("weseeugg.qq.com/download"))
              {
                i = this.val$scene;
                j = this.Iu;
                if (TextUtils.isEmpty(((DownloadInfo)this.bq).packageName)) {}
                for (str2 = "empty";; str2 = ((DownloadInfo)this.bq).packageName)
                {
                  anot.a(null, "dc00898", "", "", "0X800A80D", "0X800A80D", i, j, "2", "1", str3, str2);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadInfoReport.1
 * JD-Core Version:    0.7.0.1
 */