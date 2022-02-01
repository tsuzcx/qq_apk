package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import lf;

public final class VasShieldFont$2
  extends TimerTask
{
  public VasShieldFont$2(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "schedule: userfontid=" + lf.iP);
    }
    if ((lf.iP == 0) && (lf.access$600()))
    {
      lf.access$602(false);
      lf.b(this.val$app, this.a.aTl, this.a.cZ);
      this.val$app.getPreferences().edit().putBoolean("keySysFontGrayTip", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont.2
 * JD-Core Version:    0.7.0.1
 */