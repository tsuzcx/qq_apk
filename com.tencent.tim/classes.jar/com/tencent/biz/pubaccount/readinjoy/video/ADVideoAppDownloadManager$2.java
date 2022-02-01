package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import arvz;
import aryv;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mrm;

class ADVideoAppDownloadManager$2
  implements Runnable
{
  ADVideoAppDownloadManager$2(ADVideoAppDownloadManager paramADVideoAppDownloadManager, mrm parammrm, WeakReference paramWeakReference) {}
  
  public void run()
  {
    Object localObject1 = this.d.mPackageName;
    String str1 = this.d.mAppID;
    String str2 = this.d.mAppName;
    Object localObject2;
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startRealDownload packageName:").append((String)localObject1).append(", appid:").append(str1).append(", appName:").append(str2);
        QLog.d("ADVideoAppDownloadManager", 2, ((StringBuilder)localObject2).toString());
      }
    }
    do
    {
      String str3;
      do
      {
        return;
        if ((TextUtils.isEmpty(this.d.mDownloadUrl)) && (!TextUtils.isEmpty(this.d.ajG))) {
          this.d.mDownloadUrl = ADVideoAppDownloadManager.a(this.this$0, this.d.ajG, 1);
        }
        str3 = this.d.mDownloadUrl;
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "downloadUrl null");
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString(aryv.PARAM_TASK_PACKNAME, (String)localObject1);
      ((Bundle)localObject2).putString(aryv.PARAM_SNG_APPID, str1);
      ((Bundle)localObject2).putString(aryv.PARAM_URL, str3);
      ((Bundle)localObject2).putString(aryv.PARAM_APPNAME, str2);
      ((Bundle)localObject2).putInt(aryv.PARAM_ACTIONCODE, 2);
      ((Bundle)localObject2).putInt(aryv.PARAM_WOWNLOAD_TYPE, 0);
      ((Bundle)localObject2).putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
      ((Bundle)localObject2).putInt(aryv.PARAM_SHOW_NOTIFICATION, 0);
      ((Bundle)localObject2).putBoolean(aryv.PARAM_IS_APK, true);
      ((Bundle)localObject2).putBoolean(aryv.PARAM_AUTO_INSTALL, true);
      ((Bundle)localObject2).putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
      ((Bundle)localObject2).putBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, false);
      if (!TextUtils.isEmpty(this.d.via)) {
        ((Bundle)localObject2).putString(aryv.PARAM_VIA, this.d.via);
      }
      ((Bundle)localObject2).putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, "startRealDownload pkg:" + (String)localObject1 + ", appid:" + str1 + ", name:" + str2 + ", url:" + str3);
      }
      this.this$0.fP.remove(this.d);
      this.this$0.fP.add(this.d);
      localObject1 = (Activity)this.cl.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "ac=null");
    return;
    arvz.a().d((Activity)localObject1, (Bundle)localObject2, "biz_src_feeds_kandianads", null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */