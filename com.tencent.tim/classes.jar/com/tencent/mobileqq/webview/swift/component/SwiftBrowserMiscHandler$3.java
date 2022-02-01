package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.os.Environment;
import aqez;
import aqul;
import arbi;
import arbi.a;
import java.io.File;

public class SwiftBrowserMiscHandler$3
  implements Runnable
{
  public SwiftBrowserMiscHandler$3(arbi paramarbi, Bitmap paramBitmap, arbi.a parama) {}
  
  public void run()
  {
    Object localObject = "";
    if (this.fr != null)
    {
      localObject = new File(aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots"));
      String str = "ShareScreenShot_" + System.currentTimeMillis() + ".jpg";
      localObject = aqez.c(this.fr, (File)localObject, str);
      this.this$0.cXA = true;
    }
    if (this.a != null) {
      this.a.call((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
 * JD-Core Version:    0.7.0.1
 */