package com.tencent.mobileqq.app.automator.step;

import aldz;
import alem;
import aqqj;
import aqrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetSelfPendantId
  extends AsyncStep
{
  private String getUin()
  {
    if ((this.a.app.getAccount() != null) && (this.a.app.isLogin())) {
      return this.a.app.getAccount();
    }
    return "0";
  }
  
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetSelfPendantId", 2, "doStep");
    }
    aqqj.k(this.a.app);
    alem.k(this.a.app);
    aldz.k(this.a.app);
    ((aqrb)this.a.app.getBusinessHandler(71)).a(new String[] { getUin() }, new int[] { 27201, 27025, 40530, 20059, 27041, 27217, 27225, 27224, 42122, 42121, 27234, 27235, 27236, 27238, 45000, 42334, 27373, 27241 });
    this.a.app.getManager(44);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfPendantId
 * JD-Core Version:    0.7.0.1
 */