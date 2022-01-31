package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.token.ag;

final class cr
  extends bo
{
  cr(CorrectTokenActivity paramCorrectTokenActivity)
  {
    super(paramCorrectTokenActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 13: 
      int i = paramMessage.getData().getInt("serTime");
      long l1 = System.currentTimeMillis();
      long l2 = i;
      ag.c().a(l2 * 1000L - l1);
      ag.c().i();
      ag.c().n();
      CorrectTokenActivity.access$000(this.a);
      CorrectTokenActivity.access$700(this.a);
      return;
    case 14: 
      CorrectTokenActivity.access$800(this.a);
      return;
    }
    CorrectTokenActivity.access$800(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cr
 * JD-Core Version:    0.7.0.1
 */