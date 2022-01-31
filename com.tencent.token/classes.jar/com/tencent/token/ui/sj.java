package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.bean.SecurityReporterResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class sj
  extends bo
{
  sj(OpMsgDisplayActivity paramOpMsgDisplayActivity)
  {
    super(paramOpMsgDisplayActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    Intent localIntent;
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
      paramMessage = (d)paramMessage.obj;
      this.a.showToast(paramMessage.c);
      return;
    case 3038: 
      e.c("msg.arg1=" + paramMessage.arg1);
      return;
    case 3057: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (SecurityReporterResult)paramMessage.obj;
        localIntent = new Intent(this.a, SecurityReporterActivity.class);
        localIntent.putExtra("result", paramMessage);
        this.a.startActivity(localIntent);
        return;
      }
      paramMessage = (d)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        d.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (RealNameStatusResult)paramMessage.obj;
      localIntent = new Intent(this.a, RealNameActivity.class);
      localIntent.putExtra("realname_result", paramMessage);
      localIntent.putExtra("from_safe_msg", true);
      this.a.startActivity(localIntent);
      return;
    }
    paramMessage = (d)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sj
 * JD-Core Version:    0.7.0.1
 */