package com.tencent.mobileqq.troop.widget;

import aqmj;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class RedDotImageView$2
  implements Runnable
{
  public void run()
  {
    MobileQQ localMobileQQ = this.b.getApplication();
    int i = aqmj.getAppVersionCode(localMobileQQ);
    if (aqmj.b(localMobileQQ, this.b.getCurrentAccountUin(), i, this.KO))
    {
      aqmj.d(localMobileQQ, this.b.getCurrentAccountUin(), i, this.KO);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, this.KO + " close redDot");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView.2
 * JD-Core Version:    0.7.0.1
 */