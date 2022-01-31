package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ax;
import com.tencent.token.p;

final class abt
  extends Handler
{
  abt(StartPwdGestureModifyActivity paramStartPwdGestureModifyActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
    } while (!this.a.isProDialogShow());
    if (paramMessage.arg1 == 0)
    {
      this.a.dismissDialog();
      paramMessage = ax.a().e();
      if (paramMessage == null)
      {
        p.a().a(System.currentTimeMillis(), 23);
        StartPwdGestureModifyActivity.access$000(this.a, this.a, 2131362160, 2131362167);
        return;
      }
      p.a().a(System.currentTimeMillis(), 24);
      Intent localIntent = new Intent(this.a, StartPwdGestureForgetActivity.class);
      localIntent.putExtra("qquser", paramMessage);
      localIntent.putExtra("startpwd_forget_source", 2);
      this.a.startActivityForResult(localIntent, 256);
      return;
    }
    this.a.dismissDialog();
    this.a.showToast(2131362164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abt
 * JD-Core Version:    0.7.0.1
 */