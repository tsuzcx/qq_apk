package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

final class pv
  extends PhoneStateListener
{
  pv(pu parampu) {}
  
  public final void onSignalStrengthChanged(int paramInt)
  {
    super.onSignalStrengthChanged(paramInt);
    pu.a(paramInt * 2 - 113);
    if (pu.a(this.a) != null) {
      pu.a(this.a).listen(pu.b(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pv
 * JD-Core Version:    0.7.0.1
 */