package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

class PhoneUtil16Impl$1
  extends PhoneStateListener
{
  PhoneUtil16Impl$1(PhoneUtil16Impl paramPhoneUtil16Impl) {}
  
  public void onSignalStrengthChanged(int paramInt)
  {
    super.onSignalStrengthChanged(paramInt);
    PhoneUtil16Impl.c(paramInt * 2 - 113);
    if (PhoneUtil16Impl.a(this.aN) != null) {
      PhoneUtil16Impl.a(this.aN).listen(PhoneUtil16Impl.b(this.aN), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneUtil16Impl.1
 * JD-Core Version:    0.7.0.1
 */