package com.tencent.mobileqq.hotpic;

import ahzy;
import ahzz;
import android.app.Dialog;
import aqha;
import aqju;
import com.tencent.qphone.base.util.QLog;

public class PresenceInterfaceImpl$4
  implements Runnable
{
  public void run()
  {
    aqju localaqju = aqha.a(this.this$0.mContext, 232, null, this.beX, new ahzz(this), null);
    try
    {
      localaqju.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PresenceInterfaceImpl", 2, "show dialog fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.4
 * JD-Core Version:    0.7.0.1
 */