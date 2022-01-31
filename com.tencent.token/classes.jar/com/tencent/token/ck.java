package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.h;
import com.tencent.token.ui.BaseActivity;
import com.tencent.token.ui.base.GameLoginSndConfirmDialog;

class ck
  extends Handler
{
  ck(cj paramcj) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (cj.a(this.a) != null) {}
    try
    {
      new GameLoginSndConfirmDialog(BaseActivity.sTopActivity, 2131362156).show();
      return;
    }
    catch (Exception paramMessage)
    {
      h.c("GameSafeLoginManager: " + paramMessage.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ck
 * JD-Core Version:    0.7.0.1
 */