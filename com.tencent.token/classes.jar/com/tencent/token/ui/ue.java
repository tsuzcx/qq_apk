package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.e;

final class ue
  extends bo
{
  ue(RealNameActivity paramRealNameActivity)
  {
    super(paramRealNameActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    e.a("realnameactivity msg.what=" + paramMessage.what + ", msg.arg1=" + paramMessage.arg1);
    switch (paramMessage.what)
    {
    default: 
      return;
    case -100: 
      RealNameActivity.access$000(this.a);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      RealNameActivity.access$102(this.a, (RealNameStatusResult)paramMessage.obj);
      RealNameActivity.access$200(this.a);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ue
 * JD-Core Version:    0.7.0.1
 */