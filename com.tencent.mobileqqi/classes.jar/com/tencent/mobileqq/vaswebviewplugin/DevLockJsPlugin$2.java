package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;

class DevLockJsPlugin$2
  implements Runnable
{
  DevLockJsPlugin$2(DevLockJsPlugin paramDevLockJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((DevLockJsPlugin.access$000(this.this$0) != null) && (DevLockJsPlugin.access$000(this.this$0).isShowing()))
      {
        DevLockJsPlugin.access$000(this.this$0).dismiss();
        DevLockJsPlugin.access$000(this.this$0).cancel();
      }
      DevLockJsPlugin.access$002(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.DevLockJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */