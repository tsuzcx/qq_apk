package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.util.Base64;
import aqhq;
import arbf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;

public class SwiftBrowserLongClickHandler$7
  implements Runnable
{
  public SwiftBrowserLongClickHandler$7(arbf paramarbf, String paramString, IX5WebViewExtension paramIX5WebViewExtension) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = aqhq.readFile(this.val$filePath);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = Base64.encodeToString((byte[])localObject2, 0);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. read from filePath error", localException);
        continue;
        boolean bool = false;
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putCharSequence("imageBase64", (CharSequence)localObject1);
        localObject1 = (Boolean)this.a.invokeMiscMethod("imageQuery", (Bundle)localObject2);
        if (localObject1 == null) {
          continue;
        }
        bool = ((Boolean)localObject1).booleanValue();
        QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. query result:" + bool);
      }
      return;
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. FileUtils.readFile returns null, filepath:" + this.val$filePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.7
 * JD-Core Version:    0.7.0.1
 */