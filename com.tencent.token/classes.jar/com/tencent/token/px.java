package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

final class px
  extends PhoneStateListener
{
  px(pw parampw) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (pw.a(this.a) == 2) {
      pw.a(paramSignalStrength.getCdmaDbm());
    }
    if (pw.a(this.a) == 1) {
      pw.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
    if (pw.b(this.a) != null) {
      pw.b(this.a).listen(pw.c(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.px
 * JD-Core Version:    0.7.0.1
 */