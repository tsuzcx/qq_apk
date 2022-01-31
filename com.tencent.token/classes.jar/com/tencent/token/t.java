package com.tencent.token;

import android.telephony.PhoneStateListener;
import com.tencent.halley.common.c;

final class t
  extends PhoneStateListener
{
  public final void onDataConnectionStateChanged(int paramInt)
  {
    c.a("DownloaderPhoneCallState", "onDataConnectionStateChanged, state:" + paramInt);
    super.onDataConnectionStateChanged(paramInt);
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      s.a(bool);
      c.a("DownloaderPhoneCallState", "sIsDataSuspend:" + s.c());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.t
 * JD-Core Version:    0.7.0.1
 */