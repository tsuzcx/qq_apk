package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import arwt;
import aryy;
import arza;
import arzb;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

public class DownloadManager$17
  implements Runnable
{
  public DownloadManager$17(aryy paramaryy, Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt) {}
  
  public void run()
  {
    Object localObject = new arza(this);
    arzb localarzb = new arzb(this);
    arwt.i("DownloadManager_", "dialog create and show");
    localObject = new AlertDialog.Builder(this.G).setMessage(this.G.getString(2131692352)).setPositiveButton(2131692350, localarzb).setNegativeButton(2131692351, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.G.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.17
 * JD-Core Version:    0.7.0.1
 */