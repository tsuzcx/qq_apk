package com.tencent.mobileqq.webview.swift.component;

import ahbj;
import android.os.Environment;
import aqul;
import arbi;
import java.io.File;

public class SwiftBrowserMiscHandler$2
  implements Runnable
{
  public SwiftBrowserMiscHandler$2(arbi paramarbi) {}
  
  public void run()
  {
    ahbj.deleteSubFile(new File(aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
 * JD-Core Version:    0.7.0.1
 */