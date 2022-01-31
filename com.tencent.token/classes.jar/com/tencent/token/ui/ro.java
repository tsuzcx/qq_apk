package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class ro
  extends cb
{
  ro(OpMsgDisplayActivity paramOpMsgDisplayActivity)
  {
    super(paramOpMsgDisplayActivity);
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
    case 3010: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        OpMsgDisplayActivity.access$100(this.a, OpMsgDisplayActivity.access$000(this.a));
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showToast(paramMessage.c);
      return;
    case 3038: 
      h.c("msg.arg1=" + paramMessage.arg1);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (RealNameStatusResult)paramMessage.obj;
      Intent localIntent = new Intent(this.a, RealNameActivity.class);
      localIntent.putExtra("realname_result", paramMessage);
      localIntent.putExtra("from_safe_msg", true);
      this.a.startActivity(localIntent);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ro
 * JD-Core Version:    0.7.0.1
 */