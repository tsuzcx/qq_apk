package com.tencent.tim.filemanager.core;

import android.content.IntentFilter;
import attf;
import atth;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$2
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.app != null) && (this.this$0.app.getApp() != null))
    {
      if (attf.a(this.this$0) != null) {
        this.this$0.app.getApp().unregisterReceiver(attf.a(this.this$0));
      }
      if (attf.a(this.this$0) == null) {
        attf.a(this.this$0, new atth(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.app.getApp().registerReceiver(attf.a(this.this$0), localIntentFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerDataCenter.2
 * JD-Core Version:    0.7.0.1
 */