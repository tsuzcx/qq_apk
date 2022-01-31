package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

public final class q
  extends PhoneStateListener
{
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    o.b = o.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.q
 * JD-Core Version:    0.7.0.1
 */