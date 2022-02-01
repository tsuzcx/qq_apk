package com.tencent.mobileqq.app.automator.step;

import acik;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;

public class PPCLoginAuth
  extends AsyncStep
{
  public int od()
  {
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastPPCLoginAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      ((acik)this.a.app.getBusinessHandler(58)).cKU();
      localSharedPreferences.edit().putLong("lastPPCLoginAuthTime", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.PPCLoginAuth
 * JD-Core Version:    0.7.0.1
 */