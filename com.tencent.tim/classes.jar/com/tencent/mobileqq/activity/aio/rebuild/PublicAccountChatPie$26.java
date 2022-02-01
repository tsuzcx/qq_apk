package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import kaw;
import mqq.os.MqqHandler;
import ocp;
import ycd;

public class PublicAccountChatPie$26
  implements Runnable
{
  public PublicAccountChatPie$26(ycd paramycd, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "updateUnfollowInfo");
    }
    if (this.this$0.aca)
    {
      int i = ocp.getAccountType(this.e.accountFlag);
      if ((i == -3) || (i == -4)) {
        kaw.a().e(this.this$0.app, this.e.uin);
      }
    }
    if (this.this$0.a != null) {
      this.this$0.a.bc(this.e);
    }
    ycd.b(this.this$0, this.e);
    ycd.a(this.this$0).post(new PublicAccountChatPie.26.1(this));
    this.this$0.app.b().N(this.this$0.sessionInfo.aTl, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.26
 * JD-Core Version:    0.7.0.1
 */