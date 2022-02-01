package com.tencent.biz.pubaccount;

import android.os.Handler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$27
  implements Runnable
{
  AccountDetailActivity$27(AccountDetailActivity paramAccountDetailActivity, AccountDetail paramAccountDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateDetailInfo");
    }
    this.this$0.b(this.d);
    if ((this.d != null) && (this.d.followType == 1) && (this.d.isSyncLbs)) {
      this.this$0.a.bb(this.d);
    }
    if (this.abC)
    {
      this.this$0.mHandler.sendEmptyMessage(1);
      return;
    }
    AccountDetailActivity.d(this.this$0, new AccountDetailActivity.27.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.27
 * JD-Core Version:    0.7.0.1
 */