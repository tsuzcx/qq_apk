package com.tencent.mobileqq.app.automator.step;

import accr;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqpi;
import aqqh;
import aqqt;
import aqrt;
import aquv;
import aqyz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetClubContentUpdateStatus
  extends AsyncStep
{
  public int od()
  {
    Object localObject = (VasQuickUpdateManager)this.a.app.getManager(184);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    aqpi.eE(this.a.app);
    aqrt.a().k(this.a.app);
    aqyz.a().k(this.a.app);
    aqpi.eD(this.a.app);
    localObject = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = ((SharedPreferences)localObject).getLong("last_pull_club_content_update_time", 0L);
    if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() < l))
    {
      accr localaccr = (accr)this.a.app.getBusinessHandler(16);
      if (localaccr != null)
      {
        localaccr.sendRequest();
        ((SharedPreferences)localObject).edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      aquv.a().cW(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
      localObject = (aqqh)this.a.app.getManager(177);
      if (!((aqqh)localObject).cVF) {
        ((aqqh)localObject).Vu(this.a.app.getCurrentAccountUin());
      }
      ((aqqt)this.a.app.getManager(192)).efb();
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */