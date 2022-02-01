package com.tencent.mobileqq.webview.swift.component;

import arcb;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class SwiftBrowserTBSHandler$6
  implements Runnable
{
  public void run()
  {
    this.this$0.aT(MsfSdkUtils.insertMtype("Web", this.this$0.czu), 0);
    synchronized (this.this$0.fD)
    {
      this.this$0.aN = Boolean.valueOf(true);
      this.this$0.fD.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.6
 * JD-Core Version:    0.7.0.1
 */