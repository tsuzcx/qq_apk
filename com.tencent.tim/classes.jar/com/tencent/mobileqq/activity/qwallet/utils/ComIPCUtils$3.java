package com.tencent.mobileqq.activity.qwallet.utils;

import aaai.b;
import android.os.Bundle;
import android.os.ResultReceiver;

public final class ComIPCUtils$3
  extends ResultReceiver
{
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("res");
      this.b.a(this.val$key, paramBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.3
 * JD-Core Version:    0.7.0.1
 */