package com.tencent.open.downloadnew;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aroi;
import arwo;
import arwt;
import aryq;
import aryr;
import aryv;
import aryy;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

public final class DownloadApi$1
  implements Runnable
{
  public DownloadApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    String str1 = aryr.TAG;
    Object localObject = new StringBuilder().append("doDownloadAction pParams=").append(this.bC).append(" source=").append(this.arC).append(" myAppConfig=").append(this.ela).append(" ac==null is");
    if (this.G == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      arwt.v(str1, bool1);
      if (this.bC != null) {
        break;
      }
      arwt.e(aryr.TAG, "doDownloadAction pParams == null return");
      return;
    }
    aryy.a().elQ();
    localObject = this.bC.getString(aryv.PARAM_SNG_APPID);
    this.bC.putString(aryv.cDz, this.arC);
    this.bC.putInt(aryv.PARAM_WOWNLOAD_TYPE, 1);
    String str2 = this.bC.getString(aryv.cDC);
    str1 = this.bC.getString(aryv.PARAM_VIA);
    if ((TextUtils.isEmpty(str2)) || (str2.equals("0"))) {
      this.bC.putString(aryv.cDC, "");
    }
    localObject = aryy.a().c((String)localObject);
    if ((localObject == null) && ("biz_src_yyb".equals(this.arC)) && (aryq.aHp()))
    {
      int i = this.bC.getInt(aryv.PARAM_ACTIONCODE);
      str1 = this.bC.getString(aryv.PARAM_TASK_PACKNAME);
      if ((i == 5) && (str1.equals("com.tencent.android.qqdownloader"))) {
        aryr.G(this.bC);
      }
    }
    else if ((localObject != null) && (!TextUtils.isEmpty(str1)))
    {
      ((DownloadInfo)localObject).via = str1;
    }
    if (aryr.G(this.bC))
    {
      arwt.v(aryr.TAG, "doDownloadAction installApp");
      return;
    }
    if ((this.b != null) && (this.b.updatemethod == 2) && (TextUtils.isEmpty(this.bC.getString(aryv.PARAM_URL))) && (!TextUtils.isEmpty(this.b.url))) {
      this.bC.putString(aryv.PARAM_URL, this.b.url);
    }
    if (this.ela == 0)
    {
      if ((localObject != null) && (((DownloadInfo)localObject).downloadType == 1))
      {
        aryr.e(this.G, this.bC, this.arC, this.b, this.ela);
        return;
      }
      boolean bool3 = arwo.cs(aroi.a().getContext());
      boolean bool4 = arwo.cr(aroi.a().getContext());
      if ((localObject == null) || (((DownloadInfo)localObject).getState() == 1))
      {
        bool1 = true;
        if (this.G != null) {
          break label578;
        }
      }
      for (;;)
      {
        arwt.v(aryr.TAG, "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
        if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.bC.getBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG))) {
          break label583;
        }
        aryy.a().b(this.G, this.bC, this.arC, this.b, this.ela);
        return;
        bool1 = false;
        break;
        label578:
        bool2 = false;
      }
      label583:
      aryr.b(this.bC, this.arC, this.b);
      return;
    }
    if ((localObject == null) || (((DownloadInfo)localObject).downloadType == 1))
    {
      aryr.e(this.G, this.bC, this.arC, this.b, this.ela);
      return;
    }
    aryr.b(this.bC, this.arC, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.1
 * JD-Core Version:    0.7.0.1
 */