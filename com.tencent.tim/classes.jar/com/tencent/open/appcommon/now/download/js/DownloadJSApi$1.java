package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import aroi;
import arvc;
import arwo;
import arwt;
import aryv;
import aryy;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.downloadnew.DownloadInfo;

public final class DownloadJSApi$1
  implements Runnable
{
  public DownloadJSApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject1 = new StringBuilder().append("doDownloadAction pParams=").append(this.bC).append(" source=").append(this.arC).append(" myAppConfig=").append(this.ela).append(" ac==null is");
    if (this.G == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      arwt.v("DownloadJSApi", bool1);
      if (this.bC != null) {
        break;
      }
      arwt.e("DownloadJSApi", "doDownloadAction pParams == null return");
      return;
    }
    Object localObject2 = this.bC.getString(aryv.PARAM_SNG_APPID);
    this.bC.putString(aryv.cDz, this.arC);
    this.bC.putInt(aryv.PARAM_WOWNLOAD_TYPE, 1);
    String str = this.bC.getString(aryv.cDC);
    localObject1 = this.bC.getString(aryv.PARAM_VIA);
    if ((TextUtils.isEmpty(str)) || (str.equals("0"))) {
      this.bC.putString(aryv.cDC, "");
    }
    localObject2 = aryy.a().c((String)localObject2);
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      ((DownloadInfo)localObject2).via = ((String)localObject1);
    }
    if ((this.b != null) && (this.b.updatemethod == 2) && (TextUtils.isEmpty(this.bC.getString(aryv.PARAM_URL))) && (!TextUtils.isEmpty(this.b.url))) {
      this.bC.putString(aryv.PARAM_URL, this.b.url);
    }
    boolean bool3 = arwo.cs(aroi.a().getContext());
    boolean bool4 = arwo.cr(aroi.a().getContext());
    if ((localObject2 == null) || (((DownloadInfo)localObject2).getState() == 1))
    {
      bool1 = true;
      if (this.G != null) {
        break label426;
      }
    }
    for (;;)
    {
      arwt.v("DownloadJSApi", "check wifi dialog isWifiActive=" + bool4 + " isFirstDownload=" + bool1 + " acIsNull=" + bool2);
      if ((!bool3) || (bool2) || (bool4) || (!bool1) || (!this.bC.getBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG))) {
        break label431;
      }
      arvc.c(this.G, this.bC, this.arC, this.b, this.ela);
      return;
      bool1 = false;
      break;
      label426:
      bool2 = false;
    }
    label431:
    arvc.a(this.bC, this.arC, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi.1
 * JD-Core Version:    0.7.0.1
 */