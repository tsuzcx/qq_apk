package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class SetPwdJsPlugin$2
  implements Runnable
{
  SetPwdJsPlugin$2(SetPwdJsPlugin paramSetPwdJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((SetPwdJsPlugin.access$000(this.this$0) == null) && (!this.this$0.activity.isFinishing()))
      {
        SetPwdJsPlugin.access$002(this.this$0, new QQProgressDialog(this.this$0.activity, this.this$0.activity.getTitleBarHeight()));
        SetPwdJsPlugin.access$000(this.this$0).setCancelable(false);
        SetPwdJsPlugin.access$000(this.this$0).b(2131363558);
      }
      if ((SetPwdJsPlugin.access$000(this.this$0) != null) && (!SetPwdJsPlugin.access$000(this.this$0).isShowing())) {
        SetPwdJsPlugin.access$000(this.this$0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SetPwdJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */