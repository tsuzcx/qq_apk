package com.tencent.biz.pubaccount;

import aalb;
import android.os.Handler;
import anot;
import aqiy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import kaw;
import ocp;

class AccountDetailActivity$3
  implements Runnable
{
  AccountDetailActivity$3(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateUnfollowInfo");
    }
    if (this.this$0.aca)
    {
      int i = ocp.getAccountType(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i == -3) || (i == -4)) {
        kaw.a().e(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
    }
    this.this$0.mHandler.sendEmptyMessage(2);
    this.this$0.app.b().N(this.this$0.uin, 1008);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.bc(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.c(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    aalb.l(this.this$0.app, this.this$0.uin, 1008);
    anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "0X8004E43", "0X8004E43", 0, 0, this.this$0.uin, "", "", "");
    aqiy.bk(" pubAcc_follow_cancel", null, this.this$0.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */