package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;

class SetPwdJsPlugin$3
  implements Runnable
{
  SetPwdJsPlugin$3(SetPwdJsPlugin paramSetPwdJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((SetPwdJsPlugin.access$000(this.this$0) != null) && (SetPwdJsPlugin.access$000(this.this$0).isShowing()))
      {
        SetPwdJsPlugin.access$000(this.this$0).dismiss();
        SetPwdJsPlugin.access$000(this.this$0).cancel();
      }
      SetPwdJsPlugin.access$002(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SetPwdJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */