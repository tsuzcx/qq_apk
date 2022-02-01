package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

final class qd
  extends PhoneStateListener
{
  qd(qc paramqc) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (qc.a(this.a) == 2) {
      qc.a(paramSignalStrength.getCdmaDbm());
    }
    if (qc.a(this.a) == 1) {
      qc.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
    if (qc.b(this.a) != null) {
      qc.b(this.a).listen(qc.c(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qd
 * JD-Core Version:    0.7.0.1
 */