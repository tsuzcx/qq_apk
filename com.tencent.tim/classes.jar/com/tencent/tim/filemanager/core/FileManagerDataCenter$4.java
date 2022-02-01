package com.tencent.tim.filemanager.core;

import attf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$4
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.app != null) && (this.this$0.app.getApp() != null) && (attf.a(this.this$0) != null)) {
      this.this$0.app.getApp().unregisterReceiver(attf.a(this.this$0));
    }
    attf.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.FileManagerDataCenter.4
 * JD-Core Version:    0.7.0.1
 */