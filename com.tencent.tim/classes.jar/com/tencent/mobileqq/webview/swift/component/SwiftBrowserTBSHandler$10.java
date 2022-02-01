package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import arcb;
import arcm;
import arcm.a;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.QbSdk;

public class SwiftBrowserTBSHandler$10
  implements Runnable
{
  public SwiftBrowserTBSHandler$10(arcb paramarcb, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.this$0.a) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (arcm.rT(this.czv))
      {
        arcm.a locala = arcm.a(this.czv);
        localObject1 = localObject2;
        if (locala != null) {
          localObject1 = locala.data;
        }
      }
      if (!TextUtils.isEmpty(this.czv)) {
        arcb.a(this.this$0.b.j, this.czv, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
 * JD-Core Version:    0.7.0.1
 */