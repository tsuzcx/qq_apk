package com.tencent.av.ui.redbag;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import jia;

public class GetRedBag$1
  extends ResultReceiver
{
  public GetRedBag$1(jia paramjia, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.d(this.this$0.TAG, 1, "onReceiveResult, 忽略");
      this.this$0.D(-6, 5000L);
      return;
    }
    jia.a(this.this$0, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GetRedBag.1
 * JD-Core Version:    0.7.0.1
 */