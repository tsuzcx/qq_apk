package com.tencent.token;

import android.telephony.PhoneStateListener;

final class ma
  extends PhoneStateListener
{
  public final void onDataConnectionStateChanged(int paramInt)
  {
    mc.a("DownloaderPhoneCallState", "onDataConnectionStateChanged, state:".concat(String.valueOf(paramInt)));
    super.onDataConnectionStateChanged(paramInt);
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    lz.a(bool);
    StringBuilder localStringBuilder = new StringBuilder("sIsDataSuspend:");
    localStringBuilder.append(lz.c());
    mc.a("DownloaderPhoneCallState", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ma
 * JD-Core Version:    0.7.0.1
 */