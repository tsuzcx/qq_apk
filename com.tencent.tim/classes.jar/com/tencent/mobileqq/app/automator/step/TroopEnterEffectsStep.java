package com.tencent.mobileqq.app.automator.step;

import apdh;
import apdh.a;
import apdr;
import aqmj;
import aqrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectsStep
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "TroopEnterEffectsStep: doStep");
    }
    long l = aqmj.o(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
    apdh localapdh = ((apdr)this.a.app.getManager(231)).a();
    if ((l == 0L) || (localapdh.a == null) || ((System.currentTimeMillis() - l) / 1000L > localapdh.a.dTz))
    {
      ((aqrb)this.a.app.getBusinessHandler(71)).aM(2L, 0L);
      return 2;
    }
    return 7;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep
 * JD-Core Version:    0.7.0.1
 */