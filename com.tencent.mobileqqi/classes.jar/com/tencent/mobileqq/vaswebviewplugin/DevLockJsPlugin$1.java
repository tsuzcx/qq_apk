package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class DevLockJsPlugin$1
  implements Runnable
{
  DevLockJsPlugin$1(DevLockJsPlugin paramDevLockJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((DevLockJsPlugin.access$000(this.this$0) == null) && (!this.this$0.activity.isFinishing()))
      {
        DevLockJsPlugin.access$002(this.this$0, new QQProgressDialog(this.this$0.activity, this.this$0.activity.d()));
        DevLockJsPlugin.access$000(this.this$0).setCancelable(false);
        DevLockJsPlugin.access$000(this.this$0).b(2131562645);
      }
      if ((DevLockJsPlugin.access$000(this.this$0) != null) && (!DevLockJsPlugin.access$000(this.this$0).isShowing())) {
        DevLockJsPlugin.access$000(this.this$0).show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.DevLockJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */