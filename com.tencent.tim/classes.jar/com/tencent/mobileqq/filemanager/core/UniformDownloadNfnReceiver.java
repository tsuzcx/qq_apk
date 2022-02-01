package com.tencent.mobileqq.filemanager.core;

import aglz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadNfnReceiver
  extends BroadcastReceiver
{
  public static String TAG = "UniformDownloadNfnReceiver<FileAssistant>";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    paramContext = paramIntent.getBundleExtra("_PARAM_EXTRA");
    if (str1 != null)
    {
      if (!str1.equals("com.tencent.mobileqq.UniformDownloadNfn.PAUSE")) {
        break label100;
      }
      if (paramContext == null) {
        break label90;
      }
      i = paramContext.getInt("_notify_param_Id");
      paramIntent = paramContext.getString("_notify_param_Url");
      QLog.i(TAG, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: id:" + i + " url:" + paramIntent);
      aglz.a().A(paramIntent, paramContext);
    }
    label90:
    label100:
    do
    {
      return;
      QLog.e(TAG, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: param = null");
      return;
      if (str1.equals("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          QLog.i(TAG, 1, "[UniformDL] onReceive. DO_DOWNLOAD:id:" + i + " url:" + paramIntent);
          aglz.a().B(paramIntent, paramContext);
          return;
        }
        QLog.e(TAG, 1, "[UniformDL] onReceive. DO_DOWNLOAD: param = null");
        return;
      }
      if (str1.equals("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          QLog.i(TAG, 1, "[UniformDL] onReceive. TRY_DOWNLOAD:id:" + i + " url:" + paramIntent);
          aglz.a().C(paramIntent, paramContext);
          return;
        }
        QLog.e(TAG, 1, "[UniformDL] onReceive. TRY_DOWNLOAD: param = null");
        return;
      }
      if (!str1.equals("com.tencent.mobileqq.UniformDownloadNfn.INSTALL")) {
        break;
      }
      paramContext = paramIntent.getStringExtra("_PARAM_FILEPATH");
      str1 = paramIntent.getStringExtra("_PARAM_PKGNAME");
      String str2 = paramIntent.getStringExtra("big_brother_source_key");
      QLog.i(TAG, 1, "[UniformDL] onReceive. DO_INSTALL: PH:" + paramContext + "PKGN:" + str1);
      aglz.a().fJ(paramContext, str2);
    } while (str1 == null);
    int i = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
    aglz.a().eF(str1, i);
    return;
    if (str1.equals("com.tencent.mobileqq.UniformDownloadNfn.BEDEL"))
    {
      if (paramContext != null)
      {
        i = paramContext.getInt("_notify_param_Id");
        str1 = paramContext.getString("_notify_param_Url");
        QLog.i(TAG, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: id:" + i + " url:" + str1);
        aglz.a().D(str1, paramContext);
      }
      for (;;)
      {
        paramContext = paramIntent.getStringExtra("_PARAM_PKGNAME");
        if (paramContext == null) {
          break;
        }
        i = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
        QLog.i(TAG, 1, "[UniformDL] onReceive. download suc. NOTIFICATION_BE_DEL: id:" + i);
        aglz.a().eF(paramContext, i);
        return;
        QLog.w(TAG, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: param = null. may not be clean info except download succ");
      }
    }
    QLog.e(TAG, 1, "[UniformDL] onReceive. unkown action:" + str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadNfnReceiver
 * JD-Core Version:    0.7.0.1
 */