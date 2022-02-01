package com.tencent.token;

import android.telephony.PhoneStateListener;
import com.tencent.halley.common.b;

final class s
  extends PhoneStateListener
{
  public final void onDataConnectionStateChanged(int paramInt)
  {
    b.a("DownloaderPhoneCallState", "onDataConnectionStateChanged, state:" + paramInt);
    super.onDataConnectionStateChanged(paramInt);
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      r.a(bool);
      b.a("DownloaderPhoneCallState", "sIsDataSuspend:" + r.c());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.s
 * JD-Core Version:    0.7.0.1
 */