package com.tencent.mobileqq.filemanager.core;

import agkf;
import agkg;
import ahaf;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(agkf paramagkf) {}
  
  public void run()
  {
    if ((this.this$0.app != null) && (this.this$0.app.getApp() != null))
    {
      if (agkf.a(this.this$0) != null) {
        this.this$0.app.getApp().unregisterReceiver(agkf.a(this.this$0));
      }
      if (agkf.a(this.this$0) == null) {
        agkf.a(this.this$0, new agkg(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.app.getApp().registerReceiver(agkf.a(this.this$0), localIntentFilter);
      ahaf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */