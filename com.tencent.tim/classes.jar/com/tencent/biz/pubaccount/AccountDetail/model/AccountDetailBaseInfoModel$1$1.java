package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import jtz;
import jua;

public class AccountDetailBaseInfoModel$1$1
  implements Runnable
{
  public AccountDetailBaseInfoModel$1$1(jua paramjua, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailInSubThread");
    }
    jtz.a(this.this$0.val$app, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel.1.1
 * JD-Core Version:    0.7.0.1
 */