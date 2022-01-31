package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

class PhoneUtil20Impl$1
  extends PhoneStateListener
{
  PhoneUtil20Impl$1(PhoneUtil20Impl paramPhoneUtil20Impl) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (PhoneUtil20Impl.a(this.aP) == 2) {
      PhoneUtil20Impl.d(paramSignalStrength.getCdmaDbm());
    }
    if (PhoneUtil20Impl.a(this.aP) == 1) {
      PhoneUtil20Impl.d(paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    }
    if (PhoneUtil20Impl.b(this.aP) != null) {
      PhoneUtil20Impl.b(this.aP).listen(PhoneUtil20Impl.c(this.aP), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.1
 * JD-Core Version:    0.7.0.1
 */