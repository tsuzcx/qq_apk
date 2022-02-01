package com.tencent.token;

import android.telephony.PhoneStateListener;

final class lf
  extends PhoneStateListener
{
  public final void onDataConnectionStateChanged(int paramInt)
  {
    lh.a("DownloaderPhoneCallState", "onDataConnectionStateChanged, state:".concat(String.valueOf(paramInt)));
    super.onDataConnectionStateChanged(paramInt);
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    le.a(bool);
    StringBuilder localStringBuilder = new StringBuilder("sIsDataSuspend:");
    localStringBuilder.append(le.c());
    lh.a("DownloaderPhoneCallState", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lf
 * JD-Core Version:    0.7.0.1
 */