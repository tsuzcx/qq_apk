package com.tencent.mobileqq.widget;

import aqmj;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ArcImageView$1
  implements Runnable
{
  public void run()
  {
    MobileQQ localMobileQQ = this.b.getApplication();
    int i = aqmj.getAppVersionCode(localMobileQQ);
    boolean bool = aqmj.b(localMobileQQ, this.b.getCurrentAccountUin(), i, this.KO);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, this.KO + " show redDot: " + bool);
    }
    this.this$0.showRedDot(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView.1
 * JD-Core Version:    0.7.0.1
 */