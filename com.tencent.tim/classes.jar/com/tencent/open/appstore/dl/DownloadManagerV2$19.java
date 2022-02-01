package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import arvv;
import arvx;
import arvy;
import arwt;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

public class DownloadManagerV2$19
  implements Runnable
{
  public DownloadManagerV2$19(arvv paramarvv, Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt) {}
  
  public void run()
  {
    Object localObject = new arvx(this);
    arvy localarvy = new arvy(this);
    arwt.i("DownloadManagerV2", "dialog create and show");
    localObject = new AlertDialog.Builder(this.G).setMessage(this.G.getString(2131692352)).setPositiveButton(2131692350, localarvy).setNegativeButton(2131692351, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.G.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.19
 * JD-Core Version:    0.7.0.1
 */