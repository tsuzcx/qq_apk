package com.tencent.qqmail.utilities.qmnetwork;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;

final class PhoneState$1
  extends Handler
{
  PhoneState$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      PhoneState.access$402(new PhoneState.QMPhoneStateListener(null));
      ((TelephonyManager)QMApplicationContext.sharedInstance().getSystemService("phone")).listen(PhoneState.access$400(), 256);
      return;
    }
    catch (Throwable paramMessage)
    {
      QMLog.log(4, PhoneState.access$000(), "init err", paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.PhoneState.1
 * JD-Core Version:    0.7.0.1
 */