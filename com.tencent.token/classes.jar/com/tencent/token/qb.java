package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

final class qb
  extends PhoneStateListener
{
  qb(qa paramqa) {}
  
  public final void onSignalStrengthChanged(int paramInt)
  {
    super.onSignalStrengthChanged(paramInt);
    qa.a(paramInt * 2 - 113);
    if (qa.a(this.a) != null) {
      qa.a(this.a).listen(qa.b(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qb
 * JD-Core Version:    0.7.0.1
 */