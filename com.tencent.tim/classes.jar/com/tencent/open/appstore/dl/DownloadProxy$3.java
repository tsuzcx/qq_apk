package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aroi;
import arvv;
import arvz;
import arwo;
import arwt;
import aryq;
import aryv;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadProxy$3
  implements Runnable
{
  public DownloadProxy$3(arvz paramarvz, Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject = new StringBuilder().append("[doDownloadAction] pParams=").append(this.bC).append(" source=").append(this.arC).append(" myAppConfig=").append(this.ela).append(" ac==null is");
    if (this.G == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      arwt.i("DownloadResolver", bool1);
      if (this.bC != null) {
        break;
      }
      arwt.i("DownloadResolver", "[doDownloadAction] pParams == null return");
      return;
    }
    arvv.a().elQ();
    this.bC.getString(aryv.PARAM_SNG_APPID);
    this.bC.putString(aryv.cDz, this.arC);
    this.bC.putString("big_brother_source_key", this.arC);
    this.bC.putInt(aryv.PARAM_WOWNLOAD_TYPE, 1);
    localObject = this.bC.getString(aryv.cDC);
    String str2 = this.bC.getString(aryv.PARAM_VIA);
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("0"))) {
      this.bC.putString(aryv.cDC, "");
    }
    String str1 = this.bC.getString(aryv.PARAM_URL);
    localObject = str1;
    if (this.b != null)
    {
      localObject = str1;
      if (this.b.updatemethod == 2)
      {
        localObject = str1;
        if (TextUtils.isEmpty(str1))
        {
          localObject = str1;
          if (!TextUtils.isEmpty(this.b.url))
          {
            this.bC.putString(aryv.PARAM_URL, this.b.url);
            localObject = this.b.url;
          }
        }
      }
    }
    localObject = arvv.a().e((String)localObject);
    if ((localObject == null) && ("biz_src_yyb".equals(this.arC)) && (aryq.aHp()))
    {
      int i = this.bC.getInt(aryv.PARAM_ACTIONCODE);
      str1 = this.bC.getString(aryv.PARAM_TASK_PACKNAME);
      if ((i == 5) && ("com.tencent.android.qqdownloader".equals(str1))) {
        arvz.G(this.bC);
      }
    }
    else if ((localObject != null) && (!TextUtils.isEmpty(str2)))
    {
      ((DownloadInfo)localObject).via = str2;
    }
    if (arvz.G(this.bC))
    {
      arwt.v("DownloadResolver", "[doDownloadAction] installApp");
      return;
    }
    if (this.bC.getInt(aryv.PARAM_ACTIONCODE) == 5) {
      this.bC.putInt(aryv.PARAM_ACTIONCODE, 2);
    }
    if (this.ela == 0)
    {
      if ((localObject != null) && (((DownloadInfo)localObject).downloadType == 1))
      {
        arvz.a(this.this$0, this.G, this.bC, this.arC, this.b, this.ela);
        return;
      }
      boolean bool3 = arwo.cs(aroi.a().getContext());
      boolean bool4 = arwo.cr(aroi.a().getContext());
      if ((localObject == null) || (((DownloadInfo)localObject).getState() == 1))
      {
        bool1 = true;
        if (this.G != null) {
          break label640;
        }
      }
      for (;;)
      {
        arwt.v("DownloadResolver", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.bC.getBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG))) {
          break label645;
        }
        arvv.a().b(this.G, this.bC, this.arC, this.b, this.ela);
        return;
        bool1 = false;
        break;
        label640:
        bool2 = false;
      }
      label645:
      arvz.a(this.this$0, this.bC, this.arC, this.b);
      return;
    }
    if ((localObject == null) || (((DownloadInfo)localObject).downloadType == 1))
    {
      arvz.a(this.this$0, this.G, this.bC, this.arC, this.b, this.ela);
      return;
    }
    arvz.a(this.this$0, this.bC, this.arC, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */