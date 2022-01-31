package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.h;

class tn
  extends cb
{
  tn(RealNameActivity paramRealNameActivity)
  {
    super(paramRealNameActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    h.a("realnameactivity msg.what=" + paramMessage.what + ", msg.arg1=" + paramMessage.arg1);
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
 * Qualified Name:     com.tencent.token.ui.tn
 * JD-Core Version:    0.7.0.1
 */