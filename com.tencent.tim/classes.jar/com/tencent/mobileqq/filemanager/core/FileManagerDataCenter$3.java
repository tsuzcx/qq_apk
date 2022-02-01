package com.tencent.mobileqq.filemanager.core;

import agkf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$3
  implements Runnable
{
  public FileManagerDataCenter$3(agkf paramagkf) {}
  
  public void run()
  {
    if ((this.this$0.app != null) && (this.this$0.app.getApp() != null) && (agkf.a(this.this$0) != null)) {
      this.this$0.app.getApp().unregisterReceiver(agkf.a(this.this$0));
    }
    agkf.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3
 * JD-Core Version:    0.7.0.1
 */