package com.tencent.token;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

final class qp
  extends PhoneStateListener
{
  qp(qo paramqo) {}
  
  public final void onSignalStrengthChanged(int paramInt)
  {
    super.onSignalStrengthChanged(paramInt);
    qo.a(paramInt * 2 - 113);
    if (qo.a(this.a) != null) {
      qo.a(this.a).listen(qo.b(this.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qp
 * JD-Core Version:    0.7.0.1
 */