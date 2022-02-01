package com.tencent.mobileqq.secspy;

import amzn;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;

class SecSpyFileManager$2$1
  extends ResultReceiver
{
  SecSpyFileManager$2$1(SecSpyFileManager.2 param2, Handler paramHandler, String paramString1, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    long l = paramBundle.getLong("seq");
    switch (paramInt)
    {
    default: 
      this.a.this$0.a(l, -1, new Object[] { "x5 log upload failed, x5 upload result code = " + paramInt });
      return;
    case 0: 
      this.a.this$0.a(l, 0, new Object[0]);
      return;
    }
    amzn.a(this.a.this$0, this.ccE, this.a.this$0.mApp.getCurrentAccountUin(), l, this.ccF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.2.1
 * JD-Core Version:    0.7.0.1
 */