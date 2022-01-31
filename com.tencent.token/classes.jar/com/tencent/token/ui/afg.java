package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.global.f;

class afg
  extends cb
{
  afg(VerifySuccActivity paramVerifySuccActivity)
  {
    super(paramVerifySuccActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
      paramMessage.putExtra("op_type", 1);
      paramMessage.putExtra("title", this.a.getResources().getString(2131230788));
      paramMessage.putExtra("page_id", 10);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showToast(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afg
 * JD-Core Version:    0.7.0.1
 */