package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ax;
import com.tencent.token.p;

final class aaz
  extends Handler
{
  aaz(StartPwdGestureDeleteActivity paramStartPwdGestureDeleteActivity) {}
  
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
        StartPwdGestureDeleteActivity.access$000(this.a, this.a, 2131362161, 2131362144);
        return;
      }
      p.a().a(System.currentTimeMillis(), 24);
      Intent localIntent = new Intent(this.a, StartPwdGestureForgetActivity.class);
      localIntent.putExtra("qquser", paramMessage);
      localIntent.putExtra("startpwd_forget_source", 1);
      this.a.startActivityForResult(localIntent, 256);
      return;
    }
    this.a.dismissDialog();
    this.a.showToast(2131362164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aaz
 * JD-Core Version:    0.7.0.1
 */