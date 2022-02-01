package com.tencent.gdtad.api.interstitial;

import com.tencent.ark.open.ArkAppMgr;
import thi;
import thj;
import tkw;

public class GdtArkPreDownloadTask$5
  implements Runnable
{
  public GdtArkPreDownloadTask$5(thj paramthj) {}
  
  public void run()
  {
    tkw.i("GdtArkPreDownloadTask", String.format("preDownload appName:%s view:%s minVersion:%s", new Object[] { thj.a(this.this$0).appName, thj.a(this.this$0).appView, thj.a(this.this$0).minVersion }));
    ArkAppMgr.getInstance().getAppPathByName(thj.a(this.this$0).appName, "", thj.a(this.this$0).minVersion, null, thj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.5
 * JD-Core Version:    0.7.0.1
 */