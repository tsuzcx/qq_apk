package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

final class pw
  extends PhoneStateListener
{
  pw(pv parampv) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (pv.a(this.a) == 2) {
      pv.a(paramSignalStrength.getCdmaDbm());
    }
    if (pv.a(this.a) == 1) {
      pv.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
    if (pv.b(this.a) != null) {
      pv.b(this.a).listen(pv.c(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pw
 * JD-Core Version:    0.7.0.1
 */