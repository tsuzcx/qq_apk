package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

final class qr
  extends PhoneStateListener
{
  qr(qq paramqq) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (qq.a(this.a) == 2) {
      qq.a(paramSignalStrength.getCdmaDbm());
    }
    if (qq.a(this.a) == 1) {
      qq.a(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
    if (qq.b(this.a) != null) {
      qq.b(this.a).listen(qq.c(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qr
 * JD-Core Version:    0.7.0.1
 */