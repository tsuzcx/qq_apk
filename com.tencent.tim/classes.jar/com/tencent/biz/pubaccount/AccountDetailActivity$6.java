package com.tencent.biz.pubaccount;

import aqiy;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$6
  implements Runnable
{
  AccountDetailActivity$6(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateFollowInfo");
    }
    this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.bb(this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.this$0.azr();
    if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null) {}
    for (boolean bool = true;; bool = false)
    {
      aqiy.bk("pubAcc_follow_confirm", null, this.this$0.uin);
      AccountDetailActivity.a(this.this$0, new AccountDetailActivity.6.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.6
 * JD-Core Version:    0.7.0.1
 */