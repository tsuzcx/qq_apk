package com.tencent.mobileqq.microapp.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import java.lang.ref.WeakReference;

class MiniAppBridgeActivity$4$1
  extends ResultReceiver
{
  MiniAppBridgeActivity$4$1(MiniAppBridgeActivity.4 param4, Handler paramHandler, WeakReference paramWeakReference)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      paramBundle = (FragmentActivity)this.val$activityRef.get();
      if ((paramBundle != null) && (!paramBundle.isFinishing())) {
        paramBundle.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.4.1
 * JD-Core Version:    0.7.0.1
 */