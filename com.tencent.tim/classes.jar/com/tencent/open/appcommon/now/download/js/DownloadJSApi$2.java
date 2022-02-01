package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import arvd;
import arve;
import arwt;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

public final class DownloadJSApi$2
  implements Runnable
{
  public DownloadJSApi$2(Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt) {}
  
  public void run()
  {
    Object localObject = new arvd(this);
    arve localarve = new arve(this);
    arwt.i("DownloadJSApi", "dialog create and show");
    localObject = new AlertDialog.Builder(this.G).setMessage(this.G.getString(2131692352)).setPositiveButton(2131692350, localarve).setNegativeButton(2131692351, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.G.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi.2
 * JD-Core Version:    0.7.0.1
 */