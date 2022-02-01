package com.tencent.mobileqq.activity.qwallet.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;

public final class ComIPCUtils$2
  extends ResultReceiver
{
  public ComIPCUtils$2(Handler paramHandler, OnUpdateListener paramOnUpdateListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("action");
      bool = paramBundle.getBoolean("res");
      if (paramInt == 0) {
        if (this.a != null) {
          this.a.onCheckForUpdate(bool);
        }
      }
    }
    while (this.a == null)
    {
      boolean bool;
      do
      {
        return;
      } while ((paramInt != 1) || (this.a == null));
      this.a.onUpdateSucc(bool);
      return;
    }
    this.a.onCheckForUpdate(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils.2
 * JD-Core Version:    0.7.0.1
 */