package com.tencent.mobileqq.ark.API;

import adon;
import ador;
import ados;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

public class ArkAppYYBDownloadModule$7
  implements Runnable
{
  public ArkAppYYBDownloadModule$7(adon paramadon, DownloadInfo paramDownloadInfo, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new ador(this);
    ados localados = new ados(this);
    QLog.i("ArkApp.downloadyyb.module", 1, "dialog create and show");
    localObject = new AlertDialog.Builder(this.G).setMessage(this.G.getString(2131692352)).setPositiveButton(2131692350, localados).setNegativeButton(2131692351, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.G.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.7
 * JD-Core Version:    0.7.0.1
 */