package com.tencent.mobileqq.app.automator.step;

import akjp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class getLocalRedtouchStep
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "reconnect pullRedTouchs");
    }
    ((akjp)this.a.app.getManager(160)).dBx();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.getLocalRedtouchStep
 * JD-Core Version:    0.7.0.1
 */