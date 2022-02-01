package com.tencent.mobileqq.app.automator.step;

import acks;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;

public class GetRedpointStep
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetRedpointStep", 2, "GetRedpointStep");
    }
    ((acks)this.a.app.getBusinessHandler(87)).bJ(false, false);
    ((MedalWallMng)this.a.app.getManager(250)).dvO();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetRedpointStep
 * JD-Core Version:    0.7.0.1
 */