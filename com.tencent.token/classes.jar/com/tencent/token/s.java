package com.tencent.token;

import android.telephony.PhoneStateListener;
import com.tencent.halley.common.b;

final class s
  extends PhoneStateListener
{
  public final void onDataConnectionStateChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onDataConnectionStateChanged, state:");
    localStringBuilder.append(paramInt);
    b.a("DownloaderPhoneCallState", localStringBuilder.toString());
    super.onDataConnectionStateChanged(paramInt);
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    r.a(bool);
    localStringBuilder = new StringBuilder("sIsDataSuspend:");
    localStringBuilder.append(r.c());
    b.a("DownloaderPhoneCallState", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.s
 * JD-Core Version:    0.7.0.1
 */