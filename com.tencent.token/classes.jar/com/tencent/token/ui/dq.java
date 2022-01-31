package com.tencent.token.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.d;

final class dq
  extends Handler
{
  dq(FaceChangeMobileActivity paramFaceChangeMobileActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (RealNameStatusResult)paramMessage.obj;
      Intent localIntent = new Intent(this.a, RealNameActivity.class);
      localIntent.putExtra("realname_result", paramMessage);
      this.a.startActivity(localIntent);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dq
 * JD-Core Version:    0.7.0.1
 */