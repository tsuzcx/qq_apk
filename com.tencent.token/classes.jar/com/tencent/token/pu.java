package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

final class pu
  extends PhoneStateListener
{
  pu(pt parampt) {}
  
  public final void onSignalStrengthChanged(int paramInt)
  {
    super.onSignalStrengthChanged(paramInt);
    pt.a(paramInt * 2 - 113);
    if (pt.a(this.a) != null) {
      pt.a(this.a).listen(pt.b(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pu
 * JD-Core Version:    0.7.0.1
 */