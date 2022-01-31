package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.base.GameLoginSndConfirmDialog;

final class s
  extends Handler
{
  s(r paramr) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (r.a(this.a) != null) {}
    try
    {
      new GameLoginSndConfirmDialog(BaseActivity.sTopActivity).show();
      return;
    }
    catch (Exception paramMessage)
    {
      e.c("GameSafeLoginManager: " + paramMessage.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.s
 * JD-Core Version:    0.7.0.1
 */