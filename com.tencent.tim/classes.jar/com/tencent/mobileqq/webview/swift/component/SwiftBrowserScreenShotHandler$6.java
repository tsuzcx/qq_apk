package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import arbo;
import arhz;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jqg;
import nnu;
import rwt;

public class SwiftBrowserScreenShotHandler$6
  implements Runnable
{
  public SwiftBrowserScreenShotHandler$6(arbo paramarbo, String paramString, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    String str = jqg.a(BaseApplication.getContext(), this.val$imgUrl, this.G);
    boolean bool2 = arbo.a(this.this$0).a().isShowing();
    if ((!TextUtils.isEmpty(this.val$imgUrl)) && (this.val$imgUrl.equals(this.this$0.czh))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare download Finish!");
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isGif:" + this.cXD + ", imgUrl:" + this.val$imgUrl);
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isLastMultiShare:" + bool1 + ", mLastMultiShareUrl:" + this.this$0.czh);
        QLog.d("SwiftBrowserScreenShotHandler", 2, "isDialogShowing:" + bool2 + ", localPath:" + str);
      }
      if ((bool2) && (bool1))
      {
        this.this$0.uiHandler.post(new SwiftBrowserScreenShotHandler.6.1(this));
        if (TextUtils.isEmpty(str)) {
          break label289;
        }
        this.this$0.czg = str;
        arbo.a(this.this$0).tO(3);
        if (!this.cXD) {
          break;
        }
        arbo.a(this.this$0).om(this.this$0.czg);
      }
      return;
    }
    this.this$0.uiHandler.post(new SwiftBrowserScreenShotHandler.6.2(this));
    return;
    label289:
    rwt.ez(1, 2131697453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.6
 * JD-Core Version:    0.7.0.1
 */