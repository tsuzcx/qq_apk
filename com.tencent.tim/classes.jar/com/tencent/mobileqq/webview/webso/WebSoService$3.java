package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import android.text.TextUtils;
import aqhq;
import arcy;
import ardk;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class WebSoService$3
  implements Runnable
{
  WebSoService$3(WebSoService paramWebSoService, File paramFile, String paramString, WebSoService.a parama, Uri paramUri) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      String str = aqhq.readFileToString(this.T);
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "readFileToString cost=" + (System.currentTimeMillis() - l));
      }
      if (!TextUtils.isEmpty(str))
      {
        l = System.currentTimeMillis();
        if (arcy.getSHA1(str).equals(this.czU))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "verify html success cost=" + (System.currentTimeMillis() - l));
          }
          this.a.onResult(str);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "verify html fail cost=" + (System.currentTimeMillis() - l));
        }
        ardk.k(this.d);
        this.a.onResult("");
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "deal eTag exception=" + localIOException.getMessage());
      }
      ardk.k(this.d);
      this.a.onResult("");
      localIOException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "verify load data exception=" + localOutOfMemoryError.getMessage());
      }
      this.a.onResult("");
      localOutOfMemoryError.printStackTrace();
      VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 1, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.3
 * JD-Core Version:    0.7.0.1
 */