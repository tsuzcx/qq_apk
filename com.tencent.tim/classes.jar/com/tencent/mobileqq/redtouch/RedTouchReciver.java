package com.tencent.mobileqq.redtouch;

import alti;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;

public class RedTouchReciver
  extends ResultReceiver
{
  QQAppInterface app;
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    alti localalti = alti.a(paramBundle);
    if (localalti != null) {
      localalti.e(this.app, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchReciver
 * JD-Core Version:    0.7.0.1
 */