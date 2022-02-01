package com.tencent.biz.pubaccount.readinjoy.viola;

import acbn;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aqhq;
import aqul;
import arwu;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.a;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public final class ViolaAccessHelper$6
  implements Runnable
{
  public ViolaAccessHelper$6(String paramString, ViolaBaseView.a parama) {}
  
  public void run()
  {
    String str = aqul.getSDKPrivatePath(acbn.bnx + arwu.toMD5(this.val$url) + ".js");
    if (TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "loadJSFromNet [url:" + this.val$url + "] get localPath error, download cancel");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "loadJSFromNet [ url:" + this.val$url + "] Download to " + str);
        }
        if (new File(str).exists()) {
          aqhq.deleteFile(str);
        }
        boolean bool = HttpDownloadUtil.a(null, this.val$url, new File(str));
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc" + bool);
        }
        if (bool) {}
        try
        {
          if (this.a != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.6.1(this, str), 0L);
          }
          if (TextUtils.isEmpty(aqhq.readFileToString(new File(str))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc but readFileToString is null");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc and readFileToString succ");
            return;
          }
        }
        catch (IOException localIOException) {}
      }
    } while (this.a == null);
    new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.6.2(this), 0L);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.6
 * JD-Core Version:    0.7.0.1
 */