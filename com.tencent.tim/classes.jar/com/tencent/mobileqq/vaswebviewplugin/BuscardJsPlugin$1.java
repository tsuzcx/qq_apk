package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class BuscardJsPlugin$1
  extends ResultReceiver
{
  BuscardJsPlugin$1(BuscardJsPlugin paramBuscardJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    this.this$0.handleReceiveResult(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */