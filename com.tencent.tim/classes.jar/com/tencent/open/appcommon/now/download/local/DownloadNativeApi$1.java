package com.tencent.open.appcommon.now.download.local;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import arvh;
import arvi;
import arvj;
import arvl;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadNativeApi$1
  implements Runnable
{
  public DownloadNativeApi$1(arvh paramarvh, DownloadInfo paramDownloadInfo, arvl paramarvl, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new arvi(this);
    arvj localarvj = new arvj(this);
    arwt.i("DownloadNativeApi", "dialog create and show");
    localObject = new AlertDialog.Builder(this.G).setMessage(this.G.getString(2131692352)).setPositiveButton(2131692350, localarvj).setNegativeButton(2131692351, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.G.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1
 * JD-Core Version:    0.7.0.1
 */